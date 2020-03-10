package com.xy.vmes.deecoop.produce.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.produce.dao.ProducePlanDetailByQualityMapper;
import com.xy.vmes.deecoop.produce.dao.ProducePlanDetailMapper;
import com.xy.vmes.entity.ProducePlanDetail;
import com.xy.vmes.entity.ProducePlanDetailChild;
import com.xy.vmes.service.ProducePlanDetailChildService;
import com.xy.vmes.service.ProducePlanDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_produce_plan_detail:生产计划明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-02-27
*/
@Service
@Transactional(readOnly = false)
public class ProducePlanDetailServiceImp implements ProducePlanDetailService {
    @Autowired
    private ProducePlanDetailMapper producePlanDetailMapper;
    @Autowired
    private ProducePlanDetailByQualityMapper producePlanDetailByQualityMapper;
    @Autowired
    private ProducePlanDetailChildService planDetailChildService;

    @Autowired
    private SaleOrderDetailService orderDetailService;

    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void save(ProducePlanDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        producePlanDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public ProducePlanDetail selectById(String id) throws Exception{
        return producePlanDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public List<ProducePlanDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<ProducePlanDetail> warehouseCheckDetailList = producePlanDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void update(ProducePlanDetail object) throws Exception{
        object.setUdate(new Date());
        producePlanDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateAll(ProducePlanDetail object) throws Exception{
        object.setUdate(new Date());
        producePlanDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteById(String id) throws Exception{
        producePlanDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        producePlanDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        producePlanDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        producePlanDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    public List<ProducePlanDetail> dataList(PageData pd) throws Exception{
        return producePlanDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return producePlanDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return producePlanDetailMapper.getDataListPage(pd,pg);
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
    public List<ProducePlanDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<ProducePlanDetail>();
        }

        return this.dataList(pageData);
    }

    public ProducePlanDetail findProducePlanDetail(PageData object) throws Exception {
        List<ProducePlanDetail> objectList = this.findProducePlanDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public ProducePlanDetail findProducePlanDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findProducePlanDetail(findMap);
    }

    public List<ProducePlanDetail> findProducePlanDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<ProducePlanDetail> findProducePlanDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);
        findMap.put("orderStr", "cdate asc");

        return this.findProducePlanDetailList(findMap);
    }

    /**
     * 获取生产计划状态-根据生产计划明细状态
     * 生产计划状态 (1:未完成 2:已完成 -1:已取消)
     * 生产计划明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
     *
     * @param dtlList      生产计划明细List<SaleOrderDetail>
     * @return
     */
    public String findParentStateByDetail(List<ProducePlanDetail> dtlList) {
        if (dtlList == null || dtlList.size() == 0) {return null;}

        //生产计划明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
        int dtl_dsc = 0;  //0:待生产
        int dtl_scz = 0;  //1:生产中
        int dtl_ywc = 0;  //2:已完成
        int dtl_yqx = 0;  //-1:已取消

        for (ProducePlanDetail dtlObject : dtlList) {
            if ("-1".equals(dtlObject.getState())) {
                dtl_yqx = dtl_yqx + 1;
            } else if ("0".equals(dtlObject.getState())) {
                dtl_dsc = dtl_dsc + 1;
            } else if ("1".equals(dtlObject.getState())) {
                dtl_scz = dtl_scz + 1;
            } else if ("2".equals(dtlObject.getState())) {
                dtl_ywc = dtl_ywc + 1;
            }
        }

        //明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
        if (dtl_yqx > 0 && dtl_yqx == dtlList.size()) {
            return "-1";

            //明细状态:2:已完成 全是已完成状态  主表状态:2:已完成
        } else if (dtl_ywc > 0 && dtl_yqx >= 0
            && (dtl_dsc == 0 && dtl_scz == 0)
        ) {
            return "2";

            //明细中含有状态(0:待生产 1:生产中) 主表状态:1:未完成
        } else if (dtl_dsc > 0 || dtl_scz > 0) {
            return "1";
        }

        return null;
    }

    /**
     * 判断生产计划明细是否允许删除
     * 明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
     *
     * false: 不允许删除: 生产计划明细中含有(1:生产中 或 2:已完成)
     * true:  允许删除
     *
     * @param dtlList
     * @return
     */
    public boolean isAllowDeleteByDetail(List<ProducePlanDetail> dtlList) {
        if (dtlList == null || dtlList.size() == 0) {return true;}

        //生产计划明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
        int dtl_dsc = 0;  //0:待生产
        int dtl_scz = 0;  //1:生产中
        int dtl_ywc = 0;  //2:已完成
        int dtl_yqx = 0;  //-1:已取消

        for (ProducePlanDetail dtlObject : dtlList) {
            if ("-1".equals(dtlObject.getState())) {
                dtl_yqx = dtl_yqx + 1;
            } else if ("0".equals(dtlObject.getState())) {
                dtl_dsc = dtl_dsc + 1;
            } else if ("1".equals(dtlObject.getState())) {
                dtl_scz = dtl_scz + 1;
            } else if ("2".equals(dtlObject.getState())) {
                dtl_ywc = dtl_ywc + 1;
            }
        }

        if (dtl_scz >= 1 || dtl_ywc >= 1) {
            return false;
        }

        return true;
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

        producePlanDetailMapper.updateStateByDetail(pageData);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageProducePlanDetail(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("producePlanDetail");
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

        String inStates = pd.getString("inStates");
        if (inStates != null && inStates.trim().length() > 0) {
            inStates = StringUtil.stringTrimSpace(inStates);
            inStates = "'" + inStates.replace(",", "','") + "'";
            pd.put("inStates", inStates);
        }

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

        //isNeedChild 是否需要生产明细子表 true:需要
        String isNeedChild = pd.getString("isNeedChild");
        if ("true".equals(isNeedChild) && varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //planDtlId 生产计划明细id
                String planDtlId = (String)mapObject.get("id");

                List<ProducePlanDetailChild> planDtlChildList = planDetailChildService.findPlanDetailChildListByPlanDtlId(planDtlId);
                String jsonStr = this.findJsonStringByList(planDtlChildList);
                mapObject.put("jsonStr", jsonStr);

                //Map<"orderCodes", 订单编号>
                //Map<"expectDate", 订单约定交期>
                Map<String, String> valueMap = this.findOrderCodeByList(planDtlChildList);
                mapObject.put("orderCode", valueMap.get("orderCodes"));
                mapObject.put("expectDate", valueMap.get("expectDate"));
            }
        }

        if (varList != null && varList.size() > 0) {
            //获取系统时间(yyyy-MM-dd)
            String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
            Date sysDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);

            for (Map<String, Object> mapObject : varList) {
                String prodInfo = this.findProductInfo(mapObject);
                mapObject.put("prodInfo", prodInfo);

                //state 生产计划明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
                String state = (String)mapObject.get("state");
                Integer stateInt = Integer.valueOf(state);

                //isExceedTime:是否逾期 1:逾期 0:非逾期
                String isExceedTime = new String("0");
                //dayCount 剩余/逾期 天数
                String dayCount = new String();

                //生产计划明细状态 0:待生产 1:生产中
                if (0 == stateInt.intValue() || 1 == stateInt.intValue()) {
                    //(计划结束日期 - 当前系统日期) 差值

                    //endDate 计划结束日期(yyyy-MM-dd)
                    String endDateStr = (String)mapObject.get("endDate");
                    if (endDateStr != null && endDateStr.trim().length() > 0) {
                        Date endDate = DateFormat.dateString2Date(endDateStr, DateFormat.DEFAULT_DATE_FORMAT);

                        //(计划结束日期 - 当前系统日期) 差值 --> findDayOfYear(当前系统日期 , 计划结束日期)
                        int days = DateFormat.findDayOfYear(sysDate, endDate);
                        if (days < 0) {
                            //isExceedTime:是否逾期 1:逾期 0:非逾期
                            isExceedTime = "1";
                            dayCount = Integer.valueOf(days * -1).toString() + " 天";
                        } else if (days > 0) {
                            isExceedTime = "0";
                            dayCount = Integer.valueOf(days).toString() + " 天";
                        }
                    }

                    //生产计划明细状态 2:已完成
                } else if (2 == stateInt.intValue()) {
                    //(计划完成日期 - 当前系统日期) 差值

                    //planDate 计划完成日期 (yyyy-MM-dd)
                    String planDateStr = (String)mapObject.get("planDate");
                    //endDate 计划结束日期(yyyy-MM-dd)
                    String endDateStr = (String)mapObject.get("endDate");

                    if (planDateStr != null && planDateStr.trim().length() > 0) {
                        Date planDate = DateFormat.dateString2Date(planDateStr, DateFormat.DEFAULT_DATE_FORMAT);
                        Date endDate = DateFormat.dateString2Date(endDateStr, DateFormat.DEFAULT_DATE_FORMAT);

                        //(计划结束日期 - 计划完成日期) 差值 --> findDayOfYear(计划完成日期 , 计划结束日期)
                        int days = DateFormat.findDayOfYear(planDate , endDate);
                        if (days < 0) {
                            //isExceedTime:是否逾期 1:逾期 0:非逾期
                            isExceedTime = "1";
                            dayCount = Integer.valueOf(days * -1).toString() + " 天";
                        }
//                        else if (days > 0) {
//                            isExceedTime = "0";
//                            dayCount = Integer.valueOf(days).toString() + " 天";
//                        }
                    }
                }

                //设置 isExceedTime:是否逾期 1:逾期 0:非逾期
                mapObject.put("isExceedTime", isExceedTime);
                //设置 dayCount 剩余/逾期 天数
                mapObject.put("dayCount", dayCount);
            }
        }

        //pageType 页面类型 edit:修改页面
        String pageType = pd.getString("pageType");
        if ("edit".equals(pageType) && varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //operType 操作类型(add:添加, edit:修改)
                mapObject.put("operType", "edit");
            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    //生产计划明细(检验)报工
    public ResultModel listPageProducePlanDetailByQuality(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("producePlanDetailByQuality");
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

        String ids = pd.getString("ids");
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            pd.put("ids", ids);
        }

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

        List<Map> varList = this.listProducePlanDetailByQuality(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageMaterialRequisition(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("MaterialRequisition");
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
        Pagination pg = HttpUtils.parsePagination(pd);
        result.put("pageData", pg);

        List<Map> varList = producePlanDetailMapper.getMaterialRequisition(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listPageMaterialRequisitionGroup(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("MaterialRequisitionGroup");
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
        Pagination pg = HttpUtils.parsePagination(pd);
        result.put("pageData", pg);

        List<Map> varList = producePlanDetailMapper.getMaterialRequisitionGroup(pd,pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    String findProductInfo(Map<String, Object> mapObject) {
        StringBuffer prodBuf = new StringBuffer();

        if (mapObject != null) {

            String productCode = (String)mapObject.get("productCode");
            if (productCode != null && productCode.trim().length() > 0) {
                prodBuf.append(productCode.trim()).append("_");
            }

            String productName = (String)mapObject.get("productName");
            if (productName != null && productName.trim().length() > 0) {
                prodBuf.append(productName.trim()).append("_");
            }

            String productSpec = (String)mapObject.get("productSpec");
            if (productSpec != null && productSpec.trim().length() > 0) {
                prodBuf.append(productSpec.trim());
            }

//            String unitName = (String)mapObject.get("unitName");
//            if (unitName != null && unitName.trim().length() > 0) {
//                prodBuf.append(unitName.trim());
//            }

            String productProperty = (String)mapObject.get("productProperty");
            if (productProperty != null && productProperty.trim().length() > 0) {
                prodBuf.append("<br/>");
                prodBuf.append(productProperty);
            }
        }

        return prodBuf.toString();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<Map> listProducePlanDetailByQuality(PageData pd,Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return producePlanDetailByQualityMapper.listProducePlanDetailByQuality(pd);
        } else if (pg != null) {
            return producePlanDetailByQualityMapper.listProducePlanDetailByQuality(pd, pg);
        }

        return mapList;
    }

    private String findJsonStringByList(List<ProducePlanDetailChild> ObjectList) {
        if (ObjectList == null || ObjectList.size() == 0) {return new String();}

        //orderDetailMap<销售订单明细id, 销售订单明细id>
        Map<String, String> orderDetailMap = new LinkedHashMap<>();
        for (ProducePlanDetailChild object : ObjectList) {
            //saleOrderDtlId:销售订单明细ID
            String saleOrderDtlId = object.getSaleOrderDtlId();
            if (saleOrderDtlId != null && saleOrderDtlId.trim().length() > 0) {
                orderDetailMap.put(saleOrderDtlId, saleOrderDtlId);
            }
        }

        List<Map<String, String>> childMapList = new ArrayList<>();
        //遍历orderDetailMap<销售订单明细id, 销售订单明细id> 生成货品合并json字符串
        if (orderDetailMap != null) {
            for (Iterator iterator = orderDetailMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey_orderDtlId = iterator.next().toString().trim();
                if (mapKey_orderDtlId != null && mapKey_orderDtlId.trim().length() > 0) {
                    Map<String, String> childMap = new LinkedHashMap<>();
                    childMap.put("orderDtlId", mapKey_orderDtlId);
                    childMapList.add(childMap);
                }
            }
        }

        if (childMapList.size() > 0) {
            return YvanUtil.toJson(childMapList);
        }

        return new String();
    }

    //Map<"orderCodes", 订单编号>
    //Map<"expectDate", 订单约定交期>
    private Map<String, String> findOrderCodeByList(List<ProducePlanDetailChild> ObjectList) throws Exception {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("orderCodes", new String());
        valueMap.put("expectDate", new String());

        if (ObjectList == null || ObjectList.size() == 0) {return valueMap;}

        //orderDetailMap<销售订单明细id, 销售订单明细id>
        Map<String, String> orderDetailMap = new LinkedHashMap<>();
        for (ProducePlanDetailChild object : ObjectList) {
            //saleOrderDtlId:销售订单明细ID
            String saleOrderDtlId = object.getSaleOrderDtlId();
            if (saleOrderDtlId != null && saleOrderDtlId.trim().length() > 0) {
                orderDetailMap.put(saleOrderDtlId, saleOrderDtlId);
            }
        }

        StringBuffer orderDtlIdBuf = new StringBuffer();
        //遍历orderDetailMap<销售订单明细id, 销售订单明细id> 生成货品合并json字符串
        if (orderDetailMap != null) {
            for (Iterator iterator = orderDetailMap.keySet().iterator(); iterator.hasNext();) {
                String mapKey_orderDtlId = iterator.next().toString().trim();
                if (mapKey_orderDtlId != null && mapKey_orderDtlId.trim().length() > 0) {
                    orderDtlIdBuf.append(mapKey_orderDtlId).append(",");
                }
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (orderDtlIdBuf != null && orderDtlIdBuf.toString().trim().length() > 0) {
            String orderDtlIds = StringUtil.stringTrimSpace(orderDtlIdBuf.toString().trim());
            orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";

            PageData findMap = new PageData();
            findMap.put("ids", orderDtlIds);
            List<Map> tableMapList = orderDetailService.getDataListPage(findMap, null);

            //获取订单编号
            StringBuffer orderCodeBuf = new StringBuffer();
            if (tableMapList != null && tableMapList.size() > 0) {
                for (Map<String, Object> mapData : tableMapList) {
                    String sysCode = (String)mapData.get("sysCode");
                    if (sysCode != null && sysCode.trim().length() > 0) {
                        orderCodeBuf.append(sysCode).append(",");
                    }
                }
            }

            //orderCodes 订单编号
            String orderCodes = new String();
            if (orderCodeBuf != null && orderCodeBuf.toString().trim().length() > 0) {
                orderCodes = StringUtil.stringTrimSpace(orderCodeBuf.toString().trim());
            }
            valueMap.put("orderCodes", orderCodes);

            //订单约定交期
            if (tableMapList != null && tableMapList.size() == 1) {
                Map<String, Object> mapData = tableMapList.get(0);
                String expectDate = new String();
                if (mapData.get("expectDate") != null) {
                    expectDate = mapData.get("expectDate").toString().trim();
                }
                valueMap.put("expectDate", expectDate);
            }
        }

        return valueMap;
    }

}



