package com.xy.vmes.deecoop.kanban.service;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.kanban.dao.KanbanWarehouseMapper;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
* 说明：vmes_kanban_visualization:销售开票 实现类
* 创建人：刘威 自动创建
* 创建时间：2020-01-06
*/
@Service
@Transactional(readOnly = false)
public class KanbanWarehouseServiceImp implements KanbanWarehouseService {


    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseCheckService warehouseCheckService;
    @Autowired
    private ProductService productService;
    @Autowired
    private KanbanWarehouseMapper kanbanWarehouseMapper;
    @Autowired
    private ColumnService columnService;


    @Override
    public ResultModel getWarehouseTotalKanban(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Map<String,Object> result = new HashMap<String,Object>();
        PageData pageData = new PageData();
        pageData.put("company_id",pd.getString("currentCompanyId"));
        pageData.put("isdisable","1");
        List<WarehouseOut> outList = warehouseOutService.selectByColumnMap(pageData);
        int outCompleted = 0;
        int outUnCompleted = 0;
        int inCompleted = 0;
        int inUnCompleted = 0;
        int checkCompleted = 0;
        int checkUnCompleted = 0;
        int allCompleted = 0;
        int allUnCompleted = 0;
        if(outList!=null&&outList.size()>0){
            for(int i=0;i<outList.size();i++){
                WarehouseOut obj = outList.get(i);
                if(obj!=null){
                    if("1".equals(obj.getState())){
                        outCompleted = outCompleted + 1;
                    }else if("0".equals(obj.getState())){
                        outUnCompleted = outUnCompleted + 1;
                    }
                }
            }
            result.put("outCompleted",outCompleted);
            result.put("outUnCompleted",outUnCompleted);
            if(outCompleted+outUnCompleted>0){
                result.put("outCompletedRatio",outCompleted*100/(outCompleted+outUnCompleted));
            }else{
                result.put("outCompletedRatio",0);
            }

        }else{
            result.put("outCompleted",0);
            result.put("outUnCompleted",0);
            result.put("outCompletedRatio",0);
        }
        List<WarehouseIn> inList = warehouseInService.selectByColumnMap(pageData);
        if(inList!=null&&inList.size()>0){
            for(int i=0;i<inList.size();i++){
                WarehouseIn obj = inList.get(i);
                if(obj!=null){
                    if("1".equals(obj.getState())){
                        inCompleted = inCompleted + 1;
                    }else if("0".equals(obj.getState())){
                        inUnCompleted = inUnCompleted + 1;
                    }
                }
            }
            result.put("inCompleted",inCompleted);
            result.put("inUnCompleted",inUnCompleted);
            if(inCompleted+inUnCompleted>0){
                result.put("inCompletedRatio",inCompleted*100/(inCompleted+inUnCompleted));
            }else{
                result.put("inCompletedRatio",0);
            }
        }else{
            result.put("inCompleted",0);
            result.put("inUnCompleted",0);
            result.put("inCompletedRatio",0);
        }
        List<WarehouseCheck> checkList = warehouseCheckService.selectByColumnMap(pageData);
        if(checkList!=null&&checkList.size()>0){
            for(int i=0;i<checkList.size();i++){
                WarehouseCheck obj = checkList.get(i);
                if(obj!=null){
                    if("1".equals(obj.getState())){
                        checkCompleted = checkCompleted + 1;
                    }else if("0".equals(obj.getState())){
                        checkUnCompleted = checkUnCompleted + 1;
                    }
                }
            }
            result.put("checkCompleted",checkCompleted);
            result.put("checkUnCompleted",checkUnCompleted);
            if(checkCompleted+checkUnCompleted>0){
                result.put("checkCompletedRatio",checkCompleted*100/(checkCompleted+checkUnCompleted));
            }else{
                result.put("checkCompletedRatio",0);
            }
        }else{
            result.put("checkCompleted",0);
            result.put("checkUnCompleted",0);
            result.put("checkCompletedRatio",0);
        }
        allCompleted = outCompleted + inCompleted + checkCompleted;
        allUnCompleted = outUnCompleted + inUnCompleted + checkUnCompleted;
        result.put("allCompleted",allCompleted);
        result.put("allUnCompleted",allUnCompleted);
        if(allCompleted+allUnCompleted>0){
            result.put("allCompletedRatio",allCompleted*100/(allCompleted+allUnCompleted));
        }else{
            result.put("allCompletedRatio",0);
        }


        List<Product> productList = productService.selectByColumnMap(pageData);
        if(productList!=null&&productList.size()>0){
            result.put("productCount",productList.size());
            int alertProductCount = 0;
            for(int i=0;i<productList.size();i++){
                Product product = productList.get(i);
                if(product.getStockCount().compareTo(product.getSafetyCount())<0){
                    alertProductCount = alertProductCount + 1;
                }
            }
            result.put("alertProductCount",alertProductCount);
        }else{
            result.put("productCount",0);
            result.put("alertProductCount",0);
        }
        model.putResult(result);
        return model;
    }




    @Override
    public ResultModel listWarehouseDetailKanban(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> result = kanbanWarehouseMapper.listWarehouseDetailKanban(pd);
        if(result!=null&&result.size()>0){
            model.putResult(result);
        }
        return model;
    }



}



