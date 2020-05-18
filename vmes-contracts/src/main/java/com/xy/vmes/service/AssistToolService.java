package com.xy.vmes.service;

/**
 * 说明：外协件模块根据类
 * 创建人：陈刚
 * 创建时间：2020-05-18
 */
public interface AssistToolService {

    /**
     * 验证(外协件id) 是否允许删除
     * @param assistProductId  外协件id
     * @return
     */
    String checkDeleteAssistProduct(String assistProductId) throws Exception;
}
