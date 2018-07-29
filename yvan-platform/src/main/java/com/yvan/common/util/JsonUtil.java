package com.yvan.common.util;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yvan.platform.RestException;

public class JsonUtil {
    public static Map<String, String> jsonString2Map(String jsonString) {
        Map<String, String> mapObject = new HashMap<String, String>();
        if (jsonString == null || jsonString.trim().length() == 0) {
            return mapObject;
        }

        try{
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            mapObject = new Gson().fromJson(jsonString, type);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return mapObject;
    }

    public static Object jsonString2Object(String jsonString, Class entityClass) {
        if (jsonString == null || jsonString.trim().length() == 0) {return null;}

        Object object = null;
        try{
            object = new Gson().fromJson(jsonString, entityClass);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return object;
    }
}
