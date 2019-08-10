package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseInitial;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_initial:仓库初始化设定 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-11-20
*/
@Mapper
@Repository
public interface WarehouseInitialMapper extends BaseMapper<WarehouseInitial> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-20
     */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateIsdisable(PageData pd);

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-20
     */
    List<WarehouseInitial> dataList(PageData pd);

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-20
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);

    //仓库初始化(复杂版仓库)
    //List<Map> findWarehouseProductByComplex(PageData pd);
    //List<Map> findWarehouseProductByComplex(PageData pd, Pagination pg);

    //仓库初始化(简版仓库)
    List<Map> findWarehouseProductBySimple(PageData pd);
    List<Map> findWarehouseProductBySimple(PageData pd, Pagination pg);



}


