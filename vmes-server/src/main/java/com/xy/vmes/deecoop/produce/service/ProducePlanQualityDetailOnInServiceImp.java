package com.xy.vmes.deecoop.produce.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.produce.dao.ProducePlanQualityDetailOnInMapper;
import com.xy.vmes.service.ProducePlanQualityDetailOnInService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 说明：生产计划明细检验报工关联入库明细 实现类
 * 创建人：陈刚
 * 创建时间：2020-03-11
 */
@Service
public class ProducePlanQualityDetailOnInServiceImp implements ProducePlanQualityDetailOnInService {
    @Autowired
    private ProducePlanQualityDetailOnInMapper qualityDetailOnInMapper;

    public List<Map> findProducePlanQualityDetailOnInDetail(PageData pd, Pagination pg) throws Exception{
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return qualityDetailOnInMapper.findProducePlanQualityDetailOnInDetail(pd);
        } else if (pg != null) {
            return qualityDetailOnInMapper.findProducePlanQualityDetailOnInDetail(pd, pg);
        }

        return mapList;
    }
}
