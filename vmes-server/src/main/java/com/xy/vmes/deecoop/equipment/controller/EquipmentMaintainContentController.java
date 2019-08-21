package com.xy.vmes.deecoop.equipment.controller;

import com.xy.vmes.entity.EquipmentMaintainContent;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.EquipmentMaintainContentService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* 说明：vmes_equipment_maintain_content:设备保养内容Controller
* @author 陈刚 自动生成
* @date 2019-07-24
*/
@RestController
@Slf4j
public class EquipmentMaintainContentController {

    private Logger logger = LoggerFactory.getLogger(EquipmentMaintainContentController.class);

    @Autowired
    private EquipmentMaintainContentService maintainContentService;

    @Autowired
    private DepartmentService departmentService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-07-24
    */
    @PostMapping("/equipment/equipmentMaintainContent/listPageMaintainContent")
    public ResultModel listPageMaintainContent() throws Exception {
        logger.info("################/equipment/equipmentMaintainContent/listPageMaintainContent 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();

        //id: id,
        String id = pd.getString("id");

        //layer: layer,
        Integer layer = null;
        String layerStr = pd.getString("layer");
        if (layerStr != null && layerStr.trim().length() > 0) {
            try {
                layer = Integer.valueOf(layerStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //type: ("dept" 部门 "eqpt" 设备)
        String type = pd.getString("type");
        if ("dept".equals(type) && id != null && id.trim().length() > 0) {
            String queryIdStr = departmentService.findDeptidById(id, layer, "department.");
            pd.put("deptEqptQueryStr", queryIdStr);
        } else if ("eqpt".equals(type) && id != null && id.trim().length() > 0) {
            pd.put("equipmentId", id);
        }

        ResultModel model = maintainContentService.listPageEquipmentMaintainContent(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainContent/listPageMaintainContent 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取下拉控件-设备保养内容
     * @author 陈刚
     * @date 2019-07-24
     */
    @PostMapping("/equipment/equipmentMaintainContent/selectListMaintainContent")
    public ResultModel selectListMaintainContent() throws Exception {
        logger.info("################/equipment/equipmentMaintainContent/selectListMaintainContent 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String equipmentId = pd.getString("equipmentId");
        if (equipmentId == null || equipmentId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("设备id为空或空字符串！");
            return model;
        }

        List<EquipmentMaintainContent> objectList = new ArrayList<>();
        try {
            PageData findMap = new PageData();
            findMap.put("equipmentId", equipmentId);
            //isdisable 是否启用(0:已禁用 1:启用)
            findMap.put("isdisable", "1");
            objectList = maintainContentService.findMaintainContentList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<HashMap<String, String>> selectList = new ArrayList<>();
        if (objectList != null && objectList.size() > 0) {
            for (EquipmentMaintainContent object : objectList) {
                HashMap<String, String> mapObject = new HashMap<>();
                String id = object.getId();
                String content = object.getContent();
                if (content != null && content.trim().length() > 0) {
                    //{id:'1', label:'用户1'}
                    mapObject.put("id", id);
                    mapObject.put("label", content.trim());
                }
                selectList.add(mapObject);
            }
        }

        model.put("options", selectList);
        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainContent/selectListMaintainContent 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增-设备保养内容
     * @author 陈刚
     * @date 2019-07-24
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainContent/addMaintainContent")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addMaintainContent() throws Exception {
        logger.info("################/equipment/equipmentMaintainContent/addMaintainContent 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String equipmentId = pageData.getString("equipmentId");
        if (equipmentId == null || equipmentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备id为空或空字符串！");
            return model;
        }

        //content 保养内容
        String content = pageData.getString("content");
        if (content == null || content.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养内容为空或空字符串！");
            return model;
        }

        //remark 备注
        String remark = pageData.getString("remark");
        String cuser = pageData.getString("cuser");

        EquipmentMaintainContent addContent = new EquipmentMaintainContent();
        addContent.setEquipmentId(equipmentId);
        addContent.setCompanyId(companyId);
        addContent.setContent(content);
        if (remark != null && remark.trim().length() > 0) {
            addContent.setRemark(remark.trim());
        }
        addContent.setCuser(cuser);
        maintainContentService.save(addContent);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainContent/addMaintainContent 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改-设备保养内容
     * @author 陈刚
     * @date 2019-07-24
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainContent/updateMaintainContent")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateMaintainContent() throws Exception {
        logger.info("################/equipment/equipmentMaintainContent/updateMaintainContent 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备保养内容id为空或空字符串！");
            return model;
        }

        //content 保养内容
        String content = pageData.getString("content");
        if (content == null || content.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("保养内容为空或空字符串！");
            return model;
        }

        //remark 备注
        String remark_edit = new String();
        if (pageData.getString("remark") != null) {
            remark_edit = pageData.getString("remark").trim();
        }

        EquipmentMaintainContent editContent = new EquipmentMaintainContent();
        editContent.setId(id);
        editContent.setContent(content);
        editContent.setRemark(remark_edit);
        maintainContentService.update(editContent);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainContent/updateMaintainContent 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 逻辑删除-设备保养内容
     * 修改-设备保养内容(是否禁用状态)-(禁用)
     *
     * @author 陈刚
     * @date 2019-07-24
     * @throws Exception
     */
    @PostMapping("/equipment/equipmentMaintainContent/updateDisableMaintainContent")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableMaintainContent() throws Exception {
        logger.info("################/equipment/equipmentMaintainContent/updateDisableMaintainContent 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("设备保养内容id为空或空字符串！");
            return model;
        }

        EquipmentMaintainContent editContent = new EquipmentMaintainContent();
        editContent.setId(id);
        //是否启用(0:已禁用 1:启用)
        editContent.setIsdisable("0");
        maintainContentService.update(editContent);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/equipmentMaintainContent/updateDisableMaintainContent 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}



