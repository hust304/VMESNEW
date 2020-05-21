package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.AssistOrderDetailChild;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_order_detail_child:外协订单明细子表 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2020-04-24
*/
@Mapper
@Repository
public interface AssistOrderDetailChildMapper extends BaseMapper<AssistOrderDetailChild> {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void updateToDisableByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    List<AssistOrderDetailChild> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void insertAssistOrderDetailChild(PageData pd);

    //根据(外协订单id) 汇总查询取外协件原材料(成品签收检验,原材料退货检验,原材料报废,成品报废,) 验证外协订单状态
    List<Map<String, Object>> findCheckAssistOrderChild(PageData pd);

    /**
     * 获取 外协收货明细子表(原材料) 当前发货数量
     * @param pd
     * @return
     */
    List<Map<String, Object>> findAssistOrderDetailChildByDeliverChild(PageData pd);
}


