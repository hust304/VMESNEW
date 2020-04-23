package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.entity.AssistSupplier;
import com.xy.vmes.service.AssistSupplierService;

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

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
* 说明：vmes_assist_supplier:外协供应商Controller
* @author 陈刚 自动生成
* @date 2020-04-23
*/
@RestController
@Slf4j
public class AssistSupplierController {
    private Logger logger = LoggerFactory.getLogger(AssistSupplierController.class);

    @Autowired
    private AssistSupplierService assistSupplierService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-23
    */
    @PostMapping("/assist/assistSupplier/listPageAssistSupplier")
    public ResultModel listPageAssistSupplier() throws Exception {
        logger.info("################/assist/assistSupplier/listPageAssistSupplier 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistSupplierService.listPageAssistSupplier(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSupplier/listPageAssistSupplier 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增外协供应商设定
     * @author 陈刚
     * @date 2020-04-23
     * @throws Exception
     */
    @PostMapping("/assist/assistSupplier/addAssistSupplier")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistSupplier() throws Exception {
        logger.info("################/assist/assistSupplier/addAssistSupplier 执行开始 ################# ");
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

        //supplierId:供应商ID
        String supplierName = pageData.getString("supplierName");
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }

        //assistProductId:外协件ID
        String assistProductName = pageData.getString("assistProductName");
        String assistProductId = pageData.getString("assistProductId");
        if (assistProductId == null || assistProductId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协件id为空或空字符串！");
            return model;
        }

        //price:单价
        BigDecimal price = BigDecimal.valueOf(0D);
        String priceStr = pageData.getString("price");
        if (priceStr != null && priceStr.trim().length() > 0) {
            try {
                price = new BigDecimal(priceStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //四舍五入到2位小数
        price = price.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        //lossRatio:损耗率
        BigDecimal lossRatio = BigDecimal.valueOf(0D);
        String lossRatioStr = pageData.getString("lossRatio");
        if (lossRatioStr != null && lossRatioStr.trim().length() > 0) {
            try {
                lossRatio = new BigDecimal(lossRatioStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //四舍五入到2位小数
        lossRatio = lossRatio.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        //判断(供应商,外协件)--表(vmes_assist_supplier:外协供应商) 是否存在
        if (assistSupplierService.isExistAssistSupplier(null, companyID, supplierId, assistProductId)) {
            String msgTemp = "供应商:{0} 外协件:{1} 在系统中已经存在，请重新选择！";
            String msgStr = MessageFormat.format(msgTemp,
                    supplierName,
                    assistProductName);

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        AssistSupplier addSupplier = new AssistSupplier();
        addSupplier.setCuser(cuser);
        addSupplier.setCompanyId(companyID);

        addSupplier.setSupplierId(supplierId);
        addSupplier.setAssistProductId(assistProductId);

        addSupplier.setPrice(price);
        addSupplier.setLossRatio(lossRatio);

        assistSupplierService.save(addSupplier);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSupplier/addAssistSupplier 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除外协供应商设定
     * @author 陈刚
     * @date 2020-04-23
     * @throws Exception
     */
    @PostMapping("/assist/assistSupplier/deleteAssistSupplier")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistSupplier() throws Exception {
        logger.info("################/assist/assistSupplier/deleteAssistSupplier 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协供应商设定id为空或空字符串！");
            return model;
        }

        assistSupplierService.deleteById(id);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSupplier/deleteAssistSupplier 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协供应商设定
     * @author 陈刚
     * @date 2020-04-23
     * @throws Exception
     */
    @PostMapping("/assist/assistSupplier/updateAssistSupplier")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistSupplier() throws Exception {
        logger.info("################/assist/assistSupplier/updateAssistSupplier 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String id = pageData.getString("id");
        if (id == null || id.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协供应商设定id为空或空字符串！");
            return model;
        }

        //supplierId:供应商ID
        String supplierName = pageData.getString("supplierName");
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }

        //assistProductId:外协件ID
        String assistProductName = pageData.getString("assistProductName");
        String assistProductId = pageData.getString("assistProductId");
        if (assistProductId == null || assistProductId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协件id为空或空字符串！");
            return model;
        }

        //price:单价
        BigDecimal price = BigDecimal.valueOf(0D);
        String priceStr = pageData.getString("price");
        if (priceStr != null && priceStr.trim().length() > 0) {
            try {
                price = new BigDecimal(priceStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //四舍五入到4位小数
        price = price.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        //lossRatio:损耗率
        BigDecimal lossRatio = BigDecimal.valueOf(0D);
        String lossRatioStr = pageData.getString("lossRatio");
        if (lossRatioStr != null && lossRatioStr.trim().length() > 0) {
            try {
                lossRatio = new BigDecimal(lossRatioStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //四舍五入到2位小数
        lossRatio = lossRatio.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        String companyID = pageData.getString("currentCompanyId");
        if (assistSupplierService.isExistAssistSupplier(id, companyID, supplierId, assistProductId)) {
            String msgTemp = "供应商:{0} 外协件:{1} 在系统中已经存在，请重新选择！";
            String msgStr = MessageFormat.format(msgTemp,
                    supplierName,
                    assistProductName);

            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        AssistSupplier editSupplier = new AssistSupplier();
        editSupplier.setId(id);
        editSupplier.setSupplierId(supplierId);
        editSupplier.setAssistProductId(assistProductId);

        editSupplier.setPrice(price);
        editSupplier.setLossRatio(lossRatio);
        assistSupplierService.update(editSupplier);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSupplier/updateAssistSupplier 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协供应商设定(禁用)状态
     *
     * @author 陈刚
     * @date 2020-04-23
     */
    @PostMapping("/assist/assistSupplier/updateDisableAssistSupplier")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableAssistSupplier() throws Exception {
        logger.info("################/assist/assistSupplier/updateDisableAssistSupplier 执行开始 ################# ");
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

        AssistSupplier editSupplier = new AssistSupplier();
        editSupplier.setId(id);
        editSupplier.setIsdisable(isdisable);
        assistSupplierService.update(editSupplier);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSupplier/updateDisableAssistSupplier 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}



