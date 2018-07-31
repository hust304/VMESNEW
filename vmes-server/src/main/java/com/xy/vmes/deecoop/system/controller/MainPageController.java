package com.xy.vmes.deecoop.system.controller;

import com.google.gson.JsonObject;
import com.xy.vmes.entity.User;
import com.xy.vmes.entity.UserDefinedMenu;
import com.xy.vmes.entity.UserRole;
import com.xy.vmes.service.UserDefinedMenuService;
import com.xy.vmes.service.UserService;
import com.yvan.HttpUtils;
import com.yvan.MD5Utils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.platform.JsonWapper;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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


    private Logger logger = LoggerFactory.getLogger(MainPageController.class);


    /**
     * @author 刘威 修改用户密码
     * @date 2018-07-27
     */
    @GetMapping("/mainPage/changePassWord")
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
    @GetMapping("/mainPage/changePageStyle")
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
    @GetMapping("/mainPage/saveUserDefinedMenu")
    public ResultModel saveUserDefinedMenu()  throws Exception {

        logger.info("################mainPage/saveUserDefinedMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String userDefinedMenus = pd.getString("userDefinedMenus");
//        userDefinedMenus ="{\"userDefinedMenus\":[{\"userId\":\"1\",\"menuId\":\"1\",\"serialNumber\":\"1\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532599975000,\"serialNumber\":\"2\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532601003000,\"serialNumber\":\"3\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532600923000,\"serialNumber\":\"4\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532600802000,\"serialNumber\":\"5\"}," +
//                "{\"userId\":\"1\",\"menuId\":1532601034000,\"serialNumber\":\"6\"}]}";
        JsonWapper jsonWapper = new JsonWapper(userDefinedMenus);
        List<Map> userDefinedMenusList = (List<Map>)jsonWapper.get("userDefinedMenus");
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
    @GetMapping("/mainPage/listUserDefinedMenu")
    public ResultModel listUserDefinedMenu()  throws Exception {

        logger.info("################mainPage/listUserDefinedMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        Map result = new HashMap();
        List<LinkedHashMap> titles = userDefinedMenuService.getColumnList();
        result.put("titles",titles.get(0));
        List<Map> varList = userDefinedMenuService.getDataList(pd);
        result.put("varList",varList);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################mainPage/listUserDefinedMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    public static void main(String[] args) throws Exception {

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
