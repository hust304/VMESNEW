package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.service.EquipmentSensorTargetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 说明：设备传感器指标编码服务实现类
 * 创建人：陈刚
 * 创建时间：2019-06-19
 */
@Service
public class EquipmentSensorTargetServiceImp implements EquipmentSensorTargetService {

    /**
     * 获取全部传感器指标编码
     * LinkedHashMap<指标编码, 指标编码>
     * 传感器指标编码 (A0001..A0100 B0001..B0100)
     *
     * @param maxCount  系统允许生成指标编码-最大个数
     * @param maxDigit  指标编码最大位数
     * @param prefix    指标编码前缀
     * @return
     */
    public LinkedHashMap<String, String> findAllTargetCodeMap(Integer maxCount, Integer maxDigit, String prefix) {
        LinkedHashMap<String, String> codeMap = new LinkedHashMap<String, String>();
        if (maxCount == null || 0D == maxCount.intValue()) {return codeMap;}
        if (maxDigit == null || 0D == maxDigit.intValue()) {return codeMap;}
        if (prefix == null) {prefix = new String();}

        //数字位数
        int numberDigit = maxDigit.intValue() - prefix.trim().length();

        for (int i = 1; i <= maxCount.intValue(); i++) {
            Integer numberTemp = Integer.valueOf(i);
            String codeStr = findCodeByLength(numberTemp, numberDigit, "0");
            codeStr = prefix + codeStr;
            codeMap.put(codeStr, codeStr);
        }

        return codeMap;
    }

    /**
     * 获取一个新的(未使用)的指标编码
     * @param allCodeMap    系统全部指标编码 (A0001..A0100 B0001..B0100)
     * @param applyCodeMap  设备使用中的指标编码
     * @return
     */
    public String findNewTargetCode(LinkedHashMap<String, String> allCodeMap, LinkedHashMap<String, String> applyCodeMap) {
        if (allCodeMap == null || allCodeMap.size() == 0) {return new String();}
        if (applyCodeMap == null || applyCodeMap.size() == 0) {
            return this.findFirstByCodeMay(allCodeMap);
        }

        for (Iterator iterator = allCodeMap.keySet().iterator(); iterator.hasNext();) {
            String allCodeMapKey = (String) iterator.next();
            if("A0001,A0002,A0003,A0004,A0005,A0006,A0007,A0008,A0009,A0010,A0011,A0012,A0013,A0014,A0015,A0016,A0017,A0018,A0019,A0020"
                    .indexOf(applyCodeMap.get(allCodeMapKey))<0){
                if (applyCodeMap.get(allCodeMapKey) == null) {
                    return allCodeMapKey;
                }
            }

        }
        return new String();
    }

    /**
     * 获取编号，前补充
     * @param code     编码
     * @param length   编码规则(指定位数)
     * @param filling  编码规则(填充字符)
     * @return
     */
    private String findCodeByLength(Integer code, int length, String filling) {
        if (code == null || 0L == code.longValue()) {return new String();}
        if (length == 0) {return new String();}
        if (code.toString().length() > length) {return code.toString();}

        String fill_string = "";
        //1. 获取补充字符串个数
        int fill_length = length - code.toString().length();
        for (int i = 0; i < fill_length; i++) {
            fill_string = fill_string + filling;
        }

        return fill_string + code.toString();
    }

    private String findFirstByCodeMay(LinkedHashMap<String, String> codeMap) {
        if (codeMap == null || codeMap.size() == 0) {return new String();}

        for (Iterator iterator = codeMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey = (String) iterator.next();
            return mapKey;
        }

        return new String();
    }

}
