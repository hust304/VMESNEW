package com.xy.vmes.deecoop.produce.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：生产计划明细(检验)报工查询汇总 Mapper.java
 *
 * 创建人：陈刚
 * 创建时间：2020-03-04
 */
@Mapper
@Repository
public interface ProducePlanDetailByQualityCollectMapper {
    /**
     * 按(生产明细id)字段汇总查询
     * 查询条件:按(生产计划id)
     * 查询结果(生产明细id,计划数量,合格数量,不合格数量)
     *
     * @param pd
     * @return
     */
    List<Map<String, Object>> findProducePlanDetailByQuality(PageData pd);
}
