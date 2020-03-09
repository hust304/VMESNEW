package com.xy.vmes.service;

import com.xy.vmes.entity.ProducePlanDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_produce_plan_detail:生产计划明细 接口类
* 创建人：陈刚 自动生成
* 创建时间：2020-02-27
*/
public interface ProducePlanDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    void save(ProducePlanDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    void update(ProducePlanDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    void updateAll(ProducePlanDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    ProducePlanDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    List<ProducePlanDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
     */
    List<ProducePlanDetail> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2020-02-27
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
    List<ProducePlanDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    ProducePlanDetail findProducePlanDetail(PageData object) throws Exception;
    ProducePlanDetail findProducePlanDetailById(String id) throws Exception;

    List<ProducePlanDetail> findProducePlanDetailList(PageData object) throws Exception;
    List<ProducePlanDetail> findProducePlanDetailListByParentId(String parentId) throws Exception;

    /**
     * 获取生产计划状态-根据生产计划明细状态
     * 生产计划状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
     * 生产计划明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
     *
     * @param dtlList      生产计划明细List<SaleOrderDetail>
     * @return
     */
    String findParentStateByDetail(List<ProducePlanDetail> dtlList);

    /**
     * 判断生产计划明细是否允许删除
     * 明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
     *
     * false: 不允许删除: 生产计划明细中含有(1:生产中 2:已完成)
     * true:  允许删除
     *
     * @param dtlList
     * @return
     */
    boolean isAllowDeleteByDetail(List<ProducePlanDetail> dtlList);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void updateStateByDetail(String state, String parentIds) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageProducePlanDetail(PageData pd) throws Exception;
    //生产计划明细(检验)报工
    ResultModel listPageProducePlanDetailByQuality(PageData pd) throws Exception;

    ResultModel listPageMaterialRequisition(PageData pd) throws Exception;
    ResultModel listPageMaterialRequisitionGroup(PageData pd) throws Exception;


}



