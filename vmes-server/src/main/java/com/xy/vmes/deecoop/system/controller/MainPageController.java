package com.xy.vmes.deecoop.system.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.RoleMenuService;
import com.xy.vmes.service.UserDefinedMenuService;
import com.xy.vmes.service.UserService;
import com.yvan.HttpUtils;
import com.yvan.MD5Utils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 说明：主页 Controller
 * @author 刘威
 * @date 2018-07-27
 */
@RestController
@Slf4j
public class MainPageController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDefinedMenuService userDefinedMenuService;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private RoleMenuService roleMenuService;

    private Logger logger = LoggerFactory.getLogger(MainPageController.class);


    /**
     * @author 刘威 修改用户密码
     * @date 2018-07-27
     */
    @PostMapping("/mainPage/changePassWord")
    public ResultModel changePassWord()  throws Exception {

        logger.info("################mainPage/changePassWord 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        //修改用户信息
        User user = (User)HttpUtils.pageData2Entity(pd, new User());
        user.setPassword(MD5Utils.MD5(user.getPassword()));
        userService.update(user);
        Long endTime = System.currentTimeMillis();
        logger.info("################mainPage/changePassWord 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 修改界面样式
     * @date 2018-07-27
     */
    @PostMapping("/mainPage/changePageStyle")
    public ResultModel changePageStyle()  throws Exception {

        logger.info("################mainPage/changePageStyle 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        //修改用户信息
        User user = (User)HttpUtils.pageData2Entity(pd, new User());
        userService.update(user);
        Long endTime = System.currentTimeMillis();
        logger.info("################mainPage/changePageStyle 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 保存用户自定义菜单
     * @date 2018-07-27
     */
    @PostMapping("/mainPage/saveUserDefinedMenu")
    public ResultModel saveUserDefinedMenu()  throws Exception {

        logger.info("################mainPage/saveUserDefinedMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
//        String userDefinedMenus = pd.getString("userDefinedMenus");
        ArrayList userDefinedMenusList = (ArrayList)pd.get("userDefinedMenus");
//        userDefinedMenus ="{\"userDefinedMenus\":[{\"userId\":\"3\",\"menuId\":\"1\",\"serialNumber\":\"1\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532599975000,\"serialNumber\":\"2\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532601003000,\"serialNumber\":\"3\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532600923000,\"serialNumber\":\"4\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532600802000,\"serialNumber\":\"5\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532601034000,\"serialNumber\":\"6\"}]}";
//        userDefinedMenus ="[{\"userId\":\"3\",\"menuId\":\"1\",\"serialNumber\":\"1\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532599975000,\"serialNumber\":\"2\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532601003000,\"serialNumber\":\"3\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532600923000,\"serialNumber\":\"4\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532600802000,\"serialNumber\":\"5\"}," +
//                "{\"userId\":\"3\",\"menuId\":1532601034000,\"serialNumber\":\"6\"}]";

//        userDefinedMenus = userDefinedMenus.replace(", {}","");
//        List userDefinedMenusList = YvanUtil.jsonToList(userDefinedMenus);

        if(userDefinedMenusList!=null&&userDefinedMenusList.size()>0){
            for(int i=0;i<userDefinedMenusList.size();i++){
                String josnObj = YvanUtil.toJson(userDefinedMenusList.get(i));
                UserDefinedMenu userDefinedMenu = YvanUtil.jsonToObj(josnObj, UserDefinedMenu.class);
                if(i==0){
                    Map columnMap = new HashMap();
                    columnMap.put("user_id",userDefinedMenu.getUserId());
                    userDefinedMenuService.deleteByColumnMap(columnMap);
                }

                userDefinedMenuService.save(userDefinedMenu);
            }
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################mainPage/saveUserDefinedMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威  查询用户自定义菜单
     * @date 2018-07-27
     */
    @PostMapping("/mainPage/listUserDefinedMenu")
    public ResultModel listUserDefinedMenu()  throws Exception {

        logger.info("################mainPage/listUserDefinedMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("user");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
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
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);


        List<Map> varMapList = new ArrayList();
        List<Map> varList = userDefinedMenuService.getDataList(pd);
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
        logger.info("################mainPage/listUserDefinedMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 查询当前登录用户角色已经绑定的菜单
     * 1. 超级管理员: 全部菜单表数据
     * 2. 非超级管理员(企业管理员,普通用户,外部用户)-当前登录用户角色已经绑定的菜单
     *
     * userType: 当前用户类型-字典表id
     *     userType_admin:超级管理员
     *     userType_company:企业管理员
     *     userType_employee:普通用户
     *     userType_outer:外部用户
     * roleIds:  当前用户角色id
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/mainPage/listRoleMeunAll")
    public ResultModel listRoleMeunAll() throws Exception {
        logger.info("################mainPage/listUserDefinedMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();
        String userType = (String)pageData.get("userType");

        //角色Id字符串-->转换成 sql查询字符串
        String roleIds = (String)pageData.get("roleIds");
        String queryIds = "";
        if (roleIds != null && roleIds.trim().length() > 0) {
            roleIds = StringUtil.stringTrimSpace(roleIds);
            roleIds = "'" + roleIds.replace(",", "','") + "'";
            queryIds = "b.role_id in (" + roleIds + ")";
        }

        PageData findMap = new PageData();
        //超级管理员:  全部菜单表数据
        //非超级管理员 当前登录用户角色已经绑定的菜单
        //userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
        if (userType != null
            && !Common.DICTIONARY_MAP.get("userType_admin").equals(userType)
            && queryIds.trim().length() > 0
        ) {
            findMap.put("queryStr", queryIds);
        }
        findMap.put("menuIsdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Map<String, Object>> mapList = roleMenuService.findRoleMenuMapList(findMap);
        List<Menu> menuList = roleMenuService.mapList2MenuList(mapList, null);
        List<MenuEntity> entityLiset = roleMenuService.menuList2MenuEntityList(menuList, null);
        roleMenuService.orderAcsByLayer(entityLiset);
        model.putResult(entityLiset);

        Long endTime = System.currentTimeMillis();
        logger.info("################mainPage/listUserDefinedMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    public static void main(String[] args) throws Exception {
//        String mobile = "12345123456";
//        String password = mobile.substring(mobile.length()-6,mobile.length());
//        System.out.println(password);
//        String userDefinedMenus ="{\"userDefinedMenus\":[{\"userId\":\"1\",\"menuId\":\"1\",\"serialNumber\":\"1\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532599975000,\"serialNumber\":\"2\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532601003000,\"serialNumber\":\"3\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532600923000,\"serialNumber\":\"4\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532600802000,\"serialNumber\":\"5\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532601034000,\"serialNumber\":\"6\"}]}";
//        JsonWapper jsonWapper = new JsonWapper(userDefinedMenus);
//        List<Map> userDefinedMenusList = (List<Map>)jsonWapper.get("userDefinedMenus");
//
//        String josn = YvanUtil.toJson(userDefinedMenusList.get(0));
//        System.out.println(josn);
//        UserDefinedMenu userDefinedMenu = YvanUtil.jsonToObj(josn, UserDefinedMenu.class);
//        System.out.println(userDefinedMenu.getUserId());

//        String userDefinedMenus = "[{'isdisable':'1','employId':'1','id':'1','userCode':'abcde'},{'companyId':'1','cdate':1532599975000,'companyName':'公司1','mobile':'18627065815','isdisable':'1','deptId':'1','id':'29f07030446642ff841fd91b379023ff','userName':'test11','userCode':'ali000011','email':'lw@163.com'}]";
//        String userDefinedMenus = "{'varList':[{'isdisable':'1','employId':'1','id':'1','userCode':'abcde'},{'companyId':'1','cdate':1532599975000,'companyName':'公司1','mobile':'18627065815','isdisable':'1','deptId':'1','id':'29f07030446642ff841fd91b379023ff','userName':'test11','userCode':'ali000011','email':'lw@163.com'}]}";
//        String userDefinedMenus ="{\"varList\":[{\"isdisable\":\"1\",\"employId\":\"1\",\"id\":\"1\",\"userCode\":\"abcde\"},{\"companyId\":\"1\",\"cdate\":1532599975000,\"companyName\":\"公司1\",\"mobile\":\"18627065815\",\"isdisable\":\"1\",\"deptId\":\"1\",\"id\":\"29f07030446642ff841fd91b379023ff\",\"userName\":\"test11\",\"userCode\":\"ali000011\",\"email\":\"lw@163.com\"},{\"companyId\":\"1\",\"cdate\":1532601003000,\"companyName\":\"公司1\",\"mobile\":\"18627065818\",\"isdisable\":\"0\",\"deptId\":\"1\",\"id\":\"6d9f0ad0931745b9b4417d03aefac270\",\"userName\":\"test666\",\"userCode\":\"ali000032\",\"email\":\"lw666@163.com\"},{\"companyId\":\"1\",\"cdate\":1532600923000,\"companyName\":\"公司1\",\"mobile\":\"18627065817\",\"isdisable\":\"0\",\"deptId\":\"1\",\"id\":\"76126a4a96be4b48a891e42f7a225823\",\"userName\":\"test444\",\"userCode\":\"ali000031\",\"email\":\"lw444@163.com\"},{\"companyId\":\"1\",\"cdate\":1532600802000,\"companyName\":\"公司1\",\"mobile\":\"18627065816\",\"isdisable\":\"0\",\"deptId\":\"1\",\"id\":\"a33acd224e9a49f98a09f20698aac4db\",\"userName\":\"test333\",\"userCode\":\"ali000026\",\"email\":\"lw333@163.com\"},{\"companyId\":\"1\",\"cdate\":1532601034000,\"companyName\":\"公司1\",\"mobile\":\"18627065819\",\"isdisable\":\"0\",\"deptId\":\"1\",\"id\":\"ba34b9c524c94a3ba70a9ea7a4761aa8\",\"userName\":\"test777\",\"userCode\":\"ali000033\",\"email\":\"lw777@163.com\"}]}";

    }


}
