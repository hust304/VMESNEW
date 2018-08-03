package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.EmployeeMapper;
import com.xy.vmes.entity.Employee;
import com.xy.vmes.service.EmployeeService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_employee:员工管理 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-08-02
*/
@Service
@Transactional(readOnly = false)
public class EmployeeServiceImp implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void save(Employee employee) throws Exception{
        employee.setId(Conv.createUuid());
        employee.setCdate(new Date());
        employee.setUdate(new Date());
        employeeMapper.insert(employee);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void update(Employee employee) throws Exception{
        employee.setUdate(new Date());
        employeeMapper.updateById(employee);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    //@Cacheable(cacheNames = "employee", key = "''+#id")
    public Employee selectById(String id) throws Exception{
        return employeeMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void deleteById(String id) throws Exception{
        employeeMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        employeeMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<Employee> dataListPage(PageData pd,Pagination pg) throws Exception{
        return employeeMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<Employee> dataList(PageData pd) throws Exception{
        return employeeMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return employeeMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return employeeMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        employeeMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-02
    */
    @Override
    public List<Employee> selectByColumnMap(Map columnMap) throws Exception{
    List<Employee> employeeList =  employeeMapper.selectByMap(columnMap);
        return employeeList;
    }


    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-02
     */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return employeeMapper.getColumnList();
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-02
     */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return employeeMapper.getDataList(pd);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-02
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return employeeMapper.getDataListPage(pd,pg);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-02
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        employeeMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    /**
     * 创建人：刘威
     * 创建时间：2018-08-03
     */
    @Override
    public void  updateUserToDisableByIds(String[] ids) throws Exception{
        employeeMapper.updateUserToDisableByIds(ids);
    }

    /**
     * 创建人：刘威
     * 创建时间：2018-08-03
     */
    @Override
    public void  updatePostToDisableByIds(String[] ids) throws Exception{
        employeeMapper.updatePostToDisableByIds(ids);
    }
}



