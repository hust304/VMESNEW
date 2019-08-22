package com.xy.vmes.service;

import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_maintain_plan:设备保养计划 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-07-25
*/
public interface EquipmentMaintainPlanService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    void save(EquipmentMaintainPlan object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    void update(EquipmentMaintainPlan object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    void updateAll(EquipmentMaintainPlan object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    EquipmentMaintainPlan selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    List<EquipmentMaintainPlan> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
     */
    List<EquipmentMaintainPlan> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-25
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
    List<EquipmentMaintainPlan> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    EquipmentMaintainPlan findMaintainPlan(PageData object) throws Exception;
    EquipmentMaintainPlan findMaintainPlanById(String id) throws Exception;
    List<EquipmentMaintainPlan> findMaintainPlanList(PageData object) throws Exception;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 添加设备保养计划
     * @param valueMap
     *
     * 参数说明:
     * valueMap Map<String, Object>
     * eqptJsonMapList: 设备jsonMapList List<Map<String, String>>
     * planObject: 周期计划设定 EquipmentMaintainPlan
     */
    void addMaintainPlan(Map<String, Object> valueMap);

    /**
     * 当前设备保养计划是否存在
     * @param id                 保养计划id
     * @param equipmentId        设备id
     * @param maintainContentId  保养内容id
     * @return
     */
    boolean isExistByEquipmentConten(String id, String equipmentId, String maintainContentId);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageEquipmentMaintainPlan(PageData pd) throws Exception;


}



