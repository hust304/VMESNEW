package com.xy.vmes.service;

import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
 * 说明：(出库单明细id)关联查询(出库明细表,出库执行表) 接口类
 * 创建人：陈刚
 * 创建时间：2019-09-02
 */
public interface WarehouseOutDetailExecuteService {

    List<Map> findOutDetailExecute(PageData pd) throws Exception;

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
    Map<String, Map<String, Object>> findOutDetailExecuteMapByOutDtlIds(String outDtlIds);

    //List<Map> findOutDetailExecuteByOutDtlIds(String outDtlIds);
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
    //Map<String, Map<String, Object>> findOutDetailExecuteMap(List<Map> mapList);
}
