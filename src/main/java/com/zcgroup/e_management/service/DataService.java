package com.zcgroup.e_management.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcgroup.e_management.entity.Data;

public interface DataService {
    /**
     * 插入一条数据
     * @param data
     * @return
     */
    public int addData(Data data);

    /**
     * 获取所有数据项
     * @return
     */
    public Page<Data> getDatas(Page page);
}
