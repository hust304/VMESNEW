package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.DateUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class SaleRetreatAuditServiceImp implements SaleRetreatAuditService {
    @Autowired
    private SaleRetreatService saleRetreatService;
    @Autowired
    private SaleRetreatDetailService saleRetreatDetailService;

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ColumnService columnService;

    /**
     * 退货单审核(创建入库单,退货单明细)
     * 1. 创建入库单(入库单, 入库单明细)
     * 2. 修改退货单明细(退货单明细(关联)入库单明细)
     *
     * @param pageData
     * @return
     * @throws Exception
     */
    public ResultModel auditPassSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String companyId = pageData.getString("currentCompanyId");
        String cuser = pageData.getString("cuser");

        //退货单id
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        //根据(退货单id)-获取退货单明细List
        List<SaleRetreatDetail> retreatDtlList = saleRetreatDetailService.findSaleOrderReturnDetailListByParentId(parentId);
        if (retreatDtlList == null || retreatDtlList.size() == 0) {return model;}

        //1. 创建入库单
        String customerId = pageData.getString("customerId");
        String customerName = pageData.getString("customerName");
        WarehouseIn warehouseIn = warehouseInService.createWarehouseIn(customerId,
                customerName,
                cuser,
                companyId,
                Common.DICTIONARY_MAP.get("saleRetreatIn"));

        //获取实体仓库id
        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("layer", "2");
        findMap.put("isEntity", "true");
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        List<Warehouse> warehouseList = warehouseService.findWarehouseList(findMap);
        warehouseIn.setWarehouseId(warehouseList.get(0).getId());
        warehouseInService.save(warehouseIn);

        //2. 创建入库单明细
        List<WarehouseInDetail> inDtlList = saleRetreatDetailService.retreatDtlList2InDtlList(retreatDtlList, null);
        warehouseInDetailService.addWarehouseInDetail(warehouseIn, inDtlList);

        //<退货单明细id, 入库明细id>Map
        Map<String, String> retreatDtl2InDtlMap = new HashMap<String, String>();
        for (WarehouseInDetail inDtl : inDtlList) {
            retreatDtl2InDtlMap.put(inDtl.getBusinessId(), inDtl.getId());
        }

        //3. 修改退货单明细(退货单明细(关联)入库单明细)
        for (SaleRetreatDetail retreatDtl : retreatDtlList) {
            String retreatDtl_id = retreatDtl.getId();

            SaleRetreatDetail detailEdit = new SaleRetreatDetail();
            detailEdit.setId(retreatDtl_id);
            if (retreatDtl2InDtlMap != null
                && retreatDtl2InDtlMap.get(retreatDtl_id) != null
                && retreatDtl2InDtlMap.get(retreatDtl_id).trim().length() > 0
            ) {
                detailEdit.setInDetailId(retreatDtl2InDtlMap.get(retreatDtl_id).trim());
            }

            //退货单明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
            detailEdit.setState("2");
            saleRetreatDetailService.update(detailEdit);
        }

        SaleRetreat retreatEdit = new SaleRetreat();
        retreatEdit.setId(parentId);
        //审核人ID
        retreatEdit.setAuditId(cuser);
        //状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        retreatEdit.setState("2");
        saleRetreatService.update(retreatEdit);

        return model;
    }

    public ResultModel auditDisagreeSaleRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");

        //退货单id
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退货单id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退回原因为空或空字符串，退回原因为必填不可为空！");
            return model;
        }

        //当前登录用户姓名
        String userName = "";
        if (pageData.getString("userName") != null && pageData.getString("userName").trim().length() > 0) {
            userName = pageData.getString("userName").trim();
        }

        SaleRetreat retreatEdit = new SaleRetreat();
        retreatEdit.setId(parentId);
        String msgTemp = "审核退回:{0}{3}审核人:{1}{3}审核时间:{2}";
        String remarkStr = MessageFormat.format(msgTemp,
                remark,
                userName,
                DateUtils.toDateStr(new Date()),
                Common.SYS_ENDLINE_DEFAULT);
        retreatEdit.setRemark(remarkStr);
        //退货单状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        retreatEdit.setState("0");
        //审核人ID
        retreatEdit.setAuditId(cuser);
        saleRetreatService.update(retreatEdit);

        //退货单明细状态(0:待提交 1:待审核 2:待退款 3:已完成 -1:已取消)
        saleRetreatDetailService.updateStateByDetail("0", parentId);

        return model;
    }
}
