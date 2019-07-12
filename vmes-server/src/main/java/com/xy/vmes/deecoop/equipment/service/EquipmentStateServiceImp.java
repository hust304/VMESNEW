package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.deecoop.equipment.dao.EquipmentStateMapper;
import com.xy.vmes.service.EquipmentStateService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

        //查询结果集 mapList，系统将is null 的这段给忽略掉了
        List<Map> mapList = new ArrayList<Map>();
        try {
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("equipmentId", equipmentId);
            mapList = equipmentStateMapper.findEquipmentState(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Map<String, String>> valueMapList = new ArrayList<Map<String, String>>();
        if (mapList != null && mapList.size() > 0) {
            for (Map object : mapList) {
                Map<String, String> valueMap = new HashMap<String, String>();
                valueMap.put("id", (String) object.get("id"));
                valueMap.put("code", (String) object.get("code"));
                valueMap.put("name", (String) object.get("name"));
                valueMap.put("spec", (String) object.get("spec"));
                valueMap.put("deptName", (String) object.get("deptName"));

                valueMap.put("photo", "");
                if (object.get("photo") != null) {
                    valueMap.put("photo", (String)object.get("photo"));
                }

                valueMap.put("qrcode", "");
                if (object.get("qrcode") != null) {
                    valueMap.put("qrcode", (String)object.get("qrcode"));
                }

                // equipmentState 设备状态
                valueMap.put("equipmentState", "");
                if (object.get("equipmentState") != null) {
                    valueMap.put("equipmentState", (String)object.get("equipmentState"));
                }
                //equipmentStateName 设备状态(故障,维修中)
                valueMap.put("equipmentStateName", "");
                if (object.get("equipmentStateName") != null) {
                    valueMap.put("equipmentStateName", (String)object.get("equipmentStateName"));
                }

                //isBindSensor 联网状态
                valueMap.put("isBindSensor", "");
                if (object.get("isBindSensor") != null) {
                    valueMap.put("isBindSensor", (String)object.get("isBindSensor"));
                }
                //bindSensorStateName:联网状态(联网设备,非联网),
                valueMap.put("bindSensorStateName", "");
                if (object.get("bindSensorStateName") != null) {
                    valueMap.put("bindSensorStateName", (String)object.get("bindSensorStateName"));
                }

                //equipmentActivity 设备在线状态
                valueMap.put("equipmentActivity", "");
                if (object.get("equipmentActivity") != null) {
                    valueMap.put("equipmentActivity", (String)object.get("equipmentActivity"));
                }

                //equipmentActivityName:在线状态(在线)
                valueMap.put("equipmentActivityName", "");
                if (object.get("equipmentActivityName") != null) {
                    valueMap.put("equipmentActivityName", (String)object.get("equipmentActivityName"));
                }

                valueMapList.add(valueMap);
            }
        }

        model.put("EquipmentState", valueMapList);
        return model;
    }

}
