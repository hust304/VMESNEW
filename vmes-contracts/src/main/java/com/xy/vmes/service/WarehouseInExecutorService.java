package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.entity.WarehouseInExecutor;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_in_executor:入库明细执行人 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-10-31
*/
public interface WarehouseInExecutorService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    void save(WarehouseInExecutor object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    void update(WarehouseInExecutor object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    void updateAll(WarehouseInExecutor object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    List<WarehouseInExecutor> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    List<WarehouseInExecutor> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 获取入库明细执行人列表(添加入库执行)
     * @param pd
     * @return
     * @throws Exception
     */
    List<Map> findListWarehouseInExecutorByAddExecute(PageData pd) throws Exception;

    WarehouseInExecutor findWarehouseInExecutor(PageData object);
    WarehouseInExecutor findWarehouseInExecutorById(String id);

    List<WarehouseInExecutor> findWarehouseInExecutorList(PageData object);
    List<WarehouseInExecutor> findWarehouseInExecutorListByDetailId(String detailId);

    void addWarehouseInExecutor(WarehouseInDetail detail, String userIds);
}



