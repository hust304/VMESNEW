package com.xy.vmes.service;

import com.xy.vmes.entity.PurchaseQualityDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_purchase_quality_detail:采购质检项明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-01-09
*/
public interface PurchaseQualityDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    void save(PurchaseQualityDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    void update(PurchaseQualityDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    void updateAll(PurchaseQualityDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    PurchaseQualityDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    List<PurchaseQualityDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
     */
    List<PurchaseQualityDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-01-09
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
    List<PurchaseQualityDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPagePurchaseQualityDetail(PageData pd) throws Exception;

//    //获取(质量-采购检验)采购签收明细检验项目
//    //菜单路径:(质量-采购检验) 当前采购签收明细(执行)按钮弹出框查询调用方法
//    ResultModel listPagePurchaseQualityDetailByQualityExecute(PageData pd) throws Exception;
}



