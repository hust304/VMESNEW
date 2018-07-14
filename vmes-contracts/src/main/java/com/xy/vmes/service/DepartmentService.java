package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Department;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by luoyifan on 2018/7/14.
 */
public interface DepartmentService {

    Department selectById(Long id);

    List<Department> selectAll(Pagination pagination);

}
