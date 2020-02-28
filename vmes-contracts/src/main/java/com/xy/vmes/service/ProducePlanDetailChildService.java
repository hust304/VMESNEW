package com.xy.vmes.service;

import com.xy.vmes.entity.ProducePlanDetailChild;
import com.yvan.PageData;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_produce_plan_detail_child:生产计划明细子表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-02-28
*/
public interface ProducePlanDetailChildService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    void save(ProducePlanDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    void update(ProducePlanDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    void updateAll(ProducePlanDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    ProducePlanDetailChild selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    List<ProducePlanDetailChild> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    List<ProducePlanDetailChild> dataList(PageData pd) throws Exception;

    ProducePlanDetailChild findPlanDetailChild(PageData object) throws Exception;
    ProducePlanDetailChild findPlanDetailChildById(String id) throws Exception;

    List<ProducePlanDetailChild> findPlanDetailChildList(PageData object) throws Exception;
    List<ProducePlanDetailChild> findPlanDetailChildListByPlanId(String planId) throws Exception;
    List<ProducePlanDetailChild> findPlanDetailChildListByPlanDtlId(String planDtlId) throws Exception;
}



