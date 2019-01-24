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
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserEmployeeService userEmployeeService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    UserDefinedMenuService userDefinedMenuService;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;

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
    @Transactional(rollbackFor=Exception.class)
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
    @Transactional(rollbackFor=Exception.class)
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
    @Transactional(rollbackFor=Exception.class)
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
    @PostMapping("/user/addUser")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addUser()  throws Exception {
        logger.info("################user/addUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pd = HttpUtils.parsePageData();
        User user = (User)HttpUtils.pageData2Entity(pd, new User());

        //A. 手机号验证
        String mobile = user.getMobile();
        if(mobile == null || mobile.trim().length() == 0){
            model.putCode(1);
            model.putMsg("该用户手机号不能为空！");
            return model;
        }
        if (mobile.trim().length() != 11) {
            model.putCode(1);
            model.putMsg("手机号长度错误！");
            return model;
        }
        if(isExistMobile(pd)){
            model.putCode(1);
            model.putMsg("该用户手机号已存在！");
            return model;
        }
        user.setMobile(mobile.trim());

        //B. 通过手机号-设置用户默认密码
        //如果用户设置了密码那就用设置的密码加密，如果没有设置密码，那么就用手机号后六位进行加密作为默认密码
        if(StringUtils.isEmpty(user.getPassword())){
            if(mobile!=null&&mobile.trim().length()>6){
                mobile = mobile.trim();
                String password = mobile.substring(mobile.length()-6,mobile.length());
                user.setPassword(MD5Utils.MD5(password));
            }else{
                model.putCode(2);
                model.putMsg("输入手机号长度错误！");
                return model;
            }
        }else{
            user.setPassword(MD5Utils.MD5(user.getPassword()));
        }

        //C. 部门
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
        }else{
            companyId = department.getId0();
            user.setCompanyId(companyId);
        }

        //设置用户编码
        if(StringUtils.isEmpty(user.getUserCode())){
            String code = coderuleService.createCoder(companyId,"vmes_user");
            if(StringUtils.isEmpty(code)){
                model.putCode(4);
                model.putMsg("编码规则创建异常，请重新操作！");
                return model;
            }
            user.setUserCode(code);
        }

        //D. 验证企业用户数
        List<Map> countUserNum = checkCompanyUserNum(deptId,null);
        if(countUserNum!=null&&countUserNum.size()>0){
            Map userNumMap = countUserNum.get(0);
            if(userNumMap.get("isFull")!=null){
                String isFull = userNumMap.get("isFull").toString();
                if(!StringUtils.isEmpty(isFull)&&"1".equals(isFull)){
                    model.putCode(7);
                    model.putMsg("当前公司用户数已满员，请联系平台相关人员购买用户数！");
                    return model;
                }
            }
        }else{
            model.putCode(8);
            model.putMsg("公司当前用户数查询异常！");
            return model;
        }

        String employeeId = pd.getString("employeeId");
        if (employeeId != null && employeeId.trim().length() > 0) {
            user.setEmployId(employeeId);
        }
        userService.save(user);

        String roleId = pd.getString("roleId");
        if (roleId != null && roleId.trim().length() > 0) {
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(user.getId());
            userRole.setCuser(pd.getString("cuser"));
            userRole.setUuser(pd.getString("uuser"));
            userRoleService.save(userRole);
        }

        if (employeeId != null && employeeId.trim().length() > 0) {
            Employee employee = employeeService.findEmployeeById(employeeId);
            //mobile:手机号码
            employee.setMobile(user.getMobile());
            //email:邮箱地址
            employee.setEmail(user.getEmail());
            //user_name:姓名->name:员工姓名
            employee.setName(user.getUserName());
            employee.setUserId(user.getId());
            //是否开通用户(0:不开通 1:开通 is null 不开通)
            employee.setIsOpenUser("1");
            employeeService.update(employee);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################user/addUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 修改用户及角色信息
     * @date 2018-07-26
     */
    @PostMapping("/user/updateUser")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateUser()  throws Exception {
        logger.info("################user/updateUser 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pd = HttpUtils.parsePageData();
        User user = userService.findUserById(pd.getString("id"));

        //A. 手机号验证
        String mobile = pd.getString("mobile");
        String email = pd.getString("email");
        String userName = pd.getString("userName");
        if(mobile == null || mobile.trim().length() == 0){
            model.putCode(1);
            model.putMsg("该用户手机号不能为空！");
            return model;
        }
        if (mobile.trim().length() != 11) {
            model.putCode(1);
            model.putMsg("手机号长度错误！");
            return model;
        }
        if(isExistMobile(pd)){
            model.putCode(1);
            model.putMsg("该用户手机号已存在！");
            return model;
        }
        user.setMobile(mobile.trim());

        //B. 通过手机号-设置用户默认密码
        //如果用户设置了密码那就用设置的密码加密，如果没有设置密码，那么就用手机号后六位进行加密作为默认密码
        if(StringUtils.isEmpty(pd.getString("password"))){
            if(mobile!=null&&mobile.trim().length()>6){
                mobile = mobile.trim();
                String password = mobile.substring(mobile.length()-6,mobile.length());
                user.setPassword(MD5Utils.MD5(password));
            }else{
                model.putCode(2);
                model.putMsg("输入手机号长度错误！");
                return model;
            }
        }else{
            user.setPassword(MD5Utils.MD5(pd.getString("password")));
        }

        //删除用户角色信息
        userRoleService.deleteUserRoleByUserId(user.getId());
        //新增用户角色信息
        if(!StringUtils.isEmpty(pd.getString("roleId"))){
            UserRole userRole = new UserRole();
            userRole.setRoleId(pd.getString("roleId"));
            userRole.setUserId(user.getId());
            userRole.setCuser(pd.getString("cuser"));
            userRole.setUuser(pd.getString("uuser"));
            userRoleService.save(userRole);
        }

        //原绑定员工
        String old_employeeId = user.getEmployId();
        if (old_employeeId != null && old_employeeId.trim().length() > 0) {
            Employee employee = employeeService.findEmployeeById(old_employeeId);
            if (employee != null) {
                employee.setUserId(null);
                //是否开通用户(0:不开通 1:开通 is null 不开通)
                employee.setIsOpenUser("0");
                employeeService.updateAll(employee);
            }
        }

        //新绑定员工
        String employeeId = pd.getString("employeeId");
        if (employeeId != null && employeeId.trim().length() > 0) {
            Employee employee = employeeService.findEmployeeById(employeeId);
            if (employee != null) {
                employee.setUserId(user.getId());
                //是否开通用户(0:不开通 1:开通 is null 不开通)
                employee.setIsOpenUser("1");
                employee.setMobile(mobile);
                employee.setEmail(email);
//                employee.setName(userName);
                employeeService.update(employee);
            }

            user.setEmployId(employeeId);
            //mobile:手机号码
            user.setMobile(mobile);
            //email:邮箱地址
            user.setEmail(email);
            //user_name:姓名->name:员工姓名
            user.setUserName(userName);
        }
        userService.update(user);

        Long endTime = System.currentTimeMillis();
        logger.info("################user/updateUser 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    private boolean isExistMobile(PageData pd) throws Exception {
        boolean isExist = userService.isExistMobile(pd);
        return isExist;
    }

    private boolean isExistUserCode(String userCode) throws Exception {
        boolean isExist = false;
        PageData pd = new PageData();
        pd.putQueryStr("user_code = '"+userCode+"'");
        List<Map> userList = userService.findDataList(pd);
        if(userList!=null&&userList.size()>0){
            isExist = true;
        }
        return isExist;
    }

    /**
     * @author 刘威 批量重置密码
     * @date 2018-07-26
     */
    @PostMapping("/user/updatePasswords")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updatePasswords()  throws Exception {

        logger.info("################user/updatePasswords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String userIds = pd.getString("ids");
        String[] ids = userIds.split(",");

        if(ids!=null&&ids.length>0){
            for(int i=0;i<ids.length;i++){
                String id =  ids[i];
                User user = userService.selectById(id);
                if(StringUtils.isEmpty(user.getMobile())){
                    user.setPassword(MD5Utils.MD5("123"));
                }else{
                    String mobile = user.getMobile();
                    if(mobile!=null&&mobile.trim().length()>6){
                        mobile = mobile.trim();
                        String password = mobile.substring(mobile.length()-6,mobile.length());
                        user.setPassword(MD5Utils.MD5(password));
                    }else{
                        model.putCode(1);
                        model.putMsg("用户"+user.getUserName()+"的手机号长度错误！");
                        return model;
                    }

                }
                userService.update(user);
            }
        }



        Long endTime = System.currentTimeMillis();
        logger.info("################user/updatePasswords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 解除当前用户绑定员工
     * @date 2018-07-26
     */
    @PostMapping("/user/updateEmployeeUserUnbind")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateEmployeeUserUnbind()  throws Exception {

        logger.info("################user/updateEmployeeUserUnbind 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String userId = pd.getString("id");
        String employeeId = pd.getString("employeeId");

        if(!StringUtils.isEmpty(userId)){
            User user = userService.selectById(userId);
            user.setEmployId(null);
            userService.updateAll(user);
        }

        if(!StringUtils.isEmpty(employeeId)){
            Employee employee = employeeService.selectById(employeeId);
            employee.setUserId(null);
            //是否开通用户(0:不开通 1:开通 is null 不开通)
            employee.setIsOpenUser("0");
            employeeService.updateAll(employee);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################user/updateEmployeeUserUnbind 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 当前用户绑定员工
     * @date 2018-07-26
     */
    @PostMapping("/user/updateEmployeeUserBind")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateEmployeeUserBind() throws Exception {

        logger.info("################user/updateEmployeeUserBind 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String userId = pd.getString("id");
        if (userId == null || userId.trim().length() == 0) {
            model.putCode(1);
            model.putMsg("用户id为空或空字符串！");
            return model;
        }

        User user = userService.selectById(userId);

        //原绑定员工
        String old_employeeId = user.getEmployId();
        if (old_employeeId != null && old_employeeId.trim().length() > 0) {
            Employee employee = employeeService.findEmployeeById(old_employeeId);
            if (employee != null) {
                employee.setUserId(null);
                //是否开通用户(0:不开通 1:开通 is null 不开通)
                employee.setIsOpenUser("0");
                employeeService.updateAll(employee);
            }
        }

        //新绑定员工
        String employeeId = pd.getString("employeeId");
        if (employeeId != null && employeeId.trim().length() > 0) {
            Employee employee = employeeService.findEmployeeById(employeeId);
            if (employee != null) {
                employee.setUserId(user.getId());
                //是否开通用户(0:不开通 1:开通 is null 不开通)
                employee.setIsOpenUser("1");
                employeeService.update(employee);
            }

            user.setEmployId(employeeId);
            //mobile:手机号码
            user.setMobile(employee.getMobile());
            //email:邮箱地址
            user.setEmail(employee.getEmail());
            //user_name:姓名->name:员工姓名
            user.setUserName(employee.getName());
        }

        userService.update(user);

        Long endTime = System.currentTimeMillis();
        logger.info("################user/updateEmployeeUserBind 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    public List<Map> checkCompanyUserNum(String deptId,String queryStr)  throws Exception {
        PageData pd = new PageData();
        pd.put("deptId",deptId);
        pd.putQueryStr(queryStr);
        List<Map>  countUserNum =  userService.selectCountUserNum(pd);
        return  countUserNum;
    }


    /**
     * @author 刘威 查询公司用户使用情况
     * @date 2018-07-26
     */
    @PostMapping("/user/selectCountUserNum")
    public ResultModel selectCountUserNum()  throws Exception {

        logger.info("################user/selectCountUserNum 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String deptId = pd.getString("deptId");
        if(StringUtils.isEmpty(deptId)){
            model.putCode(1);
            model.putMsg("部门ID不能为空！");
            return model;
        }
        List<Map>  countUserNum =  checkCompanyUserNum(deptId,null);
//        List<Map>  countUserNum =  userService.selectCountUserNum(pd);
        if(countUserNum!=null&&countUserNum.size()>0){
            model.putResult(countUserNum.get(0));
        }else{
            model.putCode(2);
            model.putMsg("公司当前用户数查询异常！");
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################user/selectCountUserNum 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 修改用户及角色信息
     * @date 2018-07-26
     */
    @PostMapping("/user/deleteUsers")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteUsers()  throws Exception {

        logger.info("################user/deleteUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String userIds = pd.getString("ids");
        String[] ids = userIds.split(",");

        for (int i = 0; i < ids.length; i++) {
            String userId = ids[i];
            //1. 删除(vmes_user_role)用户角色表
            userRoleService.deleteUserRoleByUserId(userId);
            //2. 删除(vmes_user_defined_menu)用户主页表
            userDefinedMenuService.deleteUserDefinedMenuByUserId(userId);

            //3. 修改员工表(vmes_employee)-字段user_id 设置为 Null
            //用户id查询(vmes_user)
            Map<String, Object> mapObject = userEmployeeService.findViewUserEmployByUserId(userId);
            if (mapObject != null) {
                Employee employee = userEmployeeService.mapObject2Employee(mapObject, null);
                employee.setUserId(null);
                //是否开通用户(0:不开通 1:开通 is null 不开通)
                employee.setIsOpenUser("0");
                employeeService.updateAll(employee);
            }
        }

        //3. 删除(vmes_user)用户表
        userService.deleteByIds(ids);

        Long endTime = System.currentTimeMillis();
        logger.info("################user/deleteUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 用户列表分页
     * @date 2018-07-26
     */
    @PostMapping("/user/listPageUsers")
    public ResultModel listPageUsers()  throws Exception {

        logger.info("################user/listPageUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("user");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        PageData pd = HttpUtils.parsePageData();
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = userService.getDataListPage(pd, pg);
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
        result.put("pageData", pg);
        model.putResult(result);

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
    @PostMapping("/user/exportExcelUsers")
    public void exportExcelUsers() throws Exception {
        logger.info("################user/exportExcelUsers 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("user");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        PageData pd = HttpUtils.parsePageData();
        String ids = pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = userService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response  = HttpUtils.currentResponse();


        //查询数据-Excel文件导出
        //String fileName = "Excel数据字典数据导出";
        String fileName = "ExcelUser";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################user/exportExcelUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

    }

//    /**
//     * @author 刘威 自动创建，禁止修改
//     * @date 2018-07-26
//     */
//    @GetMapping("/user/exportExcelUsers")
//    public void exportExcelUsers()  throws Exception {
//
//        logger.info("################user/exportExcelUsers 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        HttpServletResponse response  = HttpUtils.currentResponse();
//        HttpServletRequest request  = HttpUtils.currentRequest();
//
//        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
//            @Override
//            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
//                // TODO Auto-generated method stub
//                PageData pd = HttpUtils.parsePageData();
//                List<LinkedHashMap> titles = userService.getColumnList();
//                request.setAttribute("titles", titles.get(0));
//                List<Map> varList = userService.getDataList(pd);
//                request.setAttribute("varList", varList);
//            }
//        });
//        Long endTime = System.currentTimeMillis();
//        logger.info("################user/exportExcelUsers 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }


}



