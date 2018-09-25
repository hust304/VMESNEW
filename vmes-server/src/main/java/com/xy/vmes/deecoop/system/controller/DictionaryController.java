package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.*;
import com.xy.vmes.entity.*;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.DictionaryService;
import com.xy.vmes.service.UserService;
import com.yvan.*;
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
import java.text.MessageFormat;
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

    @Autowired
    private ColumnService columnService;
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
        Pagination pg = HttpUtils.parsePagination(pd);
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
                //List<Map> varList = dictionaryService.findDataList(pd);
                //request.setAttribute("varList", varList);
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
    @PostMapping("/dictionary/addDictionary")
    public ResultModel addDictionary()  throws Exception {
        logger.info("################dictionary/addDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());

        String sessionID = pd.getString("sessionID");
        User user = RedisUtils.getUserInfoBySessionID(redisClient,sessionID);
        if(user == null){
            user = userService.selectById(pd.getString("currentUserId"));
        }

        //默认pid:= 字典表根节点
        String pid = Common.DICTIONARY_MAP.get("root");
        if (dictionary.getPid() != null && dictionary.getPid().trim().length() > 0) {
            pid = dictionary.getPid().trim();
        }

        //pid 获取父节点对象<Department>
        Dictionary paterObj = dictionaryService.findDictionaryById(pid);
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(pid:"+ pid + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (字典名称)在同一层名称不可重复
        if (dictionaryService.isExistByName(pid, null, dictionary.getName(), pd.getString("currentCompanyId"))) {
            String msgTemp = "上级字典名称: {0}{2}字典名称: {1}{2}在系统中已经重复！{2}";
            String str_isnull = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    dictionary.getName(),
                    Common.SYS_ENDLINE_DEFAULT);
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        //3. 创建字典信息
        String id = Conv.createUuid();
        dictionary.setId(id);
        dictionary.setCompanyId(user.getCompanyId());

        //userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
        //isglobal: 0：否  1：是
        if(Common.DICTIONARY_MAP.get("userType_admin").equals(user.getUserType())){
            dictionary.setIsglobal("1");//超级管理员创建的数据字典都是全局设置
        } else {
            dictionary.setIsglobal("0");//非全局设置
        }

        dictionary = dictionaryService.id2DictionaryByLayer(id,
                Integer.valueOf(paterObj.getLayer().intValue() + 1),
                dictionary);
        dictionary = dictionaryService.paterObject2ObjectDB(paterObj, dictionary);

        //设置默认部门顺序
        if (dictionary.getSerialNumber() == null) {
            Integer maxCount = dictionaryService.findMaxSerialNumber(dictionary.getPid());
            dictionary.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
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
    @PostMapping("/dictionary/updateDictionary")
    public ResultModel updateDictionary()  throws Exception {
        logger.info("################dictionary/updateDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());

        //pid 获取父节点对象<Department>
        Dictionary paterObj = dictionaryService.findDictionaryById(dictionary.getPid());
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(pid:"+ dictionary.getPid() + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (字典名称)在同一层名称不可重复
        if (dictionaryService.isExistByName(dictionary.getPid(), dictionary.getId(), dictionary.getName(),pd.getString("currentCompanyId"))) {
            String msgTemp = "上级字典名称: {0}{2}字典名称: {1}{2}在系统中已经重复！{2}";
            String str_isnull = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    dictionary.getName(),
                    Common.SYS_ENDLINE_DEFAULT);
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        //3. 修改部门信息
        Dictionary dictionaryDB = dictionaryService.findDictionaryById(dictionary.getId());
        dictionaryDB = dictionaryService.object2objectDB(dictionary, dictionaryDB);
        dictionaryDB = dictionaryService.clearDictionaryByPath(dictionaryDB);
        dictionaryDB = dictionaryService.id2DictionaryByLayer(dictionaryDB.getId(),
                Integer.valueOf(paterObj.getLayer().intValue() + 1),
                dictionaryDB);
        dictionaryDB = dictionaryService.paterObject2ObjectDB(paterObj, dictionaryDB);

//        //设置默认部门顺序
//        if (dictionary.getSerialNumber() == null) {
//            Integer maxCount = dictionaryService.findMaxSerialNumber(dictionary.getPid());
//            dictionaryDB.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
//        }
        dictionaryDB.setUuser((String)pd.get("uuser"));
        dictionaryService.update(dictionaryDB);

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/updateDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**修改组织架构(禁用)状态
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/dictionary/updateDisableDictionary")
    public ResultModel updateDisableDictionary() throws Exception {
        logger.info("################dictionary/updateDisableDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

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

        //2. 当前组织节点下是否含有(子节点-岗位)
        msgStr = dictionaryService.checkDeleteDictionaryByIds(id);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //3. 修改组织架构(禁用)状态
        Dictionary objectDB = dictionaryService.findDictionaryById(id);
        objectDB.setIsdisable(isdisable);
        objectDB.setUdate(new Date());
        objectDB.setUuser((String)pageData.get("uuser"));
        dictionaryService.update(objectDB);

        Long endTime = System.currentTimeMillis();
        logger.info("################/dictionary/updateDisableDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/dictionary/deleteDictionarys")
    public ResultModel deleteDictionarys()  throws Exception {
        logger.info("################dictionary/deleteDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pd = HttpUtils.parsePageData();
        String ids = pd.getString("ids");
        if(StringUtils.isEmpty(ids)){
            model.putCode("1");
            model.putMsg("未勾选删除记录，请重新选择！");
            return model;
        }

        String id_str = StringUtil.stringTrimSpace(ids);
        String msgStr = dictionaryService.checkDeleteDictionaryByIds(id_str);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        String[] id_arry = id_str.split(",");
        if(id_arry.length>0){
            dictionaryService.deleteByIds(id_arry);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/deleteDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/dictionary/listPageDictionarys")
    public ResultModel listPageDictionarys()  throws Exception {

        logger.info("################dictionary/listPageDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

//        List<LinkedHashMap> titles = new ArrayList<LinkedHashMap>();
        List<Column> columnList = columnService.findColumnList("dictionary");
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
//                if(entry.getKey().indexOf("_hide")>0){
//                    titlesLinkedMap.put(entry.getKey().replace("_hide",""),entry.getValue());
//                    titlesHideList.add(entry.getKey().replace("_hide",""));
//                    varModelMap.put(entry.getKey().replace("_hide",""),"");
//                }else{
//                    titlesLinkedMap.put(entry.getKey(),entry.getValue());
//                    varModelMap.put(entry.getKey(),"");
//                }
//                titlesList.add(titlesLinkedMap);
            }
        }
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = dictionaryService.getDataListPage(pd,pg);
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
        logger.info("################dictionary/listPageDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-08-01
     */
//    @GetMapping("/dictionary/exportExcelDictionarys")
//    public void exportExcelDictionarys()  throws Exception {
//
//        logger.info("################dictionary/exportExcelDictionarys 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        HttpServletResponse response  = HttpUtils.currentResponse();
//        HttpServletRequest request  = HttpUtils.currentRequest();
//
//        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
//            @Override
//            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
//                // TODO Auto-generated method stub
//                PageData pd = HttpUtils.parsePageData();
//                List<LinkedHashMap> titles = dictionaryService.getColumnList();
//                request.setAttribute("titles", titles.get(0));
//                List<Map> varList = dictionaryService.getDataList(pd);
//                request.setAttribute("varList", varList);
//            }
//        });
//        Long endTime = System.currentTimeMillis();
//        logger.info("################dictionary/exportExcelDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }

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
    @PostMapping("/dictionary/exportExcelDictionarys")
    public void exportExcelDictionarys() throws Exception {
        logger.info("################dictionary/exportExcelDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("dictionary");
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
        List<Map> dataList = dictionaryService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);

        HttpServletResponse response  = HttpUtils.currentResponse();
        //查询数据-Excel文件导出
        //String fileName = "Excel数据字典数据导出";
        String fileName = "ExcelDictionary";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/exportExcelDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/dictionary/treeDictionarys")
    public ResultModel treeDictionarys()  throws Exception {
        logger.info("################dictionary/treeDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        pd.put("isdisable", "1");
        pd.put("queryStr", " and company_id = '"+pd.get("currentCompanyId")+"' or  isopen = '1'");

        List<TreeEntity> treeList = dictionaryService.getTreeList(pd);
        TreeEntity treeObj = TreeUtil.switchTree(null, treeList);
//        String treeJsonStr = YvanUtil.toJson(treeObj);
//        System.out.println("treeJsonStr: " + treeJsonStr);

        Map result = new HashMap();
        result.put("treeList", treeObj);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/treeDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/dictionary/getDictionarys")
    public ResultModel getDictionarys()  throws Exception {
        logger.info("################dictionary/getDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String dictionaryKey = pd.getString("dictionaryKey");
        String isglobal = pd.getString("isglobal");
        String queryStr = pd.getString("queryStr");
        String id = Common.DICTIONARY_MAP.get(dictionaryKey);
        pd.put("isdisable", "1");

        if(StringUtils.isEmpty(isglobal)||"0".equals(isglobal)){
            pd.put("queryStr", "  and company_id = '"+pd.get("currentCompanyId")+"'  and ( id = '"+id+"' or id_1 = '"+id+"'  )  " + queryStr);
        }else if("1".equals(isglobal)){
            pd.put("queryStr", "  and isglobal = '"+pd.get("isglobal")+"'  and ( id = '"+id+"' or id_1 = '"+id+"'  ) " + queryStr);
        }


        List<TreeEntity> treeList = dictionaryService.getTreeList(pd);
        TreeEntity treeObj = TreeUtil.switchTree(id, treeList);

        dealWithTreeEntityChildren(treeObj);

        Map result = new HashMap();
        result.put("options", treeObj.getChildren());
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/getDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    public void dealWithTreeEntityChildren(TreeEntity treeObj){
        if(treeObj!=null&&treeObj.getChildren()!=null&&treeObj.getChildren().size()>0){
            for(int i=0;i<treeObj.getChildren().size();i++){
                dealWithTreeEntityChildren(treeObj.getChildren().get(i));
            }
        }else {
            treeObj.setChildren(null);
        }
    }




    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-31
     */
    @PostMapping("/dictionary/dataListDictionarys")
    public ResultModel dataListDictionarys()  throws Exception {

        logger.info("################dictionary/dataListDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String dictionaryKey = pd.getString("dictionaryKey");
        String pid = Common.DICTIONARY_MAP.get(dictionaryKey);
        String queryStr =  pd.getString("queryStr")!=null?pd.getString("queryStr"):"";
        pd.put("queryStr","(isdisable = '1' and pid = '"+pid+"' "+queryStr+" )");
        List<Map> dictionaryList = dictionaryService.findDataList(pd);
        model.putResult(dictionaryList);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/dataListDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}



