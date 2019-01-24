package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;



/**
* 说明：移库单执行Controller
* @author 刘威 自动生成
* @date 2018-11-16
*/
@RestController
@Slf4j
public class WarehouseMoveExecuteController {

    private Logger logger = LoggerFactory.getLogger(WarehouseMoveExecuteController.class);

    @Autowired
    private WarehouseMoveExecuteService warehouseMoveExecuteService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private WarehouseProductService warehouseProductService;


    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    @Autowired
    private WarehouseMoveService warehouseMoveService;
    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouseMoveExecute/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveExecute/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteService.selectById(id);
        model.putResult(warehouseMoveExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveExecute/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseMoveExecute/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveExecute warehouseMoveExecute = (WarehouseMoveExecute)HttpUtils.pageData2Entity(pd, new WarehouseMoveExecute());
        warehouseMoveExecuteService.save(warehouseMoveExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveExecute/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseMoveExecute/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseMoveExecute warehouseMoveExecute = (WarehouseMoveExecute)HttpUtils.pageData2Entity(pd, new WarehouseMoveExecute());
        warehouseMoveExecuteService.update(warehouseMoveExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @GetMapping("/warehouseMoveExecute/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseMoveExecute/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        warehouseMoveExecuteService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveExecute/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseMoveExecute/deleteByIds 执行开始 ################# ");
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
            warehouseMoveExecuteService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveExecute/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseMoveExecute/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseMoveExecuteList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveExecute/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseMoveExecute/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.dataList(pd);
        model.putResult(warehouseMoveExecuteList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    /**
     * 出库执行
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseMoveExecute/executeWarehouseMoveExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseMoveExecute() throws Exception {
        logger.info("################/warehouseMoveExecute/executeWarehouseMoveExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseMoveExecuteService.executeWarehouseMoveExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveExecute/executeWarehouseMoveExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 移库删除
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseMoveExecute/deleteWarehouseMoveExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseMoveExecute() throws Exception {
        logger.info("################/warehouseMoveExecute/deleteWarehouseMoveExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String id = pageData.getString("id");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        WarehouseMoveExecute execute = warehouseMoveExecuteService.selectById(id);
        execute.setIsdisable("0");
        if(StringUtils.isEmpty(execute.getRemark())){
            execute.setRemark("操作记录：删除  操作时间："+ dateFormat.format(new Date()));
        }else {
            execute.setRemark(execute.getRemark()+"  操作记录：删除  操作时间："+ dateFormat.format(new Date()));
        }
        warehouseMoveExecuteService.update(execute);


        try {
            //还原移库操作
            WarehouseProduct outObject = warehouseProductService.selectById(execute.getWarehouseProductId());
            WarehouseProduct inObject = warehouseProductService.selectById(execute.getNewWarehouseProductId());

            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setParentId("");
            loginfo.setDetailId(execute.getDetailId());
            loginfo.setExecuteId(execute.getId());
            loginfo.setCompanyId(currentCompanyId);
            loginfo.setCuser(currentUserId);
            //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
            loginfo.setOperation("delete");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(execute.getCount());
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(BigDecimal.ZERO);


            String msgStr = warehouseProductService.moveStockCount(outObject,inObject,execute.getCount().negate(), loginfo);

//            Product product = productService.selectById(outObject.getProductId());
//            productService.updateStockCount(product,product.getStockCount().add(execute.getCount()),currentUserId);

            if (msgStr != null && msgStr.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }
        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }



        //更新出库单及出库明细状态
        WarehouseMoveDetail detail = warehouseMoveDetailService.selectById(execute.getDetailId());

        Map columnMap = new HashMap();
        columnMap.put("detail_id",execute.getDetailId());
        columnMap.put("isdisable","1");
        BigDecimal totalCount = BigDecimal.ZERO;
        List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.selectByColumnMap(columnMap);
        if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
            for(int i=0;i<warehouseMoveExecuteList.size();i++){
                WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteList.get(i);
                if(warehouseMoveExecute!=null&&warehouseMoveExecute.getCount()!=null){
                    totalCount = totalCount.add(warehouseMoveExecute.getCount());
                }
            }
        }
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if(detail.getCount().compareTo(totalCount)>0){
            detail.setState("1");
        }else {
            detail.setState("2");
        }

        warehouseMoveDetailService.update(detail);
        warehouseMoveService.updateState(detail.getParentId());


        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveExecute/deleteWarehouseMoveExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * 出库编辑
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseMoveExecute/updateWarehouseMoveExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseMoveExecute() throws Exception {
        logger.info("################/warehouseMoveExecute/updateWarehouseMoveExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String id = pageData.getString("id");
        String beforeCount = pageData.getString("beforeCount");
        String afterCount = pageData.getString("afterCount");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");

        if((!StringUtils.isEmpty(beforeCount))&&(!StringUtils.isEmpty(afterCount))){

            BigDecimal before = BigDecimal.valueOf(Double.parseDouble(beforeCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal after = BigDecimal.valueOf(Double.parseDouble(afterCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            WarehouseMoveExecute execute = warehouseMoveExecuteService.selectById(id);
            execute.setCount(after);
            if(StringUtils.isEmpty(execute.getRemark())){
                execute.setRemark("操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            }else {
                execute.setRemark(execute.getRemark()+"  操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            }

            warehouseMoveExecuteService.update(execute);


            try {
                //修改移库操作
                WarehouseProduct outObject = warehouseProductService.selectById(execute.getWarehouseProductId());
                WarehouseProduct inObject = warehouseProductService.selectById(execute.getNewWarehouseProductId());

                //库存变更日志
                WarehouseLoginfo loginfo = new WarehouseLoginfo();
                loginfo.setParentId("");
                loginfo.setDetailId(execute.getDetailId());
                loginfo.setExecuteId(execute.getId());
                loginfo.setCompanyId(currentCompanyId);
                loginfo.setCuser(currentUserId);
                //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
                loginfo.setOperation("modify");

                //beforeCount 操作变更前数量(业务相关)
                loginfo.setBeforeCount(before);
                //afterCount 操作变更后数量(业务相关)
                loginfo.setAfterCount(after);

                String msgStr = warehouseProductService.moveStockCount(outObject,inObject,after.subtract(before), loginfo);

//                Product product = productService.selectById(outObject.getProductId());
//                productService.updateStockCount(product,product.getStockCount().subtract(after.subtract(before)),currentUserId);

                if (msgStr != null && msgStr.trim().length() > 0) {
                    model.putCode(Integer.valueOf(1));
                    model.putMsg(msgStr);
                    return model;
                }
            } catch (TableVersionException tabExc) {
                //库存变更 version 锁
                if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                    model.putCode(Integer.valueOf(1));
                    model.putMsg(tabExc.getMessage());
                    return model;
                }
            }

            //更新出库单及出库明细状态
            WarehouseMoveDetail detail = warehouseMoveDetailService.selectById(execute.getDetailId());

            Map columnMap = new HashMap();
            columnMap.put("detail_id",execute.getDetailId());
            columnMap.put("isdisable","1");
            BigDecimal totalCount = BigDecimal.ZERO;
            List<WarehouseMoveExecute> warehouseMoveExecuteList = warehouseMoveExecuteService.selectByColumnMap(columnMap);
            if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
                for(int i=0;i<warehouseMoveExecuteList.size();i++){
                    WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteList.get(i);
                    if(warehouseMoveExecute!=null&&warehouseMoveExecute.getCount()!=null){
                        totalCount = totalCount.add(warehouseMoveExecute.getCount());
                    }
                }
            }
            //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            if(detail.getCount().compareTo(totalCount)>0){
                detail.setState("1");
            }else {
                detail.setState("2");
            }
            warehouseMoveDetailService.update(detail);
            warehouseMoveService.updateState(detail.getParentId());
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseMoveExecute/updateWarehouseMoveExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }




    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveExecute/listPageWarehouseMoveExecutes")
    public ResultModel listPageWarehouseMoveExecutes()  throws Exception {

        logger.info("################warehouseMoveExecute/listPageWarehouseMoveExecutes 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        List<Column> columnList = columnService.findColumnList("WarehouseMoveExecute");
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
        List<Map> varList = warehouseMoveExecuteService.getDataListPage(pd,pg);
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
        logger.info("################warehouseMoveExecute/listPageWarehouseMoveExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveExecute/exportExcelWarehouseMoveExecutes")
    public void exportExcelWarehouseMoveExecutes() throws Exception {
        logger.info("################warehouseMoveExecute/exportExcelWarehouseMoveExecutes 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("WarehouseMoveExecute");
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
        List<Map> dataList = warehouseMoveExecuteService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseMoveExecute";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseMoveExecute/exportExcelWarehouseMoveExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-16
    */
    @PostMapping("/warehouseMoveExecute/importExcelWarehouseMoveExecutes")
    public ResultModel importExcelWarehouseMoveExecutes(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseMoveExecute/importExcelWarehouseMoveExecutes 执行开始 ################# ");
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
        logger.info("################warehouseMoveExecute/importExcelWarehouseMoveExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



