package com.xy.vmes.service;

import com.xy.vmes.entity.AssistOrderDetail;
import com.xy.vmes.entity.AssistOrderDetailChild;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_order_detail_child:外协订单明细子表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-04-24
*/
public interface AssistOrderDetailChildService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void save(AssistOrderDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void update(AssistOrderDetailChild object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    void updateAll(AssistOrderDetailChild object) throws Exception;

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
    AssistOrderDetailChild selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    List<AssistOrderDetailChild> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-04-24
     */
    List<AssistOrderDetailChild> dataList(PageData pd) throws Exception;

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
    List<AssistOrderDetailChild> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    AssistOrderDetailChild findOrderDetailChild(PageData object) throws Exception;
    AssistOrderDetailChild findOrderDetailChildById(String id) throws Exception;
    List<AssistOrderDetailChild> findOrderDetailChildList(PageData object) throws Exception;

    /**
     * 根据(外协订单id) 汇总查询取外协件原材料(成品签收检验,原材料退货检验,原材料报废,成品报废,) 验证外协订单状态
     * 查询SQL:AssistOrderDetailChildMapper.findCheckAssistOrderChild
     *
     * @param orderId    外协订单id
     * @return
     */
    List<Map<String, Object>> findCheckAssistOrderChild(String orderId);

    /**
     * 返回完成的外协订单id
     * 1. 遍历查询结果集
     * 2. 比较 orderCount(原材料订单数量) assistCount 原材料(成品签收检验,成品报废,原材料报废,原材料退回检验)
     * 3. 全部原材料 (原材料订单数量 <= 原材料(成品签收检验,成品报废,原材料报废,原材料退回检验))
     *
     * @param mapList
     * @throws Exception
     */
    String finishOrderByAssistOrderChild(List<Map<String, Object>> mapList);

    /**
     * 外协订单明细子表(外协件)详情查询
     * 外协订单明细(外协件)详情查询
     *
     * @param pd
     * @param pg
     * @return
     * @throws Exception
     */
    List<Map> listAssistOrderDetailChildInfo(PageData pd, Pagination pg) throws Exception;

    /**
     * 获取 外协收货明细子表(原材料) 当前发货数量
     * SQL: AssistOrderDetailChildMapper.findAssistOrderDetailChildByDeliverChild
     *
     * @param orderId    外协订单id
     * @param orderDtlId 外协订单明细id
     * @return
     */
    List<Map<String, Object>> findAssistOrderDetailChildByDeliverChild(String orderId, String orderDtlId);

    /**
     * 获取订单明细id(外协件)最小发货数量
     * 1. 获取订单明细id(外协件)-所有原材料的发货数量
     * 2. 获取订单明细id(外协件)最小发货数量 (原材料的发货数量,单件用量)
     *
     * @param orderDtlId
     * @return
     */
    int findMiniDeliverCountByOrderDetail(String orderDtlId);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void insertAssistOrderDetailChild(AssistOrderDetail assistOrderDetail) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageAssistOrderDetailChild(PageData pd) throws Exception;
    ResultModel listPageAssistOrderDetailChildInfo(PageData pd) throws Exception;



}



