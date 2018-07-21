package com.xy.vmes.deecoop.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.UserService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;


/**
* 说明：部门表 Controller
* 创建人：自动创建
* 创建时间：2018-07-20
*/
@RestController
@Slf4j
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
    * 创建人：陈刚
    * 创建时间：2018-07-20
    */
    @GetMapping("/user/selectById/{id}")
    public String selectById(@PathVariable("id") String id) {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            User user = userService.selectById(id);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",user);
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################user/selectById################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }



    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/user/findById")
    public String findById() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            User user = userService.findById(pd);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",user);
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################user/findById################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/user/save")
    public String save() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            User user = (User)HttpUtils.pageData2Entity(pd, new User());
            userService.save(user);
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################user/save################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/user/update")
    public String update() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            User user = (User)HttpUtils.pageData2Entity(pd, new User());
            userService.update(user);
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################user/update################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/user/delete")
    public String delete() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            User user = (User)HttpUtils.pageData2Entity(pd, new User());
            userService.delete(user);
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################user/delete################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }


    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @GetMapping("/user/deleteById/{id}")
    public String deleteById(@PathVariable("id") String id) {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            userService.deleteById(id);
            result.put("code",0);
            result.put("msg","执行成功！");
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################user/deleteById################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/user/dataListPage")
    public String dataListPage() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            Pagination pg = HttpUtils.parsePagination();
            List<User> userList = userService.dataListPage(pd,pg);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",userList);
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################user/dataListPage################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @PostMapping("/user/dataList")
    public String dataList() {
        Gson gosn = new Gson();
        Map result = new HashMap();
        try {
            PageData pd = HttpUtils.parsePageData();
            List<User> userList = userService.dataList(pd);
            result.put("code",0);
            result.put("msg","执行成功！");
            result.put("result",userList);
        }catch (Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            logger.error("################user/dataList################# 执行异常:"+sw.toString());
            result.put("code",1);
            result.put("msg","执行异常！");
            result.put("result",sw.toString());
        }
        return gosn.toJson(result);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-20
    */
    @GetMapping("/user/excelExport")
    public void excelExport() {

        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();
        response.addHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods","*");
        response.addHeader("Access-Control-Max-Age","100");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.addHeader("Access-Control-Allow-Credentials","false");
        try {
                ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
                    @Override
                    public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                        // TODO Auto-generated method stub
                        PageData pd = HttpUtils.parsePageData();
                        List<LinkedHashMap> titles = userService.findColumnList();
                        request.setAttribute("titles", titles.get(0));
                        List<Map> varList = userService.findDataList(pd);
                        request.setAttribute("varList", varList);
                    }
                });
            }catch(Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                logger.error("################user/excelExport################# 执行异常:"+sw.toString());
            }

    }



}



