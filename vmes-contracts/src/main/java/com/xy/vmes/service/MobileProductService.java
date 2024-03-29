package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 库存查询     （接口复用，不发送参数获得公司所有的库存信息；发送参数则进行筛选）
 */
public interface MobileProductService {


    List<Map> findListPageProduct(PageData pd, Pagination pg) throws Exception;


}
