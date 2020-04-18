package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleRetreatDetail;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_retreat_detail:退货明细 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2019-02-25
*/
@Mapper
@Repository
public interface SaleRetreatDetailMapper extends BaseMapper<SaleRetreatDetail> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    void updateToDisableByIds(String[] ids);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    List<SaleRetreatDetail> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);

    void updateStateByDetail(PageData pd);
}


