package com.xy.vmes.deecoop.equipment.controller;

import com.yvan.common.util.Common;
import com.xy.vmes.entity.EquipmentSensor;
import com.xy.vmes.service.EquipmentSensorFormulaService;
import com.xy.vmes.service.EquipmentSensorService;

import com.xy.vmes.service.EquipmentSensorTargetService;
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
import java.util.LinkedHashMap;
import java.util.List;

/**
* 说明：vmes_equipment_sensor:设备传感器指标(设备联网)Controller
* @author 陈刚 自动生成
* @date 2019-06-19
*/
@RestController
@Slf4j
public class EquipmentSensorController {
    private Logger logger = LoggerFactory.getLogger(EquipmentSensorController.class);

    @Autowired
    private EquipmentSensorService equipmentSensorService;
    @Autowired
    private EquipmentSensorTargetService equipmentSensorTargetService;
    @Autowired
    private EquipmentSensorFormulaService equipmentSensorFormulaService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-06-19
    */
    @PostMapping("/equipment/equipmentSensor/listPageEquipmentSensor")
    public ResultModel listPageEquipmentSensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/listPageEquipmentSensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentSensorService.listPageEquipmentSensor(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/listPageEquipmentSensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/equipment/equipmentSensor/findAllEquipmentBySensor")
    public ResultModel findAllEquipmentBySensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/findAllEquipmentBySensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentSensorService.findAllEquipmentBySensor(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/findAllEquipmentBySensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //获取设备全部传感器指标-公式编辑器调用
    @PostMapping("/equipment/equipmentSensor/findListEquipmentSensorByEquipment")
    public ResultModel findEquipmentSensorByEquipment() throws Exception {
        logger.info("################/equipment/equipmentSensor/findListEquipmentSensorByEquipment 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = equipmentSensorService.findListEquipmentSensorByEquipment(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/findListEquipmentSensorByEquipment 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增-设备传感器指标
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentSensor/addEquipmentSensor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addEquipmentSensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/addEquipmentSensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();
        EquipmentSensor eqptSensor = (EquipmentSensor) HttpUtils.pageData2Entity(pageData, new EquipmentSensor());

        //非空判断
        String msgStr = equipmentSensorService.checkColumnByEdit(eqptSensor);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //该设备下-指标名称是否相同
        if (equipmentSensorService.isExistByName(null, eqptSensor.getEquipmentId(), eqptSensor.getTargetName())) {
            String msgTemp = "该指标名称: {0} 在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String str_isnull = MessageFormat.format(msgTemp, eqptSensor.getTargetName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        //1. 获取全部传感器指标编码
        //指标编码前缀 := 指标类型(A:传感器指标 B:分析指标)
        LinkedHashMap<String, String> allCodeMap = equipmentSensorTargetService.findAllTargetCodeMap(
                Common.SYS_EQUIPMENT_SENSORTARGET_TARGETCODE_MAXCOUNT,
                Common.SYS_EQUIPMENT_SENSORTARGET_TARGETCODE_MAXDIGIT,
                eqptSensor.getTargetType());

        PageData findMap = new PageData();
        findMap.put("equipmentId", eqptSensor.getEquipmentId());
        findMap.put("targetType", eqptSensor.getTargetType());
        findMap = equipmentSensorService.setupSqlOrder("target_code asc", findMap);
        List<EquipmentSensor> eqptList = equipmentSensorService.findEquipmentSensorList(findMap);
        LinkedHashMap<String, String> applyCodeMap = equipmentSensorService.findTargetCodeMap(eqptList);

        //获取一个新的(未使用)的指标编码
        String targetCode = equipmentSensorTargetService.findNewTargetCode(allCodeMap, applyCodeMap);
        if (targetCode == null || targetCode.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备id" + eqptSensor.getEquipmentId() + " 获取(未使用)的指标编码失败，请与管理员联系！");
            return model;
        }
        eqptSensor.setTargetCode(targetCode);

        //2. targetType指标类型 := B:分析指标 [公式转换:=sql查询可以直接使用]
        // targetType指标类型(A:传感器指标 B:分析指标)
        if ("B".equals(eqptSensor.getTargetType())) {
//            String targetFormulaColumn = equipmentSensorFormulaService.formula2TargetFormulaColumn(
//                    eqptSensor.getEquipmentId(),
//                    eqptSensor.getTargetType(),
//                    eqptSensor.getTargetFormula());
            eqptSensor.setTargetFormula(eqptSensor.getTargetFormula());
            eqptSensor.setTargetFormulaSql(eqptSensor.getTargetFormulaSql());
            eqptSensor.setTargetFormulaDisplay(eqptSensor.getTargetFormulaDisplay());
        } else if ("A".equals(eqptSensor.getTargetType())) {
            eqptSensor.setTargetFormula(null);
            eqptSensor.setTargetFormulaSql(eqptSensor.getTargetCode());
            eqptSensor.setTargetFormulaDisplay(null);
        }

        //获取企业id
        String companyID = pageData.getString("currentCompanyId");
        eqptSensor.setCompanyId(companyID);

        equipmentSensorService.save(eqptSensor);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/addEquipmentSensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * 新增-设备传感器指标
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentSensor/addStandardEquipmentSensor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addStandardEquipmentSensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/addEquipmentSensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();
        String companyID = pageData.getString("currentCompanyId");
        String equipmentId = pageData.getString("equipmentId");
        String currentUserId = pageData.getString("currentUserId");

        EquipmentSensor eqptSensor = new EquipmentSensor();
        eqptSensor.setTargetType("O");
        eqptSensor.setTargetCode("A0001");
        eqptSensor.setTargetName("是否开机");
        eqptSensor.setTargetFormulaSql("A0001");
        eqptSensor.setRemark("0：否 1：是");
        eqptSensor.setEquipmentId(equipmentId);
        eqptSensor.setCompanyId(companyID);
        eqptSensor.setCuser(currentUserId);
        eqptSensor.setUuser(currentUserId);
        equipmentSensorService.save(eqptSensor);

        eqptSensor = new EquipmentSensor();
        eqptSensor.setTargetType("O");
        eqptSensor.setTargetCode("A0002");
        eqptSensor.setTargetName("是否工作");
        eqptSensor.setTargetFormulaSql("A0002");
        eqptSensor.setRemark("0：否 1：是");
        eqptSensor.setEquipmentId(equipmentId);
        eqptSensor.setCompanyId(companyID);
        eqptSensor.setCuser(currentUserId);
        eqptSensor.setUuser(currentUserId);
        equipmentSensorService.save(eqptSensor);


        eqptSensor = new EquipmentSensor();
        eqptSensor.setTargetType("O");
        eqptSensor.setTargetCode("A0003");
        eqptSensor.setTargetName("是否故障");
        eqptSensor.setTargetFormulaSql("A0003");
        eqptSensor.setRemark("0：否 1：是");
        eqptSensor.setEquipmentId(equipmentId);
        eqptSensor.setCompanyId(companyID);
        eqptSensor.setCuser(currentUserId);
        eqptSensor.setUuser(currentUserId);
        equipmentSensorService.save(eqptSensor);


        eqptSensor = new EquipmentSensor();
        eqptSensor.setTargetType("O");
        eqptSensor.setTargetCode("A0004");
        eqptSensor.setTargetName("生产计数");
        eqptSensor.setTargetFormulaSql("A0004");
        eqptSensor.setRemark(null);
        eqptSensor.setEquipmentId(equipmentId);
        eqptSensor.setCompanyId(companyID);
        eqptSensor.setCuser(currentUserId);
        eqptSensor.setUuser(currentUserId);
        equipmentSensorService.save(eqptSensor);



        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/addEquipmentSensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 删除-设备传感器指标
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentSensor/deleteEquipmentSensor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteEquipmentSensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/deleteEquipmentSensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备传感器指标id为空或空字符串！");
            return model;
        }

        EquipmentSensor equipmentSensor = equipmentSensorService.selectById(id);
        pageData = new PageData();
        pageData.put("queryStr"," target_formula like '%"+equipmentSensor.getTargetCode()+"%' and equipment_id = '"+equipmentSensor.getEquipmentId()+"' ");

        List<EquipmentSensor> equipmentSensorList = equipmentSensorService.dataList(pageData);
        if(equipmentSensorList!=null&&equipmentSensorList.size()>0){
            String equipmentSensorNames = null;
            for(int i=0;i<equipmentSensorList.size();i++){
                EquipmentSensor obj = equipmentSensorList.get(i);
                if(equipmentSensorNames==null){
                    equipmentSensorNames = obj.getTargetName();
                }else{
                    equipmentSensorNames = equipmentSensorNames+ "," + obj.getTargetName();
                }
            }

            model.putCode(Integer.valueOf(1));
            model.putMsg("该设备传感器指标已被其他分析指标("+equipmentSensorNames+")引用，不能直接删除，请先删除"+equipmentSensorNames+"！");
            return model;
        }
        equipmentSensorService.deleteById(id);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/deleteEquipmentSensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (按设备)删除-设备传感器指标
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentSensor/deleteEquipmentSensorByEquipment")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteEquipmentSensorByEquipment() throws Exception {
        logger.info("################/equipment/equipmentSensor/deleteEquipmentSensorByEquipment 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String equipmentId = pageData.getString("equipmentId");
        if (equipmentId == null || equipmentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备id为空或空字符串！");
            return model;
        }

        equipmentSensorService.deleteTableByEquipment(pageData);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/deleteEquipmentSensorByEquipment 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改-设备传感器指标
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentSensor/updateEquipmentSensor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateEquipmentSensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/updateEquipmentSensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();
        EquipmentSensor eqptSensor = (EquipmentSensor) HttpUtils.pageData2Entity(pageData, new EquipmentSensor());

        //非空判断
        String msgStr = equipmentSensorService.checkColumnByEdit(eqptSensor);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //该设备下-指标名称是否相同
        if (equipmentSensorService.isExistByName(eqptSensor.getId(), eqptSensor.getEquipmentId(), eqptSensor.getTargetName())) {
            String msgTemp = "该指标名称: {0} 在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String str_isnull = MessageFormat.format(msgTemp, eqptSensor.getTargetName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        EquipmentSensor editObject = new EquipmentSensor();
        editObject.setId(eqptSensor.getId());
        editObject.setTargetName(eqptSensor.getTargetName());
        if (eqptSensor.getRemark() == null || eqptSensor.getRemark().trim().length() == 0) {
            editObject.setRemark("");
        } else {
            editObject.setRemark(eqptSensor.getRemark().trim());
        }

        //2. targetType指标类型 := B:分析指标 [公式转换:=sql查询可以直接使用]
        // targetType指标类型(A:传感器指标 B:分析指标)
        if ("B".equals(eqptSensor.getTargetType())) {
//            String targetFormulaColumn = equipmentSensorFormulaService.formula2TargetFormulaColumn(
//                    eqptSensor.getEquipmentId(),
//                    eqptSensor.getTargetType(),
//                    eqptSensor.getTargetFormula());
            editObject.setTargetFormula(eqptSensor.getTargetFormula());
            editObject.setTargetFormulaSql(eqptSensor.getTargetFormulaSql());
            editObject.setTargetFormulaDisplay(eqptSensor.getTargetFormulaDisplay());
            pageData = new PageData();
            pageData.put("equipmentId",eqptSensor.getEquipmentId());
            pageData.put("targetFormula",eqptSensor.getTargetCode());
            pageData.put("queryStr"," id not in ('"+eqptSensor.getId()+"') ");
            List<EquipmentSensor>  equipmentSensorList = equipmentSensorService.dataList(pageData);
            if(equipmentSensorList!=null&&equipmentSensorList.size()>0){
                for(int i=0;i<equipmentSensorList.size();i++){
                    EquipmentSensor equipmentSensor = equipmentSensorList.get(i);
                    String targetFormula = equipmentSensor.getTargetFormula();
                    String targetFormulaSql = targetFormula.replace(eqptSensor.getTargetCode(),eqptSensor.getTargetFormulaSql());
                    equipmentSensor.setTargetFormulaSql(targetFormulaSql);
                    equipmentSensorService.update(equipmentSensor);
                }
            }

        } else if ("A".equals(eqptSensor.getTargetType())) {
            editObject.setTargetFormula(null);
            editObject.setTargetFormulaSql(eqptSensor.getTargetCode());
            editObject.setTargetFormulaDisplay(null);
        }
        equipmentSensorService.update(editObject);


        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/updateEquipmentSensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改-设备传感器指标(禁用)状态
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentSensor/updateDisableEquipmentSensor")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableEquipmentSensor() throws Exception {
        logger.info("################/equipment/equipmentSensor/updateDisableEquipmentSensor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        String isdisable = pageData.getString("isdisable");

        //非空判断
        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        EquipmentSensor editObject = new EquipmentSensor();
        editObject.setId(id);
        editObject.setIsdisable(isdisable);
        equipmentSensorService.update(editObject);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/updateDisableEquipmentSensor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 修改-设备传感器指标(禁用)状态
     * @author 陈刚
     * @date 2019-10-16
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentSensor/checkEquipmentSensorFormula")
    public ResultModel checkEquipmentSensorFormula() throws Exception {
        logger.info("################/equipment/equipmentSensor/checkEquipmentSensorFormula 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        try {
            equipmentSensorService.checkEquipmentSensorFormula(pd);
        }catch (Exception e){
            model.putCode(Integer.valueOf(1));
            model.putMsg("校验公式逻辑错误，请重新编辑！");
            return model;
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentSensor/checkEquipmentSensorFormula 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}



