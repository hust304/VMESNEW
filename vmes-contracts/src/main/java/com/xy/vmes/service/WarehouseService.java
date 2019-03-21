package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.entity.Warehouse;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse:仓库货位表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-10-10
*/
public interface WarehouseService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    void save(Warehouse warehouse) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    void update(Warehouse warehouse) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    void updateAll(Warehouse warehouse) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    List<Warehouse> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-09
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 获取全部仓库货位记录，同时带出该(货位,货品)库存数量
     *
     * @param pd
     * @param pg
     * @return
     */
    List<Map> findListWarehouseByWarehouseProduct(PageData pd, Pagination pg) throws Exception;

    Map<String, String> getKeyNameMap();
    Map<String, String> getNameKeyMap();
    void createBusinessMap();
    void implementBusinessMapByCompanyId(String companyId);
    ////////////////////////////////////////////////////////////////////////////////////
    Warehouse findWarehouse(PageData object);
    Warehouse findWarehouseById(String id);
    Warehouse findWarehouseByRoot();

    List<Warehouse> findWarehouseList(PageData object);
    List<Warehouse> findWarehouseListByPid(String pid);

    boolean isExistByName(String pid, String id, String companyID, String name);

    List<String> findNameListByNumber(int start, int end);
    List<String> findNameListByChar(String start, String end);
    List<String> findNameList(String start, String end, String suffix);
    String nameList2NameString(List<String> nameList);
    Integer findMaxSerialNumber(String pid);

    ///////////////////////////////////////////////////////////////////////////////////////////////
    String checkColumnByEntity(Warehouse object);
    String checkColumnByVirtual(Warehouse object);
    Warehouse paterObject2Warehouse(Warehouse paterObject, Warehouse objectDB);
    Warehouse clearWarehouseByPath(Warehouse objectDB);
    Warehouse warehouseObj2QRCodeObj(Warehouse warehouseObj, Warehouse QRCodeObj);

    String findPidsByWarehouseList(List<Warehouse> objectList);

    /**
     * 创建部门货位
     * @param paterObj
     * @param keyNameMap
     * @return
     */
    void createWarehouseByDeptPosition(Warehouse paterObj, Map<String, String> keyNameMap);
    void createWarehouseByPosition(Warehouse paterObj, List<String> nameList);

    TreeEntity warehouse2Tree(Warehouse warehouse, TreeEntity tree);
    List<TreeEntity> warehouseList2TreeList(List<Warehouse> warehouseList, List<TreeEntity> treeList);

    ResultModel listWarehouseNodeByPid(PageData pd) throws Exception;

    ResultModel treeWarehouse(PageData pageData) throws Exception;

    ResultModel listPageWarehouse(PageData pd, Pagination pg) throws Exception;

    ResultModel findListWarehouseByWarehouseProduct(PageData pd) throws Exception;

    ResultModel addWarehouseByEntity(PageData pageData) throws Exception;

    ResultModel addWarehouseByVirtual(PageData pageData) throws Exception;

    ResultModel addWarehousePosition(PageData pageData) throws Exception;

    ResultModel addWarehousePositionByRange(PageData pageData) throws Exception;

    ResultModel updateWarehouseByEntity(PageData pageData) throws Exception;

    ResultModel updateWarehouseByVirtual(PageData pageData) throws Exception;

    ResultModel updateWarehousePositionByName(PageData pageData) throws Exception;

    ResultModel deleteWarehouse(PageData pageData) throws Exception;

    void exportExcelWarehouse(PageData pd, Pagination pg) throws Exception;

    ResultModel importExcelWarehouse(MultipartFile file) throws Exception;
}



