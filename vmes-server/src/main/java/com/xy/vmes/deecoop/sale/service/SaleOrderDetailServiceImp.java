package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailService;
import com.xy.vmes.service.SaleOrderService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：vmes_sale_order_detail:订单明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-12-05
*/
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailServiceImp implements SaleOrderDetailService {

    @Autowired
    private SaleOrderDetailMapper saleOrderDetailMapper;
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private ColumnService columnService;
    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-12-05
    */
    @Override
    public void save(SaleOrderDetail saleOrderDetail) throws Exception{
        saleOrderDetail.setId(Conv.createUuid());
        saleOrderDetail.setCdate(new Date());
        saleOrderDetail.setUdate(new Date());
        saleOrderDetailMapper.insert(saleOrderDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public SaleOrderDetail selectById(String id) throws Exception{
        return saleOrderDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<SaleOrderDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleOrderDetail> warehouseCheckDetailList =  saleOrderDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void update(SaleOrderDetail object) throws Exception{
        object.setUdate(new Date());
        saleOrderDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void updateAll(SaleOrderDetail object) throws Exception{
        object.setUdate(new Date());
        saleOrderDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleOrderDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleOrderDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleOrderDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleOrderDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<SaleOrderDetail> dataList(PageData pd) throws Exception{
        return saleOrderDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleOrderDetailMapper.getDataListPage(pd,pg);
    }

    /**
    *
    * @param pageData    查询参数对象<HashMap>
    * @param isQueryAll  是否查询全部
    *   true: 无查询条件返回表全部结果集
    *   false: (false or is null)无查询条件-查询结果集返回空或
    *
    * @return
    * @throws Exception
    */
    public List<SaleOrderDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleOrderDetail>();
        }

        return this.dataList(pageData);
    }

    public SaleOrderDetail findSaleOrderDetail(PageData object) throws Exception {
        List<SaleOrderDetail> objectList = this.findSaleOrderDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public SaleOrderDetail findSaleOrderDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleOrderDetail(findMap);
    }

    public List<SaleOrderDetail> findSaleOrderDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public List<SaleOrderDetail> findSaleOrderDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findSaleOrderDetailList(findMap);
    }

    public List<SaleOrderDetail> mapList2DetailList(List<Map<String, String>> mapList, List<SaleOrderDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleOrderDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleOrderDetail detail = (SaleOrderDetail) HttpUtils.pageData2Entity(mapObject, new SaleOrderDetail());
            objectList.add(detail);
        }

        return objectList;
    }
    public List<SaleOrderDetail> mapList2OrderDetailListByEdit(List<Map<String, String>> mapList, List<SaleOrderDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleOrderDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleOrderDetail detail = (SaleOrderDetail) HttpUtils.pageData2Entity(mapObject, new SaleOrderDetail());

            //orderCount 订单订购数量 := 货品数量(计价数量)
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (detail.getOrderCount() != null) {
                orderCount = detail.getOrderCount();
            }
            //orderCount:订购数量(计价数量)
            detail.setOrderCount(orderCount);
            //priceCount 货品数量(计价数量)
            detail.setPriceCount(orderCount);

            //计价转换计量单位 数量转换公式 p2nFormula
            String p2nFormula = mapObject.get("p2nFormula");
            BigDecimal valueBig = BigDecimal.valueOf(0D);
            //P(计价单位) --> N(计量单位)
            if (p2nFormula != null && p2nFormula.trim().length() > 0) {
                Map<String, Object> parmMap = new HashMap<String, Object>();
                parmMap.put("P", orderCount);
                valueBig = EvaluateUtil.formulaReckon(parmMap, p2nFormula);
            }
            //productCount:货品数量(计量数量)
            detail.setProductCount(valueBig);

            objectList.add(detail);
        }

        return objectList;
    }

    public String findProductIdsByDetailList(List<SaleOrderDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        for (SaleOrderDetail object : objectList) {
            String productId = object.getProductId();
            if (productId != null && productId.trim().length() > 0)  {
                strBuf.append(productId.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strTemp;
    }

    public SaleDeliverDetail orderDetail2DeliverDetail(SaleOrderDetailEntity orderDetail, SaleDeliverDetail deliverDetail) {
        if (deliverDetail == null) {deliverDetail = new SaleDeliverDetail();}
        if (orderDetail == null) {return deliverDetail;}

        //orderId 订单ID
        deliverDetail.setOrderId(orderDetail.getParentId());
        //orderDetaiId 订单明细ID
        deliverDetail.setOrderDetaiId(orderDetail.getId());
        //productId货品ID
        deliverDetail.setProductId(orderDetail.getProductId());
        //orderUnit订单明细单位id
        deliverDetail.setOrderUnit(orderDetail.getOrderUnit());

        //orderCount 发货数量(订单单位)
        deliverDetail.setOrderCount(BigDecimal.valueOf(0D));
        if (orderDetail.getNeedDeliverCount() != null) {
            deliverDetail.setOrderCount(orderDetail.getNeedDeliverCount());
        }

        //priceUnit计价单位id
        deliverDetail.setPriceUnit(orderDetail.getPriceUnit());

        deliverDetail.setRemark(orderDetail.getDeliverDtlRemark());

        //productPrice 货品单价
        deliverDetail.setProductPrice(BigDecimal.valueOf(0D));
        if (orderDetail.getProductPrice() != null) {
            deliverDetail.setProductPrice(orderDetail.getProductPrice());
        }
        //priceCount 货品数量(计价数量) --> 本次发货数量(计价单位)
        deliverDetail.setPriceCount(BigDecimal.valueOf(0D));
        if (orderDetail.getPriceCount() != null) {
            deliverDetail.setPriceCount(orderDetail.getPriceCount());
        }

        //sum 发货金额 := 货品单价 * 发货数量
        //四舍五入到2位小数
        BigDecimal sum = BigDecimal.valueOf(deliverDetail.getProductPrice().doubleValue() * deliverDetail.getPriceCount().doubleValue());
        sum = sum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        deliverDetail.setSum(sum);

        return deliverDetail;
    }

    public List<SaleDeliverDetail> orderDtlList2DeliverDtllList(List<SaleOrderDetailEntity> orderDtlList, List<SaleDeliverDetail> deliverDtlList) {
        if (deliverDtlList == null) {deliverDtlList = new ArrayList<SaleDeliverDetail>();}
        if (orderDtlList == null || orderDtlList.size() == 0) {return deliverDtlList;}

        for (SaleOrderDetailEntity orderDtl : orderDtlList) {
            SaleDeliverDetail deliverDtl = this.orderDetail2DeliverDetail(orderDtl, null);
            deliverDtlList.add(deliverDtl);
        }

        return deliverDtlList;
    }

    public WarehouseOutDetail orderDetail2OutDetail(SaleOrderDetailEntity orderDetail, WarehouseOutDetail outDetail) {
        if (outDetail == null) {outDetail = new WarehouseOutDetail();}
        if (orderDetail == null) {return outDetail;}

        //productId 产品ID
        outDetail.setProductId(orderDetail.getProductId());
        //count 出库数量 (订单明细 计量单位数量)
        outDetail.setCount(orderDetail.getProductCount());
        //businessId 业务id(订单明细id)
        outDetail.setBusinessId(orderDetail.getId());

        return outDetail;
    }

    public List<WarehouseOutDetail> orderDtlList2OutDtlList(List<SaleOrderDetailEntity> orderDtlList, List<WarehouseOutDetail> outDtlList) {
        if (outDtlList == null) {outDtlList = new ArrayList<WarehouseOutDetail>();}
        if (orderDtlList == null || orderDtlList.size() == 0) {return outDtlList;}

        for (SaleOrderDetailEntity orderDtl : orderDtlList) {
            WarehouseOutDetail outDetail = this.orderDetail2OutDetail(orderDtl, null);
            outDtlList.add(outDetail);
        }

        return outDtlList;
    }

    public SaleInvoiceDetail orderDetail2InvoiceDetail(SaleOrderDetail orderDetail, SaleInvoiceDetail invoiceDetail) {
        if (invoiceDetail == null) {invoiceDetail = new SaleInvoiceDetail();}
        if (orderDetail == null) {return invoiceDetail;}

        invoiceDetail.setOrderDetaiId(orderDetail.getId());
        invoiceDetail.setProductId(orderDetail.getProductId());
        invoiceDetail.setPriceUnit(orderDetail.getPriceUnit());

        //productPrice 货品单价
        invoiceDetail.setProductPrice(BigDecimal.valueOf(0D));
        if (orderDetail.getProductPrice() != null) {
            invoiceDetail.setProductPrice(orderDetail.getProductPrice());
        }
        //count 开票数量
        invoiceDetail.setCount(BigDecimal.valueOf(0D));
        if (orderDetail.getOrderCount() != null) {
            invoiceDetail.setCount(orderDetail.getOrderCount());
        }
        //sum 发票金额 := 货品单价 * 开票数量
        //四舍五入到2位小数
        BigDecimal sum = BigDecimal.valueOf(invoiceDetail.getProductPrice().doubleValue() * invoiceDetail.getCount().doubleValue());
        sum = sum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        invoiceDetail.setSum(sum);

        return invoiceDetail;
    }
    public List<SaleInvoiceDetail> orderDtlList2InvoiceDtlList(List<SaleOrderDetail> orderDtlList, List<SaleInvoiceDetail> invoiceDtlList) {
        if (invoiceDtlList == null) {invoiceDtlList = new ArrayList<SaleInvoiceDetail>();}
        if (orderDtlList == null || orderDtlList.size() == 0) {return invoiceDtlList;}

        for (SaleOrderDetail orderDtl : orderDtlList) {
            SaleInvoiceDetail invoiceDetail = this.orderDetail2InvoiceDetail(orderDtl, null);
            invoiceDtlList.add(invoiceDetail);
        }

        return invoiceDtlList;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addSaleOrderDetail(SaleOrder parentObj, List<SaleOrderDetail> objectList) throws Exception {
        if (parentObj == null) {return;}
        if (objectList == null || objectList.size() == 0) {return;}

        for (SaleOrderDetail detail : objectList) {
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());

            //计价类型(1:先计价 2:后计价)
            if (parentObj.getPriceType() != null && "2".equals(parentObj.getPriceType().trim())) {
                //计价单位id
                detail.setPriceUnit(null);
                //货品数量(计价数量)
                detail.setPriceCount(BigDecimal.valueOf(0D));
                //货品单价
                detail.setProductPrice(BigDecimal.valueOf(0D));
                //货品金额(订购数量 * 货品单价)
                detail.setProductSum(BigDecimal.valueOf(0D));
            }

            this.save(detail);
        }
    }

    public void updateStateByDetail(PageData pd) throws Exception {
        saleOrderDetailMapper.updateStateByDetail(pd);
    }

    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", "parent_id in (" + parentIds + ")");

        saleOrderDetailMapper.updateStateByDetail(pageData);
    }

    public void updateLockCount(PageData pd) throws Exception {
        saleOrderDetailMapper.updateLockCount(pd);
    }

    /**
     * 根据订单明细状态-反写订单状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
     *
     * @param parent       订单对象
     * @param dtlList      订单明细List<SaleOrderDetail>
     */
    public void updateParentStateByDetailList(SaleOrder parent, List<SaleOrderDetail> dtlList) throws Exception {
        if (parent == null) {return;}
        if (parent.getId() == null || parent.getId().trim().length() == 0) {return;}

        if (dtlList == null) {
            dtlList = this.findSaleOrderDetailListByParentId(parent.getId());
        }

        if (dtlList.size() == 0) {
            saleOrderService.deleteById(parent.getId());
        } else {
            //获取订单状态-根据订单明细状态
            //String parentState = this.findParentStateByDetailList(dtlList);
            //parent.setState(parentState);
            parent = this.findParentStateByDetailList(parent, dtlList);
            saleOrderService.update(parent);
        }
    }

    public BigDecimal findTotalSumByDetailList(List<SaleOrderDetail> objectList) {
        double totalSum_double = 0D;
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        for (SaleOrderDetail detail : objectList) {
            //订购数量(计价数量)
            double count_double = 0D;
            if (detail.getOrderCount() != null) {
                count_double = detail.getOrderCount().doubleValue();
            }

            //货品单价
            double productPrice_double = 0D;
            if (detail.getProductPrice() != null) {
                productPrice_double = detail.getProductPrice().doubleValue();
            }

            //货品金额(货品金额:=订购数量 * 货品单价)
            BigDecimal productSum = BigDecimal.valueOf(count_double * productPrice_double);
            //四舍五入到2位小数
            productSum = productSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setProductSum(productSum);

            totalSum_double = totalSum_double + (count_double * productPrice_double);
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal findTotalSumByPrice(List<SaleOrderDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        double totalSum_double = 0D;
        for (SaleOrderDetail detail : objectList) {

            //productSum 货品金额(订购数量 * 货品单价)
            double productSum_double = 0D;
            if (detail.getProductSum() != null) {
                productSum_double = detail.getProductSum().doubleValue();
            }

            totalSum_double = totalSum_double + productSum_double;
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 订单明细状态，在订单明细List<SaleOrderDetail>中是否全部相同
     *   true : 全部相同，在订单明细List
     *   false: 一条或多条不同，在订单明细List
     *
     * @param state       明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
     * @param objectList  订单明细List<SaleOrderDetail>
     * @return
     */
    public boolean isAllExistStateByDetailList(String state, List<SaleOrderDetail> objectList) {
        if (state == null || state.trim().length() == 0) {return false;}
        if (objectList == null || objectList.size() == 0) {return false;}

        for (SaleOrderDetail detail : objectList) {
            String dtl_state = detail.getState();
            if (dtl_state == null || dtl_state.trim().length() == 0) {return false;}
            if (!state.trim().equals(dtl_state.trim())) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取订单状态-根据订单明细状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
     *
     * @param dtlList      订单明细List<SaleOrderDetail>
     * @return
     */
    public String findParentStateByDetailList(List<SaleOrderDetail> dtlList) {
        String parentState = new String("0");
        if (dtlList == null || dtlList.size() == 0) {return parentState;}

        //1. 验证订单状态(4:已完成) --> 全部明细状态 (6:已完成) -- 忽视状态(-1:已取消)
        String checkDtlState = "6";
        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
            return "4";
        }

        //2. 验证订单状态(3:已发货) --> 全部明细状态 (5:已发货) -- 忽视状态(-1:已取消)
        checkDtlState = "5";
        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
            return "3";
        }

        //3. 验证订单状态(-1:已取消) --> 全部明细状态 (-1:已取消) -- 忽视状态 null
        checkDtlState = "-1";
        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
            return "-1";
        }

        return parentState;
    }

    /**
     * 获取订单状态-根据订单明细状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:已发货 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
     *
     * @param dtlList      订单明细List<SaleOrderDetail>
     * @return
     */
    public SaleOrder findParentStateByDetailList(SaleOrder parent, List<SaleOrderDetail> dtlList) {
        if (parent == null) {return null;}
        if (dtlList == null || dtlList.size() == 0) {return null;}

        //1. 验证订单状态(4:已完成) --> 全部明细状态 (6:已完成) -- 忽视状态(-1:已取消)
        String checkDtlState = "6";
        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
            parent.setState("4");
            return parent;
        }

        //2. 验证订单状态(3:已发货) --> 全部明细状态 (5:已发货) -- 忽视状态(-1:已取消)
        checkDtlState = "5";
        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
            parent.setState("3");
            parent.setDeliverDate(new Date());
            return parent;
        }

        //3. 验证订单状态(-1:已取消) --> 全部明细状态 (-1:已取消) -- 忽视状态 null
        checkDtlState = "-1";
        if (this.isAllExistStateByDetailList(checkDtlState, dtlList)) {
            parent.setState("-1");
            return parent;
        }

        return parent;
    }

    @Override
    public ResultModel listPageSaleOrderDetail(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleOrderDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        //添加订单明细界面使用该参数
        String type = pd.getString("type");
        if ("add".equals(type)) {
            pd.put("queryStr", "1=2");
        }

        //订单明细 ids
        String ids = pd.getString("ids");
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            pd.put("ids", ids);
        }

        //设置查询排序
        pd.put("orderStr", "detail.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }

        //遍历结果集
        //(计量单位)(库存数量,库存可用数量) 单位换算公式(n2pFormula) (计价单位)(库存数量,库存可用数量)
        for (Map mapObject : varMapList) {
            //n2pFormula (计量单位转换计价单位公式)
            String n2pFormula = (String)mapObject.get("n2pFormula");

            //stockCount (计量单位)库存数量
            String stockCount_str = (String)mapObject.get("stockCount");
            //stockCountByPrice        (计价单位)库存数量
            if (n2pFormula != null && stockCount_str != null) {
                Map<String, Object> formulaParmMap = new HashMap<String, Object>();
                formulaParmMap.put("N", new BigDecimal(stockCount_str));

                BigDecimal valueBig = EvaluateUtil.formulaReckon(formulaParmMap, n2pFormula);
                mapObject.put("stockCountByPrice", valueBig);
            }

            //productStockCount (计量单位)库存可用数量
            String productStockCount_str = (String)mapObject.get("productStockCount");
            //productStockCountByPrice (计价单位)库存可用数量
            if (n2pFormula != null && productStockCount_str != null) {
                Map<String, Object> formulaParmMap = new HashMap<String, Object>();
                formulaParmMap.put("N", new BigDecimal(productStockCount_str));

                BigDecimal valueBig = EvaluateUtil.formulaReckon(formulaParmMap, n2pFormula);
                mapObject.put("productStockCountByPrice", valueBig);
            }
        }

        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel cancelSaleOrderDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细id为空或空字符串！");
            return model;
        }

        SaleOrderDetail detail = this.findSaleOrderDetailById(detailId);
        //明细状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        if (detail.getState() != null && "1,2,3,4,5".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前订单明细不可取消，该订单明细状态(1:待审核 2:待出库 3:待发货 4:已发货 5:已完成)！");
            return model;
        }

        SaleOrder order = saleOrderService.findSaleOrderById(detail.getParentId());
        //订单状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        if (order != null && order.getState() != null && "1,2,3,4,5".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该订单已经(1:待审核 2:待出库 3:待发货 4:已发货 5:已完成)！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已发货 6:已完成 -1:已取消)
        detail.setState("-1");
        this.update(detail);

        //2.返写订单状态
        //获取订单状态-根据订单明细状态 -- 忽视状态(-1:已取消)
        if (order != null) {
            this.updateParentStateByDetailList(order, null);
        }

        return model;
    }

    @Override
    public ResultModel deleteSaleOrderDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细id为空或空字符串！");
            return model;
        }

        SaleOrderDetail detail = this.findSaleOrderDetailById(detailId);
        String checkState = detail.getState();
        if ("-1".equals(checkState)) {checkState = "c";}

        //订单状态(0:待提交 1:待审核 2:待出库 3:待发货 4:已发货 5:已完成 -1:已取消)
        if (checkState != null && "1,2,3,4,5".indexOf(checkState.trim()) != -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该订单明细状态(1:待审核 2:待出库 3:待发货 4:已发货 5:已完成)！");
            return model;
        }


        //1. 删除入库明细
        this.deleteById(detailId);

        //2.返写订单状态
        //获取订单状态-根据订单明细状态 -- 忽视状态(-1:已取消)
        SaleOrder order = saleOrderService.findSaleOrderById(detail.getParentId());
        if (order != null) {
            this.updateParentStateByDetailList(order, null);
        }

        return model;
    }

    @Override
    public void exportExcelSaleOrderDetails(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("saleOrderDetail");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        pg.setSize(100000);
        List<Map> dataList = this.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelSaleOrderDetail";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelSaleOrderDetails(MultipartFile file) throws Exception {
        ResultModel model = new ResultModel();
        //HttpServletRequest Request = HttpUtils.currentRequest();

        if (file == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请上传Excel文件！");
            return model;
        }

        // 验证文件是否合法
        // 获取上传的文件名(文件名.后缀)
        String fileName = file.getOriginalFilename();
        if (fileName == null
                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
                || fileName.matches("^.+\\.(?i)(xls)$"))
                ) {
            String failMesg = "不是excel格式文件,请重新选择！";
            model.putCode(Integer.valueOf(1));
            model.putMsg(failMesg);
            return model;
        }

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        return model;
    }
}



