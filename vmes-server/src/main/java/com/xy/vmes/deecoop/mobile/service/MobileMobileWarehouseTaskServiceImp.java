package com.xy.vmes.deecoop.mobile.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseTaskMapper;
import com.xy.vmes.service.MobileWarehouseTaskService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库管理(入库,出库,盘点,移库)任务单Service
 */
@Service
@Transactional(readOnly = false)
public class MobileMobileWarehouseTaskServiceImp implements MobileWarehouseTaskService {

    @Autowired
    private MobileWarehouseTaskMapper mobileWarehouseTaskMapper;

    public ResultModel findListPageWarehouseTaskList(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList = mobileWarehouseTaskMapper.findListPageWarehouseTaskList(pd,pg);
        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }
}
