package com.xy.vmes.deecoop.produce.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.produce.dao.ProducePlanQualityDetailMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.ProducePlanQualityDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.ProducePlanQualityDetailService;

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
* 说明：vmes_produce_plan_quality_detail:生产计划明细检验报工表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-03-03
*/
@Service
@Transactional(readOnly = false)
public class ProducePlanQualityDetailServiceImp implements ProducePlanQualityDetailService {
    @Autowired
    private ProducePlanQualityDetailMapper producePlanQualityDetailMapper;
    @Autowired
    private ColumnService columnService;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    @Override
    public void save(ProducePlanQualityDetail object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        producePlanQualityDetailMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    @Override
    public ProducePlanQualityDetail selectById(String id) throws Exception{
        return producePlanQualityDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    @Override
    public List<ProducePlanQualityDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<ProducePlanQualityDetail> warehouseCheckDetailList = producePlanQualityDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    @Override
    public void update(ProducePlanQualityDetail object) throws Exception{
        object.setUdate(new Date());
        producePlanQualityDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    @Override
    public void updateAll(ProducePlanQualityDetail object) throws Exception{
        object.setUdate(new Date());
        producePlanQualityDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    @Override
    public void deleteById(String id) throws Exception{
        producePlanQualityDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        producePlanQualityDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        producePlanQualityDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        producePlanQualityDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    public List<ProducePlanQualityDetail> dataList(PageData pd) throws Exception{
        return producePlanQualityDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-03-03
     */
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return producePlanQualityDetailMapper.getDataListPage(pd);
        } else if (pg != null) {
            return producePlanQualityDetailMapper.getDataListPage(pd,pg);
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
    public List<ProducePlanQualityDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<ProducePlanQualityDetail>();
        }

        return this.dataList(pageData);
    }

    public ProducePlanQualityDetail findPlanQualityDetail(PageData object) throws Exception {
        List<ProducePlanQualityDetail> objectList = this.findPlanQualityDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public ProducePlanQualityDetail findPlanQualityDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findPlanQualityDetail(findMap);
    }

    public List<ProducePlanQualityDetail> findPlanQualityDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<ProducePlanQualityDetail> findPlanQualityDetailListByPlanId(String planId) throws Exception {
        if (planId == null || planId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("planId", planId);
        findMap.put("orderStr", "cdate asc");

        return this.findPlanQualityDetailList(findMap);
    }
    public List<ProducePlanQualityDetail> findPlanQualityDetailListByPlanDtlId(String planDtlId) throws Exception {
        if (planDtlId == null || planDtlId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("planDtlId", planDtlId);
        findMap.put("orderStr", "cdate asc");

        return this.findPlanQualityDetailList(findMap);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param pd    查询参数对象PageData
     * @return      返回对象ResultModel
     * @throws Exception
     */
    public ResultModel listPageProducePlanQualityDetail(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Column> columnList = columnService.findColumnList("producePlanQualityDetail");
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
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }

    /**
     * vmes_produce_plan_quality_detail:生产计划明细检验报工表
     * 返回货品入库Map
     * 货品入库Map<生产计划明细检验报工id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     *
     * @param detailList
     * @return
     */
    public Map<String, Map<String, Object>> findProductMapByIn(List<ProducePlanQualityDetail> detailList) {
        Map<String, Map<String, Object>> productByInMap = new HashMap<>();
        if (detailList == null || detailList.size() == 0) {return productByInMap;}

        for (ProducePlanQualityDetail dtlObject : detailList) {
            String detailId = dtlObject.getId();

            String productId = dtlObject.getProductId();

            //fineCount:(检验)合格数量(计量数量) := inCount 入库数量
            BigDecimal fineCount = BigDecimal.valueOf(0D);
            if (dtlObject.getFineCount() != null) {
                fineCount = dtlObject.getFineCount();
            }
            //四舍五入到2位小数
            fineCount = fineCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

            Map<String, Object> productMap = new HashMap<>();
            productMap.put("productId", productId);
            productMap.put("inDtlId", null);
            productMap.put("inCount", fineCount);

            productByInMap.put(detailId, productMap);
        }

        return productByInMap;
    }


}



