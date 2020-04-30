package com.xy.vmes.service;

import com.xy.vmes.entity.AssistOrder;
import com.xy.vmes.entity.AssistOrderDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_order_detail:外协订单明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-04-24
*/
public interface AssistOrderDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void save(AssistOrderDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void update(AssistOrderDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void updateAll(AssistOrderDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    AssistOrderDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    List<AssistOrderDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    List<AssistOrderDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
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
    List<AssistOrderDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistOrderDetail findAssistOrderDetail(PageData object) throws Exception;
    AssistOrderDetail findAssistOrderDetailById(String id) throws Exception;

    List<AssistOrderDetail> findAssistOrderDetailList(PageData object) throws Exception;
    List<AssistOrderDetail> findAssistOrderDetailListByParentId(String parentId) throws Exception;

    List<AssistOrderDetail> mapList2DetailList(List<Map<String, String>> mapList, List<AssistOrderDetail> objectList);
    BigDecimal findTotalAmount(List<AssistOrderDetail> objectList);

    /**
     * 获取外协订单状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
     *
     * @param dtlList      外协订单明细List<AssistOrderDetail>
     * @return
     */
    String findParentStateByDetail(List<AssistOrderDetail> dtlList);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void updateStateByDetail(String state, String parentIds) throws Exception;
    /**
     * 根据订单明细状态-反写订单状态
     * 订单状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
     * 订单明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
     *
     * @param parent       订单对象
     * @param detailList   订单明细List<SaleOrderDetail>
     */
    void updateParentStateByDetailList(AssistOrder parent, List<AssistOrderDetail> detailList) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistOrderDetail(PageData pd) throws Exception;


}



