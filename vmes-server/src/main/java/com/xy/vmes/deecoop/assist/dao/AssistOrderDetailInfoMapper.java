package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：外协订单明细查询汇总 Mapper.java
 * 外协订单明细(外协件)详情查询
 *
 * 创建人：陈刚
 * 创建时间：2020-05-16
 */
@Mapper
@Repository
public interface AssistOrderDetailInfoMapper {
    List<Map> listAssistOrderDetailInfo(PageData pd);
    List<Map> listAssistOrderDetailInfo(PageData pd, Pagination pg);
}
