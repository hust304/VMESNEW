package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleWaresRetreatDetailMapper;
import com.xy.vmes.entity.SaleWaresRetreatDetail;
import com.xy.vmes.service.SaleWaresRetreatDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_sale_wares_retreat_detail:无订单退货明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-12-05
*/
@Service
@Transactional(readOnly = false)
public class SaleWaresRetreatDetailServiceImp implements SaleWaresRetreatDetailService {
    @Autowired
    private SaleWaresRetreatDetailMapper saleWaresRetreatDetailMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void save(SaleWaresRetreatDetail object) throws Exception {
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        saleWaresRetreatDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public SaleWaresRetreatDetail selectById(String id) throws Exception{
        return saleWaresRetreatDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public List<SaleWaresRetreatDetail> selectByColumnMap(Map columnMap) throws Exception {
        List<SaleWaresRetreatDetail> warehouseCheckDetailList = saleWaresRetreatDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void update(SaleWaresRetreatDetail object) throws Exception {
        object.setUdate(new Date());
        saleWaresRetreatDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateAll(SaleWaresRetreatDetail object) throws Exception {
        object.setUdate(new Date());
        saleWaresRetreatDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        saleWaresRetreatDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        saleWaresRetreatDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        saleWaresRetreatDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        saleWaresRetreatDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    public List<SaleWaresRetreatDetail> dataList(PageData pd) throws Exception {
        return saleWaresRetreatDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleWaresRetreatDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleWaresRetreatDetailMapper.getDataListPage(pd, pg);
        }

        return mapList;
    }
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
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
    public List<SaleWaresRetreatDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleWaresRetreatDetail>();
        }

        return this.dataList(pageData);
    }

    public SaleWaresRetreatDetail findWaresRetreatDetail(PageData object) throws Exception {
        List<SaleWaresRetreatDetail> objectList = this.findWaresRetreatDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleWaresRetreatDetail findWaresRetreatDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findWaresRetreatDetail(findMap);
    }

    public List<SaleWaresRetreatDetail> findWaresRetreatDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<SaleWaresRetreatDetail> findWaresRetreatDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findWaresRetreatDetailList(findMap);
    }

    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", parentIds);

        saleWaresRetreatDetailMapper.updateStateByDetail(pageData);
    }

    public BigDecimal findRetreatTotalSum(List<SaleWaresRetreatDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        double totalSum_double = 0D;
        for (SaleWaresRetreatDetail detail : objectList) {

            //orderSum 退货金额(单据退货数量 * 单据 单价)
            double orderSum_double = 0D;
            if (detail.getOrderSum() != null) {
                orderSum_double = detail.getOrderSum().doubleValue();
            }

            totalSum_double = totalSum_double + orderSum_double;
        }

        //四舍五入到2位小数
        return BigDecimal.valueOf(totalSum_double).setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    public SaleWaresRetreatDetail jsonMap2RetreatDetail(Map<String, String> jsonMap, SaleWaresRetreatDetail object) {
        if (object == null) {object = new SaleWaresRetreatDetail();}
        if (jsonMap == null) {return object;}

        //货品id productId
        String productId = jsonMap.get("productId");
        object.setProductId(productId);

        //单据单位id orderUnit(单据单位id:=计量单位)
        String orderUnit = jsonMap.get("orderUnit");
        object.setOrderUnit(orderUnit);
        object.setProductUnit(orderUnit);

        //退货数量(单据单位) orderCount
        BigDecimal orderCount = BigDecimal.valueOf(0D);
        String orderCountStr = jsonMap.get("orderCount");
        if (orderCountStr != null && orderCountStr.trim().length() > 0) {
            try {
                orderCount = new BigDecimal(orderCountStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //四舍五入到2位小数
        orderCount = orderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        object.setOrderCount(orderCount);
        object.setProductCount(orderCount);

        //货品单价(单据单价) orderPrice
        BigDecimal orderPrice = BigDecimal.valueOf(0D);
        String orderPriceStr = jsonMap.get("orderPrice");
        if (orderPriceStr != null && orderPriceStr.trim().length() > 0) {
            try {
                orderPrice = new BigDecimal(orderPriceStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //四舍五入到4位小数
        orderPrice = orderPrice.setScale(Common.SYS_NUMBER_FORMAT_4, BigDecimal.ROUND_HALF_UP);
        object.setOrderPrice(orderPrice);

        //orderSum 退货金额(单据退货数量 * 单据 单价)
        BigDecimal orderSum = BigDecimal.valueOf(orderCount.doubleValue() * orderPrice.doubleValue());
        //四舍五入到2位小数
        orderSum = orderSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        object.setOrderSum(orderSum);

        //remark 备注
        String remark = new String();
        if (jsonMap.get("remark") != null) {
            remark = jsonMap.get("remark").trim();
        }
        object.setRemark(remark);

        return object;
    }

    /**
     * 返回货品入库Map
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param detailList
     * @return
     */
    public Map<String, Map<String, Object>> findProductMapByIn(List<SaleWaresRetreatDetail> detailList) {
        Map<String, Map<String, Object>> productByOutMap = new HashMap<String, Map<String, Object>>();
        if (detailList == null || detailList.size() == 0) {return productByOutMap;}

        for (SaleWaresRetreatDetail dtlObject : detailList) {
            String detailId = dtlObject.getId();

            String productId = dtlObject.getProductId();

            //productCount:货品数量(计量数量) := inCount 入库数量
            BigDecimal productCount = BigDecimal.valueOf(0D);
            if (dtlObject.getProductCount() != null) {
                productCount = dtlObject.getProductCount();
            }
            //四舍五入到2位小数
            productCount = productCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            Map<String, Object> productMap = new HashMap<String, Object>();
            productMap.put("productId", productId);
            productMap.put("inDtlId", null);
            productMap.put("inCount", productCount);

            productByOutMap.put(detailId, productMap);
        }

        return productByOutMap;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleWaresRetreatDetail(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("saleWaresRetreatDetail");
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
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

//        //设置查询排序方式
//        //pd.put("orderStr", "a.cdate asc");
//        String orderStr = pd.getString("orderStr");
//        if (orderStr != null && orderStr.trim().length() > 0) {
//            pd.put("orderStr", orderStr);
//        }

        //添加订单明细界面使用该参数
        String type = pd.getString("type");
        if ("add".equals(type)) {
            pd.put("queryStr", "1=2");
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        Pagination pg = HttpUtils.parsePagination(pd);
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = this.getDataListPage(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

}



