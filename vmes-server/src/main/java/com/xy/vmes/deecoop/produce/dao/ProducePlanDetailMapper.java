package com.xy.vmes.deecoop.produce.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.ProducePlanDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_produce_plan_detail:生产计划明细 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2020-02-27
*/
@Mapper
@Repository
public interface ProducePlanDetailMapper extends BaseMapper<ProducePlanDetail> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    void updateToDisableByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    List<ProducePlanDetail> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2020-02-27
     */
    void updateStateByDetail(PageData pd);

    List<Map> getMaterialRequisition(PageData pd, Pagination pg);

    List<Map> getMaterialRequisitionGroup(PageData pd, Pagination pg);
}


