package com.xy.vmes.deecoop.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.dao.EmployeeMapper;
import com.xy.vmes.entity.Employee;
import com.xy.vmes.service.EmployeeService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：部门表 实现类
* 创建人：自动创建
* 创建时间：2018-07-20
*/
@Service
@Transactional(readOnly = true)
public class EmployeeServiceImp implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void save(Employee employee) throws Exception{
        employeeMapper.save(employee);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void delete(Employee employee) throws Exception{
        employeeMapper.delete(employee);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void update(Employee employee) throws Exception{
        employeeMapper.update(employee);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    @Cacheable(cacheNames = "employee", key = "''+#id")
    public Employee selectById(String id) throws Exception{
        return employeeMapper.selectById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void deleteById(String id) throws Exception{
        employeeMapper.deleteById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public Employee findById(PageData pd) throws Exception{
        return employeeMapper.findById(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public List<Employee> dataListPage(PageData pd,Pagination pg) throws Exception{
        return employeeMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public List<Employee> dataList(PageData pd) throws Exception{
        return employeeMapper.dataList(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        employeeMapper.deleteByIds(ids);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return employeeMapper.findColumnList();
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return employeeMapper.findDataList(pd);
    }

}



