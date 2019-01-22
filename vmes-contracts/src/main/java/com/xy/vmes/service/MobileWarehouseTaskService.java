package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * 仓库管理(入库,出库,盘点,移库)任务单Service
 */
public interface MobileWarehouseTaskService {

    ResultModel findListPageWarehouseTaskList(PageData pd, Pagination pg) throws Exception;
}
