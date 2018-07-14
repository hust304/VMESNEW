package com.xy.vmes.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by luoyifan on 2018/7/14.
 */
@Mapper
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {

    @Select("select * from sys_department")
    List<Department> selectAll(Pagination pagination);
}
