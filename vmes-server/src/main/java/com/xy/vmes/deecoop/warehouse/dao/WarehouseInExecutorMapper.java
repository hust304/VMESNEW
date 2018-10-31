package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseInExecutor;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_in_executor:入库明细执行人 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-10-31
*/
@Mapper
@Repository
public interface WarehouseInExecutorMapper extends BaseMapper<WarehouseInExecutor> {


    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    List<WarehouseInExecutor> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-31
     */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-10-31
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
}


