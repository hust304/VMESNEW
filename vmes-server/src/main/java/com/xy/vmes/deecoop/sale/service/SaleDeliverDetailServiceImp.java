package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleDeliverDetailMapper;
import com.xy.vmes.entity.SaleDeliver;
import com.xy.vmes.entity.SaleDeliverDetail;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.service.SaleDeliverDetailService;
import com.xy.vmes.service.WarehouseOutDetailService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_sale_deliver_detail:发货明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-12-15
*/
@Service
@Transactional(readOnly = false)
public class SaleDeliverDetailServiceImp implements SaleDeliverDetailService {

    @Autowired
    private SaleDeliverDetailMapper saleDeliverDetailMapper;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

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
        return saleDeliverDetailMapper.getDataListPage(pd,pg);
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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public BigDecimal findTotalSumByDetailList(List<SaleDeliverDetail> objectList) {
        double totalSum_double = 0D;
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        for (SaleDeliverDetail detail : objectList) {
            //发货数量
            double count_double = 0D;
            if (detail.getCount() != null) {
                count_double = detail.getCount().doubleValue();
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

    public void addDeliverDetail(SaleDeliver parentObj, List<SaleDeliverDetail> detailList, Map<String, String> orderDtl2OutDtlMap) throws Exception {
        if (parentObj == null) {return;}
        if (detailList == null || detailList.size() == 0) {return;}

        for (SaleDeliverDetail detail : detailList) {
            //state:状态(0:待发货 1:已发货 -1:已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());

            //订单明细id
            String orderDtlId = detail.getOrderDetaiId();
            if (orderDtl2OutDtlMap.get(orderDtlId) != null) {
                detail.setOutDetailId(orderDtl2OutDtlMap.get(orderDtlId));
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
//    public Boolean checkIsAllOutByDeliverId(String deliverId) throws ApplicationException {
//        if (deliverId == null || deliverId.trim().length() == 0) {
//            throw new ApplicationException("发货单id为空或空字符串");
//        }
//
//        PageData findMap = new PageData();
//        findMap.put("deliverId", deliverId);
//        List<Map<String, Object>> mapList = saleDeliverDetailMapper.findDeliverDetailByOutDetail(findMap);
//        if (mapList == null || mapList.size() ==0) {return null;}
//
//        for (Map<String, Object> mapObject : mapList) {
//            //outDtlState 出库明细状态
//            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
//            String outDtlState = (String)mapObject.get("outDtlState");
//            if (!"2".equals(outDtlState)) {
//                return Boolean.FALSE;
//            }
//        }
//
//        return Boolean.TRUE;
//    }

    /**
     * 发货单取消
     * 清除订单明细与发货明细的关联关系(vmes_sale_order_detail.deliver_detail_id)
     *
     * @param deliverId 发货单id
     */
    public void updateOrderDetailByCancelDeliver(String deliverId) {
        if (deliverId == null || deliverId.trim().length() == 0) {
            return;
        }

        PageData pageData = new PageData();
        pageData.put("deliverId", deliverId);
        saleDeliverDetailMapper.updateOrderDetailByCancelDeliver(pageData);
    }

    /**
     * 验证出库单明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
     *
     * @param deliverId 发货单id
     * @return
     */
    public String checkOutDetailStateByCancelDeliver(String deliverId) throws Exception {
        if (deliverId == null || deliverId.trim().length() == 0) {return new String();}

        PageData findMap = new PageData();
        findMap.put("isNeedDeliver", "true");
        findMap.put("deliverId", deliverId);
        //出库单明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        findMap.put("queryStr", "state in ('1','2')");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<WarehouseOutDetail> outDetailLiset = warehouseOutDetailService.dataList(findMap);
        if (outDetailLiset != null && outDetailLiset.size() > 0) {
            return new String("当前发货单含有出库(执行中,已完成)，不可取消发货单");
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
}



