package com.xy.vmes.deecoop.controller;

import com.xy.vmes.entity.Department;
import com.xy.vmes.service.DepartmentService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.Tree;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明：树形结构 Controller (部门,菜单,字典)树形结构
 * 创建人：陈刚
 * 创建时间：2018-07-20
 */
@RestController
@Slf4j
public class TreeLoadController {
    private Logger logger = LoggerFactory.getLogger(TreeLoadController.class);

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获得部门树形结构
     * 当前部门节点下面所有子节点树形结构
     *
     * 创建人：陈刚
     * 创建时间：2018-07-20
     */
    @GetMapping("/treeLoad/departmentTreeLoad")
    public String departmentTreeLoad() {
        PageData mapObj = HttpUtils.parsePageData();

        //递归调用获得(当前部门+当前部门下所有子部门)List结构体
        Department detp = new Department();
        //detp.setId1("1");
        //detp.setName("公司1");
        //detp.setLayer(Integer.valueOf(1));
        detp = null;
//        Tree<Department> treeObj = departmentService.findTree(detp);

        return null;
    }
}
