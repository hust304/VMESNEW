package com.xy.vmes.deecoop.produce.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.EvaluateUtil;
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
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    /**
     * 获取jsonMapList中 (计划开始日期, 计划结束日期)
     * 遍历jsonMapList
     *   计划开始日期: jsonMapList中最小值(计划开始日期)
     *   计划结束日期: jsonMapList中最大值(计划结束日期)
     *
     * 返回值 Map<String, Date>
     *     mapKey:
     *       beginDate: 计划开始日期
     *       endDate  : 计划结束日期
     *
     * @param jsonMapList
     * @return
     */
    public Map<String, Date> findBeginEndDate(List<Map<String, String>> jsonMapList) {
        String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        Date sysDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        Map<String, Date> valueMap = new HashMap<>();
        valueMap.put("beginDate", sysDate);
        valueMap.put("endDate", sysDate);
        if (jsonMapList == null || jsonMapList.size() == 0) {return valueMap;}

        //遍历 jsonMapList 添加生产计划明细
        List<ProducePlanDetail> dtlList = new ArrayList<>();
        if (jsonMapList != null && jsonMapList.size() > 0) {
            for (Map<String, String> mapObject : jsonMapList) {
                ProducePlanDetail dtlObj = new ProducePlanDetail();

                Date beginDate_dtl = sysDate;
                String beginDate_dtl_Str = mapObject.get("beginDate");
                if (beginDate_dtl_Str != null && beginDate_dtl_Str.trim().length() > 0) {
                    beginDate_dtl = DateFormat.dateString2Date(beginDate_dtl_Str, DateFormat.DEFAULT_DATE_FORMAT);
                }
                dtlObj.setBeginDate(beginDate_dtl);

                //计划结束日期 默认(计划开始日期)
                Date endDate_dtl = beginDate_dtl;
                String endDate_dtl_Str = mapObject.get("endDate");
                if (endDate_dtl_Str != null && endDate_dtl_Str.trim().length() > 0) {
                    endDate_dtl = DateFormat.dateString2Date(endDate_dtl_Str, DateFormat.DEFAULT_DATE_FORMAT);
                }
                dtlObj.setEndDate(endDate_dtl);

                dtlList.add(dtlObj);
            }
        }

        long minBeginLong = -1;
        long maxEndLong = -1;
        for (int i = 0; i < dtlList.size(); i++) {
            ProducePlanDetail dtlObj = dtlList.get(i);

            //beginDate 计划开始日期
            Date beginDate = dtlObj.getBeginDate();
            long beginL = beginDate.getTime();

            //endDate 计划结束日期
            Date endDate = dtlObj.getEndDate();
            long endL = endDate.getTime();

            if (i == 0) {
                minBeginLong = beginDate.getTime();
                maxEndLong = endDate.getTime();
            } else if (i > 0) {
                if (beginL < minBeginLong) {minBeginLong = beginL;}
                if (endL > maxEndLong) {maxEndLong = endL;}
            }
        }

        Date beginDate = new Date(minBeginLong);
        valueMap.put("beginDate", beginDate);

        Date maxDate = new Date(maxEndLong);
        valueMap.put("endDate", maxDate);

        return valueMap;
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

                //合格/不合格 fineBadCount
                BigDecimal fineCount = (BigDecimal)mapObject.get("fineCount");
                BigDecimal badCount = (BigDecimal)mapObject.get("fineCount");
                String fineBadCount = fineCount.toString() + "&nbsp;/&nbsp;" + badCount.toString();
                mapObject.put("fineBadCount", fineBadCount);

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
                        } else if (days == 0) {
                            dayCount = "0 天";
                        }
                    }

                    //生产计划明细状态 2:已完成
                } else if (2 == stateInt.intValue()) {
                    //(计划结束日期 - 计划完成日期) 差值

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
                        } else if (days == 0) {
                            dayCount = "0 天";
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


    @Override
    public ResultModel listPageMaterialRequisitionGroupDetail(PageData pd) throws Exception {
        ResultModel model = new ResultModel();


        //出库单明细表 (出库模块与报废模块)
        //modelCode:WarehouseOutDetail 出库模块
        //modelCode:WarehouseScrapDetail 报废模块
        String modelCode = "WarehouseOutDetail";
        String typeName = pd.getString("typeName");
        if (typeName != null && "报废处理".equals(typeName)) {
            modelCode = "WarehouseScrapDetail";
        }else if (typeName != null && "领料明细".equals(typeName)) {
            modelCode = "MaterialRequisitionDetail";
        }

        List<Column> columnList = columnService.findColumnList(modelCode);
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

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        Pagination pg =  HttpUtils.parsePagination(pd);
        result.put("pageData", pg);

        List<Map> varList = producePlanDetailMapper.getMaterialRequisitionGroupDetail(pd,pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> mapObject : varList) {
                //priceCount 计价单位数量
                BigDecimal priceCount = BigDecimal.valueOf(0D);
                if (mapObject.get("priceCount") != null) {
                    priceCount = (BigDecimal)mapObject.get("priceCount");
                }

                //n2pIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String n2pIsScale = new String();
                if (mapObject.get("n2pIsScale") != null) {
                    n2pIsScale = mapObject.get("n2pIsScale").toString().trim();
                }

                //小数位数 (最小:0位 最大:4位)
                Integer n2pDecimalCount = Integer.valueOf(2);
                if (mapObject.get("n2pDecimalCount") != null) {
                    n2pDecimalCount = (Integer)mapObject.get("n2pDecimalCount");
                }
                priceCount = StringUtil.scaleDecimal(priceCount, n2pIsScale, n2pDecimalCount);
                mapObject.put("priceCount", priceCount.toString());

                //n2pFormula (计量单位转换计价单位公式)
                String n2pFormula = (String)mapObject.get("n2pFormula");
                //stockCount (计量单位)库存数量
                BigDecimal stockCount = BigDecimal.valueOf(0D);
                if (mapObject.get("stockCount") != null) {
                    stockCount = (BigDecimal)mapObject.get("stockCount");
                }

                //stockCountByPrice        (计价单位)库存数量
                BigDecimal stockCountByPrice = EvaluateUtil.countFormulaN2P(stockCount, n2pFormula);
                stockCountByPrice = StringUtil.scaleDecimal(stockCountByPrice, n2pIsScale, n2pDecimalCount);
                mapObject.put("stockCountByPrice", stockCountByPrice.toString());

                //count 出库数量(计量单位)
                BigDecimal count = BigDecimal.valueOf(0D);
                if (mapObject.get("count") != null) {
                    count = (BigDecimal)mapObject.get("count");
                }
                //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String p2nIsScale = new String();
                if (mapObject.get("p2nIsScale") != null) {
                    p2nIsScale = mapObject.get("p2nIsScale").toString().trim();
                }

                //小数位数 (最小:0位 最大:4位)
                Integer p2nDecimalCount = Integer.valueOf(2);
                if (mapObject.get("p2nDecimalCount") != null) {
                    p2nDecimalCount = (Integer)mapObject.get("p2nDecimalCount");
                }
                count = StringUtil.scaleDecimal(count, p2nIsScale, p2nDecimalCount);
                mapObject.put("count", count.toString());

                //executeCount 已完成数量(计量单位)
                BigDecimal executeCount = BigDecimal.valueOf(0D);
                if (mapObject.get("executeCount") != null) {
                    executeCount = (BigDecimal)mapObject.get("executeCount");
                }
                executeCount = StringUtil.scaleDecimal(executeCount, p2nIsScale, p2nDecimalCount);
                mapObject.put("executeCount", executeCount.toString());
            }
        }
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

            //获取最小订单约定交期 expectDate(yyyy-MM-dd)
            long minExpectDateLong = -1;
            if (tableMapList != null && tableMapList.size() > 0) {
                for (int i = 0; i < tableMapList.size(); i++) {
                    Map<String, Object> mapData = tableMapList.get(i);

                    String expectDateStr = (String)mapData.get("expectDate");
                    Date expectDate = DateFormat.dateString2Date(expectDateStr, DateFormat.DEFAULT_DATE_FORMAT);
                    long expectL = expectDate.getTime();

                    if (i == 0) {
                        minExpectDateLong = expectL;
                    } else if (i > 0) {
                        if (expectL < minExpectDateLong) {minExpectDateLong = expectL;}
                    }
                }
            }

            String expectDateStr = new String();
            if (minExpectDateLong != -1) {
                Date expectDate = new Date(minExpectDateLong);
                expectDateStr = DateFormat.date2String(expectDate, DateFormat.DEFAULT_DATE_FORMAT);
            }
            valueMap.put("expectDate", expectDateStr);
        }

        return valueMap;
    }

    public static void main(String args[]) throws Exception {
        ProducePlanDetailServiceImp testService = new ProducePlanDetailServiceImp();

        List<Map<String, String>> jsonMapList = new ArrayList<>();
        Map<String, String> map_1 = new HashMap<>();
        map_1.put("beginDate", "2020-03-05");
        map_1.put("endDate", "2020-03-05");
//        map_1.put("beginDate", null);
//        map_1.put("endDate", null);
        jsonMapList.add(map_1);

        Map<String, String> map_2 = new HashMap<>();
        map_2.put("beginDate", "2020-03-01");
        map_2.put("endDate", "2020-03-03");
//        map_2.put("beginDate", null);
//        map_2.put("endDate", null);
        jsonMapList.add(map_2);

        Map<String, String> map_3 = new HashMap<>();
        map_3.put("beginDate", "2020-02-06");
        map_3.put("endDate", "2020-02-10");
        jsonMapList.add(map_3);

        Map<String, Date> valueMap = testService.findBeginEndDate(jsonMapList);
        Date beginDate = valueMap.get("beginDate");
        String beginDateStr = DateFormat.date2String(beginDate, DateFormat.DEFAULT_DATE_FORMAT);

        Date endDate = valueMap.get("endDate");
        String endDateStr = DateFormat.date2String(endDate, DateFormat.DEFAULT_DATE_FORMAT);

        System.out.println("beginDateStr:" + beginDateStr + " endDateStr:" + endDateStr);

    }

}



