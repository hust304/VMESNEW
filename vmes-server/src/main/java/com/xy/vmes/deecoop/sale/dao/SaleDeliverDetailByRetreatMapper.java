package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SaleDeliverDetailByRetreatMapper {

    List<Map> findDeliverDetailByRetreat(PageData pageData);
    List<Map> findDeliverDetailByRetreat(PageData pageData, Pagination pg);
}
