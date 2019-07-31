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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建设备保养单
     * @param plan  设备保养计划对象<EquipmentMaintainPlan>
     */
    void addMaintainByCustom(EquipmentMaintainPlan plan) throws Exception;
    /**
     * 创建设备保养单
     *
     * 参数说明:
     * Map<重复类型Key, 周期起止日期时间Map>
     * 重复类型Key:
     *   everDay:每天
     *   dayOfWeek:每周星期几
     *   weekOfMonth:每月第几个星期几
     *   dayOfYear:每年某月某日
     *   workDay:工作日[周1-周5]
     *   customPeriod:自定义周期
     *
     *  周期起止日期时间Map:
     *  Map<String, Date>>
     *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
     *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
     *
     * @param valueMap  周期数据Map
     * @param plan      设备保养计划对象<EquipmentMaintainPlan>
     */
    void addMaintainByPeriod(Map<String, Map<String, Date>> valueMap, EquipmentMaintainPlan plan) throws Exception;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageEquipmentMaintain(PageData pd) throws Exception;

}



