package com.xy.vmes.deecoop.service;

import com.xy.vmes.deecoop.dao.ViewVmesUserEmployeeMapper;
import com.xy.vmes.entity.ViewVmesUserEmployee;
import com.xy.vmes.service.UserEmployeeService;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserEmployeeServiceImp implements UserEmployeeService {
    @Autowired
    private ViewVmesUserEmployeeMapper viewUserEmployeeMapper;

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-20
     *
     * @param mapObj
     */
    @Override
    public List<ViewVmesUserEmployee> findViewUserEmployList(PageData mapObj) {
        List<ViewVmesUserEmployee> objectList = new ArrayList<ViewVmesUserEmployee>();
        if (mapObj == null || mapObj.size() == 0) {return objectList;}

        try {
            objectList = viewUserEmployeeMapper.findViewUserEmployList(mapObj);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }
}
