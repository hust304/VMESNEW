package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehousePosition;
import com.yvan.PageData;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_position:仓库货位表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2018-10-09
*/
public interface WarehousePositionService {

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    void save(WarehousePosition warehousePosition) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    void update(WarehousePosition warehousePosition) throws Exception;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-10-09
    */
    void updateAll(WarehousePosition warehousePosition) throws Exception;

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
    List<WarehousePosition> dataList(PageData pd) throws Exception;

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
    WarehousePosition findWarehousePosition(PageData object);
    WarehousePosition findWarehousePositionById(String id);
    WarehousePosition findWarehousePositionByRoot();

    List<WarehousePosition> findWarehousePositionList(PageData object);
    List<WarehousePosition> findWarehousePositionListByPid(String pid);

    boolean isExistByName(String pid, String id, String name);

    List<String> findNameListByNumber(int start, int end);
    List<String> findNameListByChar(String start, String end);
    List<String> findNameList(String start, String end, String suffix);
}



