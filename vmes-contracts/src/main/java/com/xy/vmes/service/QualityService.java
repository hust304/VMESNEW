package com.xy.vmes.service;

import com.xy.vmes.entity.Quality;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_quality:质量检验项目 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-12-28
*/
public interface QualityService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void save(Quality object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void update(Quality object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    void updateAll(Quality object) throws Exception;

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
    Quality selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    List<Quality> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    List<Quality> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-12-28
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;
    List<Map> findListProductByQuality(PageData pd, Pagination pg) throws Exception;

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
    List<Quality> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    Quality findQuality(PageData object) throws Exception;
    Quality findQualityById(String id) throws Exception;
    List<Quality> findQualityList(PageData object) throws Exception;

    /**
     * 修改货品表
     * purchase:采购:(vmes_product.purchase_quality_type)字段
     *
     * @param business     业务名称 (purchase:采购)
     * @param productIds   货品id ','逗号分隔的字符串
     * @param qualityType  质验方式
     */
    void updateProductQuality(String business, String productIds, String qualityType);

    /**
     * 获取(质检项,检验标准) 在系统表(vmes_quality) 中是否存在
     * (企业id,货品id,业务名称)系统表(vmes_quality)字段
     *
     * @param id
     * @param productId  货品id
     * @param business   业务名称
     * @param name       质检项
     * @param criterion  检验标准
     * @return
     */
    boolean isExistByQuality(String id,
                             String productId,
                             String business,
                             String name,
                             String criterion) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * (质量-采购质检)分页查询
     *
     * @param pd    查询参数对象PageData
     * @return      返回对象ResultModel
     * @throws Exception
     */
    ResultModel listPageProductByQuality(PageData pd) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageQuality(PageData pd) throws Exception;

    //获取(质量-采购检验)采购签收明细检验项目
    //菜单路径:(质量-采购检验) 当前采购签收明细(执行)按钮弹出框查询调用方法
    ResultModel findQualityByPurchaseSignDtl(PageData pd) throws Exception;
    //获取(质量-外协检验) 外协件货品检验项目
    ResultModel findQualityByAssist(PageData pd) throws Exception;

    ResultModel addQuality(PageData pd) throws Exception;
    ResultModel updateQuality(PageData pd) throws Exception;
}



