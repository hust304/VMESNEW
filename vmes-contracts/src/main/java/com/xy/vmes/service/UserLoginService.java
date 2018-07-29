package com.xy.vmes.service;

import java.util.Map;

public interface UserLoginService {
    Map<String, Object> findRedisMap(String jsonString);
}
