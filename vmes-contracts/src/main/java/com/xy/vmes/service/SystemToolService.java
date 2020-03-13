package com.xy.vmes.service;

import java.util.Map;

/**
 * 说明：系统工具 接口类
 * 创建人：陈刚
 * 创建时间：2020-03-13
 */
public interface SystemToolService {
    /**
     * 模块主页页面查询调用
     * 获取货品详情字符串(货品编码,货品名称,规格型号,货品自定义属性)
     *
     * @param columnKey  业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
     * @param mapObject  查询结果集行数据Map<String, Object>
     * @return
     */
    String findProductInfo(String columnKey, Map<String, Object> mapObject);
}
