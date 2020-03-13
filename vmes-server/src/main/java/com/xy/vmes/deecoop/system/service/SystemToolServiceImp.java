package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.service.SystemToolService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 说明：系统工具 实现类
 * 创建人：陈刚
 * 创建时间：2020-03-13
 */
@Service
public class SystemToolServiceImp implements SystemToolService {
    /**
     * 模块主页页面查询调用
     * 获取货品详情字符串(货品编码,货品名称,规格型号,货品自定义属性)
     *
     * @param columnKey  业务模块栏位key(','分隔的字符串)-顺序必须按(货品编码0,货品名称1,规格型号2,货品自定义属性3)摆放
     * @param mapObject  查询结果集行数据Map<String, Object>
     * @return
     */
    public String findProductInfo(String columnKey, Map<String, Object> mapObject) {
        if (columnKey == null || columnKey.trim().length() == 0) {return new String();}
        if (mapObject == null) {return new String();}

        StringBuffer strBuf = new StringBuffer();
        String[] keyArry = columnKey.split(",");
        for (int i = 0; i < keyArry.length; i++) {
            String key = keyArry[i];
            String value = (String)mapObject.get(key);

            if (i <= 1) {
                //货品编码0,货品名称1
                if (value != null && value.trim().length() > 0) {
                    strBuf.append(value).append("_");
                }
            } else if (i == 2) {
                //规格型号2
                if (value != null && value.trim().length() > 0) {
                    strBuf.append(value);
                }
            } else if (i == 3) {
                //货品自定义属性3
                if (value != null && value.trim().length() > 0) {
                    strBuf.append("<br/>");
                    strBuf.append(value);
                }
            }
        }

        return strBuf.toString();
    }
}
