package com.xy.vmes.service;

import com.xy.vmes.entity.EquipmentRepairTask;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_repairTask:设备维修任务表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-07-01
*/
public interface EquipmentRepairTaskService {

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2019-07-01
    */
    void save(EquipmentRepairTask object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void update(EquipmentRepairTask object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void updateAll(EquipmentRepairTask object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    EquipmentRepairTask selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    List<EquipmentRepairTask> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    List<EquipmentRepairTask> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-01
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2019-07-01
     */
    void updateIsdisableByRepairId(String isdisable, String repairId) throws Exception;

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
    List<EquipmentRepairTask> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    EquipmentRepairTask findRepairTask(PageData object) throws Exception;
    EquipmentRepairTask findRepairTaskById(String id) throws Exception;
    List<EquipmentRepairTask> findRepairTaskList(PageData object) throws Exception;

    boolean isExistRepairTaskByRepairId(String repairId);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @param pg    分页参数对象Pagination
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageEquipmentRepairTasks(PageData pd,Pagination pg) throws Exception;


}



