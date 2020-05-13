package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

public interface AssistDiscardDetailByEditService {
    //List<Map> findAssistDiscardDetailEditByProduct(PageData pd, Pagination pg) throws Exception;
    //List<Map> findAssistDiscardDetailEdit(PageData pd, Pagination pg) throws Exception;

    ResultModel listPageAssistDiscardDetailEditByProduct(PageData pd) throws Exception;
    ResultModel listPageAssistDiscardDetailEdit(PageData pd) throws Exception;
}
