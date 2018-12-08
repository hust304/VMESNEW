package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailMapper;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.service.SaleOrderDetailService;
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
* 说明：vmes_sale_order_detail:订单明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-12-05
*/
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailServiceImp implements SaleOrderDetailService {


    @Autowired
    private SaleOrderDetailMapper saleOrderDetailMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-12-05
    */
    @Override
    public void save(SaleOrderDetail saleOrderDetail) throws Exception{
        saleOrderDetail.setId(Conv.createUuid());
        saleOrderDetail.setCdate(new Date());
        saleOrderDetail.setUdate(new Date());
        saleOrderDetailMapper.insert(saleOrderDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public SaleOrderDetail selectById(String id) throws Exception{
        return saleOrderDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<SaleOrderDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleOrderDetail> warehouseCheckDetailList =  saleOrderDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void update(SaleOrderDetail object) throws Exception{
        object.setUdate(new Date());
        saleOrderDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void updateAll(SaleOrderDetail object) throws Exception{
        object.setUdate(new Date());
        saleOrderDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleOrderDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleOrderDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleOrderDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleOrderDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<SaleOrderDetail> dataList(PageData pd) throws Exception{
        return saleOrderDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-05
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleOrderDetailMapper.getDataListPage(pd,pg);
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
    public List<SaleOrderDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleOrderDetail>();
        }

        return this.dataList(pageData);
    }

    public SaleOrderDetail findSaleOrderDetail(PageData object) throws Exception {
        List<SaleOrderDetail> objectList = this.findSaleOrderDetailList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }

    public SaleOrderDetail findSaleOrderDetailById(String id) throws Exception {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);

        return this.findSaleOrderDetail(findMap);
    }

    public List<SaleOrderDetail> findSaleOrderDetailList(PageData object) throws Exception {
        return this.findDataList(object, null);
    }

    public List<SaleOrderDetail> findSaleOrderDetailListByParentId(String parentId) throws Exception {
        if (parentId == null || parentId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        return this.findSaleOrderDetailList(findMap);
    }
}



