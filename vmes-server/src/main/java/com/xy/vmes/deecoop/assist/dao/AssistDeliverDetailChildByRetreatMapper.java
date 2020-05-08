package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_deliver_detail_child:外协发货明细明细子表 Mapper
 * 外协-退货管理-生成退货单(退料)
 * 创建人：陈刚
 * 创建时间：2020-05-08
 */
@Mapper
@Repository
public interface AssistDeliverDetailChildByRetreatMapper {
    List<Map> findAssistDeliverDetailChildByRetreat(PageData pd, Pagination pg);
    List<Map> findAssistDeliverDetailChildByRetreat(PageData pd);
}
