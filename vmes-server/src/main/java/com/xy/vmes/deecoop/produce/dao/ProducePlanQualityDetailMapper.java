package com.xy.vmes.deecoop.produce.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xy.vmes.entity.ProducePlanQualityDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 说明：vmes_produce_plan_quality_detail:生产计划明细检验报工表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2020-03-03
*/
@Mapper
@Repository
public interface ProducePlanQualityDetailMapper extends BaseMapper<ProducePlanQualityDetail> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    void updateToDisableByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    List<ProducePlanQualityDetail> dataList(PageData pd);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}


