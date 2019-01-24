package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseInDetailService;
import com.xy.vmes.service.WarehouseInService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 说明：入库派单明细
 * @author 陈刚 自动生成
 * @date 2018-10-16
 */
@RestController
@Slf4j
public class WarehouseInDetailController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDetailController.class);

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    @Autowired
    private ColumnService columnService;

    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-10-16
     */
    @PostMapping("/warehouseInDetail/listPageWarehouseInDetail")
    public ResultModel listPageWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/listPageWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInDetail");
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
        if (columnList != null && columnList.size() > 0) {
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

        pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseInDetailService.getDataListPage(pd, pg);
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
        logger.info("################/warehouseInDetail/listPageWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-10-16
     */
    @PostMapping("/warehouseInDetail/listPageDetailProduct")
    public ResultModel listPageDetailProduct() throws Exception {
        logger.info("################/warehouseInDetail/listPageDetailProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInDetailProduct");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if (columnList != null && columnList.size() > 0) {
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

        PageData findMap = new PageData();
        findMap.put("orderStr", "a.cdate asc");
        PageData pd = HttpUtils.parsePageData();

        String type = pd.getString("type");
        if (!"edit".equals(type)) {
            findMap.put("queryStr", "1=2");
        } else {
            String parentId = pd.getString("parentId");
            findMap.put("parentId", parentId);
        }

        Pagination pg = HttpUtils.parsePagination(pd);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseInDetailService.getDataListPage(findMap, pg);
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
        logger.info("################/warehouseInDetail/listPageDetailProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseInDetail/updateWarehouseInDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/updateWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/updateWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseInDetail/cancelWarehouseInDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/cancelWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该入库单明细状态(1:执行中 2:已完成)！");
            return model;
        }

        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //状态(0:未完成 1:已完成 -1:已取消)
        if (warehouseIn != null && warehouseIn.getState() != null && "1".equals(warehouseIn.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该入库单已经(已完成)！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("-1");
        warehouseInDetailService.update(detail);

        //2.返写入库单状态
        //获取入库单状态-根据入库单明细状态 -- 忽视状态(-1:已取消)
        if (warehouseIn != null) {
            warehouseInDetailService.updateParentStateByDetailList(warehouseIn, null, null);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/cancelWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 恢复入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseInDetail/recoveryWarehouseInDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel recoveryWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/recoveryWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);
        if (detail.getState() != null && !"-1".equals(detail.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不是取消状态，不可恢复！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("0");
        warehouseInDetailService.update(detail);

        //2. 反写入库单主表状态
        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //获取入库单状态-根据入库单明细状态 -- 忽视状态(-1:已取消)
        if (warehouseIn != null) {
            warehouseInDetailService.updateParentStateByDetailList(warehouseIn, null, null);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/recoveryWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseInDetail/deleteWarehouseInDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/deleteWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);
        String checkState = detail.getState();
        if ("-1".equals(checkState)) {checkState = "c";}

        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (checkState != null && "1,2".indexOf(checkState.trim()) != -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该入库单明细状态(1:执行中 2:已完成)！");
            return model;
        }

        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //状态(0:未完成 1:已完成 -1:已取消)
        if (warehouseIn != null && warehouseIn.getState() != null && "1".equals(warehouseIn.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该入库单已经(已完成)！");
            return model;
        }

        //1. 删除入库明细
        warehouseInDetailService.deleteById(detailId);

        //2.返写入库单状态
        //获取入库单状态-根据入库单明细状态 -- 忽视状态(-1:已取消)
        if (warehouseIn != null) {
            warehouseInDetailService.updateParentStateByDetailList(warehouseIn, null, null);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/deleteWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
