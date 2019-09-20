package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseInExecute;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_in_execute:仓库入库执行明细 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Mapper
@Repository
public interface WarehouseInExecuteMapper extends BaseMapper<WarehouseInExecute> {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    List<WarehouseInExecute> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void updateIsdisableByExecute(PageData pd);

    /**
     * 获取入库执行明细列表(修改入库执行)
     * @param pd
     * @return
     */
    List<Map> findListWarehouseInExecuteByEdit(PageData pd);

    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    List<Map<String, Object>> findSumcountByWarehouseInExecute(PageData pd);

    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);
}


