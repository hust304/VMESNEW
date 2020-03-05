package com.xy.vmes.service;

import java.util.Map;

public interface ProducePlanDetailToolService {

    /**
     * 获取(生产明细id,计划数量,合格数量,不合格数量)Map<String, Map<String, Object>>结构体
     * 按(生产明细id)字段汇总查询
     * 查询条件:按(生产计划id)
     *
     * Map<生产明细id, 生产明细Map<String, Object>>
     * 生产明细Map<String, Object>
     *     dtlId: 生产明细id
     *     dtlCount: 计划数量
     *     fineCount: 合格数量
     *     badCount: 不合格数量
     *
     * @param planId  生产计划id
     * @return
     */
    Map<String, Map<String, Object>> findProducePlanDetailMap(String planId);
}
