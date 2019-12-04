package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.service.*;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleDeliverDetailMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.ApplicationException;
import com.yvan.*;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
* 说明：vmes_sale_deliver_detail:发货明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-12-15
*/
@Service
@Transactional(readOnly = false)
public class SaleDeliverDetailServiceImp implements SaleDeliverDetailService {

    @Autowired
    private SaleDeliverService saleDeliverService;
    @Autowired
    private SaleDeliverDetailMapper saleDeliverDetailMapper;

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private ColumnService columnService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-12-15
    */
    @Override
    public void save(SaleDeliverDetail saleDeliverDetail) throws Exception{
        saleDeliverDetail.setId(Conv.createUuid());
        saleDeliverDetail.setCdate(new Date());
        saleDeliverDetail.setUdate(new Date());
        saleDeliverDetailMapper.insert(saleDeliverDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public SaleDeliverDetail selectById(String id) throws Exception{
        return saleDeliverDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<SaleDeliverDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleDeliverDetail> warehouseCheckDetailList =  saleDeliverDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void update(SaleDeliverDetail object) throws Exception{
        object.setUdate(new Date());
        saleDeliverDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void updateAll(SaleDeliverDetail object) throws Exception{
        object.setUdate(new Date());
        saleDeliverDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleDeliverDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleDeliverDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleDeliverDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleDeliverDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<SaleDeliverDetail> dataList(PageData pd) throws Exception{
        return saleDeliverDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleDeliverDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleDeliverDetailMapper.getDataListPage(pd,pg);
        }

        return mapList;
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
    public List<SaleDeliverDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleDeliverDetail>();
        }

        return this.dataList(pageData);
    }

    public SaleDeliverDetail findSaleDeliverDetail(PageData object) throws Exception {
        List<SaleDeliverDetail> objectList = this.findSaleDeliverDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleDeliverDetail findSaleDeliverDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleDeliverDetail(findMap);
    }

    public List<SaleDeliverDetail> findSaleDeliverDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<SaleDeliverDetail> findSaleDeliverDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("orderStr", "order_id asc");

        return this.findSaleDeliverDetailList(findMap);
    }

    public List<SaleDeliverDetail> mapList2DetailList(List<Map<String, String>> mapList, List<SaleDeliverDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleDeliverDetail>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleDeliverDetail detail = (SaleDeliverDetail) HttpUtils.pageData2Entity(mapObject, new SaleDeliverDetail());
            objectList.add(detail);
        }

        return objectList;
    }

    /**
     * model_code = 'saleOrderDetailQueryByDeliver'
     * 1. 本次发货数量(计价单位)
     * 2. 公式:P(计价单位) 转换 N(计量单位)
     * 3. count:订购数量(计价数量) -- 本次发货数量(计价单位)
     *    productCount:货品数量(计量数量) --本次发货数量(计量单位)
     *
     * @param mapList
     * @param objectList
     * @return
     */
    public List<SaleOrderDetailEntity> mapList2OrderDetailList(List<Map<String, String>> mapList, List<SaleOrderDetailEntity> objectList) {
        if (objectList == null) {objectList = new ArrayList<SaleOrderDetailEntity>();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            SaleOrderDetailEntity detail = (SaleOrderDetailEntity) HttpUtils.pageData2Entity(mapObject, new SaleOrderDetailEntity());

            //orderDtlDeliverCount (计价单位)本次发货数量
            BigDecimal orderDtlDeliverCount = BigDecimal.valueOf(0D);
            if (detail.getOrderDtlDeliverCount() != null ) {
                orderDtlDeliverCount = detail.getOrderDtlDeliverCount();
            }
            //priceCount 货品数量(计价数量) --> 本次发货数量(计价单位)
            detail.setPriceCount(orderDtlDeliverCount);

            //productCount:货品数量(计量数量) --> 本次发货数量(计量单位)
            detail.setProductCount(BigDecimal.valueOf(0D));
            //pnFormula 计价单位转换计量单位
            String pnFormula = mapObject.get("pnFormula");
            //P(计价单位) --> N(计量单位)
            BigDecimal valueBig = EvaluateUtil.countFormulaP2N(orderDtlDeliverCount, pnFormula);
            if (valueBig != null) {
                detail.setProductCount(valueBig);
            }

            objectList.add(detail);
        }

        return objectList;
    }

    /**
     * 返回货品出库Map
     * 货品出库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     *
     * @param dtlEntityList
     * @return
     */
    public Map<String, Map<String, Object>> findProductMapByOut(List<SaleOrderDetailEntity> dtlEntityList) {
        Map<String, Map<String, Object>> productByOutMap = new HashMap<String, Map<String, Object>>();
        if (dtlEntityList == null || dtlEntityList.size() == 0) {return productByOutMap;}

        for (SaleOrderDetailEntity dtlObject : dtlEntityList) {
            String productId = dtlObject.getProductId();

            //productCount:货品数量(计量数量) := outCount 出库数量
            BigDecimal productCount = BigDecimal.valueOf(0D);
            if (dtlObject.getProductCount() != null) {
                productCount = dtlObject.getProductCount();
            }
            //四舍五入到2位小数
            productCount = productCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("outDtlId", null);
            productMap.put("outCount", productCount);

            productByOutMap.put(productId, productMap);
        }

        return productByOutMap;
    }

    /**
     * 返回货品出库Map
     * 业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     *
     * @param dtlEntityList
     * @return
     */
    public Map<String, Map<String, Object>> findProductBusinessMapByOut(List<SaleOrderDetailEntity> dtlEntityList) {
        Map<String, Map<String, Object>> prodBusinessByOutMap = new HashMap<String, Map<String, Object>>();
        if (dtlEntityList == null || dtlEntityList.size() == 0) {return prodBusinessByOutMap;}

        for (SaleOrderDetailEntity dtlObject : dtlEntityList) {
            //id:销售订单明细id
            String id = dtlObject.getId();
            String productId = dtlObject.getProductId();

            //productCount:货品数量(计量数量) := outCount 出库数量
            BigDecimal productCount = BigDecimal.valueOf(0D);
            if (dtlObject.getProductCount() != null) {
                productCount = dtlObject.getProductCount();
            }
            //四舍五入到2位小数
            productCount = productCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("outDtlId", null);
            productMap.put("outCount", productCount);

            prodBusinessByOutMap.put(id, productMap);
        }

        return prodBusinessByOutMap;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public BigDecimal findTotalSumByDetailList(List<SaleDeliverDetail> objectList) {
        double totalSum_double = 0D;
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        for (SaleDeliverDetail detail : objectList) {
            //price_count:发货数量(计价数量)
            double count_double = 0D;
            if (detail.getPriceCount() != null) {
                count_double = detail.getPriceCount().doubleValue();
            }

            //货品单价
            double productPrice_double = 0D;
            if (detail.getProductPrice() != null) {
                productPrice_double = detail.getProductPrice().doubleValue();
            }

            totalSum_double = totalSum_double + (count_double * productPrice_double);
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

//    public void addDeliverDetail(SaleDeliver parentObj, List<SaleDeliverDetail> detailList, Map<String, Map<String, Object>> productByOutMap) throws Exception {
//        if (parentObj == null) {return;}
//        if (detailList == null || detailList.size() == 0) {return;}
//
//        for (SaleDeliverDetail detail : detailList) {
//            //state:状态(0:待发货 1:已发货 -1:已取消)
//            detail.setState("0");
//            detail.setParentId(parentObj.getId());
//            detail.setCuser(parentObj.getCuser());
//
//            //productId 货品id
//            String productId = detail.getProductId();
//            if (productByOutMap != null && productByOutMap.get(productId) != null) {
//                Map<String, Object> productMap = productByOutMap.get(productId);
//                //outDtlId:  出库明细id
//                String outDtlId = new String();
//                if (productMap != null && productMap.get("outDtlId") != null) {
//                    outDtlId = (String)productMap.get("outDtlId");
//                }
//                detail.setOutDetailId(outDtlId);
//            }
//
//            //priceType 计价类型(1:先计价 2:后计价)
//            if ("2".equals(parentObj.getPriceType())) {
//                detail.setPriceUnit(null);
//                detail.setPriceCount(BigDecimal.valueOf(0D));
//                detail.setProductPrice(BigDecimal.valueOf(0D));
//                detail.setSum(BigDecimal.valueOf(0D));
//            }
//
//            this.save(detail);
//        }
//    }
    public void addDeliverDetailByBusinessMap(SaleDeliver parentObj, List<SaleDeliverDetail> detailList, Map<String, Map<String, Object>> productBusinessByOutMap) throws Exception {
        if (parentObj == null) {return;}
        if (detailList == null || detailList.size() == 0) {return;}

        for (SaleDeliverDetail detail : detailList) {
            //state:状态(0:待发货 1:已发货 -1:已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());

            //productId 货品id
            String productId = detail.getProductId();

            //orderDetaiId 订单明细ID
            String orderDetaiId = detail.getOrderDetaiId();

            if (productBusinessByOutMap != null && productBusinessByOutMap.get(orderDetaiId) != null) {
                Map<String, Object> productMap = productBusinessByOutMap.get(orderDetaiId);
                //outDtlId:  出库明细id
                String outDtlId = new String();
                if (productMap != null && productMap.get("outDtlId") != null) {
                    outDtlId = (String)productMap.get("outDtlId");
                }
                detail.setOutDetailId(outDtlId);
            }

            //priceType 计价类型(1:先计价 2:后计价)
            if ("2".equals(parentObj.getPriceType())) {
                detail.setPriceUnit(null);
                detail.setPriceCount(BigDecimal.valueOf(0D));
                detail.setProductPrice(BigDecimal.valueOf(0D));
                detail.setSum(BigDecimal.valueOf(0D));
            }

            this.save(detail);
        }
    }

    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", "parent_id in (" + parentIds + ")");

        saleDeliverDetailMapper.updateStateByDetail(pageData);
    }

    /**
     * 获取订单id的发货金额 Map<订单id, 发货金额>
     *
     * @param deliverId   发货单id
     * @param detailList  发货明细
     *
     * @return
     *     Map<订单id, 发货金额>
     */
    public Map<String, BigDecimal> findOrderDeliverSumByDeliverId(String deliverId, List<SaleDeliverDetail> detailList) throws Exception {
        if (deliverId == null || deliverId.trim().length() == 0) {return null;}
        if (detailList == null) {
            detailList = this.findSaleDeliverDetailListByParentId(deliverId);
        }

        Map<String, List<SaleDeliverDetail>> orderDeliverDtlMap = new HashMap<String, List<SaleDeliverDetail>>();
        if (detailList == null || detailList.size() == 0) {return null;}

        for (SaleDeliverDetail detail : detailList) {
            String orderId = detail.getOrderId();

            List<SaleDeliverDetail> mapList = orderDeliverDtlMap.get(orderId);
            if(mapList == null) {
                mapList = new ArrayList<SaleDeliverDetail>();
                orderDeliverDtlMap.put(orderId, mapList);
            }
            mapList.add(detail);
        }

        Map<String, BigDecimal> orderDeliverSumMap = new HashMap<String, BigDecimal>();
        for (Iterator iterator = orderDeliverDtlMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String)iterator.next();

            List<SaleDeliverDetail> deliverDtlList = orderDeliverDtlMap.get(mapKey);
            BigDecimal deliverSum = this.findTotalSumByDetailList(deliverDtlList);

            orderDeliverSumMap.put(mapKey, deliverSum);
        }

        return orderDeliverSumMap;
    }

    ////////////////////////////////////////////////////////////////////////////////

    /**
     * 验证发货单明细是否全部完成出库
     *
     * @param deliverId 发货单id
     * @return
     *  Boolean.TRUE  全部出库完成
     *  Boolean.FALSE 一条或多条出库未完成
     *  is null 无出库明细
     */
    public Boolean checkIsAllOutByDeliverId(String deliverId) throws ApplicationException {
        if (deliverId == null || deliverId.trim().length() == 0) {
            throw new ApplicationException("发货单id为空或空字符串");
        }

        PageData findMap = new PageData();
        findMap.put("deliverId", deliverId);
        List<Map<String, Object>> mapList = saleDeliverDetailMapper.findDeliverDetailByOutDetail(findMap);
        if (mapList == null || mapList.size() ==0) {return null;}

        for (Map<String, Object> mapObject : mapList) {
            //outDtlState 出库明细状态
            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            String outDtlState = (String)mapObject.get("outDtlState");
            if (!"2".equals(outDtlState)) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    /**
     * 发货单取消
     * 清除订单明细与发货明细的关联关系(vmes_sale_order_detail.deliver_detail_id)
     *
     * @param deliverId 发货单id
     */
//    public void updateOrderDetailByCancelDeliver(String deliverId) {
//        if (deliverId == null || deliverId.trim().length() == 0) {
//            return;
//        }
//
//        PageData pageData = new PageData();
//        pageData.put("deliverId", deliverId);
//        saleDeliverDetailMapper.updateOrderDetailByCancelDeliver(pageData);
//    }

    /**
     * 验证出库单明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
     *
     * @param pageData 发货单id
     * @return
     */
    public String checkOutDetailStateByCancelDeliver(PageData pageData) throws Exception {
        String deliverId = pageData.getString("id");
        if (deliverId == null || deliverId.trim().length() == 0) {return new String();}

        PageData findMap = new PageData();
        findMap.put("isNeedDeliver", "true");
        findMap.put("deliverId", deliverId);
        //出库单明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        findMap.put("queryStr", "state in ('1','2')");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<WarehouseOutDetail> outDetailLiset = warehouseOutDetailService.dataList(findMap);
        if (outDetailLiset != null && outDetailLiset.size() > 0) {
            for(int i=0;i<outDetailLiset.size();i++){
                WarehouseOutDetail warehouseOutDetail = outDetailLiset.get(i);
                PageData pd = new PageData();
                pd.put("id", warehouseOutDetail.getId());
                pd.put("cuser", pageData.getString("currentUserId"));
                pd.put("currentCompanyId", pageData.getString("currentCompanyId"));
                pd.put("rebackBillReason", "销售出库退单");
                warehouseOutDetailService.rebackWarehouseOutDetail(pd);
            }
        }

        return new String();
    }

    /**
     * 获取出库单id字符串(','逗号分隔的字符串)，根据发货单id(发货明细表,出库明细表)关联查询
     *
     * @param deliverId
     * @return
     */
    public String findOutIdsByDeliverId(String deliverId) {
        if (deliverId == null || deliverId.trim().length() == 0) {return new String();}

        //1. 根据发货单id(发货明细表,出库明细表)关联查询
        PageData findMap = new PageData();
        findMap.put("deliverId", deliverId);
        List<Map<String, Object>> mapList = saleDeliverDetailMapper.findDeliverDetailByOutDetail(findMap);
        if (mapList == null || mapList.size() == 0) {return new String();}

        //2. 遍历查询结果集-将(出库单id)放入Map<出库单id, 出库单id>
        Map<String, String> idMap = new LinkedHashMap<String, String>();
        for (Map<String, Object> mapObject : mapList) {
            String outParentId = (String)mapObject.get("outParentId");
            if (outParentId != null && outParentId.trim().length() > 0) {
                idMap.put(outParentId, outParentId);
            }
        }

        //3. 获取出库单id字符(','逗号分隔的字符串)--串遍历Map<出库单id, 出库单id>
        StringBuffer outIds = new StringBuffer();
        for (Iterator iterator = idMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            outIds.append(mapKey);
            outIds.append(",");
        }

        return outIds.toString();
    }

    public String findOrderDtlIdsByDeliverDtlList(List<SaleDeliverDetail> detailList) {
        if (detailList == null || detailList.size() == 0) {return new String();}

        StringBuffer orderDtlIds = new StringBuffer();
        for (SaleDeliverDetail detail : detailList) {
            if (detail.getOrderDetaiId() != null && detail.getOrderDetaiId().trim().length() > 0) {
                orderDtlIds.append(detail.getOrderDetaiId().trim() + ",");
            }

        }
        return orderDtlIds.toString();
    }

    public String findOutDetailIdsByDeliverDtlList(List<SaleDeliverDetail> detailList) {
        if (detailList == null || detailList.size() == 0) {return new String();}

        StringBuffer outDtlIds = new StringBuffer();
        for (SaleDeliverDetail detail : detailList) {
            if (detail.getOutDetailId() != null && detail.getOutDetailId().trim().length() > 0) {
                outDtlIds.append(detail.getOutDetailId().trim() + ",");
            }

        }
        return outDtlIds.toString();
    }

//    /**
//     * 发货明细状态，在发货明细List<SaleDeliverDetail>中是否全部相同
//     *   true : 全部相同，在发货明细List
//     *   false: 一条或多条不同，在发货明细List
//     *
//     * @param state       明细状态(0:待发货 1:已发货 -1:已取消)
//     * @param objectList  发货明细List<SaleDeliverDetail>
//     * @return
//     */
//    public boolean isAllExistStateByDetailList(String state, List<SaleDeliverDetail> objectList) {
//        if (state == null || state.trim().length() == 0) {return false;}
//        if (objectList == null || objectList.size() == 0) {return false;}
//
//        for (SaleDeliverDetail detail : objectList) {
//            String dtl_state = detail.getState();
//            if (dtl_state == null || dtl_state.trim().length() == 0) {return false;}
//            if (!state.trim().equals(dtl_state.trim())) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    /**
//     * 发货明细状态，在发货明细List<SaleDeliverDetail>中是否存在
//     *   true : 一条或多条相同，在发货明细List
//     *   false: 全部不同，在发货明细List
//     *
//     * @param state       明细状态(0:待发货 1:已发货 -1:已取消)
//     * @param objectList  发货明细List<SaleDeliverDetail>
//     * @return
//     */
//    public boolean isExistStateByDetailList(String state, List<SaleDeliverDetail> objectList) {
//        if (state == null || state.trim().length() == 0) {return false;}
//        if (objectList == null || objectList.size() == 0) {return false;}
//
//        for (SaleDeliverDetail detail : objectList) {
//            String dtl_state = detail.getState();
//            if (dtl_state != null && state.trim().equals(dtl_state.trim())) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    /**
     * 获取发货状态-根据发货明细状态
     * 发货单状态(0:待发货 1:已发货 -1:已取消)
     * 发货明细状态(0:待发货 1:已发货 -1:已取消)
     *
     * @param objectList      订单明细List<SaleDeliverDetail>
     * @return
     */
    public String findParentStateByDetailList(List<SaleDeliverDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return null;}

        //发货单明细(0:待发货 1:已发货 -1:已取消)
        int yqx = 0; //-1:已取消
        int dfh = 0; //0:待发货
        int yfh = 0; //1:已发货

        if (objectList != null && objectList.size() > 0) {
            for (SaleDeliverDetail detail : objectList) {
                if ("-1".equals(detail.getState())) {
                    yqx = yqx + 1;
                } else if ("0".equals(detail.getState())) {
                    dfh = dfh + 1;
                } else if ("1".equals(detail.getState())) {
                    yfh = yfh + 1;
                }
            }
        }

        String parentState = "0";
        //该发货单明细状态全是已取消状态，则说明当前货单单状态为已取消
        if(yqx > 0 && yfh == 0 && dfh == 0){
            //-1:已取消
            parentState = "-1";
        } else if(yfh > 0 && yqx >= 0 && dfh == 0){
            //1:已发货
            parentState = "1";
        }

        return parentState;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    public ResultModel listPageSaleDeliverDetail(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("saleDeliverDetail");
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

        //设置查询排序
        pd.put("orderStr", "detail.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd,pg);
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        //String priceType = pd.getString("priceType");
        for (Map<String, String> mapObject : varMapList) {
            //priceType 计价类型(1:先计价 2:后计价)
            String priceType = mapObject.get("priceType");
            if (!"2".equals(priceType)) {continue;}

            //orderCount 发货数量
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            String orderCount_str = mapObject.get("orderCount");
            if (orderCount_str != null && orderCount_str.trim().length() > 0) {
                try {
                    orderCount = new BigDecimal(orderCount_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //sum 发货金额
            BigDecimal sum = BigDecimal.valueOf(0D);
            String sum_str = mapObject.get("sum");
            if (sum_str != null && sum_str.trim().length() > 0) {
                try {
                    sum = new BigDecimal(sum_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //productPrice 货品单价 := 发货金额 / 发货数量
            mapObject.put("productPrice", "0.00");
            if (orderCount.doubleValue() != 0D && sum.doubleValue() != 0D) {
                BigDecimal productPrice = BigDecimal.valueOf(sum.doubleValue() / orderCount.doubleValue());
                //四舍五入到2位小数
                productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                mapObject.put("productPrice", productPrice.toString());

            }
        }

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel listPageSaleDeliverDetailByPrice(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("saleDeliverDetailByPrice");
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

        //设置查询排序
        pd.put("orderStr", "detail.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd, pg);
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);

        return model;
    }

    public ResultModel updateSaleDeliverDetailByPrice(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String deliverId = pageData.getString("deliverId");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一条发货明细数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 修改发货单明细价格
        List<SaleDeliverDetail> deliverDtlList = this.mapList2DetailList(mapList, null);
        for (SaleDeliverDetail deliverDtl : deliverDtlList) {
            //price_count:结算数量(计价数量)
            BigDecimal priceCount = BigDecimal.valueOf(0D);
            if (deliverDtl.getPriceCount() != null) {
                priceCount = deliverDtl.getPriceCount();
            }
            //productPrice 结算单价
            BigDecimal productPrice = BigDecimal.valueOf(0D);
            if (deliverDtl.getProductPrice() != null) {
                productPrice = deliverDtl.getProductPrice();
            }

            //sum 结算金额
            BigDecimal sum = BigDecimal.valueOf(priceCount.doubleValue() * productPrice.doubleValue());
            //四舍五入到2位小数
            sum = sum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            deliverDtl.setSum(sum);
            this.update(deliverDtl);
        }

        //2. 修改发货单价格
        BigDecimal totalSum = this.findTotalSumByDetailList(deliverDtlList);
        SaleDeliver saleDeliver = new SaleDeliver();
        saleDeliver.setId(deliverId);
        saleDeliver.setTotalSum(totalSum);
        saleDeliverService.update(saleDeliver);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //根据发货单id 拆分订单明细

        //根据(发货单id) 关联查询(vmes_sale_deliver_detail, vmes_sale_order_detail)
        //sql查询语句: SaleDeliverDetailMapper.getDataListPage
        PageData findMap = new PageData();
        findMap.put("parentId", deliverId);

        Map<String, String> orderIdMap = new HashMap();
        List<Map> mapValueList = this.getDataListPage(findMap, null);
        for (Map<String, Object> objectMap : mapValueList) {

            String orderId = (String)objectMap.get("orderId");
            orderIdMap.put(orderId, orderId);

            //根据发货单明细-拆分订单明细
            Map<String, SaleOrderDetail> valueMap = this.findSaleOrderDetailByChangeMap(objectMap);

            //   返回值:Map<String, SaleOrderDetail>
            //     editOrderDetail: 修改订单明细对象
            //     addOrderDetail:  添加订单明细对象
            if (valueMap != null) {
                SaleOrderDetail editOrderDetail = valueMap.get("editOrderDetail");
                if (editOrderDetail != null) {
                    saleOrderDetailService.update(editOrderDetail);
                }

                SaleOrderDetail addOrderDetail = valueMap.get("addOrderDetail");
                if (addOrderDetail != null) {
                    addOrderDetail.setCuser(cuser);
                    saleOrderDetailService.save(addOrderDetail);
                }
            }
        }

        //4. 反写订单金额
        if (orderIdMap.size() > 0) {
            for (Iterator iterator = orderIdMap.keySet().iterator(); iterator.hasNext();) {
                String orderId = (String)iterator.next();

                SaleOrder orderDB = saleOrderService.findSaleOrderById(orderId);
                List<SaleOrderDetail> detailList = saleOrderDetailService.findSaleOrderDetailListByParentId(orderId);

                //price_type:计价类型(1:先计价 2:后计价)
                if ("2".equals(orderDB.getPriceType())) {
                    //totalSum 合计金额
                    BigDecimal orderTotalSum = saleOrderDetailService.findTotalSumByPrice(detailList);

                    SaleOrder editOrder = new SaleOrder();
                    editOrder.setId(orderId);
                    //四舍五入到2位小数
                    orderTotalSum = orderTotalSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                    editOrder.setTotalSum(orderTotalSum);
                    editOrder.setOrderSum(orderTotalSum);
                    //discountSum 折扣金额
                    editOrder.setDiscountSum(BigDecimal.valueOf(0D));
                    saleOrderService.update(editOrder);
                }
            }
        }

        ////////////////////////////////////////////////////////////////////////////
//        //3. 销售订单明细(计价单位,货品金额,货品单价)
//        Map<String, String> orderIdMap = new HashMap<String, String>();
//        for (SaleDeliverDetail deliverDetail : deliverDtlList) {
//            String orderId = deliverDetail.getOrderId();
//            orderIdMap.put(orderId, orderId);
//
//            SaleOrderDetail orderDetail = new SaleOrderDetail();
//            String orderDetaiId = deliverDetail.getOrderDetaiId();
//            orderDetail.setId(orderDetaiId);
//
//            //计价单位id priceUnit --> 发货单明细:priceUnit 计价单位id
//            orderDetail.setPriceUnit(deliverDetail.getPriceUnit());
//
//            //订单明细货品金额 productSum --> 发货单明细:sum 结算金额
//            BigDecimal productSum = BigDecimal.valueOf(0D);
//            if (deliverDetail.getSum() != null) {
//                productSum = deliverDetail.getSum();
//                //四舍五入到2位小数
//                productSum = productSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            }
//            orderDetail.setProductSum(productSum);
//
//            //货品单价 productPrice --> 发货单明细:productPrice 结算单价
//            BigDecimal productPrice = BigDecimal.valueOf(0D);
//            if (deliverDetail.getProductPrice() != null) {
//                productPrice = deliverDetail.getProductPrice();
//                //四舍五入到2位小数
//                productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            }
//            orderDetail.setProductPrice(productPrice);
//
//            saleOrderDetailService.update(orderDetail);
//        }
//
//        //4. 反写订单金额
//        if (orderIdMap.size() > 0) {
//            for (Iterator iterator = orderIdMap.keySet().iterator(); iterator.hasNext();) {
//                String orderId = (String)iterator.next();
//
//                SaleOrder orderDB = saleOrderService.findSaleOrderById(orderId);
//                List<SaleOrderDetail> detailList = saleOrderDetailService.findSaleOrderDetailListByParentId(orderId);
//
//                //price_type:计价类型(1:先计价 2:后计价)
//                if ("2".equals(orderDB.getPriceType())) {
//                    //totalSum 合计金额
//                    BigDecimal orderTotalSum = saleOrderDetailService.findTotalSumByPrice(detailList);
//
//                    SaleOrder editOrder = new SaleOrder();
//                    editOrder.setId(orderId);
//                    //四舍五入到2位小数
//                    orderTotalSum = orderTotalSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                    editOrder.setTotalSum(orderTotalSum);
//                    editOrder.setOrderSum(orderTotalSum);
//                    //discountSum 折扣金额
//                    editOrder.setDiscountSum(BigDecimal.valueOf(0D));
//                    saleOrderService.update(editOrder);
//                }
//            }
//        }

        return model;
    }

//    public void exportExcelSaleDeliverDetails(PageData pd, Pagination pg) throws Exception {
//        List<Column> columnList = columnService.findColumnList("saleDeliverDetail");
//        if (columnList == null || columnList.size() == 0) {
//            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
//        }
//
//        //根据查询条件获取业务数据List
//        String ids = (String)pd.getString("ids");
//        String queryStr = "";
//        if (ids != null && ids.trim().length() > 0) {
//            ids = StringUtil.stringTrimSpace(ids);
//            ids = "'" + ids.replace(",", "','") + "'";
//            queryStr = "id in (" + ids + ")";
//        }
//        pd.put("queryStr", queryStr);
//
//        pg.setSize(100000);
//        List<Map> dataList = this.getDataListPage(pd, pg);
//
//        //查询数据转换成Excel导出数据
//        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
//        HttpServletResponse response = HttpUtils.currentResponse();
//
//        //查询数据-Excel文件导出
//        String fileName = pd.getString("fileName");
//        if (fileName == null || fileName.trim().length() == 0) {
//            fileName = "ExcelSaleDeliverDetail";
//        }
//
//        //导出文件名-中文转码
//        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
//        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
//    }

//    public ResultModel importExcelSaleDeliverDetails(MultipartFile file) throws Exception {
//        ResultModel model = new ResultModel();
//
//        if (file == null) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("请上传Excel文件！");
//            return model;
//        }
//
//        // 验证文件是否合法
//        // 获取上传的文件名(文件名.后缀)
//        String fileName = file.getOriginalFilename();
//        if (fileName == null
//                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
//                || fileName.matches("^.+\\.(?i)(xls)$"))
//                ) {
//            String failMesg = "不是excel格式文件,请重新选择！";
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(failMesg);
//            return model;
//        }
//
//        // 判断文件的类型，是2003还是2007
//        boolean isExcel2003 = true;
//        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            isExcel2003 = false;
//        }
//
//        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
//        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);
//
//        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
//        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
//        //3. Excel导入字段-名称唯一性判断-在Excel文件中
//        //4. Excel导入字段-名称唯一性判断-在业务表中判断
//        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
//        //6. 遍历List<业务表DB> 对业务表添加或修改
//
//        return model;
//    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 根据发货单明细-拆分订单明细
     * 该方法在后计价发货单结算时调用
     *
     *
     * 订购数量:10 发货数量:4
     * 拆分后订单:
     *   (修改后)订购数量:4
     *     (插入)订购数量:6
     *
     * @param objectMap  查询Map结构体
     * @return
     *   返回值:Map<String, SaleOrderDetail>
     *     editOrderDetail: 修改订单明细对象
     *     addOrderDetail:  添加订单明细对象
     *
     * @throws Exception
     */
    private Map<String, SaleOrderDetail> findSaleOrderDetailByChangeMap(Map<String, Object> objectMap) throws Exception {
        Map<String, SaleOrderDetail> valueMap = new HashMap<>();

        SaleOrderDetail editObject = this.findEditOrderDetail(objectMap);
        valueMap.put("editOrderDetail", editObject);

        SaleOrderDetail addObject = this.findAddOrderDetail(objectMap);
        valueMap.put("addOrderDetail", addObject);

        return valueMap;
    }

    /**
     * 参数Map结构体:
     * SQL查询: SaleDeliverDetailMapper.getDataListPage
     *
     * @param objectMap
     * @return
     */
    private SaleOrderDetail findEditOrderDetail(Map<String, Object> objectMap) {
        if (objectMap == null) {return null;}

        SaleOrderDetail editObject = new SaleOrderDetail();

        //订单明细id
        String orderDtlId = (String)objectMap.get("orderDetaiId");
        editObject.setId(orderDtlId);

        //发货数量(订单单位) deliverCount --> SaleOrderDetail.orderCount
        BigDecimal deliverCount = BigDecimal.valueOf(0D);
        if (objectMap.get("orderCount") != null) {
            deliverCount = (BigDecimal)objectMap.get("orderCount");
        }
        //订单明细-订购数量:= 发货数量(订单单位)
        editObject.setOrderCount(deliverCount);

        //单位转换公式: (计价转换计量)单位
        String p2nFormula = (String)objectMap.get("p2nFormula");
        //发货数量(计量数量)-productCountDeliver
        BigDecimal productCountDeliver = BigDecimal.valueOf(0D);

        //发货数量:(转换计量单位) P(计价单位) --> N(计量单位)
        if (p2nFormula != null && p2nFormula.trim().length() > 0) {
            productCountDeliver = EvaluateUtil.countFormulaP2N(deliverCount, p2nFormula);
        }

        //四舍五入到2位小数
        productCountDeliver = productCountDeliver.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        //订单明细-订购数量-货品数量:= 发货数量(计量单位)
        editObject.setProductCount(productCountDeliver);

        //////////////////////////////////////////////////////////////////////////////////////////////////
        //后计价:结算单位 结算数量 结算金额

        //结算单位 priceUnit --> SaleOrderDetail.priceUnit
        String priceUnit = (String)objectMap.get("priceUnit");
        editObject.setPriceUnit(priceUnit);

        //结算数量 priceCount --> SaleOrderDetail.priceCount
        BigDecimal priceCount = BigDecimal.valueOf(0D);
        if (objectMap.get("priceCount") != null) {
            priceCount = (BigDecimal)objectMap.get("priceCount");
        }
        editObject.setPriceCount(priceCount);

        //sum 结算金额 --> SaleOrderDetail.productSum
        BigDecimal sum = BigDecimal.valueOf(0D);
        if (objectMap.get("sum") != null) {
            sum = (BigDecimal)objectMap.get("sum");
        }
        editObject.setProductSum(sum);

        //计算货品单价 productPrice := 结算金额 / 订购数量
        BigDecimal productPrice = BigDecimal.valueOf(0D);
        if (editObject.getOrderCount() != null && editObject.getOrderCount().doubleValue() != 0D) {
            productPrice = BigDecimal.valueOf(sum.doubleValue() / editObject.getOrderCount().doubleValue());
        }
        //四舍五入到2位小数
        productPrice = productPrice.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        editObject.setProductPrice(productPrice);

        return editObject;
    }

    /**
     * 参数Map结构体:
     * SQL查询: SaleDeliverDetailMapper.getDataListPage
     *
     * @param objectMap
     * @return
     */
    private SaleOrderDetail findAddOrderDetail(Map<String, Object> objectMap) throws Exception {
        if (objectMap == null) {return null;}

        //订单明细id
        String orderDtlId = (String)objectMap.get("orderDetaiId");
        SaleOrderDetail orderDetailDB = saleOrderDetailService.findSaleOrderDetailById(orderDtlId);

        SaleOrderDetail addObject = new SaleOrderDetail();

        //订单明细订购数量(订单单位) orderDetailCount
        BigDecimal orderDetailCount = BigDecimal.valueOf(0D);
        if (objectMap.get("orderDetailCount") != null) {
            orderDetailCount = (BigDecimal)objectMap.get("orderDetailCount");
        }

        //发货数量(订单单位) deliverCount
        BigDecimal deliverCount = BigDecimal.valueOf(0D);
        if (objectMap.get("orderCount") != null) {
            deliverCount = (BigDecimal)objectMap.get("orderCount");
        }

        //订单明细-订购数量:= 订购数量 - 发货数量
        BigDecimal orderCountAdd = BigDecimal.valueOf(orderDetailCount.doubleValue() - deliverCount.doubleValue());

        //单位转换公式: (计价转换计量)单位
        String p2nFormula = (String)objectMap.get("p2nFormula");
        //订购数量:(转换计量单位) P(计价单位) --> N(计量单位)
        BigDecimal productCountAdd = BigDecimal.valueOf(0D);
        if (p2nFormula != null && p2nFormula.trim().length() > 0) {
            productCountAdd = EvaluateUtil.countFormulaP2N(orderCountAdd, p2nFormula);
        }
        //四舍五入到2位小数
        productCountAdd = productCountAdd.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        //订单明细-订购数量-货品数量(计量单位)
        addObject.setProductCount(productCountAdd);

        //订单明细-订购数量
        //四舍五入到2位小数
        orderCountAdd = orderCountAdd.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        addObject.setOrderCount(orderCountAdd);

        //订单ID parentId
        addObject.setParentId(orderDetailDB.getParentId());
        //state 明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
        addObject.setState("3");
        //附件地址 fileUrl
        addObject.setFileUrl(orderDetailDB.getFileUrl());
        //订单单位id orderUnit
        addObject.setOrderUnit(orderDetailDB.getOrderUnit());
        //计量单位id productUnit
        addObject.setProductUnit(orderDetailDB.getProductUnit());
        //计价单位id priceUnit
        //货品ID productId
        addObject.setProductId(orderDetailDB.getProductId());
        //生产计划明细ID planDetailId
        addObject.setPlanDetailId(orderDetailDB.getPlanDetailId());

        return addObject;
    }


}



