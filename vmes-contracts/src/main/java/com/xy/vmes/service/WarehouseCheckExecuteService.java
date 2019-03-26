package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseCheckExecute;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_check_execute:仓库库存盘点审核明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-11-15
*/
public interface WarehouseCheckExecuteService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void save(WarehouseCheckExecute object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void update(WarehouseCheckExecute object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void updateAll(WarehouseCheckExecute object) throws Exception;

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
    WarehouseCheckExecute selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    List<WarehouseCheckExecute> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    List<WarehouseCheckExecute> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;
    List<Map> findListWarehouseCheckExecuteByAudit(PageData pd, Pagination pg) throws Exception;

    WarehouseCheckExecute findWarehouseCheckExecute(PageData object) throws Exception;
    WarehouseCheckExecute findWarehouseCheckExecuteById(String id) throws Exception;

    List<WarehouseCheckExecute> findWarehouseCheckExecuteList(PageData object) throws Exception;
    List<WarehouseCheckExecute> findWarehouseCheckExecuteListByDetailId(String detailId) throws Exception;

    ResultModel addWarehouseCheckExecute(PageData pageData) throws Exception;

    ResultModel rebackWarehouseCheckByDetail(PageData pageData) throws Exception;

    void rebackWarehouseCheck(List<WarehouseCheckDetail> detailList, String rebackBillReason, String cuser) throws Exception;

    ResultModel findListByWarehouseCheckExecute(PageData pd, Pagination pg)throws Exception;

    ResultModel cancelAuditWarehouseCheckByExecute(PageData pageData) throws Exception;

    ResultModel auditPassWarehouseCheckExecute(PageData pageData) throws Exception;

    ResultModel auditDisagreeWarehouseCheckExecute(PageData pageData) throws Exception;

    void auditPassWarehouseCheck(List<Map<String, Object>> mapList, String cuser, String companyId)   throws Exception;

    void auditDisagreeWarehouseCheck(List<Map<String, Object>> mapList, String cuser, String remark)  throws Exception;

    void addWarehouseCheck(List<Map<String, Object>> mapList,String cuser) throws Exception;
}



