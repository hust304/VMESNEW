package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.LogInfo;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.LogInfoService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
* 说明：操作日志Controller
* @author 刘威 自动生成
* @date 2018-08-28
*/
@RestController
@Slf4j
public class LogInfoController {

    private Logger logger = LoggerFactory.getLogger(LogInfoController.class);

    @Autowired
    private LogInfoService logInfoService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-28
    */
    @GetMapping("/logInfo/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################logInfo/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        LogInfo logInfo = logInfoService.selectById(id);
        model.putResult(logInfo);
        Long endTime = System.currentTimeMillis();
        logger.info("################logInfo/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-28
    */
    @PostMapping("/logInfo/save")
    public ResultModel save()  throws Exception {

        logger.info("################logInfo/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        LogInfo logInfo = (LogInfo)HttpUtils.pageData2Entity(pd, new LogInfo());
        logInfoService.save(logInfo);
        Long endTime = System.currentTimeMillis();
        logger.info("################logInfo/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-28
    */
    @PostMapping("/logInfo/update")
    public ResultModel update()  throws Exception {

        logger.info("################logInfo/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        LogInfo logInfo = (LogInfo)HttpUtils.pageData2Entity(pd, new LogInfo());
        logInfoService.update(logInfo);
        Long endTime = System.currentTimeMillis();
        logger.info("################logInfo/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-28
    */
    @GetMapping("/logInfo/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################logInfo/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        logInfoService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################logInfo/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-28
    */
    @PostMapping("/logInfo/deleteByIds")
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################logInfo/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();
        String ids = pd.getString("ids");
        if(StringUtils.isEmpty(ids)){
            model.putCode("1");
            model.putMsg("未勾选删除记录，请重新选择！");
            return model;
        }
        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");
        if(id_arry.length>0){
            logInfoService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################logInfo/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-28
    */
    @PostMapping("/logInfo/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################logInfo/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<LogInfo> logInfoList = logInfoService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",logInfoList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################logInfo/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-08-28
    */
    @PostMapping("/logInfo/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################logInfo/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<LogInfo> logInfoList = logInfoService.dataList(pd);
        model.putResult(logInfoList);
        Long endTime = System.currentTimeMillis();
        logger.info("################logInfo/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-08-28
    */
    @PostMapping("/logInfo/listPageLogInfos")
    public ResultModel listPageLogInfos()  throws Exception {

        logger.info("################logInfo/listPageLogInfos 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String cdate = pd.getString("cdate");
        if(!StringUtils.isEmpty(cdate)){
            String[] cdateArr = cdate.replace("[","").replace("]","").split(",");
            if(cdateArr!=null&&cdateArr.length>0){
                pd.put("startDate",cdateArr[0]);
                pd.put("endDate",cdateArr[1]);
            }
        }


        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("logInfo");
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
        List<Map> varList = logInfoService.getDataListPage(pd,pg);
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
        logger.info("################logInfo/listPageLogInfos 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-08-28
    */
    @GetMapping("/logInfo/exportExcelLogInfos")
    public void exportExcelLogInfos() throws Exception {
        logger.info("################logInfo/exportExcelLogInfos 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        //1. 获取Excel导出数据查询条件
        PageData pd = HttpUtils.parsePageData();
        String ids = (String)pd.get("ids");
        String queryColumn = (String)pd.get("queryColumn");

        //2. 获取业务列表List<Map<栏位Key, 栏位名称>>
        List<Column> columnList = columnService.findColumnList("logInfo");
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

        PageData findMap = new PageData();
        //业务表查询条件 findMap.put("查询字段名称", "Value");
        findMap.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> dataList = logInfoService.getDataList(findMap);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);

        HttpServletResponse response  = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        //String fileName = "Excel文件导出";
        String fileName = "ExcelLogInfo";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################logInfo/exportExcelLogInfos 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-08-28
    */
    @PostMapping("/logInfo/importExcelLogInfos")
    public ResultModel importExcelLogInfos(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################logInfo/importExcelLogInfos 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        //HttpServletRequest Request = HttpUtils.currentRequest();

        if (file == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请上传Excel文件！");
            return model;
        }

        // 验证文件是否合法
        // 获取上传的文件名(文件名.后缀)
        String fileName = file.getOriginalFilename();
        if (fileName == null
            || !(fileName.matches("^.+\\.(?i)(xlsx)$")
            || fileName.matches("^.+\\.(?i)(xls)$"))
        ) {
            String failMesg = "不是excel格式文件,请重新选择！";
            model.putCode(Integer.valueOf(1));
            model.putMsg(failMesg);
            return model;
        }

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
            if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        Long endTime = System.currentTimeMillis();
        logger.info("################logInfo/importExcelLogInfos 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



