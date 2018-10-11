package com.xy.vmes.common.util;

import java.util.HashMap;
import java.util.Map;

public class Common {
    public final static String REDIS_SECURITY_CODE = "securityCode";
    public final static String DEPARTMENT_ROOT_ID = "b6ff76cb95f711e884ad00163e105f05";
    //public final static String REDIS_EMPLOY = "employ";
    //public final static String REDIS_DEPT = "dept";
    //public final static String REDIS_USERROLE = "userRole";
    //public final static String REDIS_USERMENU = "userMenu";
    //public final static String REDIS_USERBUTTON = "userButton";
    public final static String REDIS_USERLOGINMAP = "userLoginMap";

    //用户登录-验证码-redis有效时间(单位:秒)
    public final static int REDIS_SECURITYCODE_LONG = 1 * 60;
    //用户登录-sessionID-redis有效时间(单位:秒)
    public final static int REDIS_SESSIONID_LONG = 30 * 60;


    //系统默认密码: 123
    public final static String DEFAULT_PASSWORD = "123";

    //java代码中的换行符
    public final static String SYS_ENDLINE_JAVA = "\n";
    //html中的换行符
    public final static String SYS_ENDLINE_HTML = "<br/>";
    //系统默认换行符 "\n"
    public final static String SYS_ENDLINE_DEFAULT = SYS_ENDLINE_JAVA;

    public static Integer SYS_IMPORTEXCEL_MESSAGE_MAXROW  = Integer.valueOf(50);

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
        put("DepartmentController", "组织架构");
        put("CompanyController", "企业账号申请");
        put("DictionaryController", "数据字典");
        put("EmployeeController", "员工管理");
        put("MenuButtonController", "管理按钮");
        put("MenuController", "菜单管理");
        put("PostController", "职位管理");
        put("RoleController", "角色权限");
        put("UserController", "用户管理");
        put("MainPageController", "主页及菜单自定义");
        put("UserLoginController", "用户登录");
    }};

    //Controller操作方法前缀
    public static final Map<String, String> SYSLOGINFO_METHODPREFIX_MAP = new HashMap<String, String>() {{
        put("add", "add");
        put("update", "update");
        put("delete", "delete");
    }};

    ///////////////--Dictionary字典表大类ID映射--///////////////////////////////////////////////////////////////////
    public static final Map<String, String> DICTIONARY_MAP = new HashMap<String, String>() {{

        //字典表根节点
        put("root", "8421e4f093a44f029dddbc4ab13068bf");

        //userType: 744f2d88c9f647d0a4d967a714193850 //用户类型
        put("userType", "744f2d88c9f647d0a4d967a714193850");
            //userType: 744f2d88c9f647d0a4d967a714193850 //用户类型-超级管理员
            put("userType_admin", "6839818aecfc41be8f367e62502dfde4");

            //userType: 744f2d88c9f647d0a4d967a714193850 //用户类型-企业管理员
            put("userType_company", "2fb9bbee46ca4ce1913f3a673a7dd68f");

            //userType: 744f2d88c9f647d0a4d967a714193850 //用户类型-普通用户
            put("userType_employee", "69726efa45044117ac94a33ab2938ce4");

            //userType: 744f2d88c9f647d0a4d967a714193850 //用户类型-外部用户
            put("userType_outer", "028fb82cfbe341b1954834edfa2fc18d");

        //political: 015cecdb7fdd450c8a21c7c97d406aa4 //政治面貌
        put("political", "015cecdb7fdd450c8a21c7c97d406aa4");

        //companyType: 0d779980a3ca4e69ac393a93bca84659 //企业性质
        put("companyType", "0d779980a3ca4e69ac393a93bca84659");

        //deptType: 8421e4f093a44f029dddbc4ab13068be //部门类型
        put("deptType", "8421e4f093a44f029dddbc4ab13068be");

        //基础-产品物料
        //productGenre: 4c4bd1b59954438c8bf56facd97a0c7e 货品属性
        put("productGenre", "4c4bd1b59954438c8bf56facd97a0c7e");
        //productType: a39ac4c1e02e45788eb03a52a5e9a972 货品类型
        put("productType", "a39ac4c1e02e45788eb03a52a5e9a972");
        //基础-产品物料(计量单位-结算单位)-公用一个字典id
        //productUnit: 0ae6e79890db490585e13f34bf00ea4b 货品计量单位
        put("productUnit", "0ae6e79890db490585e13f34bf00ea4b");

        //基础-客户供应商
        //customerGenre:b166cc9397744f0cbbea3244647305ee(字典id)  客户供应商属性(字典名称)
        put("customerSupplierGenre", "b166cc9397744f0cbbea3244647305ee");
            //customerGenreKh:  df7cb67fca4148bc9632c908e4a7fdea(字典id)  客户(字典名称)
            //put("customerGenreKh", "df7cb67fca4148bc9632c908e4a7fdea");

            //customerGenreGys: 49c0a7ebcb4c4175bd5195837a6a9a13(字典id)  供应商(字典名称)
            //put("customerGenreGys", "49c0a7ebcb4c4175bd5195837a6a9a13");

        //supplierType:a50dcf66b14a440282eed9e26c1d9482 (字典id)  客户类型  (字典名称)
        put("customerType", "a50dcf66b14a440282eed9e26c1d9482");

        //supplierType:d28640b12a454246b172c49a604a89f5(字典id)  供应商类型(字典名称)
        put("supplierType", "d28640b12a454246b172c49a604a89f5");

        //equipmentType:7d24edc83dcf4619b618bf0b0eba2851(字典id)  设备类型(字典名称)
        put("equipmentType", "7d24edc83dcf4619b618bf0b0eba2851");

        //e8d9461fbe704fdcbe2ee88efb310f2c(字典id)  省直辖市(字典名称)
        put("province", "e8d9461fbe704fdcbe2ee88efb310f2c");

        //仓库货位表(vmes_warehouse_position)
        put("warehouseRoot", "df930aaecb7111e884ad00163e105f05");
            //实体库
            put("warehouseEntity", "2d75e49bcb9911e884ad00163e105f05");
            //虚拟库
            put("warehouseVirtual", "56f5e83dcb9911e884ad00163e105f05");

        //db46547d1bcb4c14baa228db1e8aaffe(字典id)  部门货位名称(字典名称)
        put("departmentPosition", "db46547d1bcb4c14baa228db1e8aaffe");
    }};

    ///////////////--菜单名称--///////////////////////////////////////////////////////////////////
    //Map<菜单key, 菜单id>
    public static final Map<String, String> SYS_MENU_MAP = new HashMap<String, String>() {{
        //root 节点(智能云管家) pid := root
        put("root", "8b678e8195f711e884ad00163e105f05");

        //home: '主页',
        put("home", "97c8c8150a7746e190a7a440b2119e02");

        //******销售******
        //order: '销售',
        put("order", "94caec1bca7e4131b16bfcee9b1351e2");

        //******生产******
        //product: '生产',
        put("product", "73883f69b4034b7f89e9d59bc4919a6a");

        //******仓库******
        //warehouse: '仓库',
        put("warehouse", "15a6c4ca92fe42a0a82320287538b727");
            //基础 base ff1330a1a96246c0b041451b3212bbee
            put("base", "ff1330a1a96246c0b041451b3212bbee");
                //库位配置 position e4fd9624f7b94e499dd2b7015b3df332
                put("position", "e4fd9624f7b94e499dd2b7015b3df332");
                //库位初始化 () bb00131c20b64b1da92321b0f71ef129

        //table: '报表',
        put("table", "156b96f3245d4a5ba45ca3c2e67fd803");

        //******人事******
        //emp: '人事',
        put("emp", "a962ac5d572d46c38d75d644974abc80");
            //department: '组织管理',
            put("department", "b0f2e472c3b84a3eba7839cb3ebc01b8");
            //post: '岗位管理',
            put("post", "7a8e501d59544e4fa61636d2b7813751");
            //employee: '员工管理',
            put("employee", "093a0bc9346044afaa814ea17a74d073");

        //******质量******
        //quality: '质量',
        put("quality", "c93a3ca8d720434dbee9a87482931772");

        //******系统设置******
        //system: '系统设置',
        put("system", "9446a05883cf4669aecd710e663aea39");
            //company: '企业账号申请',
            put("company", "55004941ca4440e09d01975829f797b0");
            //user: '用户管理',
            put("user", "59de75701c53408a857f0179fcaa7a09");
            //menumanage: '菜单管理',
            put("menumanage", "6eb9766b1396425b84cd5cd7d3bb464b");
            //template: '系统开发模板',
            put("template", "dccbd97d7b404c0ab5b76b36b2521d8d");
            //dictionary: '数据字典',
            put("dictionary", "8e7fef00aedc4da880b4c06399f47ce1");
            //role: '角色权限',
            put("role", "33112d776e7140e98002df71785de23c");
            //auths: '权限管理',
            //accountHome: '自定义主页',
            put("accountHome", "e1206343ddc94ec4b072adedb4ba40aa");
            //logInfo: '操作日志',
            put("logInfo", "cba143d6d51b4d4288071eb3bad56606");

        //******基础******
        //base: '基础',
        put("base", "be55b2f9cb6b4b6e8b77b8a9d4514b24");
            //product: 产品物料,
            put("product", "9675556924de4a34bd14e9420311e751");
            //equipment: 设备信息,
            put("equipment", "02e604fde496494993dfa4f6d7511c84");
            //customer: 客户供应商,
            put("customer", "66628bbd6bdd4f47a903feaec2feab59");

    }};
}
