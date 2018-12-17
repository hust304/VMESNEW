package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.sale.dao.SaleDeliverDetailMapper;
import com.xy.vmes.entity.SaleDeliver;
import com.xy.vmes.entity.SaleDeliverDetail;
import com.xy.vmes.service.SaleDeliverDetailService;
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
* 说明：vmes_sale_deliver_detail:发货明细 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-12-15
*/
@Service
@Transactional(readOnly = false)
public class SaleDeliverDetailServiceImp implements SaleDeliverDetailService {

    @Autowired
    private SaleDeliverDetailMapper saleDeliverDetailMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-12-15
    */
    @Override
    public void save(SaleDeliverDetail saleDeliverDetail) throws Exception{
        saleDeliverDetail.setId(Conv.createUuid());
        saleDeliverDetail.setCdate(new Date());
        saleDeliverDetail.setUdate(new Date());
        saleDeliverDetailMapper.insert(saleDeliverDetail);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public SaleDeliverDetail selectById(String id) throws Exception{
        return saleDeliverDetailMapper.selectById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<SaleDeliverDetail> selectByColumnMap(Map columnMap) throws Exception{
        List<SaleDeliverDetail> warehouseCheckDetailList =  saleDeliverDetailMapper.selectByMap(columnMap);
        return warehouseCheckDetailList;
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void update(SaleDeliverDetail object) throws Exception{
        object.setUdate(new Date());
        saleDeliverDetailMapper.updateById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void updateAll(SaleDeliverDetail object) throws Exception{
        object.setUdate(new Date());
        saleDeliverDetailMapper.updateAllColumnById(object);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteById(String id) throws Exception{
        saleDeliverDetailMapper.deleteById(id);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        saleDeliverDetailMapper.deleteByIds(ids);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        saleDeliverDetailMapper.deleteByMap(columnMap);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        saleDeliverDetailMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<SaleDeliverDetail> dataList(PageData pd) throws Exception{
        return saleDeliverDetailMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-12-15
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return saleDeliverDetailMapper.getDataListPage(pd,pg);
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
    public List<SaleDeliverDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception {
        int pageDataSize = 0;
        if (pageData != null && pageData.size() > 0) {
            pageDataSize = pageData.size();
        }

        if ((isQueryAll == null || true != isQueryAll.booleanValue()) && pageDataSize == 0) {
            return new ArrayList<SaleDeliverDetail>();
        }

        return this.dataList(pageData);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addDeliverDetail(SaleDeliver parentObj, List<SaleDeliverDetail> detailList) throws Exception {
        if (parentObj == null) {return;}
        if (detailList == null || detailList.size() == 0) {return;}

        for (SaleDeliverDetail detail : detailList) {
            //state:状态(0:待发货 1:已发货 -1:已取消)
            detail.setState("0");
            detail.setParentId(parentObj.getId());
            detail.setCuser(parentObj.getCuser());

            this.save(detail);
        }
    }
}



