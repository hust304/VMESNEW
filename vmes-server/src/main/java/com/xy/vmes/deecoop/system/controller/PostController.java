package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.common.util.RedisUtils;
import com.xy.vmes.entity.Post;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.EmployPostService;
import com.xy.vmes.service.PostService;
import com.xy.vmes.service.UserService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.cache.RedisClient;
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
    @Autowired
    private UserService userService;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private EmployPostService employPostService;

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
        Pagination pg = HttpUtils.parsePagination();
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
    @GetMapping("/post/addPost")
    public ResultModel addPost()  throws Exception {

        logger.info("################post/addPost 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Post post = (Post)HttpUtils.pageData2Entity(pd, new Post());
        String sessionID = pd.getString("sessionID");
        User user = RedisUtils.getUserInfoBySessionID(redisClient,sessionID);
        if(user==null){
            user = userService.selectById(pd.getString("currentUserId"));
        }
        if(StringUtils.isEmpty(pd.getString("deptId"))){
            model.putCode(1);
            model.putMsg("所属部门不能为空！");
            return model;
        }
        post.setCompanyId(user.getCompanyId());
        postService.save(post);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/addPost 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-08-01
     */
    @GetMapping("/post/updatePost")
    public ResultModel updatePost()  throws Exception {

        logger.info("################post/updatePost 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Set<String> postOnlineSet = null;
        if(!StringUtils.isEmpty(pd.getString("isdisable"))){
            if("1".equals(pd.getString("isdisable"))){
                //岗位的删除和禁用要先判断该岗位下是否挂载人员，如果有不能删除禁用
                if(checkExsitOnlineEmployee(pd.getString("id"),postOnlineSet)){
                    model.putCode(1);
                    model.putMsg("该岗位下面存在未离职员工不能禁用！");
                    return model;
                }
            }
        }
        Post post = (Post)HttpUtils.pageData2Entity(pd, new Post());
        postService.update(post);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/updatePost 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    private boolean checkExsitOnlineEmployee(String postId,Set<String> postOnlineSet) throws Exception {
        PageData pd = new PageData();
        pd.putQueryStr(" isdisable = 0 ");
        return checkExsitEmployee(postId,postOnlineSet,pd);
    }

    private boolean checkExsitDownlineEmployee(String postId,Set<String> postDownlineSet) throws Exception {
        PageData pd = new PageData();
        pd.putQueryStr(" isdisable = 1 ");
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
    @GetMapping("/post/deletePosts")
    public ResultModel deletePosts()  throws Exception {

        logger.info("################post/deletePosts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String dictionaryIds = pd.getString("ids");
        String[] ids = dictionaryIds.split(",");
        List<String> updateIdsList = new ArrayList<String>();
        List<String> deleteIdsList = new ArrayList<String>();
        Set<String> postOnlineSet = null;
        Set<String> postDownlineSet = null;
        if(ids!=null&&ids.length>0){
            for(int i=0;i<ids.length;i++){
                //岗位的删除和禁用要先判断该岗位下是否挂载在职人员，如果有不能删除禁用
                if(checkExsitOnlineEmployee(ids[i],postOnlineSet)){
                    model.putCode(1);
                    model.putMsg("该岗位下面存在未离职员工不能删除！");
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
    @GetMapping("/post/listPagePosts")
    public ResultModel listPagePosts()  throws Exception {

        logger.info("################post/listPagePosts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        Map result = new HashMap();
        List<LinkedHashMap> titles =postService.getColumnList();
        result.put("titles",titles.get(0));
        List<Map> varList = postService.getDataListPage(pd,pg);
        result.put("varList",varList);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################post/listPagePosts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-01
     */
    @GetMapping("/post/exportExcelPosts")
    public void exportExcelPosts()  throws Exception {

        logger.info("################post/exportExcelPosts 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = postService.getColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = postService.getDataList(pd);
                request.setAttribute("varList", varList);
            }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################post/exportExcelPosts 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

}



