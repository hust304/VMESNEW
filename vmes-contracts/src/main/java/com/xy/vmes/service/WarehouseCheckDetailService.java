package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseProduct;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_check_detail:仓库库存盘点明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-11-13
*/
public interface WarehouseCheckDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void save(WarehouseCheckDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void update(WarehouseCheckDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void updateAll(WarehouseCheckDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    WarehouseCheckDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    List<WarehouseCheckDetail> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateStateByDetail(String parentId, String state);

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-13
     */
    List<WarehouseCheckDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-13
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

    WarehouseCheckDetail findWarehouseCheckDetail(PageData object) throws Exception;
    WarehouseCheckDetail findWarehouseCheckDetailById(String id) throws Exception;

    List<WarehouseCheckDetail> findWarehouseCheckDetailList(PageData object) throws Exception;
    List<WarehouseCheckDetail> findWarehouseCheckDetailListByParentId(String parentId) throws Exception;

    List<WarehouseCheckDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseCheckDetail> objectList);

    /////////////////////////////////////////////////////////////
    /**
     * 获取业务id字符串(逗号分隔的字符串)
     *
     * @param mapList 业务id
     * @return
     */
    String findBusinessIdByMapList(List<Map<String, String>> mapList);
    void addWarehouseCheckDetail(WarehouseCheck parentObj, List<WarehouseProduct> objectList) throws Exception;

    /**
     * 根据盘点明细状态-反写盘点单状态
     * 盘点状态(0:未完成 1:已完成 -1:已取消)
     * 盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     *
     * @param parent       入库单对象
     * @param dtlList     入库单明细List<WarehouseCheckDetail>
     * @param ignoreState  忽视状态
     */
    void updateParentStateByDetailList(WarehouseCheck parent, List<WarehouseCheckDetail> dtlList, String ignoreState) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 盘点明细状态，在盘点明细List<WarehouseCheckDetail>中是否全部相同
     *   true : 一条或多条相同，在盘点单明细List
     *   false: 全部不同，在盘点单明细List
     *
     * @param state       盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     * @param ignoreState 忽视状态
     * @param objectList  盘点单明细List<WarehouseCheckDetail>
     * @return
     */
    boolean isExistStateByDetailList(String state, String ignoreState, List<WarehouseCheckDetail> objectList);

    /**
     * 盘点明细状态，在盘点明细List<WarehouseCheckDetail>中是否全部相同
     *   true : 全部相同，在盘点单明细List
     *   false: 一条或多条不同，在盘点单明细List
     *
     * @param state       盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     * @param ignoreState 忽视状态
     * @param objectList  盘点单明细List<WarehouseCheckDetail>
     * @return
     */
    boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseCheckDetail> objectList);

    /**
     * 获取盘点单状态-根据盘点明细状态
     * 盘点状态(0:未完成 1:已完成 -1:已取消)
     * 盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
     *
     * @param ignoreState  忽视状态
     * @param dtlList      盘点单明细List<WarehouseCheckDetail>
     * @return
     */
    String findParentStateByDetailList(String ignoreState, List<WarehouseCheckDetail> dtlList);
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //boolean isAllAuditStateByDetailExecuteList(String state, List<Map<String, Object>> mapList);

}



