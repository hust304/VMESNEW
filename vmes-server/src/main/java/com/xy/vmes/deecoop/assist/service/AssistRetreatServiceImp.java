package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistRetreatMapper;
import com.xy.vmes.entity.AssistRetreat;
import com.xy.vmes.entity.AssistRetreatDetail;
import com.xy.vmes.service.AssistRetreatDetailService;
import com.xy.vmes.service.AssistRetreatService;

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
* 说明：vmes_assist_retreat:外协退货单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-05-07
*/
@Service
@Transactional(readOnly = false)
public class AssistRetreatServiceImp implements AssistRetreatService {
    @Autowired
    private AssistRetreatMapper assistRetreatMapper;
    @Autowired
    private AssistRetreatDetailService assistRetreatDetailService;

    @Autowired
    private CoderuleService coderuleService;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void save(AssistRetreat object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistRetreatMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public AssistRetreat selectById(String id) throws Exception{
        return assistRetreatMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<AssistRetreat> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistRetreat> warehouseCheckDetailList = assistRetreatMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void update(AssistRetreat object) throws Exception{
        object.setUdate(new Date());
        assistRetreatMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateAll(AssistRetreat object) throws Exception{
        object.setUdate(new Date());
        assistRetreatMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistRetreatMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistRetreatMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistRetreatMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistRetreatMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    public List<AssistRetreat> dataList(PageData pd) throws Exception{
        return assistRetreatMapper.dataList(pd);
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
            return assistRetreatMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistRetreatMapper.getDataListPage(pd,pg);
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
    public List<AssistRetreat> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistRetreat>();
        }

        return this.dataList(pageData);
    }

    public AssistRetreat findAssistRetreat(PageData object) throws Exception {
        List<AssistRetreat> objectList = this.findAssistRetreatList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistRetreat findAssistRetreatById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findAssistRetreat(findMap);
    }
    public List<AssistRetreat> findAssistRetreatList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 生成外协退货单-采购质量检验(退货)
     * @param cuser      用户id
     * @param companyId  企业id
     * @param objectMap  质量检验jsonMap
     */
    public String createRetreatByQuality(String cuser, String companyId, Map<String, String> objectMap) throws Exception {
        AssistRetreat addRetreat = new AssistRetreat();
        addRetreat.setCuser(cuser);
        addRetreat.setCompanyId(companyId);

        String supplierId = new String();
        if (objectMap.get("supplierId") != null) {
            supplierId = objectMap.get("supplierId").trim();
        }
        addRetreat.setSupplierId(supplierId);
        //退货类型(1:外协件 2:外协原材料)
        addRetreat.setType("1");
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        addRetreat.setState("3");
        //退货完成日期 retreatDate
        addRetreat.setRetreatDate(new Date());

        //退货金额 amount
        addRetreat.setAmount(BigDecimal.valueOf(0D));
        addRetreat.setAuditId(Common.SYS_COMPANYAPPLICATION_ADMIN_USER_ID);

        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyId,
                "vmes_assist_retreat",
                "R",
                Common.CODE_RULE_LENGTH_3);
        addRetreat.setSysCode(code);
        this.save(addRetreat);

        AssistRetreatDetail addRetreatDtl = new AssistRetreatDetail();
        addRetreatDtl.setParentId(addRetreat.getId());
        addRetreatDtl.setState(addRetreat.getState());
        addRetreatDtl.setCuser(addRetreat.getCuser());

        //orderId:外协订单ID
        String orderId = objectMap.get("orderId").trim();
        addRetreatDtl.setOrderId(orderId);
        //orderDtlId:订单明细ID
        String orderDtlId = objectMap.get("orderDtlId").trim();
        addRetreatDtl.setOrderDtlId(orderDtlId);

        //assistProductId:外协件ID(外协件)
        String assistProductId = objectMap.get("assistProductId").trim();
        addRetreatDtl.setAssistProductId(assistProductId);
        //productId:原材料ID(系统货品表id)
        String productId = objectMap.get("productId").trim();
        addRetreatDtl.setProductId(productId);
        //orderUnit:订单单位ID
        String orderUnit = objectMap.get("orderUnit").trim();
        addRetreatDtl.setOrderUnit(orderUnit);

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
        addRetreatDtl.setOrderCount(retreatCount);

        //price:单价(外协件)
        BigDecimal price = BigDecimal.valueOf(0D);
        String priceStr = objectMap.get("price");
        if (priceStr != null && priceStr.trim().length() > 0) {
            try {
                price = new BigDecimal(priceStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //四舍五入到4位小数
        price = price.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        addRetreatDtl.setPrice(price);

        //amount:金额(外协件)
        BigDecimal amount = BigDecimal.valueOf(price.doubleValue() * retreatCount.doubleValue());
        addRetreatDtl.setAmount(amount);

        assistRetreatDetailService.save(addRetreatDtl);

        return addRetreatDtl.getId();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistRetreat(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistRetreat");
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



