package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseCheckExecutor;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_check_executor:库存盘点明细执行人 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-11-15
*/
public interface WarehouseCheckExecutorService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void save(WarehouseCheckExecutor object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void update(WarehouseCheckExecutor object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void updateAll(WarehouseCheckExecutor object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    WarehouseCheckExecutor selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    List<WarehouseCheckExecutor> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    List<WarehouseCheckExecutor> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

    /**
     * 获取盘点明细执行人列表(添加盘点执行)
     * @param pd
     * @return
     * @throws Exception
     */
    List<Map> findListWarehouseCheckExecutorByAddExecute(PageData pd, Pagination pg) throws Exception;

    WarehouseCheckExecutor findWarehouseCheckExecutor(PageData object) throws Exception;
    WarehouseCheckExecutor findWarehouseCheckExecutorById(String id) throws Exception;

    List<WarehouseCheckExecutor> findWarehouseCheckExecutorList(PageData object) throws Exception;
    List<WarehouseCheckExecutor> findWarehouseCheckExecutorListByDetailId(String detailId) throws Exception;

    void addWarehouseCheckExecutor(WarehouseCheckDetail detail, String userIds) throws Exception;

}



