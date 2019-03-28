package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.Conv;
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
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseInController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseInController.class);
    @Autowired
    private MobileWarehouseInService mobileWarehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    //获得入库任务详细信息
    @PostMapping("/mobile/mobileWarehouseIn/findWarehouseInByDetailId")
    public ResultModel findWarehouseInByDetailId()  throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInByDetailId  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.findWarehouseIn(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInByDetailId  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }


    /**
     * 手机端
     * 新增入库单明细执行
     * @author fang
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/addWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseInExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/addWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.addWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/addWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单明细执行___手机端复用
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/rebackWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseInExecute() throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/rebackWarehouseInExecute执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.rebackWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/rebackWarehouseInExecute执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * 通过Pid查找下级库位信息
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobile/mobileWarehouseIn/listWarehouseNodeByPid")
    public ResultModel listWarehouseNodeByPid()  throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/listWarehouseNodeByPid  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = mobileWarehouseInService.listWarehouseNodeByPid(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/listWarehouseNodeByPid  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/mobile/mobileWarehouseIn/findWarehouseInDetailByQrcode")
    public ResultModel findWarehouseInDetailByQrcode() throws Exception {
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInDetailByQrcode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        //货品货位二维码:= 入库明细id
        String qrcode = pageData.getString("qrcode");
        if (qrcode == null || qrcode.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("货品货位二维码(入库明细id)为空或空字符串！");
            return model;
        }

        Map<String, String> warehouseInDtlMap = new HashMap<String, String>();
        WarehouseInDetail inDetail = warehouseInDetailService.findWarehouseInDetailById(qrcode);
        if (inDetail != null) {
            if (inDetail.getWarehouseId() != null && inDetail.getWarehouseId().trim().length() > 0) {
                warehouseInDtlMap.put("warehouseId", inDetail.getWarehouseId().trim());
            }

            if (inDetail.getParentId() != null && inDetail.getParentId().trim().length() > 0) {
                warehouseInDtlMap.put("productId", inDetail.getParentId().trim());
            }

            if (inDetail.getCode() != null && inDetail.getCode().trim().length() > 0) {
                warehouseInDtlMap.put("code", inDetail.getCode().trim());
            }
        }

        String jsonStr = new String();
        if (warehouseInDtlMap.size() > 0) {
            jsonStr = YvanUtil.toJson(warehouseInDtlMap);
        }
        model.set("jsonStr", jsonStr);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseIn/findWarehouseInDetailByQrcode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}
