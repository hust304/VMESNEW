package com.xy.vmes.entity;

import java.math.BigDecimal;
import java.util.Map;


public class PageEntity {
    Map<String, Object>  jsonMap = null;
    BigDecimal count = null;

    public Map<String, Object> getJsonMap() {
        return jsonMap;
    }

    public void setJsonMap(Map<String, Object> jsonMap) {
        this.jsonMap = jsonMap;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
