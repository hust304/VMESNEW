package com.xy.vmes.deecoop.equipment.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.equipment.dao.EquipmentMaintainTaskDetailInfoMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.EquipmentMaintainTaskDetailInfoService;
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
 * 说明：vmes_equipment_maintainTask_detail:设备保养任务明细详情 实现类
 * 创建人：陈刚
 * 创建时间：2019-08-05
 */
@Service
@Transactional(readOnly = false)
public class EquipmentMaintainTaskDetailInfoServiceImp implements EquipmentMaintainTaskDetailInfoService {
    @Autowired
    private EquipmentMaintainTaskDetailInfoMapper maintainTaskDetailInfoMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map> findMaintainTaskDetailByInfo(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return maintainTaskDetailInfoMapper.findMaintainTaskDetailByInfo(pd);
        } else if (pg != null) {
            return maintainTaskDetailInfoMapper.findMaintainTaskDetailByInfo(pd, pg);
        }

        return mapList;
    }

    public ResultModel findListMaintainTaskDetailByInfo(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("equipmentMaintainTaskDetailByInfo");
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

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
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

        List<Map> varList = this.findMaintainTaskDetailByInfo(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }
}
