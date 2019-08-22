package com.xy.vmes.service;

import com.xy.vmes.entity.EquipmentRepairTaskDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_repairTask_detail:设备维修任务明细表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-07-01
*/
public interface EquipmentRepairTaskDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void save(EquipmentRepairTaskDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void update(EquipmentRepairTaskDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void updateAll(EquipmentRepairTaskDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    EquipmentRepairTaskDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    List<EquipmentRepairTaskDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    List<EquipmentRepairTaskDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     *
     * @param pageData    查询参数对象<HashMap>
     * @param isQueryAll  是否查询全部
     *   true: 无查询条件返回表全部结果集
     *   false: (false or is null)无查询条件-查询结果集返回空或
     *
     * @return
     * @throws Exception
     */
    List<EquipmentRepairTaskDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    EquipmentRepairTaskDetail findRepairTaskDetail(PageData object) throws Exception;
    EquipmentRepairTaskDetail findRepairTaskDetailById(String id) throws Exception;

    List<EquipmentRepairTaskDetail> findRepairTaskDetailList(PageData object) throws Exception;
    List<EquipmentRepairTaskDetail> findRepairTaskDetailListByTaskId(String taskId) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    List<EquipmentRepairTaskDetail> jsonMapList2DetailList(List<Map<String, String>> jsonMapList, List<EquipmentRepairTaskDetail> objectList);

    /**
     * 获取Map结构体
     * 遍历JsonMapList-根据货品属性(productGenre)-返回Map结构体
     * 1.货品属性:productGenre:备件   添加到:warehouseList
     * 2.货品属性:productGenre:非备件 添加到:spareList
     *
     * Map<String, List<Map<String, String>>>
     *     warehouseList: 复杂版仓库,简版仓库
     *     spareList:     备件库
     *
     * @param jsonMapList 页面JsonMapList
     * @return
     */
    Map<String, List<Map<String, String>>> findMapByProductGenre(List<Map<String, String>> jsonMapList);


    /**
     * 获取新的editJsonMap
     * Map<String, List<Map<String, String>>>
     *     notEqualZeroList: 退回数量(不等于零)List
     *     equalZeroList:    退回数量(等于零)List
     *
     * Map<String, String>
     *   receiveCount 领取数量
     *   applyCount   实际使用数量
     *   retreatCount 退回数量 := 领取数量 - 实际使用数量
     *
     * @param editJsonMapList
     * @return
     */
    Map<String, List<Map<String, String>>> findNewEditJsonMap(List<Map<String, String>> editJsonMapList);

//    /**
//     * 该方法按值引用调用-参数货品出库Map(productMap)
//     * 方法调用后-参数(productMap)发生改变
//     *
//     * 货品出库Map
//     * 货品出库Map<货品id, 货品Map<String, Object>>
//     * 货品Map<String, Object>
//     *     productId: 货品id
//     *     outDtlId:  出库明细id
//     *     outCount:  出库数量
//     *
//     * @param jsonMapList
//     * @param productByOutMap
//     * @return
//     */
//    void findProductMapByOut(List<Map<String, String>> jsonMapList, Map<String, Map<String, Object>> productByOutMap);
    /**
     * 返回货品出库Map
     * 货品出库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     *
     * @param jsonMapList
     * @return
     */
    Map<String, Map<String, Object>> findProductMapByOut(List<Map<String, String>> jsonMapList);
    /**
     * 返回业务货品出库Map
     * 业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     *
     * @param jsonMapList
     * @return
     */
    Map<String, Map<String, Object>> findBusinessProducMapByOut(List<Map<String, String>> jsonMapList);

    /**
     * 返回货品入库Map
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param jsonMapList
     * @return
     */
    Map<String, Map<String, Object>> findProductMapByIn(List<Map<String, String>> jsonMapList);
    /**
     * 返回业务货品入库Map
     * 业务货品入库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param jsonMapList
     * @return
     */
    Map<String, Map<String, Object>> findBusinessProducMapByIn(List<Map<String, String>> jsonMapList);


    void addRepairTaskDetail(String cuser,
                             List<EquipmentRepairTaskDetail> objectList,
                             Map<String, Map<String, Object>> productByOutMap) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageRepairTaskDetail(PageData pd) throws Exception;
    ResultModel findListTaskDetailByOutDetail(PageData pd) throws Exception;


}



