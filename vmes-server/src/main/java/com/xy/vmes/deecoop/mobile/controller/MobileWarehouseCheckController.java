package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.entity.WarehouseCheck;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseCheckExecute;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@RestController
@Slf4j
public class MobileWarehouseCheckController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseCheckController.class);
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    @Autowired
    private WarehouseCheckExecutorService warehouseCheckExecutorService;
    @Autowired
    private WarehouseCheckExecuteService warehouseCheckExecuteService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    @Autowired
    private MobileWarehouseCheckService mobileWarehouseCheckService;

    //获得盘点任务详细信息
    @PostMapping("/mobile/mobileWarehouseCheck/findWarehouseCheckByDetailId")
    //@GetMapping("/mobileWarehouseCheck/findWarehouseCheckByDetailId")
    public ResultModel findWarehouseCheckByDetailId()  throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/findWarehouseCheckByDetailId执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        List<Map> varList = mobileWarehouseCheckService.findWarehouseCheck(pd);
        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/findWarehouseCheckByDetailId  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }

    /**
     * 新增盘点单明细执行_____复用
     * @author 陈刚
     * @date 2018-11-16
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseCheck/addWarehouseCheckExecute")
    @Transactional
    public ResultModel addWarehouseCheckExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseCheck/addWarehouseCheckExecute执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String addExecuteJsonStr = pageData.getString("addExecuteJsonStr");
        if (addExecuteJsonStr == null || addExecuteJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少勾选一条盘点数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(addExecuteJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细执行 Json字符串-转换成List错误！");
            return model;
        }

        Map<String, String> parentMap = new HashMap<String, String>();
        for (Map<String, Object> mapObject : mapList) {
            WarehouseCheckExecute execute = (WarehouseCheckExecute)HttpUtils.pageData2Entity(mapObject, new WarehouseCheckExecute());
            if (execute.getCount() == null) {execute.setCount(BigDecimal.valueOf(0D));}
            execute.setExecutorId(cuser);
            execute.setCuser(cuser);
            //state:状态(0:待审核 2:同意 3:不同意)
            execute.setState("0");
            warehouseCheckExecuteService.save(execute);

            //修改盘点明细状态
            //state: 状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            WarehouseCheckDetail detail = warehouseCheckDetailService.findWarehouseCheckDetailById(execute.getDetailId());
            detail.setState("2");
            warehouseCheckDetailService.update(detail);

            parentMap.put(execute.getParentId(), execute.getParentId());
        }

        //修改盘点单状态
        if (parentMap.size() > 0) {
            for (Iterator iterator = parentMap.keySet().iterator(); iterator.hasNext();) {
                String parentId = (String) iterator.next();

                WarehouseCheck parent = new WarehouseCheck();
                parent.setId(parentId);
                //盘点明细状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)--忽视状态(-1)
                warehouseCheckDetailService.updateParentStateByDetailList(parent, null, "-1");
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseCheck/addWarehouseCheckExecute执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}
