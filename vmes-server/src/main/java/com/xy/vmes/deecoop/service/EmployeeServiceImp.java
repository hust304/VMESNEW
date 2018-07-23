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
* 说明：vmes_employee:员工表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-07-23
*/
@Service
@Transactional(readOnly = false)
public class EmployeeServiceImp implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void save(Employee employee) throws Exception{
        employeeMapper.insert(employee);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void update(Employee employee) throws Exception{
        employeeMapper.updateById(employee);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    //@Cacheable(cacheNames = "employee", key = "''+#id")
    public Employee selectById(String id) throws Exception{
        return employeeMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void deleteById(String id) throws Exception{
        employeeMapper.deleteById(id);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<Employee> dataListPage(PageData pd,Pagination pg) throws Exception{
        return employeeMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<Employee> dataList(PageData pd) throws Exception{
        return employeeMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return employeeMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return employeeMapper.findDataList(pd);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}



