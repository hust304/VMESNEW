package com.xy.vmes.common.util;

public class Common {
    public final static String REDIS_SECURITY_CODE = "securityCode";
    public final static String REDIS_USER = "user";
    public final static String REDIS_EMPLOY = "employ";
    public final static String REDIS_DEPT = "dept";
    public final static String REDIS_USERROLE = "userRole";
    public final static String REDIS_USERMENU = "userMenu";
    public final static String REDIS_USERBUTTON = "userButton";
    public final static String REDIS_USERLOGINMAP = "userLoginMap";

    //系统默认密码: 123
    public final static String DEFAULT_PASSWORD = "123";

    ///////////////--编码规则--//////////////////////////////////////////////////////////////////////////////////////////////////
    //业务编码规则-分隔符
    //public static final String CODE_RULE_SEPARATOR = "-";
    //业务编码规则-(默认)填充字符
    public static final String CODE_RULE_DEFAULT_FILLING = "0";
    //业务编码规则-最大业务流水号长度(5位)
    public static final int CODE_RULE_LENGTH_5 = 5;
    //业务编码规则-最小业务流水号长度(3位)
    public static final int CODE_RULE_LENGTH_3 = 3;
    public static final int CODE_RULE_LENGTH_DEFAULT = CODE_RULE_LENGTH_5;

    //业务编码规则-前补零
    public static final String CODE_RULE_BEFORE = "before";
    //业务编码规则-后补零
    public static final String CODE_RULE_AFTER = "after";

    public static final String CODE_RULE_DATEFORMAT_1 = "yyMMdd";
    public static final String CODE_RULE_DATEFORMAT_2 = "yyyyMMdd";
    public static final String CODE_RULE_DATEFORMAT_DEFAULT = CODE_RULE_DATEFORMAT_2;

    //(订单,订单明细)-业务编号前缀
    public static final String CODE_RULE_PREFIX_ORDER = "D";
    public static final String CODE_RULE_PREFIX_ORDERDETAIL = "D";


    //通用编码规则-企业编号+前缀+yyMMdd+流水号
    //0:企业编号
    //1:编码字符串前缀
    //2:日期字符串
    //3:编码流水号
    public static final String CODE_RULE_DEFAULT = "{0}{1}{2}{3}";
}
