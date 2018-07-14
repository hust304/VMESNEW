package com.xy.vmes.demo.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.demo.dao.DepartmentMapper;
import com.xy.vmes.entity.Department;
import com.xy.vmes.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by luoyifan on 2018/7/14.
 */
@Service
@Transactional(readOnly = true)
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    @Cacheable(cacheNames = "department", key = "''+#id")
    public Department selectById(Long id) {
        return departmentMapper.selectById(id);
    }

    @Override
    public List<Department> selectAll(Pagination pagination) {
        return departmentMapper.selectAll(pagination);
    }
}
