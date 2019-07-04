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
}
