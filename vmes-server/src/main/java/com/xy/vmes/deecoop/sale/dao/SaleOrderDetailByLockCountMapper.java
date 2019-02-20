package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SaleOrderDetailByLockCountMapper {
    List<Map> findListOrderDetailByLockCount(PageData pd);
    List<Map> findListOrderDetailByLockCount(PageData pd, Pagination pg);
}
