package com.xy.vmes.common.util;

import java.util.HashMap;
import java.util.Map;

public class Common {
    public final static String REDIS_SECURITY_CODE = "securityCode";
    //public final static String REDIS_USER = "user";
    //public final static String REDIS_EMPLOY = "employ";
    //public final static String REDIS_DEPT = "dept";
    //public final static String REDIS_USERROLE = "userRole";
    //public final static String REDIS_USERMENU = "userMenu";
    //public final static String REDIS_USERBUTTON = "userButton";
    public final static String REDIS_USERLOGINMAP = "userLoginMap";

    //用户登录-验证码-redis有效时间
    public final static int REDIS_SECURITYCODE_LONG = 1 * 60 * 1000;
    //用户登录-sessionID-redis有效时间
    public final static int REDIS_SESSIONID_LONG = 30 * 60 * 1000;


    //系统默认密码: 123
    public final static String DEFAULT_PASSWORD = "123";

    //java代码中的换行符
    public final static String SYS_ENDLINE_JAVA = "\n";
    //html中的换行符
    public final static String SYS_ENDLINE_HTML = "<br/>";
    //系统默认换行符 "\n"
    public final static String SYS_ENDLINE_DEFAULT = SYS_ENDLINE_JAVA;

    ///////////////--编码规则--//////////////////////////////////////////////////////////////////////////////////////////////////
    //业务编码规则-分隔符
    //public static final String CODE_RULE_SEPARATOR = "-";
    //业务编码规则-(默认)填充字符
    public static final String CODE_RULE_DEFAULT_FILLING = "0";
    //业务编码规则-最大业务流水号长度(5位)
    public static final int CODE_RULE_LENGTH_6 = 6;
    public static final int CODE_RULE_LENGTH_5 = 5;
    public static final int CODE_RULE_LENGTH_4 = 4;
    //业务编码规则-最小业务流水号长度(3位)
    public static final int CODE_RULE_LENGTH_3 = 3;
    public static final int CODE_RULE_LENGTH_DEFAULT = CODE_RULE_LENGTH_6;

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


    public static final String FIRST_NAME_COMPANY = "company";
    public static final String FIRST_NAME_PREFIX = "prefix";
    public static final String FIRST_NAME_DATE = "date";
    public static final String FIRST_NAME_CODE = "code";

    ///////////////--系统日志--///////////////////////////////////////////////////////////////////
    //Controller类名与业务表对应关系
    public static final Map<String, String> SYSLOGINFO_CLASSNAME2TABLENAME_MAP = new HashMap<String, String>() {{
        //put("类名称", "表名");
        put("DepartmentController", "vmes_department");
        put("CompanyController", "vmes_department");
        put("DictionaryController", "vmes_dictionary");
        put("EmployeeController", "vmes_employee");
        put("MenuButtonController", "vmes_menu_button");
        put("MenuController", "vmes_menu");
        put("PostController", "vmes_post");
        put("RoleController", "vmes_role");
        put("UserController", "vmes_user");
    }};

    //Controller操作方法前缀
    public static final Map<String, String> SYSLOGINFO_METHODPREFIX_MAP = new HashMap<String, String>() {{
        put("add", "add");
        put("update", "update");
        put("delete", "delete");
    }};

    //Dictionary字典表大类ID映射
    public static final Map<String, String> DICTIONARY_MAP = new HashMap<String, String>() {{
        //companyType: 0d779980a3ca4e69ac393a93bca84659 //企业性质
        put("companyType", "0d779980a3ca4e69ac393a93bca84659");

        //deptType: 8421e4f093a44f029dddbc4ab13068be //部门类型
        put("deptType", "8421e4f093a44f029dddbc4ab13068be");


    }};

}
