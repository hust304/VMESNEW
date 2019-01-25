package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.MD5Utils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * 说明：用户管理Controller
 * @author 刘威 自动生成
 * @date 2018-07-26
 */
@RestController
@Slf4j
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @GetMapping("/system/user/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################user/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        User user = userService.selectById(id);
        model.putResult(user);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @PostMapping("/system/user/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################user/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        User user = (User)HttpUtils.pageData2Entity(pd, new User());
        userService.save(user);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @PostMapping("/system/user/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################user/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        User user = (User)HttpUtils.pageData2Entity(pd, new User());
        userService.update(user);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @GetMapping("/system/user/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################user/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        userService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @PostMapping("/system/user/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################user/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<User> userList = userService.dataListPage(pd,pg);
        model.putResult(userList);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @PostMapping("/system/user/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################user/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<User> userList = userService.dataList(pd);
        model.putResult(userList);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @GetMapping("/system/user/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################user/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

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
        Long endTime = System.currentTimeMillis();
        logger.info("################user/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    /**
     * @author 刘威 创建用户并且分配角色
     * @date 2018-07-26
     */
    @PostMapping("/system/user/addUser")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addUser()  throws Exception {
        logger.info("################user/addUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = userService.addUser(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/addUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 修改用户及角色信息
     * @date 2018-07-26
     */
    @PostMapping("/system/user/updateUser")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateUser()  throws Exception {
        logger.info("################user/updateUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = userService.updateUser(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/updateUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 批量重置密码
     * @date 2018-07-26
     */
    @PostMapping("/system/user/updatePasswords")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updatePasswords()  throws Exception {

        logger.info("################user/updatePasswords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = userService.updatePasswords(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/updatePasswords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 解除当前用户绑定员工
     * @date 2018-07-26
     */
    @PostMapping("/system/user/updateEmployeeUserUnbind")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateEmployeeUserUnbind()  throws Exception {

        logger.info("################user/updateEmployeeUserUnbind 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = userService.updateEmployeeUserUnbind(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/updateEmployeeUserUnbind 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 当前用户绑定员工
     * @date 2018-07-26
     */
    @PostMapping("/system/user/updateEmployeeUserBind")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateEmployeeUserBind() throws Exception {

        logger.info("################user/updateEmployeeUserBind 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = userService.updateEmployeeUserBind(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/updateEmployeeUserBind 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }






    /**
     * @author 刘威 查询公司用户使用情况
     * @date 2018-07-26
     */
    @PostMapping("/system/user/selectCountUserNum")
    public ResultModel selectCountUserNum()  throws Exception {

        logger.info("################user/selectCountUserNum 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = userService.selectCountUserNum(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/selectCountUserNum 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 修改用户及角色信息
     * @date 2018-07-26
     */
    @PostMapping("/system/user/deleteUsers")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteUsers()  throws Exception {

        logger.info("################user/deleteUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = userService.deleteUsers(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/deleteUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 用户列表分页
     * @date 2018-07-26
     */
    @PostMapping("/system/user/listPageUsers")
    public ResultModel listPageUsers()  throws Exception {

        logger.info("################user/listPageUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = userService.listPageUsers(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/listPageUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * Excel导出功能：
     * 1. 勾选指定行导出-(','逗号分隔的id字符串)
     * 2. 按查询条件导出(默认查询方式)
     * 参数说明:
     *   ids          : 业务id字符串-(','分隔的字符串)
     *   queryColumn  : 查询字段(sql where 子句)
     *   showFieldcode: 导出Excel字段Code-显示顺序按照字符串排列顺序-(','分隔的字符串)

     * 注意: 参数(ids,queryColumn)这两个参数是互斥的，(有且有一个参数不为空)
     *
     * @throws Exception
     */
    @PostMapping("/system/user/exportExcelUsers")
    public void exportExcelUsers() throws Exception {
        logger.info("################user/exportExcelUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        userService.exportExcelUsers(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/exportExcelUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

    }


}



