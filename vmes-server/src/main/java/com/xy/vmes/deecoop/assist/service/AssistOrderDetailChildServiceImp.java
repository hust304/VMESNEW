package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.deecoop.assist.dao.AssistOrderDetailChildInfoMapper;
import com.xy.vmes.deecoop.assist.dao.AssistOrderDetailChildMapper;
import com.xy.vmes.entity.AssistOrderDetail;
import com.xy.vmes.entity.AssistOrderDetailChild;
import com.xy.vmes.service.AssistOrderDetailChildService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SystemToolService;
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
* 说明：vmes_assist_order_detail_child:外协订单明细子表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-04-24
*/
@Service
@Transactional(readOnly = false)
public class AssistOrderDetailChildServiceImp implements AssistOrderDetailChildService {
    @Autowired
    private AssistOrderDetailChildMapper assistOrderDetailChildMapper;
    @Autowired
    private AssistOrderDetailChildInfoMapper assistOrderDetailChildInfoMapper;

    @Autowired
    private SystemToolService systemToolService;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void save(AssistOrderDetailChild object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        assistOrderDetailChildMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public AssistOrderDetailChild selectById(String id) throws Exception{
        return assistOrderDetailChildMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public List<AssistOrderDetailChild> selectByColumnMap(Map columnMap) throws Exception{
        List<AssistOrderDetailChild> warehouseCheckDetailList = assistOrderDetailChildMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void update(AssistOrderDetailChild object) throws Exception{
        object.setUdate(new Date());
        assistOrderDetailChildMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateAll(AssistOrderDetailChild object) throws Exception{
        object.setUdate(new Date());
        assistOrderDetailChildMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteById(String id) throws Exception{
        assistOrderDetailChildMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        assistOrderDetailChildMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        assistOrderDetailChildMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        assistOrderDetailChildMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    public List<AssistOrderDetailChild> dataList(PageData pd) throws Exception{
        return assistOrderDetailChildMapper.dataList(pd);
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
            return assistOrderDetailChildMapper.getDataListPage(pd);
        } else if (pg != null) {
            return assistOrderDetailChildMapper.getDataListPage(pd,pg);
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
    public List<AssistOrderDetailChild> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<AssistOrderDetailChild>();
        }

        return this.dataList(pageData);
    }

    public AssistOrderDetailChild findOrderDetailChild(PageData object) throws Exception {
        List<AssistOrderDetailChild> objectList = this.findOrderDetailChildList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public AssistOrderDetailChild findOrderDetailChildById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findOrderDetailChild(findMap);
    }
    public List<AssistOrderDetailChild> findOrderDetailChildList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    /**
     * 根据(外协订单id) 汇总查询取外协件原材料(成品签收检验,原材料退货检验,原材料报废,成品报废,) 验证外协订单状态
     * 查询SQL:AssistOrderDetailChildMapper.findCheckAssistOrderChild
     *
     * @param orderId    外协订单id
     * @return
     */
    public List<Map<String, Object>> findCheckAssistOrderChild(String orderId) {
        PageData findMap = new PageData();
        findMap.put("orderId", orderId);
        return assistOrderDetailChildMapper.findCheckAssistOrderChild(findMap);
    }

    /**
     * 返回完成的外协订单id
     * 1. 遍历查询结果集
     * 2. 比较 orderCount(原材料订单数量) assistCount 原材料(成品签收检验,成品报废,原材料报废,原材料退回检验)
     * 3. 全部原材料 (原材料订单数量 <= 原材料(成品签收检验,成品报废,原材料报废,原材料退回检验))
     *
     * @param mapList
     * @throws Exception
     */
    public String finishOrderByAssistOrderChild(List<Map<String, Object>> mapList) {
        String orderId = null;
        if (mapList != null && mapList.size() > 0) {
            boolean isFinish = true;

            //遍历查询结构体
            for (Map<String, Object> objectMap : mapList) {
                //orderCount 原材料订单数量
                BigDecimal orderCount = BigDecimal.valueOf(0D);
                if (objectMap.get("orderCount") != null) {
                    orderCount = (BigDecimal)objectMap.get("orderCount");
                }

                //assistCount 原材料(成品签收检验,成品报废,原材料报废,原材料退回检验)
                BigDecimal assistCount = BigDecimal.valueOf(0D);
                if (objectMap.get("assistCount") != null) {
                    assistCount = (BigDecimal)objectMap.get("assistCount");
                }

                if (orderCount.doubleValue() > assistCount.doubleValue()) {
                    isFinish = false;
                    break;
                }
            }

            if (isFinish) {
                String tempStr = (String)mapList.get(0).get("orderId");
                if (tempStr != null && tempStr.trim().length() > 0) {
                    orderId = tempStr.trim();
                }

                return orderId;
            }
        }

        return orderId;
    }

    /**
     * 外协订单明细子表(外协件)详情查询
     * 外协订单明细(外协件)详情查询
     *
     * @param pd
     * @param pg
     * @return
     * @throws Exception
     */
    public List<Map> listAssistOrderDetailChildInfo(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return assistOrderDetailChildInfoMapper.listAssistOrderDetailChildInfo(pd);
        } else if (pg != null) {
            return assistOrderDetailChildInfoMapper.listAssistOrderDetailChildInfo(pd, pg);
        }

        return mapList;
    }

    /**
     * 获取 外协收货明细子表(原材料) 当前发货数量
     * SQL: AssistOrderDetailChildMapper.findAssistOrderDetailChildByDeliverChild
     *
     * @param orderId    外协订单id
     * @param orderDtlId 外协订单明细id
     * @return
     */
    public List<Map<String, Object>> findAssistOrderDetailChildByDeliverChild(String orderId, String orderDtlId) {
        PageData findMap = new PageData();
        if (orderId != null && orderId.trim().length() > 0) {
            findMap.put("orderId", orderId);
        }
        if (orderDtlId != null && orderDtlId.trim().length() > 0) {
            findMap.put("orderDtlId", orderDtlId);
        }
        if (findMap.size() == 0) {return new ArrayList<>();}

        return assistOrderDetailChildMapper.findAssistOrderDetailChildByDeliverChild(findMap);
    }

    /**
     * 获取订单明细id(外协件)最小发货数量
     * 1. 获取订单明细id(外协件)-所有原材料的发货数量
     * 2. 获取订单明细id(外协件)最小发货数量 (原材料的发货数量,单件用量)
     *
     * @param orderDtlId
     * @return
     */
    public int findMiniDeliverCountByOrderDetail(String orderDtlId) {
        int miniDeliverCount = 0;
        if (orderDtlId == null || orderDtlId.trim().length() == 0) {return miniDeliverCount;}

        //SQL: AssistOrderDetailChildMapper.findAssistOrderDetailChildByDeliverChild
        List<Map<String, Object>> dataList = this.findAssistOrderDetailChildByDeliverChild(null, orderDtlId);
        if (dataList == null || dataList.size() == 0) {return miniDeliverCount;}

        Map<String, BigDecimal> deliverMap = new HashMap<>();
        for (Map<String, Object> objectMap : dataList) {
            String id = (String)objectMap.get("id");

            //原材料:单件用量
            BigDecimal ratio = BigDecimal.valueOf(1D);
            if (objectMap.get("ratio") != null) {
                ratio = (BigDecimal)objectMap.get("ratio");
            }

            //原材料:当前发货数量
            BigDecimal deliverCount = BigDecimal.valueOf(0D);
            if (objectMap.get("deliverCount") != null) {
                deliverCount = (BigDecimal)objectMap.get("deliverCount");
            }

            //(当前发货数量 / 单件用量) 取整
            BigDecimal tempData = BigDecimal.valueOf(deliverCount.doubleValue() / ratio.doubleValue());
            tempData = tempData.setScale(0, BigDecimal.ROUND_DOWN);

            deliverMap.put(id, tempData);
        }

        BigDecimal miniTemp = BigDecimal.valueOf(99999D);
        for (Iterator iterator = deliverMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = iterator.next().toString().trim();
            BigDecimal deliverCount = deliverMap.get(mapKey);
            if (deliverCount.doubleValue() < miniTemp.doubleValue()) {miniTemp = deliverCount;}
        }

        if (miniTemp.doubleValue() < BigDecimal.valueOf(99999D).doubleValue()) {
            miniTemp = miniTemp.setScale(0, BigDecimal.ROUND_DOWN);
            miniDeliverCount = Integer.valueOf(miniTemp.intValue()).intValue();
        }

        return miniDeliverCount;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void insertAssistOrderDetailChild(AssistOrderDetail assistOrderDetail) throws Exception {
        PageData pd = new PageData();
        pd.put("assistProductId",assistOrderDetail.getAssistProductId());
        pd.put("orderCount",assistOrderDetail.getOrderCount());
        pd.put("orderDtlId",assistOrderDetail.getId());
        pd.put("orderId",assistOrderDetail.getParentId());
        pd.put("cuser",assistOrderDetail.getCuser());
        pd.put("uuser",assistOrderDetail.getCuser());
        assistOrderDetailChildMapper.insertAssistOrderDetailChild(pd);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageAssistOrderDetailChild(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistOrderDetailChild");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
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

        List<Map> varList = this.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");

            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);

                String prodInfo = systemToolService.findProductInfo(prodColumnKey, objectMap);
                objectMap.put("prodInfo", prodInfo);
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    public ResultModel listPageAssistOrderDetailChildInfo(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("assistOrderDetailChildInfo");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //addColumn 页面上传递需要添加的栏位
        if (pd.get("addColumn") != null) {
            Map<String, String> addColumnMap = (Map<String, String>) pd.get("addColumn");
            ColumnUtil.addColumnByColumnList(columnList, addColumnMap);
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

        List<Map> varList = this.listAssistOrderDetailChildInfo(pd, pg);
        if (varList != null && varList.size() > 0) {
            //prodColumnKey 业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码,货品名称,规格型号,货品自定义属性)摆放
            String prodColumnKey = pd.getString("prodColumnKey");

            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);

                String prodInfo = systemToolService.findProductInfo(prodColumnKey, objectMap);
                objectMap.put("prodInfo", prodInfo);
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



