package com.xy.vmes.deecoop.controller;


import com.xy.vmes.service.UserEmployeeService;
import com.xy.vmes.entity.ViewVmesUserEmployee;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * 说明：用户登录退出系统 Controller
 * 创建人：自动创建
 * 创建时间：2018-07-20
 */
@RestController
@Slf4j
public class UserLoginController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserEmployeeService userEmployService;

    /**
     * 系统用户登录(web,手机)端-通用登录接口
     * Redis缓存Key(前缀):uuid_用户ID_deecoop
     * Redis缓存Key:uuid_用户ID_deecoop_userID
     *
     * 1. (用户账号, 密码MD5)-查询(v_vmes_user_employee)
     * 2. (用户账号, 密码MD5)-系统中存在
     * 3. 生成新的Redis会话(生成新的uuid)
     * 4. 生成新的uuid-与Redis缓存中的Key比较
     * 5. 生成新的uuid-与Redis缓存中的历史(uuid)-不同(在其他终端登录)
     * 6. 清空历史Redis缓存Key(系统用户ID)z字符串匹配
     * 7. 生成新的uuid-生成新的Redis缓存数据
     * 8. 缓存业务数据
     *
     * 用户信息(userID,userCode,companyID,)
     * 员工信息(employID,employName,postID(主岗),deptID,)
     * 当前用户角色(userRoles-角色ID','分隔的字符串)
     * 当前用户菜单树Json(userMenuTree-当前用户所有角色关联的模块-生成菜单树Json字符串)
     *
     * 创建人：陈刚
     * 创建时间：2018-07-20
     */
    @GetMapping("/userLogin/sysUserLogin")
    public String departmentTreeLoad() {
        //1. (用户账号, 密码MD5)-查询(v_vmes_user_employee)
        PageData pageData = HttpUtils.parsePageData();
        ViewVmesUserEmployee findObj = (ViewVmesUserEmployee)HttpUtils.pageData2Entity(pageData, new ViewVmesUserEmployee());
        List<ViewVmesUserEmployee> objectList = userEmployService.findViewUserEmployList(findObj);
        if (objectList == null || objectList.size() == 0) {
            throw new RestException("", "当前(用户,密码)输入错误，请重新输入！");
        }

        //(用户账号, 密码MD5)-系统中存在--RedisKey: uuid_系统用户ID_deecoop
        //3. 生成新的Redis会话(生成新的uuid)
        String uuid = UUID.randomUUID().toString().replaceAll("-","");

        //4. 生成新的uuid-与Redis缓存中的Key比较
        //5. 生成新的uuid-与Redis缓存中的历史(uuid)-不同(在其他终端登录)
        //6. 清空历史Redis缓存Key(系统用户ID)z字符串匹配
        //7. 生成新的uuid-生成新的Redis缓存数据
        //8. 缓存业务数据
        return null;
    }
}
