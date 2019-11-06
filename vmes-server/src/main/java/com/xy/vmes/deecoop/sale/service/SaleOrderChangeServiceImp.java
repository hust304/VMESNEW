package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.sale.dao.SaleOrderChangeMapper;
import com.xy.vmes.entity.SaleOrderChange;
import com.xy.vmes.entity.SaleOrderDetailChange;
import com.xy.vmes.service.SaleOrderChangeService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailChangeService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_saleOrde_change:订单变更记录表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-11-05
*/
@Service
@Transactional(readOnly = false)
public class SaleOrderChangeServiceImp implements SaleOrderChangeService {
    @Autowired
    private SaleOrderChangeMapper saleOrdeChangeMapper;

    @Autowired
    private SaleOrderDetailChangeService ordeDtlChangeService;

    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void save(SaleOrderChange object) throws Exception {
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        saleOrdeChangeMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public SaleOrderChange selectById(String id) throws Exception{
        return saleOrdeChangeMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public List<SaleOrderChange> selectByColumnMap(Map columnMap) throws Exception {
        List<SaleOrderChange> warehouseCheckDetailList = saleOrdeChangeMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void update(SaleOrderChange object) throws Exception {
        object.setUdate(new Date());
        saleOrdeChangeMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void updateAll(SaleOrderChange object) throws Exception {
        object.setUdate(new Date());
        saleOrdeChangeMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        saleOrdeChangeMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        saleOrdeChangeMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        saleOrdeChangeMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        saleOrdeChangeMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-11-05
     */
    public List<SaleOrderChange> dataList(PageData pd) throws Exception {
        return saleOrdeChangeMapper.dataList(pd);
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
            return saleOrdeChangeMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleOrdeChangeMapper.getDataListPage(pd, pg);
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
    public List<SaleOrderChange> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleOrderChange>();
        }

        return this.dataList(pageData);
    }

    public SaleOrderChange findOrdeChange(PageData object) throws Exception {
        List<SaleOrderChange> objectList = this.findOrdeChangeList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleOrderChange findOrdeChangeById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findOrdeChange(findMap);
    }
    public List<SaleOrderChange> findOrdeChangeList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleOrderChange(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("saleOrdeChange");
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
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel addSaleOrderChange(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //变更订单id
        String orderId = pageData.getString("orderId");
        //(变更前)发票类型
        String receiptTypeBefore = pageData.getString("receiptTypeBefore");
        //(变更后)发票类型
        String receiptTypeAfter = pageData.getString("receiptTypeAfter");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //1. 创建订单变更记录表
        SaleOrderChange addOrdeChange = new SaleOrderChange();
        addOrdeChange.setCompanyId(companyId);
        addOrdeChange.setCuser(cuser);
        addOrdeChange.setUuser(cuser);

        addOrdeChange.setOrderId(orderId);
        //状态(0:审核中 1:完成:审核通过 2:取消:审核不通过)
        addOrdeChange.setState("0");
        addOrdeChange.setReceiptTypeBefore(receiptTypeBefore);
        addOrdeChange.setReceiptTypeAfter(receiptTypeAfter);
        this.save(addOrdeChange);

        //2. 创建订单明细变更记录表
        //当前系统时间()
        String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        Date sysDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        if (mapList != null && mapList.size() > 0) {
            for (Map<String, String> mapObject : mapList) {
                SaleOrderDetailChange addDtlChange = new SaleOrderDetailChange();
                addDtlChange.setParentId(addOrdeChange.getId());
                addDtlChange.setCuser(cuser);
                addDtlChange.setUuser(cuser);

                //订单明细id orderDtlId
                String orderDtlId = mapObject.get("orderDtlId");
                addDtlChange.setOrderDtlId(orderDtlId);

                //订单订购数量(变更前-订单单位) orderCountBefore
                BigDecimal orderCountBefore = BigDecimal.valueOf(0D);
                String orderCountBeforeStr = mapObject.get("orderCountBefore");
                if (orderCountBeforeStr != null && orderCountBeforeStr.trim().length() > 0) {
                    try {
                        orderCountBefore = new BigDecimal(orderCountBeforeStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                orderCountBefore = orderCountBefore.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setOrderCountBefore(orderCountBefore);


                //订单订购数量(变更后-订单单位) orderCountAfter
                BigDecimal orderCountAfter = BigDecimal.valueOf(0D);
                String orderCountAfterStr = mapObject.get("orderCountAfter");
                if (orderCountAfterStr != null && orderCountAfterStr.trim().length() > 0) {
                    try {
                        orderCountAfter = new BigDecimal(orderCountAfterStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                orderCountAfter = orderCountAfter.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setOrderCountAfter(orderCountAfter);


                //货品单价(变更前) productPriceBefore
                BigDecimal productPriceBefore = BigDecimal.valueOf(0D);
                String productPriceBeforeStr = mapObject.get("productPriceBefore");
                if (productPriceBeforeStr != null && productPriceBeforeStr.trim().length() > 0) {
                    try {
                        productPriceBefore = new BigDecimal(productPriceBeforeStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                productPriceBefore = productPriceBefore.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setProductPriceBefore(productPriceBefore);

                //货品单价(变更后) productPriceAfter
                BigDecimal productPriceAfter = BigDecimal.valueOf(0D);
                String productPriceAfterStr = mapObject.get("productPriceAfter");
                if (productPriceAfterStr != null && productPriceAfterStr.trim().length() > 0) {
                    try {
                        productPriceAfter = new BigDecimal(productPriceAfterStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                productPriceAfter = productPriceAfter.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setOrderCountAfter(productPriceAfter);

                //约定交期(变更前) deliverDateBefore
                Date deliverDateBefore = sysDate;
                String deliverDateBeforeStr = mapObject.get("deliverDateBefore");
                if (deliverDateBeforeStr != null && deliverDateBeforeStr.trim().length() > 0) {
                    Date dateTemp = DateFormat.dateString2Date(deliverDateBeforeStr, DateFormat.DEFAULT_DATE_FORMAT);
                    if (dateTemp != null) {
                        deliverDateBefore = dateTemp;
                    }
                }
                addDtlChange.setDeliverDateBefore(deliverDateBefore);

                //约定交期(变更后) deliverDateAfter
                Date deliverDateAfter = sysDate;
                String deliverDateAfterStr = mapObject.get("deliverDateAfter");
                if (deliverDateAfterStr != null && deliverDateAfterStr.trim().length() > 0) {
                    Date dateTemp = DateFormat.dateString2Date(deliverDateAfterStr, DateFormat.DEFAULT_DATE_FORMAT);
                    if (dateTemp != null) {
                        deliverDateAfter = dateTemp;
                    }
                }
                addDtlChange.setDeliverDateAfter(deliverDateAfter);

                //发货单数量(订单单位) deliverCount
                BigDecimal deliverCount = BigDecimal.valueOf(0D);
                String deliverCountStr = mapObject.get("deliverCount");
                if (deliverCountStr != null && deliverCountStr.trim().length() > 0) {
                    try {
                        deliverCount = new BigDecimal(deliverCountStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                deliverCount = deliverCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setDeliverCount(deliverCount);

                //完成发货数量(订单单位) endDeliverCount
                BigDecimal endDeliverCount = BigDecimal.valueOf(0D);
                String endDeliverCountStr = mapObject.get("endDeliverCount");
                if (endDeliverCountStr != null && endDeliverCountStr.trim().length() > 0) {
                    try {
                        endDeliverCount = new BigDecimal(endDeliverCountStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                endDeliverCount = endDeliverCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addDtlChange.setEndDeliverCount(endDeliverCount);

                ordeDtlChangeService.save(addDtlChange);
            }
        }

        return model;
    }


}



