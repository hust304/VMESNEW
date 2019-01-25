package com.xy.vmes.deecoop.mobile.service;

import com.xy.vmes.service.MobileLoginService;
import com.xy.vmes.service.UserLoginService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 46368 on 2019/1/24.
 */
@Service
@Transactional(readOnly = false)
public class MobileLoginServiceImp implements MobileLoginService {

    @Autowired
    private UserLoginService userLoginService;
    @Override
    public ResultModel loginIn(PageData pageData) throws Exception {
        return userLoginService.loginIn(pageData);
    }
}
