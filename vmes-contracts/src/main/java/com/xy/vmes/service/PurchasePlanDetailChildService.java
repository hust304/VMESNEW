package com.xy.vmes.service;

import com.xy.vmes.entity.PurchasePlanDetailChild;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_purchase_plan_detail_child:采购计划明细子表 接口类
 * 创建人：陈刚 自动生成
 * 创建时间：2020-03-23
 */
public interface PurchasePlanDetailChildService {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    void save(PurchasePlanDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    void update(PurchasePlanDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    void updateAll(PurchasePlanDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    PurchasePlanDetailChild selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    List<PurchasePlanDetailChild> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    List<PurchasePlanDetailChild> dataList(PageData pd) throws Exception;

    PurchasePlanDetailChild findPlanDetailChild(PageData object) throws Exception;
    PurchasePlanDetailChild findPlanDetailChildById(String id) throws Exception;

    List<PurchasePlanDetailChild> findPlanDetailChildList(PageData object) throws Exception;
    List<PurchasePlanDetailChild> findPlanDetailChildListByPlanId(String planId) throws Exception;
    List<PurchasePlanDetailChild> findPlanDetailChildListByPlanDtlId(String planDtlId) throws Exception;
}
