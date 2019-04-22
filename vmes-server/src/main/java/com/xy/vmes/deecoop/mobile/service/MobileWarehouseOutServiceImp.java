package com.xy.vmes.deecoop.mobile.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseOutMapper;
import com.xy.vmes.service.MobileWarehouseOutService;
import com.xy.vmes.service.WarehouseOutDetailService;
import com.xy.vmes.service.WarehouseOutExecuteService;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 46368 on 2019/1/22.
 */
@Service
@Transactional(readOnly = false)
public class MobileWarehouseOutServiceImp implements MobileWarehouseOutService {
    @Autowired
    private MobileWarehouseOutMapper mobileWarehouseOutMapper;

    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;

    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Override
    public ResultModel findWarehouseOutByDetailId(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        //货品二维码:= 货品id
        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("出库明细id为空或空字符串！");
            return model;
        }

        Map<String, Object> outDelMap = new HashMap<String, Object>();

        PageData findMap = new PageData();
        findMap.put("outDetailId", detailId);
        List<Map<String, Object>> mapList = warehouseOutDetailService.findMapListWarehouseOutDetail(findMap);
        if (mapList != null && mapList.size() > 0) {
            outDelMap = mapList.get(0);
        }

        String jsonStr = new String();
        if (outDelMap.size() > 0) {
            jsonStr = YvanUtil.toJson(outDelMap);
        }
        model.set("jsonStr", jsonStr);

        //出库明细id-获取出库执行列表
        findMap = new PageData();
        findMap.put("detailId", detailId);
        List<Map> executeCountList = mobileWarehouseOutMapper.listWarehouseOutExecuteCount(findMap);
        model.put("executeCountList",executeCountList);

        return model;
    }

    @Override
    public List<Map> listWarehousePath(PageData pd) throws Exception {
        return mobileWarehouseOutMapper.listWarehousePath(pd);
    }

    @Override
    public List<Map> listWarehouseCode(PageData pd) throws Exception {
        return mobileWarehouseOutMapper.listWarehouseCode(pd);
    }

    @Override
    public ResultModel addWarehouseOutExecute(PageData pageData) throws Exception {
        String detailId = pageData.getString("detailId");
        String warehouseId = pageData.getString("warehouseId");
        String warehouseProductId = pageData.getString("warehouseProductId");
        String countStr = pageData.getString("count");
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        BigDecimal count = StringUtils.isEmpty(countStr)?BigDecimal.ZERO:BigDecimal.valueOf(Double.parseDouble(countStr));

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        List<Map> outMapList = warehouseOutDetailService.getDataListPage(findMap, null);

        Map outDtlMap = null;
        if (outMapList != null && outMapList.size() > 0) {
            outDtlMap = outMapList.get(0);
        }

        //出库执行验证 出库单明细数量 (出库单明已执行数量 + 当前执行数量) --(web端,app端)同时执行情况
        ResultModel model = new ResultModel();
        if (outDtlMap != null) {
            //productCode 货品编码
            String productCode = new String();
            if (outDtlMap.get("productCode") != null) {
                productCode = outDtlMap.get("productCode").toString().trim();
            }

            //productName 货品名称
            String productName = new String();
            if (outDtlMap.get("productName") != null) {
                productName = outDtlMap.get("productName").toString().trim();
            }

            //executeCount 已完成数量
            BigDecimal executeCount = BigDecimal.valueOf(0D);
            if (outDtlMap.get("executeCount") != null) {
                executeCount = (BigDecimal)outDtlMap.get("executeCount");
            }

            //订单明细:出库数量
            BigDecimal dtl_count = BigDecimal.valueOf(0D);
            if (outDtlMap.get("count") != null) {
                dtl_count = (BigDecimal)outDtlMap.get("count");
            }

            String msgTemp = "货品编码({0})货品名称({1}) 出库执行冲突，出库数量({2}) 已执行({3}) 不可大于剩余数量！" + Common.SYS_ENDLINE_DEFAULT;
            if (dtl_count.doubleValue() < (executeCount.doubleValue() + count.doubleValue())) {
                String msgStr = MessageFormat.format(msgTemp,
                        productCode,
                        productName,
                        dtl_count.toString(),
                        executeCount.toString());

                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }
        }

        model = warehouseOutExecuteService.addWarehouseOutExecute(detailId,warehouseId,warehouseProductId,currentUserId,currentCompanyId,count);
        if(model.get("code") != null && !"0".equals(model.get("code").toString().trim())){
            return model;
        }
        //更新出库单及出库明细状态
        model = warehouseOutExecuteService.updateWarehouseOutState(detailId);
        return model;
    }

    @Override
    public ResultModel rebackWarehouseOutDetail(PageData pd) throws Exception {
        pd.put("id",pd.getString("detailId"));
        return warehouseOutDetailService.rebackWarehouseOutDetail(pd);
    }

    @Override
    public ResultModel findWarehouseCodeByQrcode(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList = this.listWarehousePath(pd);
        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("当前批次号不存在或者当前批次库存数量小于等于零！");
        }
        return model;
    }

    @Override
    public ResultModel listWarehouseCodeByWarehouseId(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList = this.listWarehouseCode(pd);
        Map result = new HashMap();
        if(varList!=null&&varList.size()>0){
            result.put("varList",varList);
            model.putResult(result);
        }else {
            model.putCode("1");
            model.putMsg("当前库位下面没有该产品批次信息或者该产品批次库存数量小于等于零！");
        }
        return model;
    }

    @Override
    public ResultModel listWarehousePathByProduct(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList = this.listWarehousePath(pd);
        Map result = new HashMap();
        if(varList!=null&&varList.size()>0){
            result.put("varList",varList);
            model.putResult(result);
        }else {
            model.putCode("1");
            model.putMsg("没有找到当前产品的货位信息或者已存在的货位中该产品的数量小于等于零！");
        }
        return model;
    }

    @Override
    public ResultModel findWarehousePathByQrcode(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList = this.listWarehousePath(pd);

        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("没有找到货位信息或者在当前货位中该产品的数量小于等于零！");
        }
        return model;
    }

}
