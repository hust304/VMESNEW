package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleInvoiceMapper;
import com.xy.vmes.entity.SaleInvoice;
import com.xy.vmes.service.SaleInvoiceService;
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
* 说明：vmes_sale_invoice:发票 实现类
* 创建人：陈刚 自动创建
* 创建时间：2019-01-08
*/
@Service
@Transactional(readOnly = false)
public class SaleInvoiceServiceImp implements SaleInvoiceService {


    @Autowired
    private SaleInvoiceMapper saleInvoiceMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-01-08
    */
    @Override
    public void save(SaleInvoice saleInvoice) throws Exception{
        saleInvoice.setId(Conv.createUuid());
        saleInvoice.setCdate(new Date());
        saleInvoice.setUdate(new Date());
        saleInvoiceMapper.insert(saleInvoice);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public SaleInvoice selectById(String id) throws Exception{
        return saleInvoiceMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<SaleInvoice> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleInvoice> warehouseCheckDetailList =  saleInvoiceMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void update(SaleInvoice object) throws Exception{
        object.setUdate(new Date());
        saleInvoiceMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateAll(SaleInvoice object) throws Exception{
        object.setUdate(new Date());
        saleInvoiceMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleInvoiceMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleInvoiceMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleInvoiceMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleInvoiceMapper.updateToDisableByIds(ids);
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
    public List<SaleInvoice> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleInvoice>();
        }

        return this.dataList(pageData);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<SaleInvoice> dataList(PageData pd) throws Exception{
        return saleInvoiceMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-01-08
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleInvoiceMapper.getDataListPage(pd,pg);
    }

    public void updateStateByInvoice(String state, String ids) throws Exception {
        if (state == null || state.trim().length() == 0) {return;}
        if (ids == null || ids.trim().length() == 0) {return;}

        PageData pageData = new PageData();
        pageData.put("state", state);

        ids = StringUtil.stringTrimSpace(ids);
        ids = "'" + ids.replace(",", "','") + "'";
        pageData.put("ids", "id in (" + ids + ")");

        saleInvoiceMapper.updateStateByInvoice(pageData);
    }

    public SaleInvoice findSaleInvoice(PageData object) throws Exception{
        List<SaleInvoice> objectList = this.findSaleInvoiceList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public SaleInvoice findSaleInvoiceById(String id) throws Exception{
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleInvoice(findMap);
    }

    public List<SaleInvoice> findSaleInvoiceList(PageData object) throws Exception{
        return this.findDataList(object, null);
    }
}



