package com.xy.vmes.deecoop.equipment.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.equipment.dao.EquipmentRepairTaskOutDetailMapper;
import com.xy.vmes.service.EquipmentRepairTaskOutDetailService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class EquipmentRepairTaskOutDetailServiceImp implements EquipmentRepairTaskOutDetailService {
    @Autowired
    private EquipmentRepairTaskOutDetailMapper repairTaskOutDetailMapper;

    public List<Map> findTaskDetailByOutDetail(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return repairTaskOutDetailMapper.findTaskDetailByOutDetail(pd);
        } else if (pg != null) {
            return repairTaskOutDetailMapper.findTaskDetailByOutDetail(pd, pg);
        }

        return mapList;
    }

    /**
     * 获取维修任务货品明细-是否出库执行完成
     * (vmes_equipment_repairTask_detail, vmes_warehouse_out_detail)
     *
     * @param repairTaskId  维修任务id
     *
     * @return
     *   true : 全部出库完成(默认值)
     *   false: 一条或多条出库未完成
     */
    public boolean isAllOutExecuteRepairTaskDetail(String repairTaskId) {
        if (repairTaskId == null || repairTaskId.trim().length() == 0) {return true;}

        List<Map> mapList = null;
        try {
            PageData findMap = new PageData();
            findMap.put("taskId", repairTaskId);
            mapList = this.findTaskDetailByOutDetail(findMap, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mapList == null || mapList.size() == 0) {return true;}

        for (Map objectMap : mapList) {
            //出库单明细状态(0:待派单 1:执行中 2:已完成)
            String outDtlState = (String)objectMap.get("outDtlState");
            if (!"2".equals(outDtlState)) {return false;}
        }

        return true;
    }
}
