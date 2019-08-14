package com.xy.vmes.deecoop.equipment.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.equipment.dao.EquipmentStateMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.EquipmentRepair;
import com.xy.vmes.entity.EquipmentSensor;
import com.xy.vmes.service.EquipmentRepairService;
import com.xy.vmes.service.EquipmentSensorService;
import com.xy.vmes.service.EquipmentStateService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EquipmentStateServiceImp implements EquipmentStateService {
    @Autowired
    private EquipmentStateMapper equipmentStateMapper;
    @Autowired
    private EquipmentSensorService equipmentSensorService;
    @Autowired
    private EquipmentRepairService equipmentRepairService;

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

                // alarmState 设备状态
                valueMap.put("alarmState", "");
                if (object.get("alarmState") != null) {
                    valueMap.put("alarmState", (String)object.get("alarmState"));
                }
                //alarmStateName 设备状态(故障,维修中)
                valueMap.put("alarmStateName", "");
                if (object.get("alarmStateName") != null) {
                    valueMap.put("alarmStateName", (String)object.get("alarmStateName"));
                }

                valueMap.put("alarmId", "");
                if (object.get("alarmId") != null) {
                    valueMap.put("alarmId", (String)object.get("alarmId"));
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

    @Override
    public ResultModel getOutputAndDate(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Map outputNumMap = equipmentStateMapper.getOutputNum(pd);
        Map startDateMap = equipmentStateMapper.getStartDate(pd);
        Map collectDateMap = equipmentStateMapper.getCollectDate(pd);
        if(outputNumMap!=null&&outputNumMap.size()>0){
            model.put("outputNum",outputNumMap.get("outputNum"));
        }
        if(startDateMap!=null&&startDateMap.size()>0){
            model.put("startDate",startDateMap.get("startDate"));
        }
        if(collectDateMap!=null&&collectDateMap.size()>0){
            model.put("collectDate",collectDateMap.get("collectDate"));
        }
        return model;
    }


    @Override
    public ResultModel get24HoursData(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> hoursData = equipmentStateMapper.get24HoursData(pd);
        List<Map> openDate = new ArrayList<Map>();
        List<Map> workDate = new ArrayList<Map>();
        List<Map> alarmDate = new ArrayList<Map>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        if(hoursData!=null){
            String openStartDate = null;
            String openEndDate = null;
            String workStartDate = null;
            String workEndDate = null;
            String alarmStartDate = null;
            String alarmEndDate = null;
            for(int i=0;i<hoursData.size();i++){
                Map dataMap = hoursData.get(i);
                Date cdate = dataMap.get("cdate")!=null?(Date)dataMap.get("cdate"):null;
                String time = dateFormat.format(cdate);
                String isOpen = dataMap.get("A0001")!=null?(String)dataMap.get("A0001"):null;
                String isWork = dataMap.get("A0002")!=null?(String)dataMap.get("A0002"):null;
                String isAlarm = dataMap.get("A0003")!=null?(String)dataMap.get("A0003"):null;
                if("1".equals(isOpen)&&openStartDate==null){
                    openStartDate = time;
                }
                if("0".equals(isOpen)&&openStartDate!=null&&openEndDate==null){
                    openEndDate = time;
                    Map map = new HashMap();
                    map.put("startDate",openStartDate);
                    map.put("endDate",openEndDate);
                    openDate.add(map);
                    openStartDate = null;
                    openEndDate = null;
                }


                if("1".equals(isWork)&&workStartDate==null){
                    workStartDate = time;
                }
                if("0".equals(isWork)&&workStartDate!=null&&workEndDate==null){
                    workEndDate = time;
                    Map map = new HashMap();
                    map.put("startDate",workStartDate);
                    map.put("endDate",workEndDate);
                    workDate.add(map);
                    workStartDate = null;
                    workEndDate = null;
                }



                if("1".equals(isAlarm)&&alarmStartDate==null){
                    alarmStartDate = time;
                }
                if("0".equals(isAlarm)&&alarmStartDate!=null&&alarmEndDate==null){
                    alarmEndDate = time;
                    Map map = new HashMap();
                    map.put("startDate",alarmStartDate);
                    map.put("endDate",alarmEndDate);
                    alarmDate.add(map);
                    alarmStartDate = null;
                    alarmEndDate = null;
                }

                if(i==hoursData.size()-1){
                    if("1".equals(isOpen)&&openStartDate!=null){
                        openEndDate = time;
                        Map map = new HashMap();
                        map.put("startDate",openStartDate);
                        map.put("endDate",openEndDate);
                        openDate.add(map);
                        openStartDate = null;
                        openEndDate = null;
                    }

                    if("1".equals(isWork)&&workStartDate!=null){
                        workEndDate = time;
                        Map map = new HashMap();
                        map.put("startDate",workStartDate);
                        map.put("endDate",workEndDate);
                        workDate.add(map);
                        workStartDate = null;
                        workEndDate = null;
                    }

                    if("1".equals(isAlarm)&&alarmStartDate!=null){
                        alarmEndDate = time;
                        Map map = new HashMap();
                        map.put("startDate",alarmStartDate);
                        map.put("endDate",alarmEndDate);
                        alarmDate.add(map);
                        alarmStartDate = null;
                        alarmEndDate = null;
                    }
                }
            }
        }


        if(alarmDate!=null && alarmDate.size()==0){
            pd.put("queryStr"," cdate >= DATE_FORMAT(NOW(),'%Y-%m-%d') ");
            EquipmentRepair equipmentRepair = equipmentRepairService.findEquipmentRepair(pd);
            if(equipmentRepair!=null){
                String alarmStartDate = dateFormat.format(equipmentRepair.getCdate());
                if(equipmentRepair.getEndTime()!=null){
                    String alarmEndDate = dateFormat.format(equipmentRepair.getEndTime());
                    Map map = new HashMap();
                    map.put("startDate",alarmStartDate);
                    map.put("endDate",alarmEndDate);
                    alarmDate.add(map);
                }else{
                    String alarmEndDate = dateFormat.format(new Date());
                    Map map = new HashMap();
                    map.put("startDate",alarmStartDate);
                    map.put("endDate",alarmEndDate);
                    alarmDate.add(map);
                }
            }
        }


        model.put("openDate",openDate);
        model.put("workDate",workDate);
        model.put("alarmDate",alarmDate);
        return model;
    }

    @Override
    public ResultModel get24HoursDataDetail(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);
        Map result = new HashMap();

        Map titlesAndSQLMap = get24HoursDataTitlesAndSQL(pd);
        String colStr = titlesAndSQLMap.get("colStr")!=null?(String)titlesAndSQLMap.get("colStr"):null;
        pd.put("colStr",colStr);
        if(StringUtils.isEmpty(pd.getString("viewStr"))){
            pd.put("viewStr","( select * from vmes_sensor_source )");
        }
        List<Map> varMapList = equipmentStateMapper.get24HoursDataDetail(pd);

        result.put("hideTitles",null);
        result.put("titles",titlesAndSQLMap.get("titlesList"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    public Map get24HoursDataTitlesAndSQL(PageData pd) throws Exception {
        Map map = new HashMap();
        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        LinkedHashMap titleMap = new LinkedHashMap();
        titleMap.put("cdate","时间");
        titlesList.add(titleMap);
        String colStr = null;
        pd.put("isdisable","1");
        pd.put("orderStr"," target_code asc ");

        List<EquipmentSensor> listSensor = equipmentSensorService.dataList(pd);
        if(listSensor!=null&&listSensor.size()>0){
            for(int i=0;i<listSensor.size();i++){
                EquipmentSensor equipmentSensor = listSensor.get(i);
                titleMap = new LinkedHashMap();
                titleMap.put(equipmentSensor.getTargetCode(),equipmentSensor.getTargetName());
                titlesList.add(titleMap);
                if(colStr==null){
                    colStr = " ,"+equipmentSensor.getTargetFormulaSql() + " " + equipmentSensor.getTargetCode();
                }else {
                    colStr = colStr + "," + equipmentSensor.getTargetFormulaSql() + " " + equipmentSensor.getTargetCode();
                }
            }
        }
        map.put("titlesList",titlesList);
        map.put("colStr",colStr);
        return map;
    }

}
