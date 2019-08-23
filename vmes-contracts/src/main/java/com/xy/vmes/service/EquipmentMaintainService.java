package com.xy.vmes.service;

import com.xy.vmes.entity.EquipmentMaintain;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_maintain:设备保养单 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-07-29
*/
public interface EquipmentMaintainService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void save(EquipmentMaintain object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void update(EquipmentMaintain object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void updateAll(EquipmentMaintain object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    EquipmentMaintain selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    List<EquipmentMaintain> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    List<EquipmentMaintain> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
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
    List<EquipmentMaintain> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    EquipmentMaintain findMaintain(PageData object) throws Exception;
    EquipmentMaintain findMaintainById(String id) throws Exception;
    List<EquipmentMaintain> findMaintainList(PageData object) throws Exception;

    /**
     * 根据保养计划id-查询该保养计划保养单-获取下一个保养单(周期保养计划)
     *
     * 表字段说明(vmes_equipment_maintain):
     * 1. isdisable: 是否启用(0:已禁用 1:启用)-该字段仅用于逻辑删除
     *    该字段维护场景: 保养计划删除, 保养计划修改 (设置:0:已禁用)
     *                  保养单删除 (设置:0:已禁用)
     *                  保养单完成(报工并且已解决) (设置:0:已禁用)
     *                  定时器中生成保养单 (设置:1:启用)
     *
     * 2. is_valid_state: 保养单有效状态(1:有效 0:无效 is null 无效)-保养单队列游标(整个保养周期有且只有一行是1-任务执行完成设置0)
     *    0:无效: 当前保养任务执行完成(报工并且已解决)设置为'0'--寻找下一个最近的保养单设置为'1'
     *           当前保养任务删除设置为'0'--寻找下一个最近的保养单设置为'1'
     *    1:有效: 定时器中保养计划无保养单时默认设置'1'--当前保养任务执行完成寻找下一个最近的保养单设置为'1'
     *    该字段维护场景:
     *      0:无效: 保养任务执行完成, 当前保养任务删除
     *      1:有效: 定时器中保养计划无保养单时默认设置'1'
     *              当前保养任务执行完成寻找下一个最近的保养单设置为'1'
     *              当前保养任务删除寻找下一个最近的保养单设置为'1'
     *
     * @param @param maintainPlanId  保养计划id
     * @return
     */
    EquipmentMaintain findNextMaintainByPeriod(String maintainPlanId);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建设备保养单(设备保养定时任务调用)
     * @param plan  设备保养计划对象<EquipmentMaintainPlan>
     */
    void addMaintainCustomByTimer(EquipmentMaintainPlan plan) throws Exception;

    /**
     * 创建设备保养单(设备保养定时任务调用)
     *
     *  周期起止日期时间Map:
     *  Map<String, Date>>
     *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
     *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
     *      nextMaintainDate: 下一保养日期(yyyy-MM-dd)
     *
     * @param dateMap   周期数据Map
     * @param plan      设备保养计划对象<EquipmentMaintainPlan>
     */
    void addMaintainPeriodByTimer(Map<String, Date> dateMap, EquipmentMaintainPlan plan) throws Exception;

    void updateIsdisableByPlan(String parentIds, String isdisable);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageEquipmentMaintain(PageData pd) throws Exception;

}



