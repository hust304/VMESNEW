package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

public interface UserLoginService {
//    Map<String, Object> findRedisMap(String jsonString);

    ResultModel loginIn(PageData pageData) throws Exception;

    ResultModel createSecurityCode(PageData pageData) throws Exception;

    ResultModel changePassWord(PageData pageData) throws Exception;

    ResultModel findPassWord(PageData pageData) throws Exception;

    ResultModel loginOut(PageData pageData) throws Exception;
}
