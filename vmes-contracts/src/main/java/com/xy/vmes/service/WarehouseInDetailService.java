package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_in_detail:仓库入库单明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-10-16
*/
public interface WarehouseInDetailService {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void save(WarehouseInDetail warehouseIn) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void update(WarehouseInDetail warehouseIn) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void updateAll(WarehouseInDetail warehouseIn) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<WarehouseInDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<WarehouseInDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    void updateStateByDetail(PageData pd) throws Exception;

    WarehouseInDetail findWarehouseInDetail(PageData object);
    WarehouseInDetail findWarehouseInDetailById(String id);

    List<WarehouseInDetail> findWarehouseInDetailList(PageData object);
    List<WarehouseInDetail> findWarehouseInDetailListByParentId(String parentId);

    List<WarehouseInDetail> mapList2DetailList(List<Map<String, String>> mapList, List<WarehouseInDetail> objectList);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void addWarehouseInDetail(WarehouseIn parentObj, List<WarehouseInDetail> objectList) throws Exception;

    /**
     * 修改入库单明细状态(vmes_warehouse_in_detail)
     * state:状态(0:待派单 1:执行中 2:已完成 -1.已取消)
     *
     * 入库执行明细(vmes_warehouse_in_execute)
     *     按照(detail_id:入库明细ID)汇总求和(count:当前入库数量)
     * 汇总数量 >= 入库数量  state:2:已完成
     *
     * @param detailList
     */
    void updateStateWarehouseInDetail(List<WarehouseInDetail> detailList) throws Exception;


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 入库单明细状态，在入库单明细List<WarehouseInDetail>中是否全部相同
     *   true : 全部相同，在入库单明细List
     *   false: 一条或多条不同，在入库单明细List
     *
     * @param state       明细状态-入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消)
     * @param ignoreState 忽视状态
     * @param objectList  入库单明细List<WarehouseInDetail>
     * @return
     */
    boolean isAllExistStateByDetailList(String state, String ignoreState, List<WarehouseInDetail> objectList);

}



