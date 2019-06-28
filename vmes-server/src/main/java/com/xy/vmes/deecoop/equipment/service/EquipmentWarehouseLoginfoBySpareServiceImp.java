package com.xy.vmes.deecoop.equipment.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.equipment.dao.EquipmentWarehouseLoginfoBySpareMapper;
import com.xy.vmes.service.EquipmentWarehouseLoginfoBySpareService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentWarehouseLoginfoBySpareServiceImp implements EquipmentWarehouseLoginfoBySpareService {
    @Autowired
    private EquipmentWarehouseLoginfoBySpareMapper warehouseLoginfoBySpareMapper;

    public List<Map> findListWarehouseLoginfoBySpare(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return warehouseLoginfoBySpareMapper.findListWarehouseLoginfoBySpare(pd);
        } else if (pg != null) {
            return warehouseLoginfoBySpareMapper.findListWarehouseLoginfoBySpare(pd, pg);
        }

        return mapList;
    }
}
