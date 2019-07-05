package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface WarehouseProductByCollectMapper {
    List<Map<String, Object>> findProductMapList(PageData pd);
    List<Map<String, Object>> findProductMapList(PageData pd, Pagination pg);

    //获取仓库货品信息(虚拟库)-根据(货品id)汇总
    List<Map> findProductByVirtual(PageData pd);
    List<Map> findProductByVirtual(PageData pd, Pagination pg);

}
