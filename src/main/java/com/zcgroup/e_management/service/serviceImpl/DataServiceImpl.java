package com.zcgroup.e_management.service.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcgroup.e_management.entity.Data;
import com.zcgroup.e_management.mapper.DataMapper;
import com.zcgroup.e_management.networkCommunications.Server;
import com.zcgroup.e_management.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;
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


}
