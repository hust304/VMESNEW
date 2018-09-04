package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.common.util.TreeUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Post;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.cache.RedisClient;
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
import java.util.*;


/**
 * 说明：vmes_post:岗位管理Controller
 * @author 刘威 自动生成
 * @date 2018-08-01
 */
@RestController
@Slf4j
public class PostController {

    private Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;
    //@Autowired
    //private UserService userService;
    //@Autowired
    //private RedisClient redisClient;
    @Autowired
    private EmployPostService employPostService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;
    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-01
     */
    @GetMapping("/post/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################post/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Post post = postService.selectById(id);
        model.putResult(post);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-01
     */
    @PostMapping("/post/save")
    public ResultModel save()  throws Exception {

        logger.info("################post/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Post post = (Post)HttpUtils.pageData2Entity(pd, new Post());
        postService.save(post);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-01
     */
    @PostMapping("/post/update")
    public ResultModel update()  throws Exception {

        logger.info("################post/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Post post = (Post)HttpUtils.pageData2Entity(pd, new Post());
        postService.update(post);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-01
     */
    @GetMapping("/post/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################post/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        postService.deleteById(id);
//        String code = postService.createCoder(id);
//        model.putCode(code);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-01
     */
    @PostMapping("/post/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################post/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Post> postList = postService.dataListPage(pd,pg);
        model.putResult(postList);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-01
     */
    @PostMapping("/post/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################post/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Post> postList = postService.dataList(pd);
        model.putResult(postList);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-01
     */
    @GetMapping("/post/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################post/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = postService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = postService.findDataList(pd);
                request.setAttribute("varList", varList);
            }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################post/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    /**
     * @author 刘威
     * @date 2018-08-01
     */
    @PostMapping("/post/addPost")
    public ResultModel addPost()  throws Exception {

        logger.info("################post/addPost 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Post post = (Post)HttpUtils.pageData2Entity(pd, new Post());
        String sessionID = pd.getString("sessionID");
//        User user = RedisUtils.getUserInfoBySessionID(redisClient,sessionID);
//        if(user==null){
//            user = userService.selectById(pd.getString("currentUserId"));
//        }
        String deptId = pd.getString("deptId");
        if(StringUtils.isEmpty(deptId)){
            model.putCode(1);
            model.putMsg("所属部门不能为空！");
            return model;
        }
        Department department = departmentService.selectById(deptId);

        String companyId = department.getId1();
        if(!StringUtils.isEmpty(companyId)){
            post.setCompanyId(companyId);
        }else{
            //如果没有公司ID，那么就是创建根节点下
            post.setCompanyId(department.getId0());
        }
        String code = coderuleService.createCoder(companyId,"vmes_post","P");
        if(StringUtils.isEmpty(code)){
            model.putCode(2);
            model.putMsg("编码规则创建异常，请重新操作！");
            return model;
        }
        post.setCode(code);
        postService.save(post);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/addPost 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-08-01
     */
    @PostMapping("/post/updatePost")
    public ResultModel updatePost()  throws Exception {
        logger.info("################post/updatePost 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Post post = (Post)HttpUtils.pageData2Entity(pd, new Post());
        postService.update(post);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/updatePost 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改岗位(禁用)状态
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/post/updateDisablePost")
    public ResultModel updateDisablePost() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = (String)pageData.get("id");
        String isdisable = (String)pageData.get("isdisable");

        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //当前岗位ID-员工岗位表(vmes_employ_post)中是否存在
        if ("0".equals(isdisable) && this.checkExsitOnlineEmployee(id, null)) {
            model.putCode(1);
            model.putMsg("该岗位下面存在绑定的员工不能禁用！");
            return model;
        }

        Post postDB = postService.findPostById(id);
        postDB.setIsdisable(isdisable);
        postDB.setUdate(new Date());
        postService.update(postDB);

        return model;
    }

    private boolean checkExsitOnlineEmployee(String postId,Set<String> postOnlineSet) throws Exception {
        PageData pd = new PageData();
        pd.putQueryStr(" isdisable = 1 ");
        return checkExsitEmployee(postId,postOnlineSet,pd);
    }

    private boolean checkExsitDownlineEmployee(String postId,Set<String> postDownlineSet) throws Exception {
        PageData pd = new PageData();
        pd.putQueryStr(" isdisable = 0 ");
        return checkExsitEmployee(postId,postDownlineSet,pd);
    }

    private boolean checkExsitEmployee(String postId,Set<String> postSet,PageData pd) throws Exception  {
        if(pd==null){
            pd = new PageData();
        }
        if(postSet==null){
            postSet = new HashSet<String>();
            List<Map> varList = employPostService.getDataList(pd);
            if(varList!=null&&varList.size()>0){
                for(int i=0;i<varList.size();i++){
                    if(varList.get(i)!=null&&varList.get(i).get("postId")!=null){
                        postSet.add(varList.get(i).get("postId").toString());
                    }
                }
            }
        }
        if(postSet.contains(postId)){
            return true;
        }
        return false;
    }

    /**
     * @author 刘威
     * @date 2018-08-01
     */
    @PostMapping("/post/deletePosts")
    public ResultModel deletePosts()  throws Exception {

        logger.info("################post/deletePosts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String postIds = pd.getString("ids");
        String[] ids = postIds.split(",");
        List<String> updateIdsList = new ArrayList<String>();
        List<String> deleteIdsList = new ArrayList<String>();
        Set<String> postOnlineSet = null;
        Set<String> postDownlineSet = null;
        if(ids!=null&&ids.length>0){
            for(int i=0;i<ids.length;i++){
                //岗位的删除和禁用要先判断该岗位下是否挂载在职人员，如果有不能删除禁用
                if(checkExsitOnlineEmployee(ids[i],postOnlineSet)){
                    model.putCode(1);
                    model.putMsg("该岗位下面存在绑定的员工不能删除！");
                    return model;
                }else {
                    //岗位的删除和禁用要先判断该岗位下是否挂载不在职人员，如果有只能禁用，如果没有可以删除
                    if(checkExsitDownlineEmployee(ids[i],postDownlineSet)){
                        updateIdsList.add(ids[i]);
                    }else {
                        deleteIdsList.add(ids[i]);
                    }
                }
            }
        }
        String[] updateIds =  updateIdsList.toArray(new String[updateIdsList.size()]);
        String[] deleteIds =  deleteIdsList.toArray(new String[deleteIdsList.size()]);
        if(updateIds!=null&&updateIds.length>0){
            postService.updateToDisableByIds(updateIds);
        }
        if(deleteIds!=null&&deleteIds.length>0){
            postService.deleteByIds(deleteIds);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################post/deletePosts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威
     * @date 2018-08-01
     */
    @PostMapping("/post/listPagePosts")
    public ResultModel listPagePosts()  throws Exception {
        logger.info("################post/listPagePosts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        Map result = new HashMap();
        //1. 查询遍历List列表
        List<Column> columnList = columnService.findColumnList("post");
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

        String deptId = null;
        if (pd.get("deptId") != null && pd.get("deptId").toString().trim().length() > 0) {
            deptId = ((String)pd.get("deptId")).trim();
            String queryIdStr = departmentService.findDeptidById(deptId, null, "department.");
            pd.put("queryStr", queryIdStr);
        }

//        String userType = (String)pd.get("userType");
//        //(userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
//        if (Common.DICTIONARY_MAP.get("userType_admin").equals(userType)) {
//            pd.put("cuser", null);
//        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = postService.getDataListPage(pd, pg);
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
        logger.info("################post/listPagePosts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
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
    @GetMapping("/button/exportExcelPosts")
    public void exportExcelPosts() throws Exception {
        logger.info("################post/exportExcelPosts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        //1. 获取Excel导出数据查询条件
        PageData pd = HttpUtils.parsePageData();
        String ids = pd.getString("ids");
        String queryColumn = pd.getString("queryColumn");
        List<Column> columnList = columnService.findColumnList("post");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //3. 根据查询条件获取业务数据List
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        if (queryColumn != null && queryColumn.trim().length() > 0) {
            queryStr = queryStr + queryColumn;
        }

        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        //分页参数默认设置100000
        pg.setSize(100000);

        List<Map> dataList = postService.getDataListPage(pd,pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);

        HttpServletResponse response  = HttpUtils.currentResponse();


        //查询数据-Excel文件导出
        //String fileName = "Excel数据字典数据导出";
        String fileName = "ExcelPost";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/exportExcelPosts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

    }

    /**
     * 部门岗位树
     *
     * @author 陈刚
     * @date 2018-08-28
     */
    @PostMapping("/post/treeDeptPosts")
    public ResultModel treeDeptPosts()  throws Exception {
        logger.info("################/department/treeDepartments 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        //部门id 为空查询整棵部门树
        //部门id 非空查询当前部门下所有子部门(包含当前部门节点)
        String deptId = (String)pd.get("deptID");

        PageData findMap = new PageData();
        findMap.put("deptDisable", "1");
        findMap.put("postDisable", "1");
        if (deptId != null && deptId.trim().length() > 0) {
            String queryIdStr = departmentService.findDeptidById(deptId, null, null);
            findMap.put("deptQuery", queryIdStr);

            String queryIdStr_1 = departmentService.findDeptidById(deptId, null, "b.");
            findMap.put("postQuery", queryIdStr_1);
        }

        //1. 查询(部门+岗位)表
        List<Map<String, Object>> deptPostList = postService.listDeptPost(findMap);
        List<TreeEntity> treeList = postService.deptPostList2TreeList(deptPostList, null);

        //2. 获得部门岗位树形结构
        TreeEntity treeObj = TreeUtil.switchTree(deptId, treeList);
        String treeJsonStr = YvanUtil.toJson(treeObj);
        System.out.println("treeJsonStr: " + treeJsonStr);

        //3. 树形结构返回前端
        Map result = new HashMap();
        result.put("treeList", treeObj);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################/department/treeDepartments 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

        return model;
    }

}



