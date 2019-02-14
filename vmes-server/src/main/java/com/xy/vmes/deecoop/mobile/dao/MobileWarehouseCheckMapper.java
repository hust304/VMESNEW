package com.xy.vmes.deecoop.mobile.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：手机端盘点
 * 创建人：房兆琦
 * 创建时间：2018-11-13
 */
@Mapper
@Repository
public interface MobileWarehouseCheckMapper {

    //手机端盘点详情
    List<Map> findWarehouseCheck(PageData pd);

    List<Map> listWarehouseCheckByAduiting(PageData pd, Pagination pg);

    List<Map> findWarehouseCheckById(PageData pd);

    List<Map> listWarehouseCheckByAduited(PageData pd, Pagination pg);
}

