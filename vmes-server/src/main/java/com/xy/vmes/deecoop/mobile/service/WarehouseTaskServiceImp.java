package com.xy.vmes.deecoop.mobile.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.mobile.dao.WarehouseTaskMapper;
import com.xy.vmes.service.WarehouseTaskService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 仓库管理(入库,出库,盘点,移库)任务单Service
 */
@Service
@Transactional(readOnly = false)
public class WarehouseTaskServiceImp implements WarehouseTaskService {

    @Autowired
    private WarehouseTaskMapper warehouseTaskMapper;

    public List<Map> findListPageWarehouseTaskList(PageData pd, Pagination pg) throws Exception {
        return warehouseTaskMapper.findListPageWarehouseTaskList(pd,pg);
    }
}
