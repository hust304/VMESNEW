package com.xy.vmes.deecoop.equipment.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.EquipmentSensor;
import com.xy.vmes.entity.PurchaseRetreat;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* 说明：vmes_equipment_sensor:设备传感器指标(设备联网) Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2019-06-19
*/
@Mapper
@Repository
public interface EquipmentSensorMapper extends BaseMapper<EquipmentSensor> {
    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    void deleteByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    void updateToDisableByIds(String[] ids);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    List<EquipmentSensor> dataList(PageData pd);

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2019-06-19
     */
    List<Map> getDataListPage(PageData pd, Pagination pg);
    List<Map> getDataListPage(PageData pd);

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    void deleteTableByEquipment(PageData pd);
    List<Map> findAllEquipmentBySensor(PageData pd, Pagination pg);
    List<Map> findAllEquipmentBySensor(PageData pd);
}


