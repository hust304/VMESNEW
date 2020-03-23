package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.deecoop.purchase.dao.PurchasePlanDetailChildMapper;
import com.xy.vmes.entity.PurchasePlanDetailChild;
import com.xy.vmes.service.PurchasePlanDetailChildService;
import com.yvan.Conv;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_purchase_plan_detail_child:采购计划明细子表 实现类
 * 创建人：陈刚 自动创建
 * 创建时间：2020-03-23
 */
@Service
public class PurchasePlanDetailChildServiceImp implements PurchasePlanDetailChildService {
    @Autowired
    private PurchasePlanDetailChildMapper purchasePlanDetailChildMapper;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void save(PurchasePlanDetailChild object) throws Exception{
        object.setId(Conv.createUuid());
        object.setCdate(new Date());
        object.setUdate(new Date());
        purchasePlanDetailChildMapper.insert(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public PurchasePlanDetailChild selectById(String id) throws Exception{
        return purchasePlanDetailChildMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public List<PurchasePlanDetailChild> selectByColumnMap(Map columnMap) throws Exception{
        List<PurchasePlanDetailChild> warehouseCheckDetailList = purchasePlanDetailChildMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void update(PurchasePlanDetailChild object) throws Exception{
        object.setUdate(new Date());
        purchasePlanDetailChildMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateAll(PurchasePlanDetailChild object) throws Exception{
        object.setUdate(new Date());
        purchasePlanDetailChildMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteById(String id) throws Exception{
        purchasePlanDetailChildMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        purchasePlanDetailChildMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        purchasePlanDetailChildMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        purchasePlanDetailChildMapper.updateToDisableByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    public List<PurchasePlanDetailChild> dataList(PageData pd) throws Exception{
        return purchasePlanDetailChildMapper.dataList(pd);
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
    public List<PurchasePlanDetailChild> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<PurchasePlanDetailChild>();
        }

        return this.dataList(pageData);
    }

    public PurchasePlanDetailChild findPlanDetailChild(PageData object) throws Exception {
        List<PurchasePlanDetailChild> objectList = this.findPlanDetailChildList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public PurchasePlanDetailChild findPlanDetailChildById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findPlanDetailChild(findMap);
    }

    public List<PurchasePlanDetailChild> findPlanDetailChildList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }
    public List<PurchasePlanDetailChild> findPlanDetailChildListByPlanId(String planId) throws Exception {
        if (planId == null || planId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("planId", planId);
        findMap.put("orderStr", "cdate asc");

        return this.findPlanDetailChildList(findMap);
    }
    public List<PurchasePlanDetailChild> findPlanDetailChildListByPlanDtlId(String planDtlId) throws Exception {
        if (planDtlId == null || planDtlId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("planDtlId", planDtlId);
        findMap.put("orderStr", "cdate asc");

        return this.findPlanDetailChildList(findMap);
    }
}
