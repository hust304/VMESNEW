package com.xy.vmes.deecoop.base.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.Equipment;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentExcelServiceImp implements EquipmentExcelService {
//    @Autowired
//    private DepartmentService departmentService;
//    @Autowired
//    private DictionaryService dictionaryService;
//    @Autowired
//    private EquipmentService equipmentService;
//
//    @Autowired
//    private FileService fileService;
//    @Autowired
//    private CoderuleService coderuleService;
//
//    public String checkColumnImportExcel(List<LinkedHashMap<String, String>> objectList,
//                                         String companyId,
//                                         String userId,
//                                         Integer index,
//                                         Integer maxShowRow) {
//        if (objectList == null || objectList.size() == 0) {return new String();}
//
//        int maxRow = 0;
//        int index_int = 1;
//        if (index != null) {
//            index_int = index.intValue();
//        }
//
//        int maxShowRow_int = 20;
//        if (maxShowRow != null) {
//            maxShowRow_int = maxShowRow.intValue();
//        }
//
//        //获取当前企业下全部部门 deptKeyNameMap<部门id, 部门名称> deptNameKeyMap<部门名称, 部门id>
//        departmentService.implementDeptMapByCompanyId(companyId);
//        Map<String, String> deptNameKeyMap = departmentService.getDeptNameKeyMap();
//
//        //获取全部 设备类型
//        dictionaryService.implementBusinessMapByParentID(Common.DICTIONARY_MAP.get("equipmentType"), companyId);
//        Map<String, String> typeNameKeyMap = dictionaryService.getNameKeyMap();
//
//        String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;
//        String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，在系统中不存在！" + Common.SYS_ENDLINE_DEFAULT;
//        String msg_column_date_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的日期格式(yyyy-MM-dd)！" + Common.SYS_ENDLINE_DEFAULT;
//
//        StringBuffer strBuf = new StringBuffer();
//        for (int i = 0; i < objectList.size(); i++) {
//            LinkedHashMap<String, String> mapObject = objectList.get(i);
//
//            //companyId 企业ID
//            mapObject.put("companyId", companyId);
//            mapObject.put("userId", userId);
//
//            //name 设备名称
//            String name = mapObject.get("name");
//            if (name == null || name.trim().length() == 0) {
//                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
//                String str_isnull = MessageFormat.format(msg_column_isnull,
//                        (i+index_int),
//                        "设备名称");
//                strBuf.append(str_isnull);
//
//                maxRow = maxRow + 1;
//                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
//            }
//
//            //spec 规格型号
//            String spec = mapObject.get("spec");
//            if (spec == null || spec.trim().length() == 0) {
//                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
//                String str_isnull = MessageFormat.format(msg_column_isnull,
//                        (i+index_int),
//                        "规格型号");
//                strBuf.append(str_isnull);
//
//                maxRow = maxRow + 1;
//                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
//            }
//
//            //typeName 设备类型
//            String typeName = mapObject.get("typeName");
//            if (typeName == null || typeName.trim().length() == 0) {
//                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
//                String str_isnull = MessageFormat.format(msg_column_isnull,
//                        (i+index_int),
//                        "设备类型");
//                strBuf.append(str_isnull);
//
//                maxRow = maxRow + 1;
//                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
//            } else if (typeName != null && typeName.trim().length() > 0) {
//                if (typeNameKeyMap != null && typeNameKeyMap.size() > 0 && typeNameKeyMap.get(typeName) == null) {
//                    //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，在系统中不存在！"
//                    String str_error = MessageFormat.format(msg_column_error,
//                            (i+index_int),
//                            "设备类型",
//                            typeName);
//                    strBuf.append(str_error);
//
//                    maxRow = maxRow + 1;
//                    if (maxShowRow_int <= maxRow) {return strBuf.toString();}
//                } else if (typeNameKeyMap != null && typeNameKeyMap.size() > 0 && typeNameKeyMap.get(typeName) != null) {
//                    //type 设备类型id
//                    mapObject.put("type", typeNameKeyMap.get(typeName));
//                }
//            }
//
//            //deptName 所属部门
//            String deptName = mapObject.get("deptName");
//            if (deptName == null || deptName.trim().length() == 0) {
//                //String msg_column_isnull = "第 {0} 行: ({1})输入为空或空字符串，({1})是必填字段不可为空！"
//                String str_isnull = MessageFormat.format(msg_column_isnull,
//                        (i+index_int),
//                        "所属部门");
//                strBuf.append(str_isnull);
//
//                maxRow = maxRow + 1;
//                if (maxShowRow_int <= maxRow) {return strBuf.toString();}
//            } else if (deptName != null && deptName.trim().length() > 0) {
//                if (deptNameKeyMap != null && deptNameKeyMap.size() > 0 && deptNameKeyMap.get(deptName) == null) {
//                    //String msg_column_error = "第 {0} 行: {1}:{2} 输入错误，在系统中不存在！"
//                    String str_error = MessageFormat.format(msg_column_error,
//                            (i+index_int),
//                            "所属部门",
//                            deptName);
//                    strBuf.append(str_error);
//
//                    maxRow = maxRow + 1;
//                    if (maxShowRow_int <= maxRow) {return strBuf.toString();}
//                } else if (deptNameKeyMap != null && deptNameKeyMap.size() > 0 && deptNameKeyMap.get(deptName) != null) {
//                    //deptId 所属部门id
//                    mapObject.put("deptId", deptNameKeyMap.get(deptName));
//                }
//            }
//
//            //buyDate 采购日期
//            String buyDate = mapObject.get("buyDate");
//            if (buyDate != null && buyDate.trim().length() > 0) {
//                try {
//                    SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormat.DEFAULT_DATE_FORMAT);
//                    dateFormat.parse(buyDate);
//                    //buyDate 采购日期
//                    mapObject.put("buyDate", buyDate);
//                } catch (ParseException e) {
//                    //String msg_column_date_error = "第 {0} 行: {1}:{2} 输入错误，请输入正确的日期格式(yyyy-MM-dd)！"
//                    String str_error = MessageFormat.format(msg_column_date_error,
//                            (i + index_int),
//                            "采购日期",
//                            buyDate);
//                    strBuf.append(str_error);
//
//                    maxRow = maxRow + 1;
//                    if (maxShowRow_int <= maxRow) {
//                        return strBuf.toString();
//                    }
//                }
//            }
//
//            //supplier 厂商名称
//            //remark 备注
//        }
//
//        return strBuf.toString();
//    }
//
////    public String checkExistImportExcelBySelf(List<LinkedHashMap<String, String>> objectList,
////                                              Integer index,
////                                              Integer maxShowRow) {
////        return null;
////    }
////
////    public String checkExistImportExcelByDatabase(List<LinkedHashMap<String, String>> objectList,
////                                                  Integer index,
////                                                  Integer maxShowRow) {
////        return null;
////    }
//
//    public void addImportExcelByList(List<LinkedHashMap<String, String>> objectList) {
//        if (objectList == null || objectList.size() == 0) {return;}
//
//        for (int i = 0; i < objectList.size(); i++) {
//            Equipment equipment = new Equipment();
//            LinkedHashMap<String, String> mapObject = objectList.get(i);
//
//            String userId = mapObject.get("userId");
//            equipment.setCuser(userId);
//
//            //companyId 企业ID
//            String companyId = mapObject.get("companyId");
//            equipment.setCompanyId(companyId);
//
//            //name 设备名称
//            String name = mapObject.get("name");
//            equipment.setName(name);
//
//            //spec 规格型号
//            String spec = mapObject.get("spec");
//            equipment.setSpec(spec);
//
//            //typeName 设备类型 type 设备类型id
//            String type = mapObject.get("type");
//            equipment.setType(type);
//
//            //deptName 所属部门 deptId 所属部门id
//            String deptId = mapObject.get("deptId");
//            equipment.setDeptId(deptId);
//
//            //buyDate 采购日期
//            String buyDate = mapObject.get("buyDate");
//            if (buyDate != null && buyDate.trim().length() > 0) {
//                Date date = DateFormat.dateString2Date(buyDate, DateFormat.DEFAULT_DATE_FORMAT);
//                if (date != null) {
//                    equipment.setBuyDate(date);
//                }
//            }
//
//            //supplier 厂商名称
//            String supplier = mapObject.get("supplier");
//            if (supplier != null && supplier.trim().length() > 0) {
//                equipment.setSupplier(supplier);
//            }
//
//            //remark 备注
//            String remark = mapObject.get("remark");
//            if (remark != null && remark.trim().length() > 0) {
//                equipment.setRemark(remark);
//            }
//
//            try {
//                //获取设备编码
//                String code = coderuleService.createCoder(companyId, "vmes_equipment", "E");
//                equipment.setCode(code);
//
//                //生成设备二维码
//                equipment.setId(Conv.createUuid());
//                String qrcode = fileService.createQRCode("equipment", equipment.getId());
//                if (qrcode != null && qrcode.trim().length() > 0) {
//                    equipment.setQrcode(qrcode);
//                }
//
//                equipmentService.save(equipment);
//
//                //System.out.println("第" + (i+1) + "行：添加成功！");
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
}
