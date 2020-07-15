package com.zcgroup.e_management.service.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcgroup.e_management.dto.DataDto;
import com.zcgroup.e_management.entity.Data;
import com.zcgroup.e_management.mapper.DataMapper;
import com.zcgroup.e_management.networkCommunications.Server;
import com.zcgroup.e_management.service.DataService;
import com.zcgroup.e_management.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private UserService userService;
    protected static final Logger logger = LoggerFactory.getLogger(Server.class);

    @Override
    public int addData(Data data) {
        try {
            int res = -1;
            res = dataMapper.insert(data);
            return res;
        }catch (Exception e){
            logger.info("上传数据失败");
            return -1;
        }
    }

    @Override
    public Page<Data> getDatas(Page pages) {
        Page<Data> page=new Page<>(pages.getCurrent(),pages.getSize());
        dataMapper.selectPage(page,null);
        return page;
    }

    @Override
    public List<DataDto> getHealthDatas() {
        List<Data> dataList=new ArrayList<>();
        List<DataDto> dataDtos=new ArrayList<>();
        SimpleDateFormat f = new SimpleDateFormat(" yyyy年MM月dd日  HH:mm:ss");
        dataList=dataMapper.selectList(null);
       for(Data item:dataList) {
           String UserName = userService.getUserById(item.getUserId()).getName();
           DataDto dataDto = new DataDto();
           if(item.getAroundInjection().equals("1")) {
               dataDto.setAroundInjection("有");
           }else
           {
               dataDto.setAroundInjection("无");
           }
           dataDto.setLocation(item.getLocation());
           dataDto.setName(UserName);
           dataDto.setTemperature(item.getTemperature()+"℃");
           dataDto.setTime(f.format(item.getTime()));
           dataDto.setAccount(item.getUserId());
           dataDtos.add(dataDto);
       }

        return dataDtos;
    }

}
