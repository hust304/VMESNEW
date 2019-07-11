package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.deecoop.equipment.dao.EquipmentStateMapper;
import com.xy.vmes.service.EquipmentStateService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentStateServiceImp implements EquipmentStateService {
    @Autowired
    private EquipmentStateMapper equipmentStateMapper;

    //获取设备信息状态综合查询
    public ResultModel findEquipmentState(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        String companyId = pd.getString("currentCompanyId");
        String equipmentId = pd.getString("equipmentId");

        List<Map> mapList = new ArrayList<Map>();
        try {
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("equipmentId", equipmentId);
            mapList = equipmentStateMapper.findEquipmentState(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.put("EquipmentState", mapList);
        return model;
    }
}
