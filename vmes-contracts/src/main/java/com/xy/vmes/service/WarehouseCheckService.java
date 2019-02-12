package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseCheck;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_check:仓库库存盘点 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-11-13
*/
public interface WarehouseCheckService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void save(WarehouseCheck object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void update(WarehouseCheck object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    void updateAll(WarehouseCheck object) throws Exception;

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
    WarehouseCheck selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-13
     */
    List<WarehouseCheck> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void deleteTableByWarehouseCheck(String companyId) throws Exception;

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-13
     */
    List<WarehouseCheck> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-13
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

    WarehouseCheck findWarehouseCheck(PageData object) throws Exception;
    WarehouseCheck findWarehouseCheckById(String id) throws Exception;

    List<WarehouseCheck> findWarehouseCheckList(PageData object) throws Exception;


    ResultModel listPagewarehouseChecks(PageData pd, Pagination pg) throws Exception;

    ResultModel addWarehouseCheck(PageData pageData) throws Exception;

    ResultModel cancelWarehouseCheck(PageData pageData) throws Exception;

    ResultModel rebackWarehouseCheck(PageData pageData) throws Exception;

    ResultModel deleteWarehouseCheck(PageData pageData) throws Exception;

    ResultModel checkUserRoleByWarehouseAudit(PageData pageData) throws Exception;

    void exportExcelwarehouseChecks(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelwarehouseChecks(MultipartFile file) throws Exception;

    void updateState(String id) throws Exception;
}



