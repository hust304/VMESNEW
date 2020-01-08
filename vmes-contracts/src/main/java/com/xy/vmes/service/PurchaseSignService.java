package com.xy.vmes.service;

import com.xy.vmes.entity.PurchaseSign;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_sign:采购签收 接口类
* 创建人：刘威 自动生成
* 创建时间：2019-03-12
*/
public interface PurchaseSignService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void save(PurchaseSign object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void update(PurchaseSign object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void updateAll(PurchaseSign object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    PurchaseSign selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    List<PurchaseSign> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    List<PurchaseSign> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

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
    List<PurchaseSign> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    PurchaseSign findPurchaseSign(PageData object) throws Exception;
    PurchaseSign findPurchaseSignById(String id) throws Exception;
    List<PurchaseSign> findPurchaseSignList(PageData object) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPagePurchaseSign(PageData pd) throws Exception;

    //////////////////////////////////////////////////////////////////////////////////
    /**
     * 创建采购签收单及签收明细
     *
     * @param cuser      当前用户id
     * @param companyId  企业id
     * @param orderId    采购订单id
     * @param valueMap   参数Map<String, Object>
     *   productByInMap: 入库货品数据Map
     *   jsonMapList：    签收界面传回json数据
     * @throws Exception
     */
//    void createPurchaseSign(String cuser,
//                            String companyId,
//                            String orderId,
//                            Map<String, Object> valueMap) throws Exception;

}



