package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.service.UserExcelService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserExcelServiceImp implements UserExcelService {
    public String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
                                  String companyId,
                                  Integer index,
                                  Integer maxShowRow) {

        StringBuffer strBuf = new StringBuffer();

        int index_int = 1;
        if (index != null) {
            index_int = index.intValue();
        }

        int maxShowRow_int = 20;
        if (maxShowRow != null) {
            maxShowRow_int = maxShowRow.intValue();
        }


        String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;
        String msg_column_mobile_error = "第 {0} 行: {1}:{2} 输入错误，请输入11位手机号码！" + Common.SYS_ENDLINE_DEFAULT;

        int maxRow = 0;
        for (int i = 0; i < objectList.size(); i++) {
            LinkedHashMap<String, String> mapObject = objectList.get(i);

//            //姓名 userName
//            String userName = mapObject.get("userName");
//            if (userName == null || userName.trim().length() == 0) {
//                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
//                String str_isnull = MessageFormat.format(msg_column_isnull,
//                        (i+index_int),
//                        "姓名");
//                strBuf.append(str_isnull);
//            }

//            //所属部门 deptName
//            String deptName = mapObject.get("deptName");
//            if (deptName == null || deptName.trim().length() == 0) {
//                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
//                String str_isnull = MessageFormat.format(msg_column_isnull,
//                        (i+index_int),
//                        "所属部门");
//                strBuf.append(str_isnull);
//            }

//            //角色名称 roleName
//            String roleName = mapObject.get("roleName");
//            if (roleName == null || roleName.trim().length() == 0) {
//                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
//                String str_isnull = MessageFormat.format(msg_column_isnull,
//                        (i+index_int),
//                        "角色名称");
//                strBuf.append(str_isnull);
//            }


//            //用户类型 userTypeName
//            String userTypeName = mapObject.get("userTypeName");
//            if (userTypeName == null || userTypeName.trim().length() == 0) {
//                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
//                String str_isnull = MessageFormat.format(msg_column_isnull,
//                        (i+index_int),
//                        "用户类型");
//                strBuf.append(str_isnull);
//            }

            //手机号 mobile
            String mobile = mapObject.get("mobile");
            if (mobile == null || mobile.trim().length() == 0) {
                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
                String str_isnull = MessageFormat.format(msg_column_isnull,
                        (i+index_int),
                        "手机号");
                strBuf.append(str_isnull);
            } else if (mobile != null && mobile.trim().length() > 0) {
                try {
                    new BigInteger(mobile);
                    if (mobile.trim().length() != 11) {
                        //String msg_column_mobile_error = "第 {0} 行: {1}:{2} 输入错误，请输入11位手机号码！"
                        String str_error = MessageFormat.format(msg_column_mobile_error,
                                (i+index_int),
                                "手机号",
                                mobile);
                        strBuf.append(str_error);

                        maxRow = maxRow + 1;
                        if (maxShowRow_int <= maxRow) {return strBuf.toString();}
                    }
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                    //String msg_column_mobile_error = "第 {0} 行: {1}:{2} 输入错误，请输入11位手机号码！"
                    String str_error = MessageFormat.format(msg_column_mobile_error,
                            (i+index_int),
                            "手机号",
                            mobile);
                    strBuf.append(str_error);

                    maxRow = maxRow + 1;
                    if (maxShowRow_int <= maxRow) {return strBuf.toString();}
                }
            }

        }

        return null;
    }

}
