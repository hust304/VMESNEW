package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseCheckExecute;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseCheckDetailService;
import com.xy.vmes.service.WarehouseCheckExecuteService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
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
import java.util.*;



/**
* 说明：vmes_warehouse_check_execute:仓库库存盘点审核明细Controller
* @author 陈刚 自动生成
* @date 2018-11-15
*/
@RestController
@Slf4j
public class WarehouseCheckExecuteController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckExecuteController.class);

    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    @Autowired
    private WarehouseCheckExecuteService warehouseCheckExecuteService;

    @Autowired
    private ColumnService columnService;

    /**
     * 获取盘点执行列表-(盘点审核列表)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecute/findListByWarehouseCheckExecute")
    public ResultModel findListByWarehouseCheckExecute() throws Exception {
        logger.info("################warehouseCheckExecute/findListByWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseCheckExecuteByAudit");
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

        pd.put("orderStr", "executor.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseCheckExecuteService.findListWarehouseCheckExecuteByAudit(pd, pg);
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
        logger.info("################warehouseCheckExecute/findListByWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单明细执行
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecute/addWarehouseCheckExecute")
    @Transactional
    public ResultModel addWarehouseCheckExecute() throws Exception {
        logger.info("################/warehouseCheckExecute/addWarehouseCheckExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String addExecuteJsonStr = pageData.getString("addExecuteJsonStr");
        if (addExecuteJsonStr == null || addExecuteJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少勾选一条盘点数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(addExecuteJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细执行 Json字符串-转换成List错误！");
            return model;
        }

        Map<String, String> parentMap = new HashMap<String, String>();
        for (Map<String, Object> mapObject : mapList) {
            WarehouseCheckExecute execute = (WarehouseCheckExecute)HttpUtils.pageData2Entity(mapObject, new WarehouseCheckExecute());
            if (execute.getCount() == null) {execute.setCount(BigDecimal.valueOf(0D));}
            execute.setExecutorId(cuser);
            execute.setCuser(cuser);
            //state:状态(0:待审核 2:同意 3:不同意)
            execute.setState("0");
            warehouseCheckExecuteService.save(execute);

            //修改盘点明细状态
            //state: 状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            WarehouseCheckDetail detail = warehouseCheckDetailService.findWarehouseCheckDetailById(execute.getDetailId());
            detail.setState("2");
            warehouseCheckDetailService.update(detail);

            parentMap.put(execute.getParentId(), execute.getParentId());
        }

        //修改盘点单状态
        if (parentMap.size() > 0) {
            for (Iterator iterator = parentMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = (String) iterator.next();

                WarehouseCheck parent = new WarehouseCheck();
                parent.setId(parentId);
                //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)--忽视状态(-1)
                warehouseCheckDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecute/addWarehouseCheckExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



