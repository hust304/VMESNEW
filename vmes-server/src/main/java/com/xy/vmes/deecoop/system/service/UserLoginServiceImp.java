package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Employee;
import com.xy.vmes.entity.User;
import com.xy.vmes.service.UserLoginService;
import com.yvan.Conv;
import com.yvan.common.util.JsonUtil;
import com.yvan.platform.RestException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

@Service
public class UserLoginServiceImp implements UserLoginService {
    public Map<String, Object> findRedisMap(String jsonString) {
        Map<String, Object> mapObj = new HashMap<String, Object>();
        if (jsonString == null || jsonString.trim().length() == 0) {
            return mapObj;
        }

        //JsonString 转换Map<String, String> 对象
        Map mapObject = JsonUtil.jsonString2Map(jsonString);
        for (Iterator iterator = mapObject.keySet().iterator(); iterator.hasNext(); ) {
            String mapKey = (String) iterator.next();
            String mapValue = Conv.NS(mapObject.get(mapKey));
            if (mapValue == null || mapValue.trim().length() == 0) {
                continue;
            }

            try {
                if ("sessionID".equals(mapKey)) {
                    mapObj.put(mapKey, mapValue);
                } else if ("user".equals(mapKey)) {
                    User user = (User) JsonUtil.jsonString2Object(mapValue, User.class);
                    mapObj.put(mapKey, user);
                } else if ("employ".equals(mapKey)) {
                    Employee employ = (Employee) JsonUtil.jsonString2Object(mapValue, Employee.class);
                    mapObj.put(mapKey, employ);
                } else if ("dept".equals(mapKey)) {
                    Department dept = (Department) JsonUtil.jsonString2Object(mapValue, Department.class);
                    mapObj.put(mapKey, dept);
                } else if ("userRole".equals(mapKey)) {

                } else if ("userMenu".equals(mapKey)) {

                } else if ("userButton".equals(mapKey)) {

                }
            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }

        }


        return mapObj;
    }
}
