package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseCheckDetailService;
import com.xy.vmes.service.WarehouseCheckService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.*;

/**
* 说明：vmes_warehouse_check_detail:仓库库存盘点明细Controller
* @author 陈刚 自动生成
* @date 2018-11-13
*/
@RestController
@Slf4j
public class WarehouseCheckDetailController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckDetailController.class);

    @Autowired
    private WarehouseCheckService warehouseCheckService;
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;

    @Autowired
    private ColumnService columnService;

    /**
     * @author 陈刚
     * @date 2018-11-13
     */
    @PostMapping("/warehouse/warehouseCheckDetail/listPageWarehouseCheckDetails")
    public ResultModel listPageWarehouseCheckDetails() throws Exception {
        logger.info("################warehouseCheckDetail/listPageWarehouseCheckDetails 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseCheckDetail");
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
                if (column != null) {
                    if ("0".equals(column.getIshide())) {
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

        //设置查询排序
        pd.put("orderStr", "detail.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseCheckDetailService.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheckDetail/listPageWarehouseCheckDetails 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消盘点单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckDetail/cancelWarehouseCheckDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelWarehouseCheckDetail() throws Exception {
        logger.info("################/warehouseCheckDetail/cancelWarehouseCheckDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细id为空或空字符串！");
            return model;
        }

        WarehouseCheckDetail detail = warehouseCheckDetailService.findWarehouseCheckDetailById(detailId);
        String detailState = detail.getState();
        if ("-1".equals(detailState)) {detailState = "c";}

        //状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
        if (detailState != null && "1,2,3".indexOf(detailState.trim()) != -1) {
            String msgTemp = "该盘点明细状态{0}，当前盘点明细不可取消！";
            String msgStr = MessageFormat.format(msgTemp, Common.SYS_WAREHOUSE_CHECK_DETAIL_STATE.get(detailState));

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
        detail.setState("-1");
        warehouseCheckDetailService.update(detail);

        //2.返写盘点单状态
        //获取盘点单状态-根据盘点明细状态 -- 忽视状态(-1:已取消)
        WarehouseCheck parent = new WarehouseCheck();
        parent.setId(detail.getParentId());
        if (parent != null) {
            warehouseCheckDetailService.updateParentStateByDetailList(parent, null, null);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckDetail/cancelWarehouseCheckDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除盘点单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckDetail/deleteWarehouseCheckDetail")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseCheckDetail() throws Exception {
        logger.info("################/warehouseCheckDetail/deleteWarehouseCheckDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细id为空或空字符串！");
            return model;
        }

        WarehouseCheckDetail detail = warehouseCheckDetailService.findWarehouseCheckDetailById(detailId);
        String checkState = detail.getState();
        if ("-1".equals(checkState)) {checkState = "c";}

        // 状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
        if (checkState != null && "1,2,3".indexOf(checkState.trim()) != -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前盘点明细不可删除，该盘点明细状态(执行中,审核中,已完成)！");
            return model;
        }

        //1. 删除盘点明细
        warehouseCheckDetailService.deleteById(detailId);

        //2.返写盘点单状态
        //获取盘点单状态-根据盘点明细状态 -- 忽视状态(-1:已取消)
        WarehouseCheck parent = new WarehouseCheck();
        parent.setId(detail.getParentId());
        if (parent != null) {
            warehouseCheckDetailService.updateParentStateByDetailList(parent, null, null);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckDetail/deleteWarehouseCheckDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



