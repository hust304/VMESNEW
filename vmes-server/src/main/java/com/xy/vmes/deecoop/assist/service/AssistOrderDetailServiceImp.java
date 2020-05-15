package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistOrderDetailMapper;
import com.xy.vmes.entity.AssistOrder;
import com.xy.vmes.entity.AssistOrderDetail;
import com.xy.vmes.service.AssistOrderDetailQueryBySignService;
import com.xy.vmes.service.AssistOrderDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.AssistOrderService;
import com.xy.vmes.service.ColumnService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.util.Common;
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
* 说明：vmes_assist_order_detail:外协订单明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-04-24
*/
@Service
@Transactional(readOnly = false)
public class AssistOrderDetailServiceImp implements AssistOrderDetailService {
    @Autowired
    private AssistOrderDetailMapper assistOrderDetailMapper;

    @Autowired
    private AssistOrderService orderService;
    @Autowired
    private AssistOrderDetailQueryBySignService orderDetailQueryBySignService;

    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void save(AssistOrderDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistOrderDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public AssistOrderDetail selectById(String id) throws Exception{
        return assistOrderDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<AssistOrderDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistOrderDetail> warehouseCheckDetailList = assistOrderDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void update(AssistOrderDetail object) throws Exception{
        object.setUdate(new Date());
        assistOrderDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateAll(AssistOrderDetail object) throws Exception{
        object.setUdate(new Date());
        assistOrderDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistOrderDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistOrderDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistOrderDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistOrderDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    public List<AssistOrderDetail> dataList(PageData pd) throws Exception{
        return assistOrderDetailMapper.dataList(pd);
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
            return assistOrderDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistOrderDetailMapper.getDataListPage(pd,pg);
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
    public List<AssistOrderDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistOrderDetail>();
        }

        return this.dataList(pageData);
    }

    public AssistOrderDetail findAssistOrderDetail(PageData object) throws Exception {
        List<AssistOrderDetail> objectList = this.findAssistOrderDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistOrderDetail findAssistOrderDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findAssistOrderDetail(findMap);
    }

    public List<AssistOrderDetail> findAssistOrderDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<AssistOrderDetail> findAssistOrderDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findAssistOrderDetailList(findMap);
    }

    public List<AssistOrderDetail> mapList2DetailList(List<Map<String, String>> mapList, List<AssistOrderDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            AssistOrderDetail detail = (AssistOrderDetail)HttpUtils.pageData2Entity(mapObject, new AssistOrderDetail());

            //订购数量(计价数量)
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (detail.getOrderCount() != null) {
                orderCount = detail.getOrderCount();
            }
            //四舍五入到2位小数
            orderCount = orderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            //price:单价
            BigDecimal price = BigDecimal.valueOf(0D);
            if (detail.getPrice() != null) {
                price = detail.getPrice();
            }
            //四舍五入到4位小数
            price = price.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            //amount:金额 (货品金额:=订购数量 * 货品单价)
            BigDecimal amount = BigDecimal.valueOf(orderCount.doubleValue() * price.doubleValue());
            //四舍五入到2位小数
            amount = amount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setAmount(amount);

            objectList.add(detail);
        }

        return objectList;
    }

    public BigDecimal findTotalAmount(List<AssistOrderDetail> objectList) {
        if (objectList == null || objectList.size() == 0) {return BigDecimal.valueOf(0D);}

        BigDecimal totalAmount = BigDecimal.valueOf(0D);
        for (AssistOrderDetail detail : objectList) {

            //amount:金额
            if (detail.getAmount() != null) {
                totalAmount = BigDecimal.valueOf(totalAmount.doubleValue() + detail.getAmount().doubleValue());
            }
        }

        //四舍五入到2位小数
        return totalAmount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 获取外协订单状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
     *
     * @param dtlList      外协订单明细List<AssistOrderDetail>
     * @return
     */
    public String findParentStateByDetail(List<AssistOrderDetail> dtlList) {
        if (dtlList == null || dtlList.size() == 0) {return null;}

        //订单状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        int dtl_dtj = 0;  //0:待提交
        int dtl_dsh = 0;  //1:待审核
        int dtl_dfh = 0;  //2:待发货
        int dtl_wxz = 0;  //3:外协中
        int dtl_ywc = 0;  //4:已完成
        int dtl_yqx = 0;  //-1:已取消
        //由各自业务更改--(0:待提交 1:待审核 2:待发货 -1:已取消 )

        //明细变更状态(4:待发货 5:已完成 -1:已取消)
        for (AssistOrderDetail dtlObject : dtlList) {
            if ("-1".equals(dtlObject.getState())) {
                dtl_yqx = dtl_yqx + 1;
            } else if ("0".equals(dtlObject.getState())) {
                dtl_dtj = dtl_dtj + 1;
            } else if ("1".equals(dtlObject.getState())) {
                dtl_dsh = dtl_dsh + 1;
            } else if ("2".equals(dtlObject.getState())) {
                dtl_dfh = dtl_dfh + 1;
            } else if ("3".equals(dtlObject.getState())) {
                dtl_wxz = dtl_wxz + 1;
            } else if ("4".equals(dtlObject.getState())) {
                dtl_ywc = dtl_ywc + 1;
            }
        }

        //订单明细状态:-1:已取消 全是已取消状态  订单状态:-1:已取消
        if (dtl_yqx > 0 && dtl_yqx == dtlList.size()) {
            return "-1";

            //订单明细状态:3:外协中 全是外协中状态  订单状态:3:外协中
        } else if (dtl_wxz > 0 && dtl_yqx >= 0
            && (dtl_dtj == 0 && dtl_dsh == 0 && dtl_dfh == 0 && dtl_ywc == 0)
        ) {
            return "3";

            //订单明细状态:4:已完成 全是已完成(发货)状态  订单状态:4:已完成
        } else if (dtl_ywc > 0 && dtl_yqx >= 0
            && (dtl_dtj == 0 && dtl_dsh == 0 && dtl_dfh == 0 && dtl_wxz == 0)
        ) {
            return "4";
        }

        return null;
    }

//    public Map<String, Map<String, Object>> findCheckAssistOrderDetailMap(PageData findMap) {
//        Map<String, Map<String, Object>> detailMap = new HashMap<>();
//        if (findMap == null || findMap.size() == 0) {return detailMap;}
//
//        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
//        try {
//            //查询SQL:AssistOrderDetailQueryBySignMapper.findCheckAssistOrderDetaiBySign
//            mapList = orderDetailQueryBySignService.findCheckAssistOrderDetaiBySign(findMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (mapList != null && mapList.size() > 0) {
//            for (Map<String, Object> objectMap : mapList) {
//                //orderDtlId: 外协订单明细id
//                String orderDtlId = (String)objectMap.get("orderDtlId");
//                detailMap.put(orderDtlId, objectMap);
//            }
//        }
//
//        return detailMap;
//    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", parentIds);

        assistOrderDetailMapper.updateStateByDetail(pageData);
    }

    /**
     * 根据订单明细状态-反写订单状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
     *
     * @param parent       订单对象
     * @param detailList   订单明细List<SaleOrderDetail>
     */
    public void updateParentStateByDetailList(AssistOrder parent, List<AssistOrderDetail> detailList) throws Exception {
        if (parent == null) {return;}
        if (parent.getId() == null || parent.getId().trim().length() == 0) {return;}

        if (detailList == null) {
            detailList = this.findAssistOrderDetailListByParentId(parent.getId());
        }

        //获取订单状态-根据订单明细状态
        String parentState = this.findParentStateByDetail(detailList);
        if (parentState != null && parentState.trim().length() > 0) {
            parent.setState(parentState.trim());
            orderService.update(parent);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistOrderDetail(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistOrderDetail");
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



