package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistDiscardMapper;
import com.xy.vmes.entity.AssistDiscard;
import com.xy.vmes.entity.AssistDiscardDetail;
import com.xy.vmes.service.AssistDiscardDetailService;
import com.xy.vmes.service.AssistDiscardService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.CoderuleService;
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
* 说明：vmes_assist_discard:外协报废单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-05-07
*/
@Service
@Transactional(readOnly = false)
public class AssistDiscardServiceImp implements AssistDiscardService {
    @Autowired
    private AssistDiscardMapper assistDiscardMapper;
    @Autowired
    private AssistDiscardDetailService assistDiscardDetailService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void save(AssistDiscard object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistDiscardMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public AssistDiscard selectById(String id) throws Exception{
        return assistDiscardMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<AssistDiscard> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistDiscard> warehouseCheckDetailList = assistDiscardMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void update(AssistDiscard object) throws Exception{
        object.setUdate(new Date());
        assistDiscardMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateAll(AssistDiscard object) throws Exception{
        object.setUdate(new Date());
        assistDiscardMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistDiscardMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistDiscardMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistDiscardMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistDiscardMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    public List<AssistDiscard> dataList(PageData pd) throws Exception{
        return assistDiscardMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return assistDiscardMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistDiscardMapper.getDataListPage(pd,pg);
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
    public List<AssistDiscard> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistDiscard>();
        }

        return this.dataList(pageData);
    }

    public AssistDiscard findAssistDiscard(PageData object) throws Exception {
        List<AssistDiscard> objectList = this.findAssistDiscardList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistDiscard findAssistDiscardById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findAssistDiscard(findMap);
    }
    public List<AssistDiscard> findAssistDiscardList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 生成外协报废单-外协质量检验(成品,原材料)报废
     * @param cuser      用户id
     * @param companyId  企业id
     * @param type       报废类型(1:外协件 2:外协原材料)
     * @param objectMap  质量检验jsonMap
     */
    public String createDiscardByQuality(String cuser, String companyId, String type, Map<String, String> objectMap) throws Exception {
        AssistDiscard addDiscard = new AssistDiscard();
        addDiscard.setCuser(cuser);
        addDiscard.setCompanyId(companyId);

        String supplierId = new String();
        if (objectMap.get("supplierId") != null) {
            supplierId = objectMap.get("supplierId").trim();
        }
        addDiscard.setSupplierId(supplierId);
        //退货类型(1:外协件 2:外协原材料)
        addDiscard.setType(type);
        ////状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        addDiscard.setState("3");
        //报废完成日期 discardDate
        addDiscard.setDiscardDate(new Date());

        //报废金额 amount
        //addDiscard.setAmount(BigDecimal.valueOf(0D));
        addDiscard.setAuditId(Common.SYS_COMPANYAPPLICATION_ADMIN_USER_ID);

        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyId,
                "vmes_assist_discard",
                "R",
                Common.CODE_RULE_LENGTH_3);
        addDiscard.setSysCode(code);
        this.save(addDiscard);

        AssistDiscardDetail addDiscardDtl = new AssistDiscardDetail();
        addDiscardDtl.setParentId(addDiscardDtl.getId());
        addDiscardDtl.setState(addDiscardDtl.getState());
        addDiscardDtl.setCuser(addDiscardDtl.getCuser());

        //orderId:外协订单ID
        String orderId = objectMap.get("orderId");
        addDiscardDtl.setOrderId(orderId);
        //orderDtlId:订单明细ID
        String orderDtlId = objectMap.get("orderDtlId");
        addDiscardDtl.setOrderDtlId(orderDtlId);

        //type:报废类型(1:外协件 2:外协原材料)
        if ("1".equals(type)) {
            //assistProductId:外协件ID(外协件)
            String assistProductId = objectMap.get("assistProductId");
            addDiscardDtl.setAssistProductId(assistProductId);
        } else if ("2".equals(type)) {
            //deliverDtlChildId:发货明细子表id(原材料)
            String deliverDtlChildId = objectMap.get("deliverDtlChildId");
            addDiscardDtl.setDeliverDtlChildId(deliverDtlChildId);

            //deliverDtlId:外协发货明细ID
            String deliverDtlId = objectMap.get("deliverDtlId");
            addDiscardDtl.setDeliverDtlId(deliverDtlId);

            //deliverId:外协发货ID
            String deliverId = objectMap.get("deliverId");
            addDiscardDtl.setDeliverId(deliverId);
        }

        //orderUnit:订单单位ID
        String orderUnit = objectMap.get("orderUnit");
        addDiscardDtl.setOrderUnit(orderUnit);
        //productId:原材料ID(系统货品表id)
        String productId = objectMap.get("productId");
        addDiscardDtl.setProductId(productId);

        //orderCount:退货数量(订单单位)
        //count:退货数量: retreatCount (检验)退货数量
        BigDecimal retreatCount = BigDecimal.valueOf(0D);
        String retreatCountStr = objectMap.get("retreatCount");
        if (retreatCountStr != null && retreatCountStr.trim().length() > 0) {
            try {
                retreatCount = new BigDecimal(retreatCountStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //四舍五入到2位小数
        retreatCount = retreatCount.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        addDiscardDtl.setOrderCount(retreatCount);

//        //price:单价(外协件)
//        BigDecimal price = BigDecimal.valueOf(0D);
//        String priceStr = objectMap.get("price");
//        if (priceStr != null && priceStr.trim().length() > 0) {
//            try {
//                price = new BigDecimal(priceStr);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//        }
//        //四舍五入到4位小数
//        price = price.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//        addRetreatDtl.setPrice(price);
//
//        //amount:金额(外协件)
//        BigDecimal amount = BigDecimal.valueOf(price.doubleValue() * retreatCount.doubleValue());
//        addRetreatDtl.setAmount(amount);

        assistDiscardDetailService.save(addDiscardDtl);

        return addDiscardDtl.getId();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistDiscard(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistDiscard");
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

}



