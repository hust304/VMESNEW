package com.xy.vmes.deecoop.produce.service;

import com.xy.vmes.deecoop.produce.dao.ProducePlanDetailByQualityCollectMapper;
import com.xy.vmes.service.ProducePlanDetailToolService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProducePlanDetailToolServiceImp implements ProducePlanDetailToolService {
    @Autowired
    private ProducePlanDetailByQualityCollectMapper planDetailCollectMapper;

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
    public Map<String, Map<String, Object>> findProducePlanDetailMap(String planId) {
        Map<String, Map<String, Object>> detailMap = new HashMap<>();
        if (planId == null || planId.trim().length() == 0) {return detailMap;}

        List<Map<String, Object>> mapList = new ArrayList<>();
        try {
            PageData findMap = new PageData();
            findMap.put("planId", planId);
            mapList = planDetailCollectMapper.findProducePlanDetailByQuality(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> objectMap : mapList) {
                //dtlId: 生产明细id
                String dtlId = (String)objectMap.get("dtlId");
                detailMap.put(dtlId, objectMap);
            }
        }

        return detailMap;
    }
}
