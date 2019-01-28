package com.xy.vmes.deecoop.warehouse.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseMoveExecuteMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：移库单执行 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-11-16
*/
@Service
@Transactional(readOnly = false)
public class WarehouseMoveExecuteServiceImp implements WarehouseMoveExecuteService {


    @Autowired
    private WarehouseMoveExecuteMapper warehouseMoveExecuteMapper;
    @Autowired
    private ColumnService columnService;

    @Autowired
    private WarehouseProductService warehouseProductService;


    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    @Autowired
    private WarehouseMoveService warehouseMoveService;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void save(WarehouseMoveExecute warehouseMoveExecute) throws Exception{
        warehouseMoveExecute.setId(Conv.createUuid());
        warehouseMoveExecute.setCdate(new Date());
        warehouseMoveExecute.setUdate(new Date());
        warehouseMoveExecuteMapper.insert(warehouseMoveExecute);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void update(WarehouseMoveExecute warehouseMoveExecute) throws Exception{
        warehouseMoveExecute.setUdate(new Date());
        warehouseMoveExecuteMapper.updateById(warehouseMoveExecute);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateAll(WarehouseMoveExecute warehouseMoveExecute) throws Exception{
        warehouseMoveExecute.setUdate(new Date());
        warehouseMoveExecuteMapper.updateAllColumnById(warehouseMoveExecute);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    //@Cacheable(cacheNames = "warehouseMoveExecute", key = "''+#id")
    public WarehouseMoveExecute selectById(String id) throws Exception{
        return warehouseMoveExecuteMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteById(String id) throws Exception{
        warehouseMoveExecuteMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        warehouseMoveExecuteMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveExecute> dataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveExecuteMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveExecute> dataList(PageData pd) throws Exception{
        return warehouseMoveExecuteMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return warehouseMoveExecuteMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return warehouseMoveExecuteMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        warehouseMoveExecuteMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<WarehouseMoveExecute> selectByColumnMap(Map columnMap) throws Exception{
    List<WarehouseMoveExecute> warehouseMoveExecuteList =  warehouseMoveExecuteMapper.selectByMap(columnMap);
        return warehouseMoveExecuteList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return warehouseMoveExecuteMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return warehouseMoveExecuteMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return warehouseMoveExecuteMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-11-16
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        warehouseMoveExecuteMapper.updateToDisableByIds(ids);
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    @Override
    public ResultModel executeWarehouseMoveExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String jsonDataStr = pageData.getString("jsonDataStr");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(jsonDataStr);



        if(mapList!=null&&mapList.size()>0){
            for(int j=0;j<mapList.size();j++){
                Map<String, Object> rootMap = mapList.get(j);
                if(rootMap!=null&&rootMap.get("children")!=null){
                    String newWarehouseId = (String)rootMap.get("warehouseId");
                    if(!StringUtils.isEmpty(newWarehouseId)){
                        //新增推荐库位记录
                        List childrenList = (List) rootMap.get("children");
                        if(childrenList!=null&&childrenList.size()>0){
                            for(int k=0;k<childrenList.size();k++){
                                Map<String, Object> childrenMap = (Map<String, Object>)childrenList.get(k);
                                String warehouseProductId = (String)childrenMap.get("warehouseProductId");
                                String suggestCount = (String)childrenMap.get("suggestCount");
                                String detailId = (String)childrenMap.get("id");
                                BigDecimal count = StringUtils.isEmpty(suggestCount)? BigDecimal.ZERO:BigDecimal.valueOf(Double.parseDouble(suggestCount));
                                model = this.addWarehouseMoveExecute(detailId,newWarehouseId,warehouseProductId,count,currentUserId,currentCompanyId);
                                if(model.get("code") != null && !"0".equals(model.get("code").toString().trim())){
                                    return model;
                                }
                            }
                        }

                    }
                }

            }
        }
        return model;
    }

    @Override
    public ResultModel addWarehouseMoveExecute(String detailId, String newWarehouseId, String warehouseProductId, BigDecimal count, String currentUserId, String currentCompanyId) throws Exception {
        ResultModel model = new ResultModel();
        WarehouseProduct outObject = warehouseProductService.selectById(warehouseProductId);

        PageData findMap = new PageData();
        findMap.put("code", outObject.getCode());
        findMap.put("productId", outObject.getProductId());
        findMap.put("warehouseId", newWarehouseId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        WarehouseProduct inObject = warehouseProductService.findWarehouseProduct(findMap);

        if(inObject==null){
            inObject = new WarehouseProduct();
            String id = Conv.createUuid();
            inObject.setId(id);
            inObject.setCompanyId(outObject.getCompanyId());
            inObject.setCode(outObject.getCode());
            inObject.setProductId(outObject.getProductId());
            inObject.setWarehouseId(newWarehouseId);
            inObject.setCdate(new Date());
            inObject.setQrcode(outObject.getQrcode());
            warehouseProductService.save(inObject);
        }


        WarehouseMoveExecute execute = new WarehouseMoveExecute();
        execute.setDetailId(detailId);
        execute.setExecutorId(currentUserId);
        execute.setWarehouseProductId(outObject.getId());
        execute.setNewWarehouseProductId(inObject.getId());
        execute.setCount(count);
        this.save(execute);


        //移库执行
        try {
            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setParentId("");
            loginfo.setDetailId(execute.getDetailId());
            loginfo.setExecuteId(execute.getId());
            loginfo.setCompanyId(currentCompanyId);
            loginfo.setCuser(currentUserId);
            //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
            loginfo.setOperation("add");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(BigDecimal.ZERO);
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(execute.getCount());


            String msgStr = warehouseProductService.moveStockCount(outObject,inObject, count, loginfo);
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
        WarehouseMoveDetail detail = warehouseMoveDetailService.selectById(detailId);

        Map columnMap = new HashMap();
        columnMap.put("detail_id",detailId);
        columnMap.put("isdisable","1");
        BigDecimal totalCount = BigDecimal.ZERO;
        List<WarehouseMoveExecute> warehouseMoveExecuteList = this.selectByColumnMap(columnMap);
        if(warehouseMoveExecuteList!=null&&warehouseMoveExecuteList.size()>0){
            for(int i=0;i<warehouseMoveExecuteList.size();i++){
                WarehouseMoveExecute warehouseMoveExecute = warehouseMoveExecuteList.get(i);
                if(warehouseMoveExecute!=null&&warehouseMoveExecute.getCount()!=null){
                    totalCount = totalCount.add(warehouseMoveExecute.getCount());
                }
            }
        }
        Map countResult = new HashMap();
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if(detail.getCount().compareTo(totalCount)>0){
            detail.setState("1");
            countResult.put("unCompleteCount",(detail.getCount().subtract(totalCount).setScale(2,BigDecimal.ROUND_HALF_UP)).doubleValue());
        }else {
            detail.setState("2");
            countResult.put("unCompleteCount",0.00);
        }
        model.putResult(countResult);
        warehouseMoveDetailService.update(detail);
        warehouseMoveService.updateState(detail.getParentId());

        return model;
    }

    @Override
    public ResultModel deleteWarehouseMoveExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        WarehouseMoveExecute execute = this.selectById(id);
        execute.setIsdisable("0");
        if(StringUtils.isEmpty(execute.getRemark())){
            execute.setRemark("操作记录：删除  操作时间："+ dateFormat.format(new Date()));
        }else {
            execute.setRemark(execute.getRemark()+"  操作记录：删除  操作时间："+ dateFormat.format(new Date()));
        }
        this.update(execute);


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
        List<WarehouseMoveExecute> warehouseMoveExecuteList = this.selectByColumnMap(columnMap);
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

        return model;
    }

    @Override
    public ResultModel updateWarehouseMoveExecute(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String id = pageData.getString("id");
        String beforeCount = pageData.getString("beforeCount");
        String afterCount = pageData.getString("afterCount");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");

        if((!StringUtils.isEmpty(beforeCount))&&(!StringUtils.isEmpty(afterCount))){

            BigDecimal before = BigDecimal.valueOf(Double.parseDouble(beforeCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal after = BigDecimal.valueOf(Double.parseDouble(afterCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            WarehouseMoveExecute execute = this.selectById(id);
            execute.setCount(after);
            if(StringUtils.isEmpty(execute.getRemark())){
                execute.setRemark("操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            }else {
                execute.setRemark(execute.getRemark()+"  操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            }

            this.update(execute);


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
            List<WarehouseMoveExecute> warehouseMoveExecuteList = this.selectByColumnMap(columnMap);
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

        return model;
    }

    @Override
    public ResultModel listPageWarehouseMoveExecutes(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
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
        List<Map> varList = this.getDataListPage(pd,pg);
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
        return model;
    }

    @Override
    public void exportExcelWarehouseMoveExecutes(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("WarehouseMoveExecute");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        pg.setSize(100000);
        List<Map> dataList = this.getDataListPage(pd, pg);

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
    }

    @Override
    public ResultModel importExcelWarehouseMoveExecutes(MultipartFile file) throws Exception {
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
        return model;
    }
}



