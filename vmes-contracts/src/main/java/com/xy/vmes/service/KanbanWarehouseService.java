package com.xy.vmes.service;



import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_kanban_warehouse:销售开票 接口类
* 创建人：刘威 自动生成
* 创建时间：2020-01-06
*/
public interface KanbanWarehouseService {


    ResultModel getWarehouseTotalKanban(PageData pd) throws Exception;

    ResultModel listWarehouseDetailKanban(PageData pd) throws Exception;
}



