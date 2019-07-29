package com.xy.vmes.service;

import com.xy.vmes.entity.EquipmentMaintainTaskDetail;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_maintainTask_detail:设备保养任务明细表 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-07-29
*/
public interface EquipmentMaintainTaskDetailService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void save(EquipmentMaintainTaskDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void update(EquipmentMaintainTaskDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void updateAll(EquipmentMaintainTaskDetail object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    EquipmentMaintainTaskDetail selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    List<EquipmentMaintainTaskDetail> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-07-29
     */
    List<EquipmentMaintainTaskDetail> dataList(PageData pd) throws Exception;

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
    List<EquipmentMaintainTaskDetail> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    EquipmentMaintainTaskDetail findMaintainTaskDetail(PageData object) throws Exception;
    EquipmentMaintainTaskDetail findMaintainTaskDetailById(String id) throws Exception;

    List<EquipmentMaintainTaskDetail> findMaintainTaskDetailList(PageData object) throws Exception;
    List<EquipmentMaintainTaskDetail> findMaintainTaskDetailListByTaskId(String taskId) throws Exception;

    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageEquipmentMaintainTaskDetail(PageData pd) throws Exception;


}



