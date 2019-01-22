package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.entity.WarehouseInExecute;
import com.xy.vmes.entity.WarehouseLoginfo;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_in_execute:仓库入库执行明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-10-16
*/
public interface WarehouseInExecuteService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void save(WarehouseInExecute object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void update(WarehouseInExecute object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void updateAll(WarehouseInExecute object) throws Exception;

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
    List<WarehouseInExecute> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<WarehouseInExecute> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateIsdisableByExecute(String detailId, String isdisable) throws Exception;

    /**
     * 获取入库执行明细列表(修改入库执行)
     * @param pd
     * @return
     */
    List<Map> findListWarehouseInExecuteByEdit(PageData pd) throws Exception;

    List<Map<String, Object>> findSumcountByWarehouseInExecute(PageData object);
    Map<String, BigDecimal> findExecuteCountByParentId(String parentId);

    WarehouseInExecute findWarehouseInExecute(PageData object);
    WarehouseInExecute findWarehouseInExecuteById(String id);

    List<WarehouseInExecute> findWarehouseInExecuteList(PageData object);
    List<WarehouseInExecute> findWarehouseInExecuteListByDetailId(String detailId);

    List<WarehouseInExecute> mapList2ExecuteList(List<Map<String, String>> mapList, List<WarehouseInExecute> objectList);
    ///////////////////////////////////////////////////////////////////////////////
    //BigDecimal findSumCountByExecuteList(List<WarehouseInExecute> objectList);

    String checkColumnExecuteList(List<WarehouseInExecute> objectList);

    ResultModel batchAddWarehouseInExecute(PageData pageData) throws Exception;

    ResultModel addWarehouseInExecute(PageData pageData) throws Exception;

    ResultModel rebackWarehouseInExecute(PageData pageData) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////

}



