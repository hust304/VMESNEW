package com.xy.vmes.deecoop.assist.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 说明：外协订单明细查询汇总 Mapper.java
 * 外协-收货管理-生成收货单-收货-弹出界面查询
 *
 * 创建人：陈刚
 * 创建时间：2020-05-04
 */
@Mapper
@Repository
public interface AssistOrderDetailQueryBySignMapper {
    //外协订单明细(订单数量,签收(检验完成数量))
    //List<Map<String, Object>> findCheckAssistOrderDetaiBySign(PageData pd);
    List<Map> listAssistOrderDetaiQueryBySign(PageData pd);
    List<Map> listAssistOrderDetaiQueryBySign(PageData pd, Pagination pg);
}
