package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.base.dao.DepartmentCustomerMapper;
import com.xy.vmes.service.DepartmentCustomerService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentCustomerServiceImp implements DepartmentCustomerService {

    @Autowired
    private DepartmentCustomerMapper departmentCustomerMapper;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-24
     */
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return departmentCustomerMapper.getDataListPage(pd, pg);
    }
}
