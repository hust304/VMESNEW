package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseInitial;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_initial:仓库初始化设定 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-11-20
*/
public interface WarehouseInitialService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    void save(WarehouseInitial object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    void update(WarehouseInitial object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    void updateAll(WarehouseInitial object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    WarehouseInitial selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    List<WarehouseInitial> selectByColumnMap(Map columnMap) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateIsdisable(String isdisable, String companyId);

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-20
     */
    List<WarehouseInitial> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-20
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

    //仓库初始化(复杂版仓库)
    List<Map> findWarehouseInitialByComplex(PageData pd) throws Exception;
    //仓库初始化(简版仓库)
    List<Map> findWarehouseInitialBySimple(PageData pd) throws Exception;

    void initialByWarehouse(String cuser, String companyId) throws Exception;
    void deleteTableByBusiness(String companyId) throws Exception;

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    ResultModel listPageWarehouseInitial(PageData pd, Pagination pg) throws Exception;

    ResultModel initialWarehouse(PageData pageData) throws Exception;

    ResultModel updateWarehouseProduct(PageData pageData) throws Exception;

    ResultModel deleteWarehouseProduct(PageData pageData) throws Exception;

    ResultModel deleteWarehouseProductBySimple(PageData pageData) throws Exception;

    void exportExcelWarehouseInitial(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelWarehouseInitial(MultipartFile file) throws Exception;
}



