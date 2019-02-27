package com.xy.vmes.deecoop.purchase.service;

import com.xy.vmes.service.BomTreeService;
import com.xy.vmes.service.BundleAnalysisService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 46368 on 2019/2/27.
 */
@Service
@Transactional(readOnly = false)
public class BundleAnalysisServiceImp implements BundleAnalysisService {
    @Autowired
    private BomTreeService bomTreeService;
    @Override
    public ResultModel getBomTreeProduct(PageData pd) throws Exception {
        return bomTreeService.getBomTreeProduct(pd);
    }
}
