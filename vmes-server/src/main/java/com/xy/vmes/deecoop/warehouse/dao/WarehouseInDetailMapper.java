package com.xy.vmes.deecoop.warehouse.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.WarehouseInDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_warehouse_in_detail:仓库入库单明细 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-10-16
*/
@Mapper
@Repository
public interface WarehouseInDetailMapper extends BaseMapper<WarehouseInDetail> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    @Select("dataList")
    List<WarehouseInDetail> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    @Delete("deleteByIds")
    void deleteByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-10-16
     */
    @Update("updateStateByDetail")
    void updateStateByDetail(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-10-16
     */
    @Select("getDataListPage")
    List<Map> getDataListPage(PageData pd, Pagination pg);
}


