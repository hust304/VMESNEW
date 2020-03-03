package com.xy.vmes.deecoop.produce.service;

import com.xy.vmes.deecoop.produce.dao.ProducePlanQualityDetailMapper;
import com.xy.vmes.entity.ProducePlanQualityDetail;
import com.xy.vmes.service.ProducePlanQualityDetailService;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

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

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
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
     * 创建时间：2020-02-27
     */
    @Override
    public ProducePlanQualityDetail selectById(String id) throws Exception{
        return producePlanQualityDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public List<ProducePlanQualityDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<ProducePlanQualityDetail> warehouseCheckDetailList = producePlanQualityDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void update(ProducePlanQualityDetail object) throws Exception{
        object.setUdate(new Date());
        producePlanQualityDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateAll(ProducePlanQualityDetail object) throws Exception{
        object.setUdate(new Date());
        producePlanQualityDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteById(String id) throws Exception{
        producePlanQualityDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        producePlanQualityDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        producePlanQualityDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        producePlanQualityDetailMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    public List<ProducePlanQualityDetail> dataList(PageData pd) throws Exception{
        return producePlanQualityDetailMapper.dataList(pd);
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


}



