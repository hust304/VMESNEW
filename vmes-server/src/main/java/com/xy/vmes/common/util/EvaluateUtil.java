package com.xy.vmes.common.util;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 46368 on 2018/11/14.
 */
public class EvaluateUtil {

    /**
     * 公式计算方法
     * @param parmMap  公式中的参数map
     * @param formula  公式字符串
     * @return
     */
    public static BigDecimal formulaReckon(Map<String, Object> parmMap, String formula) {
        if (parmMap == null || parmMap.size() == 0) {return null;}
        if (formula == null || formula.trim().length() == 0) {return null;}

        Binding binding = new Binding();
        for (Iterator iterator = parmMap.keySet().iterator(); iterator.hasNext();) {
            String mapkey = (String)iterator.next();
            String value = parmMap.get(mapkey).toString();
            binding.setVariable(mapkey, new BigDecimal(value));
        }

        GroovyShell shell = new GroovyShell(binding);
        Object valueObject = shell.evaluate(formula);

        if (valueObject != null) {
            BigDecimal valueBig = new BigDecimal(valueObject.toString());

            //四舍五入到2位小数
            return valueBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        }

        return null;
    }

    public static void main(String args[]) {

//        Binding binding = new Binding();
//
//        binding.setVariable("F",2.5);
//        binding.setVariable("T",30);
//        binding.setVariable("A",100);
//        binding.setVariable("P0",100);
//
//        //binding.setVariable("language", "Groovy");
//
//        GroovyShell shell = new GroovyShell(binding);
//
//        Object F1 =shell.evaluate("P1=(1+0.1 * (F/100) * T)*P0");
//
//        //Object F2 =shell.evaluate("P1=P0*(0.055*0.20+1.0011)+A; return P1 ");
//
//        System.out.println(F1.toString());
//        //System.out.println(F2);

        Map<String, Object> parmMap = new HashMap<String, Object>();
        //parmMap.put("P", "10");

        parmMap.put("F", "2.5");
        parmMap.put("T", Integer.valueOf(30));
        parmMap.put("A", "100");
        parmMap.put("P0", "100");

        //BigDecimal valueBig = EvaluateUtil.formulaReckon(parmMap, "N=8*P");
        BigDecimal valueBig = EvaluateUtil.formulaReckon(parmMap, "P1=(1+0.1 * (F/100) * T)*P0");

        System.out.println("valueBig: " + valueBig.toString());

    }
}
