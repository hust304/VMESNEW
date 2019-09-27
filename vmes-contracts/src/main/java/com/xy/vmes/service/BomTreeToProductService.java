package com.xy.vmes.service;

import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：BomTree表关联货品表 接口类
 * 创建人：陈刚
 * 创建时间：2019-09-27
 */
public interface BomTreeToProductService {
    List<Map> findBomTreeProductList(PageData pd) throws Exception;
}
