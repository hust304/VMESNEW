package com.xy.vmes.deecoop.sale.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.SaleRetreat;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_sale_retreat:退货单 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2019-02-25
*/
@Mapper
@Repository
public interface SaleRetreatMapper extends BaseMapper<SaleRetreat> {

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

    void deleteTableByDetail(PageData pageData);
    void updateStateByRetreat(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    List<SaleRetreat> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-02-25
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
}


