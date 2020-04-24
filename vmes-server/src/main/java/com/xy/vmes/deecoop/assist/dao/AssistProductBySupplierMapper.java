package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_assist_product:外协件关联查询 vmes_assist_supplier:外协供应商 Mapper.java
 * 创建人：陈刚 自动创建
 * 创建时间：2020-04-19
 */
@Mapper
@Repository
public interface AssistProductBySupplierMapper {

    List<Map> listAssistProductBySupplier(PageData pd, Pagination pg);
    List<Map> listAssistProductBySupplier(PageData pd);
}
