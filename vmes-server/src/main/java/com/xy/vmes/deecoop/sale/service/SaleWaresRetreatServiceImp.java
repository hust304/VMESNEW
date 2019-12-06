package com.xy.vmes.deecoop.sale.service;

import com.xy.vmes.deecoop.sale.dao.SaleWaresRetreatMapper;
import com.xy.vmes.entity.SaleWaresRetreat;
import com.xy.vmes.entity.SaleWaresRetreatDetail;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.SaleWaresRetreatDetailService;
import com.xy.vmes.service.SaleWaresRetreatService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
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
* 说明：vmes_sale_wares_retreat:无订单退货单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-12-05
*/
@Service
@Transactional(readOnly = false)
public class SaleWaresRetreatServiceImp implements SaleWaresRetreatService {
    @Autowired
    private SaleWaresRetreatMapper saleWaresRetreatMapper;
    @Autowired
    private SaleWaresRetreatDetailService waresRetreatDtlService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private CoderuleService coderuleService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void save(SaleWaresRetreat object) throws Exception {
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        saleWaresRetreatMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public SaleWaresRetreat selectById(String id) throws Exception{
        return saleWaresRetreatMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public List<SaleWaresRetreat> selectByColumnMap(Map columnMap) throws Exception {
        List<SaleWaresRetreat> warehouseCheckDetailList = saleWaresRetreatMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void update(SaleWaresRetreat object) throws Exception {
        object.setUdate(new Date());
        saleWaresRetreatMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateAll(SaleWaresRetreat object) throws Exception {
        object.setUdate(new Date());
        saleWaresRetreatMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteById(String id) throws Exception {
        saleWaresRetreatMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception {
        saleWaresRetreatMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception {
        saleWaresRetreatMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception {
        saleWaresRetreatMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-05
     */
    public List<SaleWaresRetreat> dataList(PageData pd) throws Exception {
        return saleWaresRetreatMapper.dataList(pd);
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
            return saleWaresRetreatMapper.getDataListPage(pd);
        } else if (pg != null) {
            return saleWaresRetreatMapper.getDataListPage(pd, pg);
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
    public List<SaleWaresRetreat> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleWaresRetreat>();
        }

        return this.dataList(pageData);
    }

    public SaleWaresRetreat findWaresRetreat(PageData object) throws Exception {
        List<SaleWaresRetreat> objectList = this.findWaresRetreatList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public SaleWaresRetreat findWaresRetreatById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findWaresRetreat(findMap);
    }
    public List<SaleWaresRetreat> findWaresRetreatList(PageData object) throws Exception  {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageSaleWaresRetreat(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("saleWaresRetreat");
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

    public ResultModel addSaleWaresRetreat(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();

        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String customerId = pageData.getString("customerId");
        if (customerId == null || customerId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("客户名称为必填项不可为空！");
            return model;
        }
        String type = pageData.getString("type");
        if (type == null || type.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("退货类型为必填项不可为空！");
            return model;
        }

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

        List<SaleWaresRetreatDetail> retreatDtlList = new ArrayList<>();
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, String> mapObject : mapList) {
                SaleWaresRetreatDetail retreatDtl = new SaleWaresRetreatDetail();

                //货品id productId
                String productId = mapObject.get("productId");
                retreatDtl.setProductId(productId);

                //单据单位id orderUnit(单据单位id:=计量单位)
                String orderUnit = mapObject.get("orderUnit");
                retreatDtl.setOrderUnit(orderUnit);
                retreatDtl.setProductId(orderUnit);

                //退货数量(单据单位) orderCount
                BigDecimal orderCount = BigDecimal.valueOf(0D);
                String orderCountStr = mapObject.get("orderCount");
                if (orderCountStr != null && orderCountStr.trim().length() > 0) {
                    try {
                        orderCount = new BigDecimal(orderCountStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                //四舍五入到2位小数
                orderCount = orderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                retreatDtl.setOrderCount(orderCount);
                retreatDtl.setProductCount(orderCount);

                //货品单价(单据单价) orderPrice
                BigDecimal orderPrice = BigDecimal.valueOf(0D);
                String orderPriceStr = mapObject.get("orderPrice");
                if (orderPriceStr != null && orderPriceStr.trim().length() > 0) {
                    try {
                        orderPrice = new BigDecimal(orderPriceStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                //四舍五入到4位小数
                orderPrice = orderPrice.setScale(Common.SYS_NUMBER_FORMAT_4, BigDecimal.ROUND_HALF_UP);
                retreatDtl.setOrderPrice(orderPrice);

                //orderSum 退货金额(单据退货数量 * 单据 单价)
                BigDecimal orderSum = BigDecimal.valueOf(orderCount.doubleValue() * orderPrice.doubleValue());
                //四舍五入到2位小数
                orderSum = orderSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                retreatDtl.setOrderSum(orderSum);

                //remark 备注
                String remark = new String();
                if (mapObject.get("remark") != null) {
                    remark = mapObject.get("remark").trim();
                }
                retreatDtl.setRemark(remark);

                retreatDtlList.add(retreatDtl);
            }
        }

        //1. 创建(无订单)退货单表
        SaleWaresRetreat addRetreat = new SaleWaresRetreat();
        addRetreat.setCompanyId(companyId);
        addRetreat.setCustomerId(customerId);
        addRetreat.setType(type);
        addRetreat.setCuser(cuser);

        //(无订单)退货编号(系统生成)
        String sysCode = coderuleService.createCoderCdateOnShortYearByDate(companyId,
                "vmes_sale_wares_retreat",
                "R",
                Common.CODE_RULE_SALEWARESRETREAT_LENGTH_DEFAULT);
        addRetreat.setSysCode(sysCode);

        BigDecimal totalSum = waresRetreatDtlService.findRetreatTotalSum(retreatDtlList);
        addRetreat.setTotalSum(totalSum);

        //状态(0:待提交 1:待审核 2:已完成:审核通过 -1:已取消)
        addRetreat.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            addRetreat.setState("1");
        }

        this.save(addRetreat);

        //2. 创建(无订单)退货单明细
        if (retreatDtlList != null && retreatDtlList.size() > 0) {
            for (SaleWaresRetreatDetail addDetail : retreatDtlList) {
                addDetail.setParentId(addRetreat.getId());
                addDetail.setCuser(cuser);
                waresRetreatDtlService.save(addDetail);
            }
        }

        return model;
    }

}



