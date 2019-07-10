package com.xy.vmes.service;

import com.xy.vmes.entity.EquipmentSensor;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_sensor:设备传感器指标(设备联网) 接口类
* 创建人：陈刚 自动生成
* 创建时间：2019-06-19
*/
public interface EquipmentSensorService {

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    void save(EquipmentSensor object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    void update(EquipmentSensor object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    void updateAll(EquipmentSensor object) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    void updateToDisableByIds(String[] ids)throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    void deleteByIds(String[] ids) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    EquipmentSensor selectById(String id) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    List<EquipmentSensor> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    List<EquipmentSensor> dataList(PageData pd) throws Exception;

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception;
    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    List<Map> findAllEquipmentBySensorMapList(PageData pd, Pagination pg) throws Exception;

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
    List<EquipmentSensor> findDataList(PageData pageData, Boolean isQueryAll) throws Exception;

    EquipmentSensor findEquipmentSensor(PageData object) throws Exception;
    EquipmentSensor findEquipmentSensorById(String id) throws Exception;
    List<EquipmentSensor> findEquipmentSensorList(PageData object) throws Exception;
    PageData setupSqlOrder(String orderStr, PageData pageData);

    LinkedHashMap<String, String> findTargetCodeMap(List<EquipmentSensor> list);
    String findTargetCode(Map<String, String> mapObject);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void deleteTableByEquipment(String equipmentId);
    String checkColumnByEdit(EquipmentSensor object);
    boolean isExistByName(String id, String equipmentId, String targetName);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    * 分页查询
    * @param pd    查询参数对象PageData
    * @return      返回对象ResultModel
    * @throws Exception
    */
    ResultModel listPageEquipmentSensor(PageData pd) throws Exception;
    ResultModel findAllEquipmentBySensor(PageData pd) throws Exception;
    //获取设备全部传感器指标-公式编辑器调用
    ResultModel findListEquipmentSensorByEquipment(PageData pd) throws Exception;


}



