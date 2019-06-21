package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.EquipmentSensor;
import com.xy.vmes.service.EquipmentSensorFormulaService;
import com.xy.vmes.service.EquipmentSensorService;
import com.xy.vmes.service.EquipmentSensorTargetService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 说明：设备传感器指标公式转换服务实现类
 * 创建人：陈刚
 * 创建时间：2019-06-19
 */
@Service
public class EquipmentSensorFormulaServiceImp implements EquipmentSensorFormulaService {
    @Autowired
    private EquipmentSensorService equipmentSensorService;
    @Autowired
    private EquipmentSensorTargetService equipmentSensorTargetService;

    /**
     * 公式转换:
     * 公式字符串转换成-栏位名称公式(SQL查询语句直接使用)
     *
     * @param equipmentId    设备id
     * @param targetType     指标类型(A:传感器指标 B:分析指标)
     * @param targetFormula  指标公式
     * @return
     */
    public String formula2TargetFormulaColumn(String equipmentId, String targetType, String targetFormula) {
        String targetFormulaColumn = new String();
        if (targetType == null || targetType.trim().length() == 0) {return targetFormulaColumn;}
        if (targetFormula == null || targetFormula.trim().length() == 0) {return targetFormulaColumn;}

        //1. 根据公式字符串-解析出指标编号Map<指标编号,指标编号>
        LinkedHashMap<String, String> targetCodeMap = this.findTargetCodeMapByFormula(targetType, targetFormula);
        if (targetCodeMap == null || targetCodeMap.size() == 0) {
            targetFormulaColumn = targetFormula;
            return targetFormulaColumn;
        }

        //2.获取设备全部指定传感器指标-转换栏位名称公式Map<指标编号,转换栏位名称公式>
        Map<String, String> targetFormulaMap = this.findTargetFormulaMapByTargetCode(equipmentId, targetCodeMap);
        if (targetFormulaMap == null || targetFormulaMap.size() == 0) {
            targetFormulaColumn = targetFormula;
            return targetFormulaColumn;
        }

        //3. 公式转换
        targetFormulaColumn = new String(targetFormula);
        for (Iterator iterator = targetCodeMap.keySet().iterator(); iterator.hasNext();) {
            String targetCode = (String) iterator.next();
            String targetFormulaColumn_source = targetFormulaMap.get(targetCode);
            if (targetFormulaColumn_source != null && targetFormulaColumn_source.trim().length() > 0) {
                targetFormulaColumn = targetFormulaColumn.replace(targetCode, "(" + targetFormulaColumn_source + ")");
            }
        }

        return targetFormulaColumn;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 根据公式字符串-解析出指标编号Map<指标编号,指标编号>
     *
     * @param targetType     指标类型(A:传感器指标 B:分析指标)
     * @param targetFormula  指标公式
     * @return
     */
    private LinkedHashMap<String, String> findTargetCodeMapByFormula(String targetType, String targetFormula) {
        LinkedHashMap<String, String> targetCodeMap = new LinkedHashMap<String, String>();
        if (targetType == null || targetType.trim().length() == 0) {return targetCodeMap;}
        if (targetFormula == null || targetFormula.trim().length() == 0) {return targetCodeMap;}


        //指标编码前缀 := 指标类型(A:传感器指标 B:分析指标)
        LinkedHashMap<String, String> allCodeMap = equipmentSensorTargetService.findAllTargetCodeMap(
                Common.SYS_EQUIPMENT_SENSORTARGET_TARGETCODE_MAXCOUNT,
                Common.SYS_EQUIPMENT_SENSORTARGET_TARGETCODE_MAXDIGIT,
                targetType.trim());

        for (Iterator iterator = allCodeMap.keySet().iterator(); iterator.hasNext();) {
            String targetCode = (String) iterator.next();
            if (targetFormula.indexOf(targetCode) != -1) {
                targetCodeMap.put(targetCode, targetCode);
            }
        }

        return targetCodeMap;
    }

    /**
     * 获取设备全部指定传感器指标-转换栏位名称公式Map<指标编号,转换栏位名称公式>
     *
     * @param equipmentId    设备id
     * @param targetCodeMap  指标编号Map
     * @return
     */
    private Map<String, String> findTargetFormulaMapByTargetCode(String equipmentId, LinkedHashMap<String, String> targetCodeMap) {
        Map<String, String> targetFormulaMap = new HashMap<String, String>();
        if (equipmentId == null || equipmentId.trim().length() == 0) {return targetFormulaMap;}
        if (targetCodeMap == null || targetCodeMap.size() == 0) {return targetFormulaMap;}

        //1. 获取指标编号字符串-','逗号分隔的字符串
        String targetCodes = equipmentSensorService.findTargetCode(targetCodeMap);
        if (targetCodes == null || targetCodes.trim().length() == 0) {
            return targetFormulaMap;
        }

        targetCodes = StringUtil.stringTrimSpace(targetCodes);
        targetCodes = "'" + targetCodes.replace(",", "','") + "'";

        //2. 查询 vmes_equipment_sensor
        List<EquipmentSensor> eqptList = null;
        try {
            PageData findMap = new PageData();
            findMap.put("equipmentId", equipmentId);
            findMap.put("targetCodes", targetCodes);
            eqptList = equipmentSensorService.findEquipmentSensorList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (eqptList == null || eqptList.size() == 0) {
            return targetFormulaMap;
        }

        //3. 遍历List<EquipmentSensor>
        for (EquipmentSensor object : eqptList) {
            String targetCode = object.getTargetCode();
            String targetFormulaColumn = object.getTargetFormulaColumn();
            if (targetCode != null && targetCode.trim().length() > 0) {
                targetFormulaMap.put(targetCode, targetFormulaColumn);
            }
        }

        return targetFormulaMap;
    }
}
