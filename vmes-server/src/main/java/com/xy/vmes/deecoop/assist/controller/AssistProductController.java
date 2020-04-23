package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.entity.AssistProduct;
import com.xy.vmes.entity.AssistProductDetail;
import com.xy.vmes.service.AssistProductDetailService;
import com.xy.vmes.service.AssistProductService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* 说明：vmes_assist_product:外协件Controller
* @author 陈刚 自动生成
* @date 2020-04-19
*/
@RestController
@Slf4j
public class AssistProductController {
    private Logger logger = LoggerFactory.getLogger(AssistProductController.class);

    @Autowired
    private AssistProductService assistProductService;
    @Autowired
    private AssistProductDetailService assistProductDetailService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-19
    */
    @PostMapping("/assist/assistProduct/listPageAssistProduct")
    public ResultModel listPageAssistProduct() throws Exception {
        logger.info("################/assist/assistProduct/listPageAssistProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistProductService.listPageAssistProduct(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistProduct/listPageAssistProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * 新增外协件
     * @author 陈刚
     * @date 2020-04-19
     * @throws Exception
     */
    @PostMapping("/assist/assistProduct/addAssistProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistProduct() throws Exception {
        logger.info("################/assist/assistProduct/addAssistProduct 执行开始 ################# ");
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
        String assistProductId = pageData.getString("assistProductId");
        if (assistProductId == null || assistProductId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协件为必填项不可为空！");
            return model;
        }

        String craftId = pageData.getString("craftId");
        if (craftId == null || craftId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("工艺名称为必填项不可为空！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //1. 添加外协件
        AssistProduct addProduct = new AssistProduct();
        addProduct.setCuser(cuser);
        addProduct.setCompanyId(companyID);
        addProduct.setProductId(assistProductId);
        addProduct.setCraftId(craftId);
        assistProductService.save(addProduct);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //遍历 jsonMapList 添加生产计划明细
        if (jsonMapList != null && jsonMapList.size() > 0) {
            for (Map<String, String> mapObject : jsonMapList) {
                AssistProductDetail addProductDtl = new AssistProductDetail();
                addProductDtl.setParentId(addProduct.getId());
                addProductDtl.setCuser(addProduct.getCuser());

                String productId = mapObject.get("productId");
                addProductDtl.setProductId(productId);
                String unitId = mapObject.get("unitId");
                addProductDtl.setUnitId(unitId);

                //ratio:用料比例
                BigDecimal ratio = BigDecimal.valueOf(0D);
                String ratioStr = mapObject.get("ratio");
                if (ratioStr != null && ratioStr.trim().length() > 0) {
                    try {
                        ratio = new BigDecimal(ratioStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                ratio = ratio.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addProductDtl.setRatio(ratio);

                assistProductDetailService.save(addProductDtl);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistProduct/addAssistProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协件
     * @author 陈刚
     * @date 2020-04-19
     * @throws Exception
     */
    @PostMapping("/assist/assistProduct/updateAssistProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistProduct() throws Exception {
        logger.info("################/assist/assistProduct/updateAssistProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //String cuser = pageData.getString("cuser");
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协件id为空或空字符串！");
            return model;
        }
        String assistProductId = pageData.getString("assistProductId");
        if (assistProductId == null || assistProductId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协件为必填项不可为空！");
            return model;
        }

        String craftId = pageData.getString("craftId");
        if (craftId == null || craftId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("工艺名称为必填项不可为空！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //1. 修改外协件
        AssistProduct editProduct = new AssistProduct();
        editProduct.setId(parentId);

        editProduct.setProductId(assistProductId);
        editProduct.setCraftId(craftId);
        assistProductService.update(editProduct);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //外协件原材料明细修改: 先删除后添加方式
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        assistProductDetailService.deleteByColumnMap(columnMap);

        if (jsonMapList != null && jsonMapList.size() > 0) {
            for (Map<String, String> mapObject : jsonMapList) {
                AssistProductDetail addProductDtl = new AssistProductDetail();
                addProductDtl.setParentId(editProduct.getId());
                addProductDtl.setCuser(editProduct.getCuser());

                String productId = mapObject.get("productId");
                addProductDtl.setProductId(productId);
                String unitId = mapObject.get("unitId");
                addProductDtl.setUnitId(unitId);

                //ratio:用料比例
                BigDecimal ratio = BigDecimal.valueOf(0D);
                String ratioStr = mapObject.get("ratio");
                if (ratioStr != null && ratioStr.trim().length() > 0) {
                    try {
                        ratio = new BigDecimal(ratioStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                ratio = ratio.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addProductDtl.setRatio(ratio);

                assistProductDetailService.save(addProductDtl);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistProduct/updateAssistProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除外协件
     * @author 陈刚
     * @date 2020-04-19
     * @throws Exception
     */
    @PostMapping("/assist/assistProduct/deleteAssistProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistProduct() throws Exception {
        logger.info("################/assist/assistProduct/deleteAssistProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协件id为空或空字符串！");
            return model;
        }

        //删除 外协件原材料
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        assistProductDetailService.deleteByColumnMap(columnMap);

        //删除外协件
        assistProductService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistProduct/deleteAssistProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协件(禁用)状态
     *
     * @author 陈刚
     * @date 2020-04-19
     */
    @PostMapping("/assist/assistProduct/updateDisableAssistProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableAssistProduct() throws Exception {
        logger.info("################/assist/assistProduct/updateDisableAssistProduct 执行开始 ################# ");
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

        AssistProduct editProduct = new AssistProduct();
        editProduct.setId(id);
        editProduct.setIsdisable(isdisable);
        assistProductService.update(editProduct);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistProduct/updateDisableAssistProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



