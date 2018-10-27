package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.entity.Warehouse;
import com.yvan.PageData;

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
    Warehouse findWarehouse(PageData object);
    Warehouse findWarehouseById(String id);
    Warehouse findWarehouseByRoot();

    List<Warehouse> findWarehouseList(PageData object);
    List<Warehouse> findWarehouseListByPid(String pid);

    boolean isExistByName(String pid, String id, String name);

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
}



