package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseIn;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_in:仓库入库单 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-10-16
*/
public interface WarehouseInService {

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void save(WarehouseIn warehouseIn) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void update(WarehouseIn warehouseIn) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void updateAll(WarehouseIn warehouseIn) throws Exception;

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
    List<WarehouseIn> dataList(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    List<WarehouseIn> selectByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;
    List<Map> getDataListPage(PageData pd) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-16
    */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    //void deleteTableByWarehouseIn(String companyId) throws Exception;

    /**
     *
     * @param companyId  企业id
     * @param warehouseGenre 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
     * @throws Exception
     */
    void deleteTableByWarehouseIn(String companyId, String warehouseGenre) throws Exception;

    WarehouseIn findWarehouseIn(PageData object);
    WarehouseIn findWarehouseInById(String id);

    List<WarehouseIn> findWarehouseInList(PageData object);

    WarehouseIn createWarehouseIn(String deptId, String deptName, String cuser, String companyId, String inType);

    ///////////////////////////////////////////////////////////////////////////////////////////////
    String checkColumn(WarehouseIn object);

    void updateState(String id) throws Exception;

    ResultModel listPageWarehouseIn(PageData pd, Pagination pg) throws Exception;

    ResultModel addWarehouseIn(PageData pageData) throws Exception;

    ResultModel updateWarehouseIn(PageData pageData) throws Exception;

    ResultModel cancelWarehouseIn(PageData pageData) throws Exception;

    ResultModel recoveryWarehouseIn(PageData pageData) throws Exception;

    ResultModel deleteWarehouseIn(PageData pageData) throws Exception;

    void exportExcelWarehouseIn(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelWarehouseIn(MultipartFile file) throws Exception;

    ResultModel listPageWarehouseInDetail(PageData pd, Pagination pg) throws Exception;

    ResultModel findWarehouseListByWarehouseIn(PageData pd, Pagination pg) throws Exception;

    ResultModel updateWarehouseInDispatch(PageData pageData) throws Exception;
}



