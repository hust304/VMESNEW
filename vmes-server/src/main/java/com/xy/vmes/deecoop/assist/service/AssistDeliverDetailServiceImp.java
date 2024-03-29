package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.assist.dao.AssistDeliverDetailMapper;
import com.xy.vmes.entity.AssistDeliverDetail;
import com.xy.vmes.service.AssistDeliverDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.AssistOrderDetailChildByAssistDeliverService;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_assist_deliver_detail:外协发货明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-04-27
*/
@Service
@Transactional(readOnly = false)
public class AssistDeliverDetailServiceImp implements AssistDeliverDetailService {
    @Autowired
    private AssistDeliverDetailMapper assistDeliverDetailMapper;
    @Autowired
    private AssistOrderDetailChildByAssistDeliverService orderDetailChilService;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void save(AssistDeliverDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistDeliverDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public AssistDeliverDetail selectById(String id) throws Exception{
        return assistDeliverDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<AssistDeliverDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistDeliverDetail> warehouseCheckDetailList = assistDeliverDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void update(AssistDeliverDetail object) throws Exception{
        object.setUdate(new Date());
        assistDeliverDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateAll(AssistDeliverDetail object) throws Exception{
        object.setUdate(new Date());
        assistDeliverDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistDeliverDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistDeliverDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistDeliverDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistDeliverDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    public List<AssistDeliverDetail> dataList(PageData pd) throws Exception{
        return assistDeliverDetailMapper.dataList(pd);
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
            return assistDeliverDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistDeliverDetailMapper.getDataListPage(pd,pg);
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
    public List<AssistDeliverDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistDeliverDetail>();
        }

        return this.dataList(pageData);
    }

    public AssistDeliverDetail findDeliverDetail(PageData object) throws Exception {
        List<AssistDeliverDetail> objectList = this.findDeliverDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistDeliverDetail findDeliverDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findDeliverDetail(findMap);
    }
    public List<AssistDeliverDetail> findDeliverDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<AssistDeliverDetail> findDeliverDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findDeliverDetailList(findMap);
    }

    public String findOrderDtlIdsByDeliverDtlList(List<AssistDeliverDetail> detailList) {
        if (detailList == null || detailList.size() == 0) {return new String();}

        StringBuffer orderDtlIds = new StringBuffer();
        for (AssistDeliverDetail detail : detailList) {
            if (detail.getOrderDetailId() != null && detail.getOrderDetailId().trim().length() > 0) {
                orderDtlIds.append(detail.getOrderDetailId().trim() + ",");
            }
        }
        return orderDtlIds.toString();
    }

    /**
     * 获取外协订单(原材料)Map结构体
     * Map<外协订单明细id, List<Map<String, Object>>>
     * Sql查询语句: AssistOrderDetailChildByAssistDeliverMapper.checkAssistOrderDetailChildByDeliver
     *
     * @param orderDtlIds
     * @return
     */
    public Map<String, List<Map<String, Object>>> findOrderDetailChildMap(String orderDtlIds) {
        Map<String, List<Map<String, Object>>> valueMap = new HashMap<>();
        if (orderDtlIds == null || orderDtlIds.trim().length() == 0) {return valueMap;}

        orderDtlIds = StringUtil.stringTrimSpace(orderDtlIds);
        orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";

        //Sql查询语句: AssistOrderDetailChildByAssistDeliverMapper.checkAssistOrderDetailChildByDeliver
        PageData findMap = new PageData();
        findMap.put("orderDtlIds", orderDtlIds);
        List<Map<String, Object>> mapList = orderDetailChilService.checkAssistOrderDetailChildByDeliver(findMap);

        if (mapList != null && mapList.size() > 0) {
            for (Map<String, Object> objectMap : mapList) {
                //订单明细id orderDtlId
                String orderDtlId = (String)objectMap.get("orderDtlId");

                if (valueMap.get(orderDtlId) == null) {
                    List<Map<String, Object>> tempList = new ArrayList<>();
                    tempList.add(objectMap);
                    valueMap.put(orderDtlId, tempList);
                } else if (valueMap.get(orderDtlId) != null) {
                    List<Map<String, Object>> tempList = valueMap.get(orderDtlId);
                    tempList.add(objectMap);
                    valueMap.put(orderDtlId, tempList);
                }
            }
        }

        return valueMap;
    }

    public boolean isAllDeliverByOrderDetail(String orderDtlId, Map<String, List<Map<String, Object>>> valueMap) {
        boolean isAllDeliver = false;
        if (orderDtlId == null || orderDtlId.trim().length() == 0) {return isAllDeliver;}
        if (valueMap == null) {return isAllDeliver;}

        List<Map<String, Object>> mapList = valueMap.get(orderDtlId);
        if (mapList != null && mapList.size() > 0) {
            boolean isAllPlus = true;
            for (Map<String, Object> mapObject : mapList) {
                //orderCount(外协订单-原材料数量)
                BigDecimal orderCount = BigDecimal.valueOf(0D);
                if (mapObject.get("orderCount") != null) {
                    orderCount = (BigDecimal)mapObject.get("orderCount");
                }

                //deliverCount(外协订单-原材料发货完成数量)
                BigDecimal deliverCount = BigDecimal.valueOf(0D);
                if (mapObject.get("deliverCount") != null) {
                    deliverCount = (BigDecimal)mapObject.get("deliverCount");
                }

                //orderCount > deliverCount
                if (orderCount.doubleValue() > deliverCount.doubleValue()) {
                    isAllPlus = false;
                    break;
                }
            }
            isAllDeliver = isAllPlus;
        }

        return isAllDeliver;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", parentIds);

        assistDeliverDetailMapper.updateStateByDetail(pageData);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistDeliverDetail(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistDeliverDetail");
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

        //isNeedInfo:是否需要显示(出库详情,发货详情):'true'
        String isNeedInfo = pd.getString("isNeedInfo");

        List<Map> varList = this.getDataListPage(pd, pg);
        if ("true".equals(isNeedInfo) && varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //发货详情(按钮) 是否显示
                //isShowDeliver:发货详情 1:显示 0:不显示
                mapObject.put("isShowDeliver", "0");

                //根据vmes_sale_deliver.type 是否为空:发货类型(1:发货 2:送货 3:供应商自提)
                String deliverType = (String)mapObject.get("deliverType");
                if (deliverType != null && deliverType.trim().length() > 0) {
                    //isShowDeliver:发货详情 1:显示 0:不显示
                    mapObject.put("isShowDeliver", "1");
                }

                ///////////////////////////////////////////////////////
                //出库详情(按钮) 是否显示
                //isShowOut:出库详情 1:显示 0:不显示
                mapObject.put("isShowOut", "0");
                String warehouseOutId = (String)mapObject.get("warehouseOutId");
                if (warehouseOutId != null && warehouseOutId.trim().length() > 0) {
                    //isShowOut:出库详情 1:显示 0:不显示
                    mapObject.put("isShowOut", "1");
                }
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

}



