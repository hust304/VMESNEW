package com.xy.vmes.deecoop.produce.service;

import com.xy.vmes.deecoop.produce.dao.ProducePlanDetailChildMapper;
import com.xy.vmes.entity.ProducePlanDetailChild;
import com.xy.vmes.service.ProducePlanDetailChildService;

import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.yvan.Conv;

/**
* 说明：vmes_produce_plan_detail_child:生产计划明细子表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2020-02-28
*/
@Service
@Transactional(readOnly = false)
public class ProducePlanDetailChildServiceImp implements ProducePlanDetailChildService {
    @Autowired
    private ProducePlanDetailChildMapper producePlanDetailChildMapper;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void save(ProducePlanDetailChild object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        producePlanDetailChildMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public ProducePlanDetailChild selectById(String id) throws Exception{
        return producePlanDetailChildMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public List<ProducePlanDetailChild> selectByColumnMap(Map columnMap) throws Exception{
        List<ProducePlanDetailChild> warehouseCheckDetailList = producePlanDetailChildMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void update(ProducePlanDetailChild object) throws Exception{
        object.setUdate(new Date());
        producePlanDetailChildMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateAll(ProducePlanDetailChild object) throws Exception{
        object.setUdate(new Date());
        producePlanDetailChildMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteById(String id) throws Exception{
        producePlanDetailChildMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        producePlanDetailChildMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        producePlanDetailChildMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        producePlanDetailChildMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    public List<ProducePlanDetailChild> dataList(PageData pd) throws Exception{
        return producePlanDetailChildMapper.dataList(pd);
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
    public List<ProducePlanDetailChild> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<ProducePlanDetailChild>();
        }

        return this.dataList(pageData);
    }

    public ProducePlanDetailChild findPlanDetailChild(PageData object) throws Exception {
        List<ProducePlanDetailChild> objectList = this.findPlanDetailChildList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public ProducePlanDetailChild findPlanDetailChildById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findPlanDetailChild(findMap);
    }

    public List<ProducePlanDetailChild> findPlanDetailChildList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<ProducePlanDetailChild> findPlanDetailChildListByPlanId(String planId) throws Exception {
        if (planId == null || planId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("planId", planId);
        findMap.put("orderStr", "cdate asc");

        return this.findPlanDetailChildList(findMap);
    }
    public List<ProducePlanDetailChild> findPlanDetailChildListByPlanDtlId(String planDtlId) throws Exception {
        if (planDtlId == null || planDtlId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("planDtlId", planDtlId);
        findMap.put("orderStr", "cdate asc");

        return this.findPlanDetailChildList(findMap);
    }


}



