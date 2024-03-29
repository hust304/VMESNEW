package com.xy.vmes.deecoop.produce.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xy.vmes.entity.ProducePlanDetailChild;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 说明：vmes_produce_plan_detail_child:生产计划明细子表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2020-02-28
*/
@Mapper
@Repository
public interface ProducePlanDetailChildMapper extends BaseMapper<ProducePlanDetailChild> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    void updateToDisableByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-28
     */
    List<ProducePlanDetailChild> dataList(PageData pd);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}


