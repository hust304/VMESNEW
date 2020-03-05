package com.xy.vmes.service;

import com.xy.vmes.entity.ProducePlanQualityDetail;
import com.yvan.PageData;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_produce_plan_quality_detail:生产计划明细检验报工表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-03-03
*/
public interface ProducePlanQualityDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    void save(ProducePlanQualityDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    void update(ProducePlanQualityDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    void updateAll(ProducePlanQualityDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    ProducePlanQualityDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    List<ProducePlanQualityDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    List<ProducePlanQualityDetail> dataList(PageData pd) throws Exception;

    ProducePlanQualityDetail findPlanQualityDetail(PageData object) throws Exception;
    ProducePlanQualityDetail findPlanQualityDetailById(String id) throws Exception;

    List<ProducePlanQualityDetail> findPlanQualityDetailList(PageData object) throws Exception;
    List<ProducePlanQualityDetail> findPlanQualityDetailListByPlanId(String planId) throws Exception;
    List<ProducePlanQualityDetail> findPlanQualityDetailListByPlanDtlId(String planDtlId) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 返回货品入库Map
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param detailList
     * @return
     */
    Map<String, Map<String, Object>> findProductMapByIn(List<ProducePlanQualityDetail> detailList);
}



