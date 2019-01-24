package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

/**
 * Created by 46368 on 2019/1/24.
 */
public interface MobileLoginService {

    ResultModel loginIn(PageData pageData) throws Exception;
}
