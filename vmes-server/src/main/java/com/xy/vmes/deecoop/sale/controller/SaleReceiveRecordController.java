package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleReceiveRecord;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleReceiveRecordService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
* 说明：收款记录Controller
* @author 刘威 自动生成
* @date 2018-12-25
*/
@RestController
@Slf4j
public class SaleReceiveRecordController {

    private Logger logger = LoggerFactory.getLogger(SaleReceiveRecordController.class);

    @Autowired
    private SaleReceiveRecordService saleReceiveRecordService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @GetMapping("/sale/saleReceiveRecord/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleReceiveRecord/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        SaleReceiveRecord saleReceiveRecord = saleReceiveRecordService.selectById(id);
        model.putResult(saleReceiveRecord);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceiveRecord saleReceiveRecord = (SaleReceiveRecord)HttpUtils.pageData2Entity(pd, new SaleReceiveRecord());
        saleReceiveRecordService.save(saleReceiveRecord);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        SaleReceiveRecord saleReceiveRecord = (SaleReceiveRecord)HttpUtils.pageData2Entity(pd, new SaleReceiveRecord());
        saleReceiveRecordService.update(saleReceiveRecord);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @GetMapping("/sale/saleReceiveRecord/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################/sale/saleReceiveRecord/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        saleReceiveRecordService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/deleteByIds 执行开始 ################# ");
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
            saleReceiveRecordService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<SaleReceiveRecord> saleReceiveRecordList = saleReceiveRecordService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",saleReceiveRecordList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################/sale/saleReceiveRecord/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<SaleReceiveRecord> saleReceiveRecordList = saleReceiveRecordService.dataList(pd);
        model.putResult(saleReceiveRecordList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/listPageSaleReceiveRecords")
    public ResultModel listPageSaleReceiveRecords()  throws Exception {
        logger.info("################/sale/saleReceiveRecord/listPageSaleReceiveRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("SaleReceiveRecord");
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
        List<Map> varList = saleReceiveRecordService.getDataListPage(pd,pg);
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
        logger.info("################/sale/saleReceiveRecord/listPageSaleReceiveRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/exportExcelSaleReceiveRecords")
    public void exportExcelSaleReceiveRecords() throws Exception {
        logger.info("################/sale/saleReceiveRecord/exportExcelSaleReceiveRecords 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("SaleReceiveRecord");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        PageData pd = HttpUtils.parsePageData();
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = saleReceiveRecordService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleReceiveRecord";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleReceiveRecord/exportExcelSaleReceiveRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-12-25
    */
    @PostMapping("/sale/saleReceiveRecord/importExcelSaleReceiveRecords")
    public ResultModel importExcelSaleReceiveRecords(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/sale/saleReceiveRecord/importExcelSaleReceiveRecords 执行开始 ################# ");
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
        logger.info("################/sale/saleReceiveRecord/importExcelSaleReceiveRecords 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



