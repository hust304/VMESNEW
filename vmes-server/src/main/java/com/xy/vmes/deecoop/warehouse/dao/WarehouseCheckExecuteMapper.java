package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.entity.WarehouseCheckExecute;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_check_execute:仓库库存盘点审核明细 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-11-15
*/
@Mapper
@Repository
public interface WarehouseCheckExecuteMapper extends BaseMapper<WarehouseCheckExecute> {

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
    void updateIsdisableByExecute(PageData pd);
    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    List<WarehouseCheckExecute> dataList(PageData pd);

    /**
     * 创建人：陈刚
     * 创建时间：2018-11-15
     */
    List<Map> getDataListPage(PageData pd);
    List<Map> getDataListPage(PageData pd, Pagination pg);

    List<Map> findListWarehouseCheckExecuteByAudit(PageData pd, Pagination pg);
    List<Map> findListWarehouseCheckExecuteByAudit(PageData pd);

}


