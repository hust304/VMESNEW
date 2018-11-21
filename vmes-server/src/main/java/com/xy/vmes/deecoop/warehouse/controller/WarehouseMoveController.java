package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.*;
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
* 说明：移库单Controller
* @author 刘威 自动生成
* @date 2018-11-16
*/
@RestController
@Slf4j
public class WarehouseMoveController {

    private Logger logger = LoggerFactory.getLogger(WarehouseMoveController.class);

    @Autowired
    private WarehouseMoveService warehouseMoveService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private CoderuleService coderuleService;

    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    @Autowired
    private WarehouseMoveExecutorService warehouseMoveExecutorService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouseMove/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMove/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        WarehouseMove warehouseMove = warehouseMoveService.selectById(id);
        model.putResult(warehouseMove);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMove/save")
    @Transactional
    public ResultModel save()  throws Exception {

        logger.info("################warehouseMove/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMove warehouseMove = (WarehouseMove)HttpUtils.pageData2Entity(pd, new WarehouseMove());
        warehouseMoveService.save(warehouseMove);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMove/update")
    @Transactional
    public ResultModel update()  throws Exception {

        logger.info("################warehouseMove/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMove warehouseMove = (WarehouseMove)HttpUtils.pageData2Entity(pd, new WarehouseMove());
        warehouseMoveService.update(warehouseMove);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouseMove/deleteById/{id}")
    @Transactional
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMove/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        warehouseMoveService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMove/deleteByIds")
    @Transactional
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseMove/deleteByIds 执行开始 ################# ");
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
            warehouseMoveService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMove/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseMove/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseMove> warehouseMoveList = warehouseMoveService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseMoveList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMove/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseMove/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseMove> warehouseMoveList = warehouseMoveService.dataList(pd);
        model.putResult(warehouseMoveList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-11-16
     */
    @PostMapping("/warehouseMove/saveWarehouseMove")
    @Transactional
    public ResultModel saveWarehouseMove()  throws Exception {

        logger.info("################warehouseMove/saveWarehouseMove 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String dtlJsonStr = pd.getString("dtlJsonStr");
        String executorIdsStr = pd.getString("executorIdsStr");

        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("移库单明细Json字符串-转换成List错误！");
            return model;
        }
        String currentUserId = pd.getString("currentUserId");
        String companyID = pd.getString("currentCompanyId");
        String warehouseId = pd.getString("warehouseId");
        WarehouseMove warehouseMove = new WarehouseMove();
        //1. 添加移库单
        String id = Conv.createUuid();
        warehouseMove.setId(id);
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseMove.setState("0");
        warehouseMove.setCompanyId(companyID);
        warehouseMove.setType("b73d12669b4646e68c1a633da5b5d22d");//移库类型：移库
        warehouseMove.setMakeId(currentUserId);
        warehouseMove.setCuser(currentUserId);
        warehouseMove.setWarehouseId(warehouseId);
        //出库单编号
        String code = coderuleService.createCoder(companyID, "vmes_warehouse_move", "O");
        warehouseMove.setCode(code);
        warehouseMoveService.save(warehouseMove);

        //2.添加移库单明细
        List<WarehouseMoveDetail> detailList = warehouseMoveDetailService.mapList2DetailList(mapList, null);
        warehouseMoveDetailService.addWarehouseMoveDetail(warehouseMove, detailList);

        //3.移库单派工添加执行人信息
        if(detailList!=null&&detailList.size()>0){
            for(int i=0;i<detailList.size();i++){
                WarehouseMoveDetail detail = detailList.get(i);
                //新增移库执行人记录
                if(!StringUtils.isEmpty(executorIdsStr)){
                    String[] executorIds = executorIdsStr.split(",");
                    if(executorIds!=null&&executorIds.length>0){
                        for(int j=0;j<executorIds.length;j++){
                            String executorId = executorIds[j];
                            WarehouseMoveExecutor executor = new WarehouseMoveExecutor();
                            executor.setExecutorId(executorId);
                            executor.setDetailId(detail.getId());
                            executor.setCuser(currentUserId);
                            warehouseMoveExecutorService.save(executor);
                        }
                    }
                }
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/saveWarehouseMove 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMove/listPageWarehouseMoves")
    public ResultModel listPageWarehouseMoves()  throws Exception {

        logger.info("################warehouseMove/listPageWarehouseMoves 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseMove");
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
        List<Map> varList = warehouseMoveService.getDataListPage(pd,pg);
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
        logger.info("################warehouseMove/listPageWarehouseMoves 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMove/exportExcelWarehouseMoves")
    public void exportExcelWarehouseMoves() throws Exception {
        logger.info("################warehouseMove/exportExcelWarehouseMoves 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("WarehouseMove");
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
        List<Map> dataList = warehouseMoveService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseMove";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMove/exportExcelWarehouseMoves 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMove/importExcelWarehouseMoves")
    public ResultModel importExcelWarehouseMoves(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseMove/importExcelWarehouseMoves 执行开始 ################# ");
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
        logger.info("################warehouseMove/importExcelWarehouseMoves 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



