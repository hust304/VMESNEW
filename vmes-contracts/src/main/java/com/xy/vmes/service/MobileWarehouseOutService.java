package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.List;
import java.util.Map;

/**
 * Created by 46368 on 2019/1/22.
 */
public interface MobileWarehouseOutService {

//    List<Map> findWarehouseOutByDetailId(PageData pd) throws Exception;


    List<Map> listWarehousePath(PageData pd) throws Exception;

    List<Map> listWarehouseCode(PageData pd) throws Exception;

    ResultModel addWarehouseOutExecute(PageData pd) throws Exception;

    ResultModel rebackWarehouseOutDetail(PageData pd) throws Exception;

    ResultModel findWarehouseCodeByQrcode(PageData pd)throws Exception;

    ResultModel listWarehouseCodeByWarehouseId(PageData pd)throws Exception;

    ResultModel listWarehousePathByProduct(PageData pd)throws Exception;

    ResultModel findWarehousePathByQrcode(PageData pd)throws Exception;

    ResultModel findWarehouseOutByDetailId(PageData pd)throws Exception;
}
