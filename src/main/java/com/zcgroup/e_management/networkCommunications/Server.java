package com.zcgroup.e_management.networkCommunications;

import com.zcgroup.e_management.entity.Data;
import com.zcgroup.e_management.entity.User;
import com.zcgroup.e_management.service.DataService;
import com.zcgroup.e_management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@Order(1)
public class Server  {

    public Server(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Server1();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Server2();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Server3();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Autowired
    private UserService userService;
    @Autowired
    private DataService dataService;
    protected static final Logger logger = LoggerFactory.getLogger(Server.class);

    /**
     * 注册用户服务器
     * @throws Exception
     */
    private void Server1()throws  Exception{
           ServerSocket serverSocket = new ServerSocket(9003);
           ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 100, 10000, TimeUnit.SECONDS,
                   new LinkedBlockingDeque<>());
           logger.info("注册用户服务器启动。。。");
           System.out.print("13543");
           while (true) {
               Socket socket = serverSocket.accept();
               logger.info("有用户注册。。。");
               threadPoolExecutor.execute(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           InputStream inputStream = null;
                           OutputStream outputStream = null;
                           inputStream = socket.getInputStream();
                           outputStream = socket.getOutputStream();
                           ObjectInputStream ois = new ObjectInputStream(inputStream);
                           DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                           User user = (User) ois.readObject();
                           int res=userService.addUser(user);
                           dataOutputStream.write((res+"").getBytes());
                       } catch (Exception e) {
                           e.printStackTrace();
                       } finally {
                           try {
                               socket.close();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                   }
               });
           }
       }

    /**
     * 上传健康信息服务器
     * @throws Exception
     */
    private void Server2()throws  Exception{
        ServerSocket serverSocket = new ServerSocket(9001);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 100, 10000, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        logger.info("上传健康信息服务器启动。。。");
        while (true) {
            Socket socket = serverSocket.accept();
            logger.info("有用户上传健康信息。。。");
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = null;
                        OutputStream outputStream = null;
                        inputStream = socket.getInputStream();
                        outputStream = socket.getOutputStream();
                        ObjectInputStream ois = new ObjectInputStream(inputStream);
                        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                        Data data = (Data) ois.readObject();
                        int res=dataService.addData(data);
                        dataOutputStream.write((res+"").getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /**
     * 登录服务器
     * @throws Exception
     */
    private void Server3()throws  Exception{
        ServerSocket serverSocket = new ServerSocket(9002);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 100, 10000, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        logger.info("登录服务器启动。。。");
        while (true) {
            Socket socket = serverSocket.accept();
            logger.info("有用户尝试登录。。。");
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = null;
                        OutputStream outputStream = null;
                        inputStream = socket.getInputStream();
                        outputStream = socket.getOutputStream();
                       ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
                        DataInputStream dataInputStream = new DataInputStream(inputStream);
                        byte buffer[] = new byte[1024];
                        dataInputStream.read(buffer);
                        String account=new String(buffer, 0, buffer.length);
                        User user=userService.getUserById(account);
                        objectOutputStream.writeObject(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
    }

