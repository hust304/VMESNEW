package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.AssistOrderDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_order_detail:外协订单明细 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2020-04-24
*/
@Mapper
@Repository
public interface AssistOrderDetailMapper extends BaseMapper<AssistOrderDetail> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void updateToDisableByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    List<AssistOrderDetail> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateStateByDetail(PageData pd);
}


