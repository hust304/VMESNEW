package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.MD5Utils;
import com.yvan.PageData;
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


//    private boolean isExistMobile(PageData pd) throws Exception {
//        List<Map> varList = employeeService.findDataList(pd);
//        if(varList!=null&&varList.size()>0){
//            return true;
//        }
//        return false;
//    }

    private boolean isExistMobile(PageData pd) throws Exception {
        boolean isExist = userService.isExistMobile(pd);
        return isExist;
    }


    private EmployPost getMainEmployPost(String employeeId) throws Exception {
        Map columnMap = new HashMap();
        columnMap.put("employ_id",employeeId);
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
     * @date 2018-07-26
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
        String  deptId = post.getDeptId();



        //新增员工信息
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employeeService.save(employee);
        //新增员工主岗信息
        EmployPost employPost = new EmployPost();
        employPost.setEmployId(employee.getId());
        employPost.setPostId(postId);
        employPost.setCuser(pd.getString("cuser"));
        employPost.setUuser(pd.getString("uuser"));
        employPostService.save(employPost);

        //新增用户信息
        String roleId = pd.getString("roleId");
        User user = new User();
        if(!StringUtils.isEmpty(roleId)){

            if(isExistMobile(pd)){
                model.putCode(3);
                model.putMsg("用户中该手机号已存在，请修改手机号！");
                return model;
            }

            user.setUserCode(userService.createCoder(companyId));
            user.setCompanyId(companyId);
            user.setDeptId(deptId);
            user.setEmail(employee.getEmail());
            user.setEmployId(employee.getId());
            user.setMobile(employee.getMobile());
            user.setUserType("内部用户");
            user.setCuser(pd.getString("cuser"));
            user.setUuser(pd.getString("uuser"));
            //使用手机号后六位进行加密作为默认密码
            String password = mobile.substring(mobile.length()-6,mobile.length());
            if(password!=null&&password.length()==6){
                user.setPassword(MD5Utils.MD5(password));
            }else{
                model.putCode(4);
                model.putMsg("输入手机号长度错误！");
                return model;
            }
            userService.save(user);

            //修改员工表用户ID
            employee.setUserId(user.getId());
            employeeService.update(employee);

            //新增用户角色信息
            UserRole userRole = new UserRole();
            userRole.setRoleId(pd.getString("roleId"));
            userRole.setUserId(user.getId());
            userRole.setCuser(pd.getString("cuser"));
            userRole.setUuser(pd.getString("uuser"));
            userRoleService.save(userRole);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/addEmployeeAndUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 修改员工信息同时修改或新增用户信息（手机号，邮箱，角色）
     * @date 2018-07-26
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
        mobile = mobile.trim();

        //新增员工信息
        Employee employee = (Employee)HttpUtils.pageData2Entity(pd, new Employee());
        employeeService.update(employee);

        String employeeId = employee.getId();
        //获取员工主岗信息，找到当前员工所在部门
        EmployPost employPost = getMainEmployPost(employeeId);
        Post post = postService.selectById(employPost.getPostId());
        String deptId = post.getDeptId();

        employee = employeeService.selectById(employeeId);
        String roleId = pd.getString("roleId");
        String userId = employee.getUserId();
        if(StringUtils.isEmpty(userId)){
            //新增用户信息
            User user = new User();
            if(!StringUtils.isEmpty(roleId)){
                //校验输入的手机号是否存在
                if(isExistMobile(pd)){
                    model.putCode(3);
                    model.putMsg("用户中该手机号已存在，请修改手机号！");
                    return model;
                }

                user.setUserCode(userService.createCoder(employee.getCompanyId()));
                user.setCompanyId(employee.getCompanyId());
                user.setDeptId(deptId);
                user.setEmail(employee.getEmail());
                user.setEmployId(employee.getId());
                user.setMobile(employee.getMobile());
                user.setUserType("内部用户");
                user.setCuser(pd.getString("cuser"));
                user.setUuser(pd.getString("uuser"));
                //使用手机号后六位进行加密作为默认密码
                String password = mobile.substring(mobile.length()-6,mobile.length());
                if(password!=null&&password.length()==6){
                    user.setPassword(MD5Utils.MD5(password));
                }else{
                    model.putCode(4);
                    model.putMsg("输入手机号长度错误！");
                    return model;
                }
                userService.save(user);

                //修改员工表用户ID
                employee.setUserId(user.getId());
                employeeService.update(employee);

                //新增用户角色信息
                UserRole userRole = new UserRole();
                userRole.setRoleId(pd.getString("roleId"));
                userRole.setUserId(user.getId());
                userRole.setCuser(pd.getString("cuser"));
                userRole.setUuser(pd.getString("uuser"));
                userRoleService.save(userRole);
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
     * @date 2018-07-26
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

        employeeService.updateToDisableByIds(ids);

//        employeeService.updateUserToDisableByIds(ids);
//
//        employeeService.updatePostToDisableByIds(ids);

        Long endTime = System.currentTimeMillis();
        logger.info("################employee/deleteEmployees 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



