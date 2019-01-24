package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

import java.util.Map;

public interface UserLoginService {
    Map<String, Object> findRedisMap(String jsonString);

    ResultModel loginIn(PageData pageData) throws Exception;
}
