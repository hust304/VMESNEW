package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.gson.Gson;
import com.xy.vmes.common.util.RedisUtils;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.DictionaryService;
import com.xy.vmes.service.UserService;
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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;


/**
* 说明：数据字典Controller
* @author 刘威 自动生成
* @date 2018-07-31
*/
@RestController
@Slf4j
public class DictionaryController {

    private Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisClient redisClient;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @GetMapping("/dictionary/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################dictionary/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Dictionary dictionary = dictionaryService.selectById(id);
        model.putResult(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/dictionary/save")
    public ResultModel save()  throws Exception {

        logger.info("################dictionary/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());
        dictionaryService.save(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/dictionary/update")
    public ResultModel update()  throws Exception {

        logger.info("################dictionary/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());
        dictionaryService.update(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @GetMapping("/dictionary/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################dictionary/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        dictionaryService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/dictionary/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################dictionary/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        List<Dictionary> dictionaryList = dictionaryService.dataListPage(pd,pg);
        model.putResult(dictionaryList);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/dictionary/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################dictionary/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Dictionary> dictionaryList = dictionaryService.dataList(pd);
        model.putResult(dictionaryList);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @GetMapping("/dictionary/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################dictionary/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = dictionaryService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = dictionaryService.findDataList(pd);
                    request.setAttribute("varList", varList);
                }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @GetMapping("/dictionary/addDictionary")
    public ResultModel addDictionary()  throws Exception {

        logger.info("################dictionary/addDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());
        String sessionID = pd.getString("sessionID");
        User user = RedisUtils.getUserInfoBySessionID(redisClient,sessionID);
        if(user==null){
            user = userService.selectById(pd.getString("currentUserId"));
        }
        dictionary.setCompanyId(user.getCompanyId());
        if(StringUtils.isEmpty(pd.getString("pid"))){
            dictionary.setPid("root");//root节点
            dictionary.setId0("root");
            dictionary.setLayer(1);
        }else{
            Dictionary pDictionary = dictionaryService.selectById(pd.getString("pid"));
            dictionary.setId0("root");
            dictionary.setId1(pDictionary.getId1());
            dictionary.setId2(pDictionary.getId2());
            dictionary.setId3(pDictionary.getId3());
            dictionary.setId4(pDictionary.getId4());
            dictionary.setId5(pDictionary.getId5());
            dictionary.setId6(pDictionary.getId6());
            dictionary.setLayer(pDictionary.getLayer()+1);
            dictionary.setPid(pDictionary.getId());
            if(pDictionary.getLayer()==1){
                dictionary.setId1(pDictionary.getId());
            }else if(pDictionary.getLayer()==2){
                dictionary.setId2(pDictionary.getId());
            }else if(pDictionary.getLayer()==3){
                dictionary.setId3(pDictionary.getId());
            }else if(pDictionary.getLayer()==4){
                dictionary.setId4(pDictionary.getId());
            }else if(pDictionary.getLayer()==5){
                dictionary.setId5(pDictionary.getId());
            }else if(pDictionary.getLayer()==6){
                dictionary.setId6(pDictionary.getId());
            }else {
                model.putCode(1);
                model.putMsg("数据字典最高层级不能超过7层!");
                return model;
            }
        }


        if("admin".equals(user.getUserCode())){
            dictionary.setIsglobal("1");//超级管理员创建的数据字典都是全局设置
        }else {
            dictionary.setIsglobal("0");//非全局设置
        }
        dictionaryService.save(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/addDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @GetMapping("/dictionary/updateDictionary")
    public ResultModel updateDictionary()  throws Exception {

        logger.info("################dictionary/updateDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());
        dictionaryService.update(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/updateDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @GetMapping("/dictionary/deleteDictionarys")
    public ResultModel deleteDictionarys()  throws Exception {

        logger.info("################dictionary/deleteDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String dictionaryIds = pd.getString("ids");
        String[] ids = dictionaryIds.split(",");
        dictionaryService.updateToDisableByIds(ids);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/deleteDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @GetMapping("/dictionary/listPageDictionarys")
    public ResultModel listPageDictionarys()  throws Exception {

        logger.info("################dictionary/listPageDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination();
        Map result = new HashMap();

        List<LinkedHashMap> titles =dictionaryService.getColumnList();

        LinkedHashMap titlesLinkedMap = new LinkedHashMap();
        List<String> titlesHideList = new ArrayList<String>();
        if(titles!=null&&titles.size()>0){
            LinkedHashMap<String, String> titlesMap = titles.get(0);
            for (Map.Entry<String, String> entry : titlesMap.entrySet()) {
                if(entry.getKey().indexOf("_hide")>0){
                    titlesLinkedMap.put(entry.getKey().replace("_hide",""),entry.getValue());
                    titlesHideList.add(entry.getKey().replace("_hide",""));
                }else{
                    titlesLinkedMap.put(entry.getKey(),entry.getValue());
                }
            }
        }
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesLinkedMap);

        List<Map> varList = dictionaryService.getDataListPage(pd,pg);
        result.put("varList",varList);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/listPageDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-08-01
     */
    @GetMapping("/dictionary/exportExcelDictionarys")
    public void exportExcelDictionarys()  throws Exception {

        logger.info("################dictionary/exportExcelDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = dictionaryService.getColumnList();
                request.setAttribute("titles", titles.get(0));
                List<Map> varList = dictionaryService.getDataList(pd);
                request.setAttribute("varList", varList);
            }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/exportExcelDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @GetMapping("/dictionary/treeDictionarys")
    public ResultModel treeDictionarys()  throws Exception {

        logger.info("################dictionary/treeDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Map result = new HashMap();

        List<Map> treeList = dictionaryService.getTreeList(pd);
        result.put("treeList",treeList);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/treeDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



