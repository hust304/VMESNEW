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
* 说明：部门表 实现类
* 创建人：自动创建
* 创建时间：2018-07-18
*/
@Service
@Transactional(readOnly = true)
public class DepartmentServiceImp implements DepartmentService {


    @Autowired
    private DepartmentMapper departmentMapper;

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void save(Department department) throws Exception{
        departmentMapper.save(department);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void delete(Department department) throws Exception{
        departmentMapper.delete(department);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void update(Department department) throws Exception{
        departmentMapper.update(department);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    @Cacheable(cacheNames = "department", key = "''+#id")
    public Department selectById(String id) throws Exception{
        return departmentMapper.selectById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void deleteById(String id) throws Exception{
        departmentMapper.deleteById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public Department findById(PageData pd) throws Exception{
        return departmentMapper.findById(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public List<Department> dataListPage(PageData pd,Pagination pg) throws Exception{
        return departmentMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public List<Department> dataList(PageData pd) throws Exception{
        return departmentMapper.dataList(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        departmentMapper.deleteByIds(ids);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return departmentMapper.findColumnList();
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return departmentMapper.findDataList(pd);
    }

}



