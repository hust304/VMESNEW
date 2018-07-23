package com.yvan;

import com.google.gson.Gson;
import org.bouncycastle.asn1.cryptopro.GOST3410NamedParameters;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by 46368 on 2018/7/17.
 */
public class CreateCodeUtil {

    public static void CreateCode() throws Exception {

        PageData pd = new PageData();

        String objectName = "User";//类名
        String tableName = "vmes_user";//表名
        String title = "vmes_user:系统用户表";
        String author = "陈刚";
        String projectName = "deecoop";//项目名


        pd.put("dbtype","mysql");//数据库类型
        pd.put("username","vmes");//用户名
        pd.put("password","owi123Q@WE!");//密码
        pd.put("dbAddress","47.93.44.177");//数据库连接地址
        pd.put("dbport","3306");//端口
        pd.put("databaseName","deecoop");//数据库名
        pd.put("table",tableName);//表名
        List<String[]> fieldList = DbFH.getColumnParameterLsit(DbFH.getFHCon(pd),pd.getString("table"),pd.getString("databaseName")); //读取字段信息

        Map<String,Object> root = new HashMap<String,Object>();
        //表字段信息
        root.put("fieldList", fieldList);
        //说明
        root.put("TITLE", title);
        //创建人
        root.put("author", author);
        //类名
        root.put("objectName", objectName);
        root.put("objectNameLower", DbFH.toLowerCaseFirstOne(objectName));
        root.put("table", tableName);
        root.put("nowDate", new Date());
        root.put("projectName", projectName);


        String path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../../../").replaceAll("file:/", "").replaceAll("%20", " ").trim();
        if(path.indexOf(":") != 1){
            path = File.separator + path;
        }

        String ftlPath = path+"yvan-platform/src/main/java/com/yvan/ftl/";
        String filePath = path+"vmes-contracts/src/main/java/com/xy/vmes/entity/"+objectName+".java";

        //生成实体类
        root.put("classPath", "com.xy.vmes.entity");
        Freemarker.printFile("entityTemplate.ftl", root, filePath,  ftlPath);

//        //生成Mapper java
//        root.put("classPath", "com.xy.vmes."+projectName+".dao");
//        filePath = path+"vmes-server/src/main/java/com/xy/vmes/"+projectName+"/dao/"+objectName+"Mapper.java";
//        Freemarker.printFile("mapperJavaTemplate.ftl", root, filePath, ftlPath);
//
//        //生成mybatis xml
//        filePath = path+"vmes-server/src/main/resources/mapper/"+objectName+"Mapper.xml";
//        Freemarker.printFile("mapperMysqlTemplate.ftl", root, filePath, ftlPath);
//
//        //生成Service java
//        root.put("classPath", "com.xy.vmes.service");
//        filePath = path+"vmes-contracts/src/main/java/com/xy/vmes/service/"+objectName+"Service.java";
//        Freemarker.printFile("serviceJavaTemplate.ftl", root, filePath, ftlPath);
//
//        //生成ServiceImp java
//        root.put("classPath", "com.xy.vmes."+projectName+".service");
//        filePath = path+"vmes-server/src/main/java/com/xy/vmes/"+projectName+"/service/"+objectName+"ServiceImp.java";
//        Freemarker.printFile("serviceImpJavaTemplate.ftl", root, filePath, ftlPath);
//
//        //生成Controller java
//        root.put("classPath", "com.xy.vmes."+projectName+".controller");
//        filePath = path+"vmes-server/src/main/java/com/xy/vmes/"+projectName+"/controller/"+objectName+"Controller.java";
//        Freemarker.printFile("controllerJavaTemplate.ftl", root, filePath, ftlPath);


//        Gson gosn = new Gson();
//        String result = gosn.toJson(fieldList);
    }

    public static void main(String[] args) throws Exception {
        CreateCode();

//        PageData pd = new PageData();
//
//        String objectName = "Department";//类名
//        String tableName = "sys_department";//表名
//        String title = "部门表";
//
//
//        pd.put("dbtype","mysql");//数据库类型
//        pd.put("username","vmes");//用户名
//        pd.put("password","owi123Q@WE!");//密码
//        pd.put("dbAddress","47.93.44.177");//数据库连接地址
//        pd.put("dbport","3306");//端口
//        pd.put("databaseName","testvmes");//数据库名
//        pd.put("table",tableName);//表名
//        List<Map<String,String>> fieldList = DbFH.getFieldParameterLsit(DbFH.getFHCon(pd),pd.getString("table")); //读取字段信息
//
//        Gson gosn = new Gson();
//        String result = gosn.toJson(fieldList);
//
//        System.out.println(result);

    }


}
