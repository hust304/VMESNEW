package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.entity.AssistCraft;
import com.xy.vmes.service.AssistCraftService;

import com.xy.vmes.service.CoderuleService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_craft:工艺名称Controller
* @author 陈刚 自动生成
* @date 2020-04-19
*/
@RestController
@Slf4j
public class AssistCraftController {
    private Logger logger = LoggerFactory.getLogger(AssistCraftController.class);

    @Autowired
    private AssistCraftService assistCraftService;
    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-19
    */
    @PostMapping("/assist/assistCraft/listPageAssistCraft")
    public ResultModel listPageAssistCraft() throws Exception {
        logger.info("################/assist/assistCraft/listPageAssistCraft 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistCraftService.listPageAssistCraft(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistCraft/listPageAssistCraft 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增外协工艺名称
     * @author 陈刚
     * @date 2020-04-19
     * @throws Exception
     */
    @PostMapping("/assist/assistCraft/addAssistCraft")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistCraft() throws Exception {
        logger.info("################/assist/assistCraft/addAssistCraft 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String companyID = pageData.getString("currentCompanyId");
        if (companyID == null || companyID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //name 工艺名称
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("工艺名称为必填项不可为空！");
            return model;
        }

        String remark = new String();
        if (pageData.getString("remark") != null) {
            remark = pageData.getString("remark").trim();
        }

        //生产明细-产品计划号
        String sysCode = coderuleService.createCoderCdateOnShortYearByDate(companyID,
                "vmes_assist_craft",
                "AC",
                Common.CODE_RULE_LENGTH_SHORTYEAR);

        AssistCraft addCraft = new AssistCraft();
        addCraft.setCuser(cuser);
        addCraft.setCompanyId(companyID);

        addCraft.setName(name);
        addCraft.setRemark(remark);
        addCraft.setSysCode(sysCode);

        assistCraftService.save(addCraft);

        model.set("Craft", addCraft);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistCraft/addAssistCraft 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除外协工艺名称
     * @author 陈刚
     * @date 2020-04-19
     * @throws Exception
     */
    @PostMapping("/assist/assistCraft/deleteAssistCraft")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistCraft() throws Exception {
        logger.info("################/assist/assistCraft/deleteAssistCraft 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协工艺名称id为空或空字符串！");
            return model;
        }

        assistCraftService.deleteById(id);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistCraft/deleteAssistCraft 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协工艺名称
     * @author 陈刚
     * @date 2020-04-19
     * @throws Exception
     */
    @PostMapping("/assist/assistCraft/updateAssistCraft")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistCraft() throws Exception {
        logger.info("################/assist/assistCraft/updateAssistCraft 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协工艺名称id为空或空字符串！");
            return model;
        }

        //name 工艺名称
        String name = pageData.getString("name");
        if (name == null || name.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("工艺名称为必填项不可为空！");
            return model;
        }

        String remark = new String();
        if (pageData.getString("remark") != null) {
            remark = pageData.getString("remark").trim();
        }

        AssistCraft editCraft = new AssistCraft();
        editCraft.setId(id);
        editCraft.setName(name);
        editCraft.setRemark(remark);
        assistCraftService.update(editCraft);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistCraft/updateAssistCraft 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协工艺名称(禁用)状态
     *
     * @author 陈刚
     * @date 2020-04-19
     */
    @PostMapping("/assist/assistCraft/updateDisableAssistCraft")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableAssistCraft() throws Exception {
        logger.info("################/assist/assistCraft/updateDisableAssistCraft 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        //是否启用(0:已禁用 1:启用)
        String isdisable = pageData.getString("isdisable");

        //1. 非空判断
        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "工艺名称id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        AssistCraft editCraft = new AssistCraft();
        editCraft.setId(id);
        editCraft.setIsdisable(isdisable);
        assistCraftService.update(editCraft);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistCraft/updateDisableAssistCraft 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



