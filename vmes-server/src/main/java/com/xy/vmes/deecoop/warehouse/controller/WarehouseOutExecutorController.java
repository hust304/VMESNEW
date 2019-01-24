package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseOutExecute;
import com.xy.vmes.entity.WarehouseOutExecutor;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseOutExecuteService;
import com.xy.vmes.service.WarehouseOutExecutorService;
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
* 说明：出库执行人Controller
* @author 刘威 自动生成
* @date 2018-11-01
*/
@RestController
@Slf4j
public class WarehouseOutExecutorController {

    private Logger logger = LoggerFactory.getLogger(WarehouseOutExecutorController.class);

    @Autowired
    private WarehouseOutExecutorService warehouseOutExecutorService;
    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;
    @Autowired
    private ColumnService columnService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @GetMapping("/warehouseOutExecutor/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutExecutor/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        WarehouseOutExecutor warehouseOutExecutor = warehouseOutExecutorService.selectById(id);
        model.putResult(warehouseOutExecutor);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouseOutExecutor/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseOutExecutor/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutExecutor warehouseOutExecutor = (WarehouseOutExecutor)HttpUtils.pageData2Entity(pd, new WarehouseOutExecutor());
        warehouseOutExecutorService.save(warehouseOutExecutor);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouseOutExecutor/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseOutExecutor/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutExecutor warehouseOutExecutor = (WarehouseOutExecutor)HttpUtils.pageData2Entity(pd, new WarehouseOutExecutor());
        warehouseOutExecutorService.update(warehouseOutExecutor);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @GetMapping("/warehouseOutExecutor/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutExecutor/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        warehouseOutExecutorService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouseOutExecutor/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseOutExecutor/deleteByIds 执行开始 ################# ");
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
            warehouseOutExecutorService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouseOutExecutor/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseOutExecutor/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseOutExecutorList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouseOutExecutor/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseOutExecutor/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.dataList(pd);
        model.putResult(warehouseOutExecutorList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/





    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-11-01
     */
    @PostMapping("/warehouseOutExecutor/updateExecutor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateExecutor()  throws Exception {

        logger.info("################warehouseOutExecutor/updateExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String detailId = pd.getString("detailId");
        String executorIds = pd.getString("executorIds");
        pd.put("queryStr","detail_id ='"+detailId+"' and isdisable = '1' ");
        pd.put("mapSize", Integer.valueOf(pd.size()));
        List<WarehouseOutExecute> warehouseOutExecuteList = warehouseOutExecuteService.dataList(pd);
        if(warehouseOutExecuteList!=null&&warehouseOutExecuteList.size()>0){
            model.putCode("1");
            model.putMsg("该出库单执行人已开始出库，不能直接更换执行人，请联系当前执行人与其沟通后撤回单据！");
            return model;
        }

        if(!StringUtils.isEmpty(executorIds)){
            String[] executorIdArr = executorIds.split(",");
            if(executorIdArr!=null&&executorIdArr.length>0){
                Map columnMap = new HashMap();
                columnMap.put("detail_id",detailId);
                List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.selectByColumnMap(columnMap);
                if(warehouseOutExecutorList!=null&&warehouseOutExecutorList.size()>0){
                    for(int i=0;i<warehouseOutExecutorList.size();i++){
                        WarehouseOutExecutor warehouseOutExecutor = warehouseOutExecutorList.get(i);
                        warehouseOutExecutor.setIsdisable("0");
                        warehouseOutExecutor.setRemark("执行人变更");
                        warehouseOutExecutorService.update(warehouseOutExecutor);
                    }
                }

                for(int i=0;i<executorIdArr.length;i++){
                    WarehouseOutExecutor warehouseOutExecutor = new WarehouseOutExecutor();
                    warehouseOutExecutor.setDetailId(detailId);
                    warehouseOutExecutor.setExecutorId(executorIdArr[i]);
                    warehouseOutExecutorService.save(warehouseOutExecutor);
                }
            }
        }else {
            model.putCode("2");
            model.putMsg("未勾选记录，请重新选择！");
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/updateExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouseOutExecutor/listPageWarehouseOutExecutors")
    public ResultModel listPageWarehouseOutExecutors()  throws Exception {

        logger.info("################warehouseOutExecutor/listPageWarehouseOutExecutors 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseOutExecutor");
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
        List<Map> varList = warehouseOutExecutorService.getDataListPage(pd,pg);
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
        logger.info("################warehouseOutExecutor/listPageWarehouseOutExecutors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouseOutExecutor/exportExcelWarehouseOutExecutors")
    public void exportExcelWarehouseOutExecutors() throws Exception {
        logger.info("################warehouseOutExecutor/exportExcelWarehouseOutExecutors 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("WarehouseOutExecutor");
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
        List<Map> dataList = warehouseOutExecutorService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseOutExecutor";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecutor/exportExcelWarehouseOutExecutors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouseOutExecutor/importExcelWarehouseOutExecutors")
    public ResultModel importExcelWarehouseOutExecutors(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseOutExecutor/importExcelWarehouseOutExecutors 执行开始 ################# ");
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
        logger.info("################warehouseOutExecutor/importExcelWarehouseOutExecutors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



