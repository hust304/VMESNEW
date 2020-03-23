package com.xy.vmes.deecoop.purchase.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xy.vmes.entity.PurchasePlanDetailChild;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 说明：vmes_purchase_plan_detail_child:采购计划明细子表 Mapper.java
 * 创建人：陈刚
 * 创建时间：2020-03-23
 */
@Mapper
@Repository
public interface PurchasePlanDetailChildMapper extends BaseMapper<PurchasePlanDetailChild> {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    void updateToDisableByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-23
     */
    List<PurchasePlanDetailChild> dataList(PageData pd);
}
