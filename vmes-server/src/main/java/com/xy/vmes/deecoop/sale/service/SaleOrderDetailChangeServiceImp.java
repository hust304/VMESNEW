package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailChangeMapper;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.entity.SaleOrderDetailChange;
import com.xy.vmes.service.SaleOrderDetailChangeService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailService;
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
* 说明：vmes_saleOrdeDtl_change:订单明细变更记录表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-11-05
*/
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailChangeServiceImp implements SaleOrderDetailChangeService {
    @Autowired
    private SaleOrderDetailChangeMapper saleOrdeDtlChangeMapper;

    @Autowired
    private SaleOrderDetailService saleOrderDetailService;

    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void save(SaleOrderDetailChange object) throws Exception {
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        saleOrdeDtlChangeMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public SaleOrderDetailChange selectById(String id) throws Exception{
        return saleOrdeDtlChangeMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public List<SaleOrderDetailChange> selectByColumnMap(Map columnMap) throws Exception {
        List<SaleOrderDetailChange> warehouseCheckDetailList = saleOrdeDtlChangeMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void update(SaleOrderDetailChange object) throws Exception {
        object.setUdate(new Date());
        saleOrdeDtlChangeMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void updateAll(SaleOrderDetailChange object) throws Exception {
        object.setUdate(new Date());
        saleOrdeDtlChangeMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        saleOrdeDtlChangeMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        saleOrdeDtlChangeMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        saleOrdeDtlChangeMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        saleOrdeDtlChangeMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    public List<SaleOrderDetailChange> dataList(PageData pd) throws Exception {
        return saleOrdeDtlChangeMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleOrdeDtlChangeMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleOrdeDtlChangeMapper.getDataListPage(pd, pg);
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
    public List<SaleOrderDetailChange> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleOrderDetailChange>();
        }

        return this.dataList(pageData);
    }

    public SaleOrderDetailChange findOrdeDtlChange(PageData object) throws Exception {
        List<SaleOrderDetailChange> objectList = this.findOrdeDtlChangeList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleOrderDetailChange findOrdeDtlChangeById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findOrdeDtlChange(findMap);
    }

    public List<SaleOrderDetailChange> findOrdeDtlChangeList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public List<SaleOrderDetailChange> findOrdeDtlChangeListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findOrdeDtlChangeList(findMap);
    }

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleOrderDetailChange(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("saleOrderDetailChange");
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

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 根据订单明细变更记录-拆分订单明细
     * 订购数量变更范围: 大于等于(发货数量)-可变更(订购数量)最小值与(发货数量)相关-如果(发货数量:=0) 任意大于零的数
     * 单价变更范围:  订购数量未发生变更-等于当前订单的订购数量-单价不允许变更
     *              订购数量发生变更-任意大于零的数
     *
     * 示例订单明细: 订购数量:10 单价:1 发货数量:0
     * 订购数量变更范围: 任意大于零的数
     * 单价变更范围:    任意大于零的数
     *
     * 示例订单明细: 订购数量:10 单价:1 发货数量:5
     * 订购数量变更范围: 大于等于5的数
     * 单价变更范围:    任意大于零的数
     *
     * 示例订单明细: 订购数量:10 单价:1 发货数量:10
     * 订购数量变更范围: 大于等于10的数
     * 单价变更范围:    不允许变更
     *
     * 订购数量:10 单价:1 发货数量:5
     * 情况1：只有价格变更 单价: 1 变更为 2
     * 订单明细: (修改)订购数量:10 单价:1 (订购数量:10 修改为 5)
     *        (修改后)订购数量:5 单价:1
     *          (插入)订购数量:5  单价:2
     *
     * 订购数量:10 单价:1 发货数量:5
     * 情况2：只有订购数量变更 订购数量: 10 变更为 7
     * 订单明细: (修改)订购数量:10 单价:1 (订购数量:10 修改为 5)
     *        (修改后)订购数量:5 单价:1
     *          (插入)订购数量:2  单价:1
     *
     * @param objectMap  查询结构体(SaleOrderDetailChangeMapper.getDataListPage)
     * @param addObject
     * @param editObject
     */
    public void findSaleOrderDetailByChangeMap(Map<String, Object> objectMap, SaleOrderDetail addObject, SaleOrderDetail editObject) throws Exception {
        //订单明细id
        String orderDtlId = (String)objectMap.get("orderDtlId");
        SaleOrderDetail orderDetail = saleOrderDetailService.findSaleOrderDetailById(orderDtlId);

        //订单明细-(变更前,变更后)订购数量
        BigDecimal orderCountBefore = (BigDecimal)objectMap.get("orderCountBefore");
        BigDecimal orderCountAfter = (BigDecimal)objectMap.get("orderCountAfter");

        //单位转换公式: (计价转换计量)单位
        String p2nFormula = (String)objectMap.get("p2nFormula");
        //productCount 货品数量(计量数量)
        BigDecimal productCountAfter = BigDecimal.valueOf(0D);

        //订购数量:(转换计量单位) P(计价单位) --> N(计量单位)
        if (p2nFormula != null && p2nFormula.trim().length() > 0) {
            productCountAfter = EvaluateUtil.countFormulaP2N(orderCountAfter, p2nFormula);
        }
        //四舍五入到2位小数
        productCountAfter = productCountAfter.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

        //订单明细-(变更前,变更后)单价
        BigDecimal productPriceBefore = (BigDecimal)objectMap.get("productPriceBefore");
        BigDecimal productPriceAfter = (BigDecimal)objectMap.get("productPriceAfter");

        //订单明细-(变更前,变更后)约定交期
        Date deliverDateBefore = (Date)objectMap.get("deliverDateBefore");
        Date deliverDateAfter = (Date)objectMap.get("deliverDateAfter");

        //发货数量
        BigDecimal deliverCount = BigDecimal.valueOf(0D);
        if (objectMap.get("deliverCount") != null) {
            deliverCount = (BigDecimal)objectMap.get("deliverCount");
        }

        //发货数量:=0 无需拆分订单明细 直接修改该订单明细
        if (0D == deliverCount.doubleValue()) {
            editObject = new SaleOrderDetail();
            editObject.setId(orderDtlId);

            //订单明细-订购数量(订单单位-计价单位)
            editObject.setOrderCount(orderCountAfter);
            //priceCount 货品数量(计价数量)
            editObject.setPriceCount(orderCountAfter);
            //订单明细-订购数量-货品数量(计量单位)
            editObject.setProductCount(productCountAfter);

            //订单明细-货品单价
            editObject.setProductPrice(productPriceAfter);
            //订单明细-约定交期
            editObject.setDeliverDate(deliverDateAfter);

            //productSum 货品金额(订购数量 * 货品单价)
            BigDecimal productSumAfter = BigDecimal.valueOf(0D);
            if (productCountAfter != null && productPriceAfter != null) {
                productSumAfter = BigDecimal.valueOf(productCountAfter.doubleValue() * productPriceAfter.doubleValue());
                //四舍五入到2位小数
                productSumAfter = productSumAfter.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            }
            editObject.setProductSum(productSumAfter);

            return;
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //发货数量: 不等于零
        //A. 订购数量发生变更: 拆分订单明细
        // 订购数量:10 单价:1 发货数量:5
        // 情况2：只有订购数量变更 订购数量: 10 变更为 7
        // 订单明细: (修改)订购数量:10 单价:1 (订购数量:10 修改为 5)
        //        (修改后)订购数量:5 单价:1
        //          (插入)订购数量:2  单价:1
        if (this.isChangeByBigDecimal(orderCountBefore, orderCountAfter)) {
            //设置订单明细:修改
            this.findEditOrderDetail(objectMap, deliverCount, editObject);

            //设置订单明细:添加
            this.findAddOrderDetail(objectMap, deliverCount, orderCountAfter, orderDetail, addObject);
        }

        //B. 单价发生变更: 拆分订单明细
        // 订购数量:10 单价:1 发货数量:5
        // 情况1：只有价格变更 单价: 1 变更为 2
        // 订单明细: (修改)订购数量:10 单价:1 (订购数量:10 修改为 5)
        //        (修改后)订购数量:5 单价:1
        //          (插入)订购数量:5  单价:2
        if (this.isChangeByBigDecimal(productPriceBefore, productPriceAfter)) {
            //设置订单明细:修改
            if (editObject == null) {
                this.findEditOrderDetail(objectMap, deliverCount, editObject);
            } else {
                this.findOrderDetailByPrice(productPriceAfter, editObject);
            }

            //设置订单明细:添加
            if (addObject == null) {
                this.findAddOrderDetail(objectMap, deliverCount, orderCountAfter, orderDetail, addObject);
            } else {
                this.findOrderDetailByPrice(productPriceAfter, addObject);
            }
        }

        //C. 约定交期发生变更:
        if (this.isChangeByDate(deliverDateBefore, deliverDateAfter)) {
            //设置订单明细:修改
            if (editObject == null) {
                editObject = new SaleOrderDetail();
                editObject.setId(orderDtlId);
            }

            //约定交期 deliverDate
            editObject.setDeliverDate(deliverDateAfter);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //订单变更审核 私有方法
    private void findOrderDetailByPrice(BigDecimal productPriceAfter, SaleOrderDetail orderDetail) {
        if (productPriceAfter == null) {productPriceAfter = BigDecimal.valueOf(0D);}

        //四舍五入到2位小数
        productPriceAfter = productPriceAfter.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        orderDetail.setProductPrice(productPriceAfter);

        //订单订购数量 orderCount
        BigDecimal orderCount = BigDecimal.valueOf(0D);
        if (orderDetail.getOrderCount() != null) {
            orderCount = orderDetail.getOrderCount();
        }

        //货品金额(订购数量 * 货品单价)productSum
        BigDecimal productSum = BigDecimal.valueOf(orderCount.doubleValue() * productPriceAfter.doubleValue());
        //四舍五入到2位小数
        productSum = productSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        orderDetail.setProductSum(productSum);

    }

    private void findEditOrderDetail(Map<String, Object> objectMap, BigDecimal deliverCount, SaleOrderDetail editObject) {
        if (editObject == null) {editObject = new SaleOrderDetail();}

        //订单明细id
        String orderDtlId = (String)objectMap.get("orderDtlId");
        //单位转换公式: (计价转换计量)单位
        String p2nFormula = (String)objectMap.get("p2nFormula");

        editObject.setId(orderDtlId);

        //订单明细-订购数量:= 发货数量(订单单位-计价单位)
        editObject.setOrderCount(deliverCount);
        //priceCount 货品数量(计价数量)
        editObject.setPriceCount(deliverCount);

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
    }

    private void findAddOrderDetail(Map<String, Object> objectMap,
                                    BigDecimal deliverCount,
                                    BigDecimal orderCountAfter,
                                    SaleOrderDetail orderDetail,
                                    SaleOrderDetail addObject) {
        if (addObject == null) {addObject = new SaleOrderDetail();}

        //单位转换公式: (计价转换计量)单位
        String p2nFormula = (String)objectMap.get("p2nFormula");

        //订单明细-订购数量:= (变更后)订购数量 - 发货数量
        BigDecimal orderCountAdd = BigDecimal.valueOf(orderCountAfter.doubleValue() - deliverCount.doubleValue());

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

        //priceCount 货品数量(计价数量)
        addObject.setPriceCount(orderCountAdd);


        //订单ID parentId
        addObject.setParentId(orderDetail.getParentId());
        //state 明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成 -1:已取消)
        addObject.setState("3");
        //附件地址 fileUrl
        addObject.setFileUrl(orderDetail.getFileUrl());
        //订单单位id orderUnit
        addObject.setOrderUnit(orderDetail.getOrderUnit());
        //计量单位id productUnit
        addObject.setProductUnit(orderDetail.getProductUnit());
        //计价单位id priceUnit
        addObject.setPriceUnit(orderDetail.getPriceUnit());
        //货品ID productId
        addObject.setProductId(orderDetail.getProductId());
        //生产计划明细ID planDetailId
        addObject.setPlanDetailId(orderDetail.getPlanDetailId());
    }

    /**
     * 返回是否发生变更(变更前,变更后)日期
     * true : 发生变更
     * false: 未发生变更
     *
     * @param beforeDate 变更前日期
     * @param afterDate  变更后日期
     * @return
     */
    private boolean isChangeByDate(Date beforeDate, Date afterDate) {
        long beforeDateLong = -1;
        if (beforeDate != null) {
            String dateStr = DateFormat.date2String(beforeDate, DateFormat.DEFAULT_DATE_FORMAT);
            if (dateStr != null && dateStr.trim().length() > 0) {
                Date DateTemp = DateFormat.dateString2Date(dateStr, DateFormat.DEFAULT_DATE_FORMAT);
                if (DateTemp != null) {
                    beforeDateLong = DateTemp.getTime();
                }
            }
        }

        long afterDateLong = -1;
        if (afterDate != null) {
            String dateStr = DateFormat.date2String(afterDate, DateFormat.DEFAULT_DATE_FORMAT);
            if (dateStr != null && dateStr.trim().length() > 0) {
                Date DateTemp = DateFormat.dateString2Date(dateStr, DateFormat.DEFAULT_DATE_FORMAT);
                if (DateTemp != null) {
                    afterDateLong = DateTemp.getTime();
                }
            }
        }

        if (beforeDateLong != afterDateLong) {return true;}

        return false;
    }

    /**
     * 返回是否发生变更(变更前,变更后)数值
     * true : 发生变更
     * false: 未发生变更
     *
     * @param beforeBigDecimal 变更前数值
     * @param afterBigDecimal  变更后数值
     * @return
     */
    private boolean isChangeByBigDecimal(BigDecimal beforeBigDecimal, BigDecimal afterBigDecimal) {
        double beforeDouble = -1D;
        if (beforeBigDecimal != null) {
            //四舍五入到2位小数
            beforeBigDecimal = beforeBigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            beforeDouble = beforeBigDecimal.doubleValue();
        }

        double afterDouble = -1D;
        if (afterBigDecimal != null) {
            //四舍五入到2位小数
            afterBigDecimal = afterBigDecimal.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            afterDouble = afterBigDecimal.doubleValue();
        }

        if (beforeDouble != afterDouble) {return true;}

        return false;
    }

}



