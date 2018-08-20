package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.User;
import com.xy.vmes.entity.UserRole;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.UserRoleService;
import com.xy.vmes.service.UserService;
import com.yvan.*;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CoderuleService coderuleService;

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @GetMapping("/user/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################user/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
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
    @PostMapping("/user/save")
    public ResultModel save()  throws Exception {

        logger.info("################user/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
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
    @PostMapping("/user/update")
    public ResultModel update()  throws Exception {

        logger.info("################user/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
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
    @GetMapping("/user/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################user/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
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
    @PostMapping("/user/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################user/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
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
    @PostMapping("/user/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################user/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
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
    @GetMapping("/user/excelExport")
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
    @GetMapping("/user/addUser")
    public ResultModel addUser()  throws Exception {

        logger.info("################user/addUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        //新增用户信息
        User user = (User)HttpUtils.pageData2Entity(pd, new User());

        String mobile = user.getMobile();
        if(StringUtils.isEmpty(mobile)){
            model.putCode(1);
            model.putMsg("该用户手机号不能为空！");
            return model;
        }
        mobile = mobile.trim();
        user.setMobile(mobile);
        //如果用户设置了密码那就用设置的密码加密，如果没有设置密码，那么就用手机号后六位进行加密作为默认密码
        if(StringUtils.isEmpty(user.getPassword())){
            String password = mobile.substring(mobile.length()-6,mobile.length());
            if(password!=null&&password.length()==6){
                user.setPassword(MD5Utils.MD5(password));
            }else{
                model.putCode(2);
                model.putMsg("输入手机号长度错误！");
                return model;
            }
        }else{
            user.setPassword(MD5Utils.MD5(user.getPassword()));
        }

        String deptId = pd.getString("deptId");
        if(StringUtils.isEmpty(deptId)){
            model.putCode(3);
            model.putMsg("所属部门不能为空！");
            return model;
        }
        Department department = departmentService.selectById(deptId);
        String companyId = department.getId1();
        if(!StringUtils.isEmpty(companyId)){
            user.setCompanyId(companyId);
            String code = coderuleService.createCoder(companyId,"vmes_user");
            if(StringUtils.isEmpty(code)){
                model.putCode(4);
                model.putMsg("编码规则创建异常，请重新操作！");
                return model;
            }
            user.setUserCode(code);
        }else{
            //如果没有公司ID，那么就是创建根节点下的管理员账号，这个时候定义的用户名就是账号
            user.setCompanyId(department.getId0());
            user.setUserCode(user.getUserName());
        }

        if(isExistMobile(pd)){
            model.putCode(5);
            model.putMsg("该用户手机号已存在！");
            return model;
        }

        userService.save(user);
        //新增用户角色信息
        UserRole userRole = new UserRole();
        userRole.setRoleId(pd.getString("roleId"));
        userRole.setUserId(user.getId());
        userRole.setCuser(pd.getString("cuser"));
        userRole.setUuser(pd.getString("uuser"));
        userRoleService.save(userRole);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/addUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 修改用户及角色信息
     * @date 2018-07-26
     */
    @GetMapping("/user/updateUser")
    public ResultModel updateUser()  throws Exception {

        logger.info("################user/updateUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        //修改用户信息
        User user = (User)HttpUtils.pageData2Entity(pd, new User());
        user.setPassword(MD5Utils.MD5(user.getPassword()));
        String mobile = user.getMobile();
        if(StringUtils.isEmpty(mobile)){
            model.putCode(2);
            model.putMsg("该用户手机号不能为空！");
            return model;
        }

        if(isExistMobile(pd)){
            model.putCode(1);
            model.putMsg("该用户手机号已存在！");
            return model;
        }
        mobile = mobile.trim();
        user.setMobile(mobile);
        userService.update(user);
        //删除用户角色信息
        userRoleService.deleteRoleByUserId(user.getId());
        //新增用户角色信息
        UserRole userRole = new UserRole();
        userRole.setRoleId(pd.getString("roleId"));
        userRole.setUserId(user.getId());
        userRole.setCuser(pd.getString("cuser"));
        userRole.setUuser(pd.getString("uuser"));
        userRoleService.save(userRole);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/updateUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    private boolean isExistMobile(PageData pd) throws Exception {
        boolean isExist = userService.isExistMobile(pd);
        return isExist;
    }


    /**
     * @author 刘威 修改用户及角色信息
     * @date 2018-07-26
     */
    @GetMapping("/user/deleteUsers")
    public ResultModel deleteUsers()  throws Exception {

        logger.info("################user/deleteUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String userIds = pd.getString("ids");
        String[] ids = userIds.split(",");

        userService.updateToDisableByIds(ids);

        Long endTime = System.currentTimeMillis();
        logger.info("################user/deleteUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 用户列表分页
     * @date 2018-07-26
     */
    @GetMapping("/user/listPageUsers")
    public ResultModel listPageUsers()  throws Exception {

        logger.info("################user/listPageUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();

        Map result = new HashMap();
        List<LinkedHashMap> titles = userService.getColumnList();

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(titles!=null&&titles.size()>0){
            LinkedHashMap<String, String> titlesMap = titles.get(0);
            for (Map.Entry<String, String> entry : titlesMap.entrySet()) {
                LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                if(entry.getKey().indexOf("_hide")>0){
                    titlesLinkedMap.put(entry.getKey().replace("_hide",""),entry.getValue());
                    titlesHideList.add(entry.getKey().replace("_hide",""));
                    varModelMap.put(entry.getKey().replace("_hide",""),"");
                }else{
                    titlesLinkedMap.put(entry.getKey(),entry.getValue());
                    varModelMap.put(entry.getKey(),"");
                }
                titlesList.add(titlesLinkedMap);
            }
        }
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);


        List<Map> varMapList = new ArrayList();
        List<Map> varList = userService.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################user/listPageUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-26
     */
    @GetMapping("/user/exportExcelUsers")
    public void exportExcelUsers()  throws Exception {

        logger.info("################user/exportExcelUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = userService.getColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = userService.getDataList(pd);
                request.setAttribute("varList", varList);
            }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################user/exportExcelUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


}



