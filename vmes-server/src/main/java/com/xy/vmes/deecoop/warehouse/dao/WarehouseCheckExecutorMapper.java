package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseCheckExecutor;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_check_executor:库存盘点明细执行人 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-11-15
*/
@Mapper
@Repository
public interface WarehouseCheckExecutorMapper extends BaseMapper<WarehouseCheckExecutor> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-11-15
     */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    List<WarehouseCheckExecutor> dataList(PageData pd);

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);

    List<Map> findListWarehouseCheckExecutorByAddExecute(PageData pd, Pagination pg);
}


