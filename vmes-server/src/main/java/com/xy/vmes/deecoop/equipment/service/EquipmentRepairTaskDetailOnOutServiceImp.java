package com.xy.vmes.deecoop.equipment.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.equipment.dao.EquipmentRepairTaskDetailOnOutMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.EquipmentRepairTaskDetailOnOutService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：设备维修任务明细关联出库明细 实现类
 * 创建人：陈刚
 * 创建时间：2019-08-28
 */
@Service
@Transactional(readOnly = false)
public class EquipmentRepairTaskDetailOnOutServiceImp implements EquipmentRepairTaskDetailOnOutService {
    @Autowired
    private EquipmentRepairTaskDetailOnOutMapper taskDetailOnOutMapper;

    @Autowired
    private ColumnService columnService;

    public List<Map> findRepairTaskDetailOnOutDetail(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return taskDetailOnOutMapper.findRepairTaskDetailOnOutDetail(pd);
        } else if (pg != null) {
            return taskDetailOnOutMapper.findRepairTaskDetailOnOutDetail(pd, pg);
        }

        return mapList;
    }

    public ResultModel listPageRepairTaskDetailByOut (PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentRepairTaskDetailOnOutDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //outId 出库单id
        String outId = pd.getString("outId");
        if (outId == null || outId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库单id为空或空字符串！");
            return model;
        }
        pd.put("outParentId", outId);

        //设置查询排序方式
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.findRepairTaskDetailOnOutDetail(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }
}
