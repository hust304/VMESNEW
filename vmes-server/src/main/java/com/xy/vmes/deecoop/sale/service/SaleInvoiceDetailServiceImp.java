package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleInvoiceDetailMapper;
import com.xy.vmes.entity.SaleInvoiceDetail;
import com.xy.vmes.service.SaleInvoiceDetailService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
* 说明：vmes_sale_invoice_detail:发票明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-01-08
*/
@Service
@Transactional(readOnly = false)
public class SaleInvoiceDetailServiceImp implements SaleInvoiceDetailService {


    @Autowired
    private SaleInvoiceDetailMapper saleInvoiceDetailMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    @Override
    public void save(SaleInvoiceDetail saleInvoiceDetail) throws Exception{
        saleInvoiceDetail.setId(Conv.createUuid());
        saleInvoiceDetail.setCdate(new Date());
        saleInvoiceDetail.setUdate(new Date());
        saleInvoiceDetailMapper.insert(saleInvoiceDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public SaleInvoiceDetail selectById(String id) throws Exception{
        return saleInvoiceDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<SaleInvoiceDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleInvoiceDetail> warehouseCheckDetailList =  saleInvoiceDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void update(SaleInvoiceDetail object) throws Exception{
        object.setUdate(new Date());
        saleInvoiceDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateAll(SaleInvoiceDetail object) throws Exception{
        object.setUdate(new Date());
        saleInvoiceDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleInvoiceDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleInvoiceDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleInvoiceDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleInvoiceDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<SaleInvoiceDetail> dataList(PageData pd) throws Exception{
        return saleInvoiceDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleInvoiceDetailMapper.getDataListPage(pd,pg);
    }

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
    public List<SaleInvoiceDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleInvoiceDetail>();
        }

        return this.dataList(pageData);
    }

    public SaleInvoiceDetail findSaleInvoiceDetail(PageData object) throws Exception {
        List<SaleInvoiceDetail> objectList = this.findSaleInvoiceDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public SaleInvoiceDetail findSaleInvoiceDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleInvoiceDetail(findMap);
    }

    public List<SaleInvoiceDetail> findSaleInvoiceDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public List<SaleInvoiceDetail> findSaleInvoiceDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findSaleInvoiceDetailList(findMap);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateStateByDetail(String state, String parentIds) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (parentIds == null || parentIds.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        parentIds = StringUtil.stringTrimSpace(parentIds);
        parentIds = "'" + parentIds.replace(",", "','") + "'";
        pageData.put("parentIds", "parent_id in (" + parentIds + ")");

        saleInvoiceDetailMapper.updateStateByDetail(pageData);
    }
}



