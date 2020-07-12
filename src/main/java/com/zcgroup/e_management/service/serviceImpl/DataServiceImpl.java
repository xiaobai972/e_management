package com.zcgroup.e_management.service.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcgroup.e_management.entity.Data;
import com.zcgroup.e_management.mapper.DataMapper;
import com.zcgroup.e_management.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public int addData(Data data) {
        int res=-1;
        res=dataMapper.insert(data);
        return res;
    }

    @Override
    public Page<Data> getDatas(Page pages) {
        Page<Data> page=new Page<>(pages.getCurrent(),pages.getSize());
        dataMapper.selectPage(page,null);
        return page;
    }


}
