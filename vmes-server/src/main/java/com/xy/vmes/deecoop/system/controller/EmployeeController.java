package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.ResponseCode;
import com.yvan.platform.RestException;
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
* 说明：vmes_employee:员工管理Controller
* @author 刘威 自动生成
* @date 2018-08-02
*/
@RestController
@Slf4j
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private EmployPostService employPostService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PostService postService;


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @GetMapping("/employee/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################employee/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Employee employee = employeeService.selectById(id);
        model.putResult(employee);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @PostMapping("/employee/save")
    public ResultModel save()  throws Exception {

        logger.info("################employee/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employeeService.save(employee);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @PostMapping("/employee/update")
    public ResultModel update()  throws Exception {

        logger.info("################employee/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employeeService.update(employee);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @GetMapping("/employee/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################employee/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        employeeService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @PostMapping("/employee/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################employee/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        List<Employee> employeeList = employeeService.dataListPage(pd,pg);
        model.putResult(employeeList);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @PostMapping("/employee/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################employee/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Employee> employeeList = employeeService.dataList(pd);
        model.putResult(employeeList);
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-02
    */
    @GetMapping("/employee/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################employee/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = employeeService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = employeeService.findDataList(pd);
                    request.setAttribute("varList", varList);
                }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    private boolean isExistColumn(PageData pd) throws Exception {
        List<Map> varList = employeeService.findDataList(pd);
        if(varList!=null&&varList.size()>0){
            return true;
        }
        return false;
    }

    private boolean isExistMobile(PageData pd) throws Exception {
        boolean isExist = userService.isExistMobile(pd);
        return isExist;
    }


    private EmployPost getMainEmployPost(String employId) throws Exception {
        Map columnMap = new HashMap();
        columnMap.put("employ_id",employId);
        columnMap.put("isplurality","0");
        columnMap.put("isdisable","0");
        List<EmployPost> employPostList = employPostService.selectByColumnMap(columnMap);
        if(employPostList!=null&&employPostList.size()>0){
            return employPostList.get(0);
        }
        return null;
    }

    /**
     * @author 刘威 新增员工信息同时需要根据情况新增用户信息
     * @date 2018-08-02
     */
    @GetMapping("/employee/addEmployeeAndUser")
    public ResultModel addEmployeeAndUser()  throws Exception {

        logger.info("################employee/addEmployeeAndUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String postId = pd.getString("postId");
        if(StringUtils.isEmpty(postId)){
            model.putMsg("岗位不能为空！！");
            model.putCode(1);
            return model;
        }
        String mobile = pd.getString("mobile");
        if(StringUtils.isEmpty(mobile)){
            model.putCode(2);
            model.putMsg("手机号不能为空！");
            return model;
        }
        mobile = mobile.trim();
        Post post = postService.selectById(postId);
        String  companyId = post.getCompanyId();

        //新增员工信息
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());

        //公司内部的工号唯一性校验
        PageData pdExist = new PageData();
        pdExist.putQueryStr("code = '"+employee.getCode()+"' and company_id = '"+companyId+"'");
        if(isExistColumn(pdExist)){
            model.putCode(3);
            model.putMsg("工号已存在，请重新输入！");
            return model;
        }
        employee.setMobile(mobile);
        employee.setCompanyId(companyId);
        employeeService.save(employee);
        //新增员工主岗信息
        EmployPost employPost = new EmployPost();
        employPost.setEmployId(employee.getId());
        employPost.setPostId(postId);
        employPost.setCuser(pd.getString("cuser"));
        employPost.setUuser(pd.getString("uuser"));
        employPost.setIsplurality("0");//主岗
        employPostService.save(employPost);

        //新增用户信息
        String  deptId = post.getDeptId();
        pd.put("deptId",deptId);
        try {
            userService.createUserAndRole(pd,employee);
        }catch (RestException e){
            model.putCode(e.getCode());
            model.putMsg(e.getMessage());
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/addEmployeeAndUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
     * @author 刘威 修改员工信息同时修改或新增用户信息（手机号，邮箱，角色）
     * @date 2018-08-02
     */
    @GetMapping("/employee/updateEmployeeAndUser")
    public ResultModel updateEmployeeAndUser()  throws Exception {

        logger.info("################employee/updateEmployeeAndUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String mobile = pd.getString("mobile");
        if(StringUtils.isEmpty(mobile)){
            model.putCode(2);
            model.putMsg("手机号不能为空！");
            return model;
        }


        //修改员工信息
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employee.setId(pd.getString("employId"));
        mobile = mobile.trim();
        employee.setMobile(mobile);
        employeeService.update(employee);


        //获取员工主岗信息，找到当前员工所在部门
        String employId = employee.getId();
        employee = employeeService.selectById(employId);

        //判断是否拥有用户信息，如果没有则新增，如果有则修改
        String userId = employee.getUserId();
        if(StringUtils.isEmpty(userId)){
            //新增用户信息
            EmployPost employPost = getMainEmployPost(employId);
            Post post = postService.selectById(employPost.getPostId());
            String deptId = post.getDeptId();
            pd.put("deptId",deptId);
            try {
                userService.createUserAndRole(pd,employee);
            }catch (RestException e){
                model.putCode(e.getCode());
                model.putMsg(e.getMessage());
                return model;
            }
        }else {
            //修改用户信息
            User user = userService.selectById(userId);
            //校验输入的手机号是否存在
            if(isExistMobile(pd)){
                model.putCode(3);
                model.putMsg("用户中该手机号已存在，请修改手机号！");
                return model;
            }
            user.setEmail(employee.getEmail());
            user.setEmployId(employee.getId());
            user.setMobile(employee.getMobile());
            user.setUuser(pd.getString("uuser"));

            //删除用户角色信息
            userRoleService.deleteRoleByUserId(user.getId());
            //新增用户角色信息
            UserRole userRole = new UserRole();
            userRole.setRoleId(pd.getString("roleId"));
            userRole.setUserId(user.getId());
            userRole.setCuser(pd.getString("cuser"));
            userRole.setUuser(pd.getString("uuser"));
            userRoleService.save(userRole);

        }


        Long endTime = System.currentTimeMillis();
        logger.info("################employee/updateEmployeeAndUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
     * @author 刘威  禁用员工信息包含主岗兼岗，同时禁用员工账号（支持批量删除，不支持物理删除）
     * @date 2018-08-02
     */
    @GetMapping("/employee/deleteEmployees")
    public ResultModel deleteEmployees()  throws Exception {

        logger.info("################employee/deleteEmployees 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();


        String employeeIds = pd.getString("ids");
        String[] ids = employeeIds.split(",");
        //禁用员工信息
        employeeService.updateToDisableByIds(ids);
        //禁用用户信息
        userService.updateToDisableByEmployIds(ids);
        //禁用用户岗位信息
        employPostService.updateToDisableByEmployIds(ids);

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/deleteEmployees 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威  单独启用禁用员工信息包含主岗兼岗，同时禁用员工账号
     * @date 2018-08-02
     */
    @GetMapping("/employee/updateEmployeePostState")
    public ResultModel updateEmployeePostState()  throws Exception {

        logger.info("################employee/updateEmployeePostState 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String isplurality = pd.getString("isplurality");
        if(StringUtils.isEmpty(isplurality) ){
            model.putCode(1);
            model.putMsg("是否兼岗不能为空！");
            return model;
        }
        String isdisable = pd.getString("isdisable");
        if(StringUtils.isEmpty(isdisable) ){
            model.putCode(2);
            model.putMsg("是否禁用不能为空！");
            return model;
        }
        String employPostId = pd.getString("employPostId");
        if(StringUtils.isEmpty(employPostId) ){
            model.putCode(3);
            model.putMsg("员工岗位ID不能为空！");
            return model;
        }
        EmployPost employPost = employPostService.selectById(employPostId);
        Employee employee = employeeService.selectById(employPost.getEmployId());
        User user = userService.selectById(employee.getUserId());
        String[] employIds = new String[1];
        employIds[0] = employPost.getEmployId();
        employPost.setIsdisable(isdisable);
        employPost.setUuser(pd.getString("uuser"));
        employee.setIsdisable(isdisable);
        employee.setUuser(pd.getString("uuser"));
        user.setIsdisable(isdisable);
        user.setUuser(pd.getString("uuser"));
        //如果是兼岗，只需要禁用开启当前兼岗即可
        if ("1".equals(isplurality)){
            employPostService.update(employPost);
        }
        //如果是主岗，只需要禁用的同时要禁用兼岗、员工、用户，启用时只需启用主岗
        else {
            if("1".equals(isdisable)){
                employPostService.updateToDisableByEmployIds(employIds);//同时禁用该员工的主岗和兼岗
            }else {
                employPostService.update(employPost);//启用员工主岗
            }
            employeeService.update(employee);//禁用启用员工
            userService.update(user);//禁用启用用户
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/updateEmployeePostState 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 变更员工岗位（只变更主岗，先禁用后新增）（支持批量操作）
     * @author 刘威
     * @date 2018-08-02
     */
    @GetMapping("/employee/updateForChangeEmployeePost")
    public ResultModel updateForChangeEmployeePost()  throws Exception {

        logger.info("################employee/updateForChangeEmployeePost 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String employPosts = pd.getString("employPosts");

//        employPosts ="[{\"employPostId\":\"3\",\"postId\":\"1\"}," +
//                "{\"employPostId\":\"3\",\"postId\":1532599975000}," +
//                "{\"employPostId\":\"3\",\"postId\":1532601003000}," +
//                "{\"employPostId\":\"3\",\"postId\":1532600923000}," +
//                "{\"employPostId\":\"3\",\"postId\":1532600802000}," +
//                "{\"employPostId\":\"3\",\"postId\":1532601034000}]";

        List employPostsList = YvanUtil.jsonToList(employPosts);
        if(employPostsList!=null&&employPostsList.size()>0){
            for(int i=0;i<employPostsList.size();i++){
                Map employPostsMap = (Map)employPostsList.get(i);
                if(employPostsMap!=null){
                    if(employPostsMap.get("employPostId")!=null && employPostsMap.get("postId")!=null){
                        //先禁用
                        EmployPost employPost = employPostService.selectById(employPostsMap.get("employPostId").toString());
                        employPost.setIsdisable("1");
                        employPost.setUuser(pd.getString("uuser"));
                        employPostService.update(employPost);
                        //后新增
                        EmployPost employPostNew = new EmployPost();
                        employPostNew.setPostId(employPostsMap.get("postId").toString());
                        employPostNew.setEmployId(employPost.getEmployId());
                        employPostNew.setIsplurality(employPost.getIsplurality());
                        employPostNew.setCuser(pd.getString("cuser"));
                        employPostNew.setUuser(pd.getString("uuser"));
                        employPostService.save(employPost);
                    }
                }
            }
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/updateForChangeEmployeePost 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * 变更员工岗位（只变更主岗，先禁用后新增）（支持批量操作）
     * @author 刘威
     * @date 2018-08-02
     */
    @GetMapping("/employee/addEmployToUser")
    public ResultModel addEmployToUser()  throws Exception {

        logger.info("################employee/addEmployToUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        StringBuffer msg = new StringBuffer();
        int success = 0;
        int error = 0;

        String employRoles = pd.getString("employRoles");

//        employRoles ="[{\"employId\":\"3\",\"roleId\":\"1\"}," +
//                "{\"employId\":\"3\",\"roleId\":1532599975000}," +
//                "{\"employId\":\"3\",\"roleId\":1532601003000}," +
//                "{\"employId\":\"3\",\"roleId\":1532600923000}," +
//                "{\"employId\":\"3\",\"roleId\":1532600802000}," +
//                "{\"employId\":\"3\",\"roleId\":1532601034000}]";

        List employRolesList = YvanUtil.jsonToList(employRoles);
        if(employRolesList!=null&&employRolesList.size()>0){
            for(int i=0;i<employRolesList.size();i++){
                Map employRolesMap = (Map)employRolesList.get(i);
                if(employRolesMap!=null){
                    if(employRolesMap.get("employId")!=null && employRolesMap.get("roleId")!=null){
                        Employee employee = employeeService.selectById(employRolesMap.get("employId").toString());
                        String msgHeader = "员工："+employee.getName()+"("+employee.getCode()+")    ";
                        //判断当前员工是否已经拥有账号信息，如果没有则新增，如果有则提示已存在
                        if(StringUtils.isEmpty(employee.getUserId())){
                            //获取当前员工主岗信息
                            EmployPost employPost = getMainEmployPost(employee.getId());
                            Post post = postService.selectById(employPost.getPostId());
                            String deptId = post.getDeptId();
                            pd.put("deptId",deptId);
                            pd.put("roleId",employRolesMap.get("roleId").toString());
                            try {
                                //新增用户信息
                                userService.createUserAndRole(pd,employee);
                                msg.append(msgHeader+"创建账号成功！");
                                success = success + 1;
                            }catch (RestException e){
                                msg.append(msgHeader+"创建账号失败，失败原因如下："+e.getMessage());
                                error = error + 1;
                            }
                        }else {
                            msg.append(msgHeader+"创建账号失败，失败原因如下：当前员工账号已存在");
                            error = error + 1;
                        }
                    }
                }
            }
        }
        msg.append("合计： 创建成功"+success+"个,创建失败"+error+"个");
        model.putMsg(msg.toString());
        Long endTime = System.currentTimeMillis();
        logger.info("################employee/addEmployToUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



