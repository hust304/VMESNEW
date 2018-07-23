package com.xy.vmes.deecoop.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.dao.DepartmentMapper;
import com.xy.vmes.entity.Department;
import com.xy.vmes.service.DepartmentService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_department:系统部门表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-07-23
*/
@Service
@Transactional(readOnly = false)
public class DepartmentServiceImp implements DepartmentService {


    @Autowired
    private DepartmentMapper departmentMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void save(Department department) throws Exception{
        departmentMapper.insert(department);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void update(Department department) throws Exception{
        departmentMapper.updateById(department);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    @Cacheable(cacheNames = "department", key = "''+#id")
    public Department selectById(String id) throws Exception{
        return departmentMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void deleteById(String id) throws Exception{
        departmentMapper.deleteById(id);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<Department> dataListPage(PageData pd,Pagination pg) throws Exception{
        return departmentMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<Department> dataList(PageData pd) throws Exception{
        return departmentMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return departmentMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return departmentMapper.findDataList(pd);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}



