package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.warehouse.dao.WarehouseOutDetailExecuteMapper;
import com.xy.vmes.service.WarehouseOutDetailExecuteService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：(出库单明细id)关联查询(出库明细表,出库执行表) 实现类
 * 创建人：陈刚
 * 创建时间：2019-09-02
 */
@Service
@Transactional(readOnly = false)
public class WarehouseOutDetailExecuteServiceImp implements WarehouseOutDetailExecuteService {
    @Autowired
    private WarehouseOutDetailExecuteMapper outDetailExecuteMapper;

    public List<Map> findOutDetailExecute(PageData pd) throws Exception {
        return outDetailExecuteMapper.findOutDetailExecute(pd);
    }

    /**
     * 根据出库单id-获取出库单明细id-出库执行数量
     * 根据出库单id-关联查询(出库明细表,出库执行表)
     *
     * 返回值Map结构体
     * <出库单明细id, 出库单明细执行Map>
     *     出库单明细执行Map
     *     outParentId:       出库单id
     *     outDtlId:          出库单明细id
     *     outDtlCount:       出库单明细出库数量
     *     outDtlExecuteCount 出库单明细出库执行数量
     *
     *
     * @param outDtlIds
     * @return
     */
    public Map<String, Map<String, Object>> findOutDetailExecuteMapByOutDtlIds(String outDtlIds) {
        Map<String, Map<String, Object>> outDtlMap = new HashMap<>();
        if (outDtlIds == null || outDtlIds.trim().length() == 0) {return outDtlMap;}

        List<Map> mapList = this.findOutDetailExecuteByOutDtlIds(outDtlIds);
        return this.findOutDetailExecuteMap(mapList);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<Map> findOutDetailExecuteByOutDtlIds(String outDtlIds) {
        List<Map> mapList = new ArrayList<>();
        if (outDtlIds == null || outDtlIds.trim().length() == 0) {return mapList;}

        outDtlIds = StringUtil.stringTrimSpace(outDtlIds);
        outDtlIds = "'" + outDtlIds.replace(",", "','") + "'";

        try {
            PageData findMap = new PageData();
            findMap.put("outDtlIds", outDtlIds);
            mapList = this.findOutDetailExecute(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapList;
    }

    /**
     * 获取出库单明细id-出库执行数量
     * 返回值Map结构体
     * <出库单明细id, 出库单明细执行Map>
     *     出库单明细执行Map
     *     outParentId:       出库单id
     *     outDtlId:          出库单明细id
     *     outDtlCount:       出库单明细出库数量
     *     outDtlExecuteCount 出库单明细出库执行数量
     *
     *
     * @param mapList  查询结果集-出库单明细表关联出库执行表
     * @return
     */
    private Map<String, Map<String, Object>> findOutDetailExecuteMap(List<Map> mapList) {
        Map<String, Map<String, Object>> outDtlMap = new HashMap<>();
        if (mapList == null || mapList.size() == 0) {return outDtlMap;}

        for (Map<String, Object> mapObject : mapList) {
            String outDtlId = (String)mapObject.get("outDtlId");
            if (outDtlId != null && outDtlId.trim().length() > 0) {
                outDtlMap.put(outDtlId, mapObject);
            }
        }

        return outDtlMap;
    }

}
