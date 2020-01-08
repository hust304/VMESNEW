package com.xy.vmes.deecoop.kanban.dao;

import com.yvan.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_kanban_visualization:销售开票 Mapper.java
* 创建人：刘威 自动创建
* 创建时间：2020-01-06
*/
@Mapper
@Repository
public interface KanbanWarehouseMapper{


    List<Map> listWarehouseDetailKanban(PageData pd);
}


