package com.xy.vmes.demo.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.DepartmentService;
import com.yvan.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luoyifan on 2018/7/14.
 */
@RestController
@Slf4j
public class RootController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/ok")
    public String ok() {
        return "OK";
    }

    @GetMapping("/department/{id}")
    public Object department(@PathVariable("id") Long id) {
        return departmentService.selectById(id);
    }

    @GetMapping("/departments")
    public Object department() {
        Pagination pagination = HttpUtils.parsePagination();
        return departmentService.selectAll(pagination);
    }
}
