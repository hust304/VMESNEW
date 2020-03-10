package com.xy.vmes.deecoop.produce.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.deecoop.produce.dao.ProducePlanMapper;
import com.xy.vmes.entity.ProducePlan;
import com.xy.vmes.service.ProducePlanService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_produce_plan:生产计划 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-02-26
*/
@Service
@Transactional(readOnly = false)
public class ProducePlanServiceImp implements ProducePlanService {
    @Autowired
    private ProducePlanMapper producePlanMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void save(ProducePlan object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        producePlanMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public ProducePlan selectById(String id) throws Exception{
        return producePlanMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public List<ProducePlan> selectByColumnMap(Map columnMap) throws Exception{
        List<ProducePlan> warehouseCheckDetailList = producePlanMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void update(ProducePlan object) throws Exception{
        object.setUdate(new Date());
        producePlanMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void updateAll(ProducePlan object) throws Exception{
        object.setUdate(new Date());
        producePlanMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void deleteById(String id) throws Exception{
        producePlanMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        producePlanMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        producePlanMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        producePlanMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    public List<ProducePlan> dataList(PageData pd) throws Exception{
        return producePlanMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return producePlanMapper.getDataListPage(pd);
        } else if (pg != null) {
            return producePlanMapper.getDataListPage(pd,pg);
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
    public List<ProducePlan> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<ProducePlan>();
        }

        return this.dataList(pageData);
    }

    public ProducePlan findProducePlan(PageData object) throws Exception {
        List<ProducePlan> objectList = this.findProducePlanList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public ProducePlan findProducePlanById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findProducePlan(findMap);
    }
    public List<ProducePlan> findProducePlanList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    *
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    public ResultModel listPageProducePlan(PageData pd) throws Exception{
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("producePlan");
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

        List<Map> varList = this.getDataListPage(pd, pg);
        if (varList != null && varList.size() > 0) {
            //获取系统时间(yyyy-MM-dd)
            String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
            Date sysDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);

            for (Map<String, Object> mapObject : varList) {
                //state 生产计划状态(1:未完成 2:已完成 -1:已取消)
                String state = (String)mapObject.get("state");
                Integer stateInt = Integer.valueOf(state);

                //isExceedTime:是否逾期 1:逾期 0:非逾期
                String isExceedTime = new String("0");
                //dayCount 剩余/逾期 天数
                String dayCount = new String();

                //生产计划状态 1:未完成
                if (1 == stateInt.intValue()) {
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

                    //生产计划状态 2:已完成
                } else if (2 == stateInt.intValue()) {
                    //(计划结束日期 - 计划完成日期) 差值

                    //planDate 计划完成日期 (yyyy-MM-dd)
                    String planDateStr = (String)mapObject.get("planDate");
                    //endDate 计划结束日期(yyyy-MM-dd)
                    String endDateStr = (String)mapObject.get("endDate");

                    if (planDateStr != null && planDateStr.trim().length() > 0 && endDateStr != null && endDateStr.trim().length() > 0) {
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
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }


}

