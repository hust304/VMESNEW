package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.entity.Department;
import com.xy.vmes.service.CompanyService;
import com.xy.vmes.service.DepartmentService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;

@Service
@Transactional(readOnly = false)
public class CompanyServiceImp implements CompanyService {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-27
     * @param object
     * @return
     */
    public String checkColumnByAdd(Department object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！<br/>";

        //code:企业编码
        if (object.getCode() == null || object.getCode().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "企业编码");
            msgBuf.append(str_isnull);
        }
        //name 企业名称
        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "企业名称");
            msgBuf.append(str_isnull);
        }
        //companyType企业性质(字典)
        if (object.getCompanyType() == null || object.getCompanyType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "企业性质");
            msgBuf.append(str_isnull);
        }
        //companyValidityDate有效期
        if (object.getCompanyValidityDate() == null) {
            String str_isnull = MessageFormat.format(column_isnull, "有效期");
            msgBuf.append(str_isnull);
        }
        //companyUserCount企业用户数
        if (object.getCompanyUserCount() == null) {
            String str_isnull = MessageFormat.format(column_isnull, "企业用户数");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-27
     * @param object
     * @return
     */
    public String checkColumnByEdit(Department object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！<br/>";

        if (object.getId() == null || object.getId().trim().length() == 0) {
            msgBuf.append("id为空或空字符串！<br/>");
        }
        //code:企业编码
        if (object.getCode() == null || object.getCode().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "企业编码");
            msgBuf.append(str_isnull);
        }
        //name 企业名称
        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "企业名称");
            msgBuf.append(str_isnull);
        }
        //companyType企业性质(字典)
        if (object.getCompanyType() == null || object.getCompanyType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "企业性质");
            msgBuf.append(str_isnull);
        }
//        //companyValidityDate有效期
//        if (object.getCompanyValidityDate() == null) {
//            String str_isnull = MessageFormat.format(column_isnull, "有效期");
//            msgBuf.append(str_isnull);
//        }
        //companyUserCount企业用户数
        if (object.getCompanyUserCount() == null) {
            String str_isnull = MessageFormat.format(column_isnull, "企业用户数");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    /**
     * 企业名称同一层级是否相同
     *
     * @param pid   (不可为空)
     * @param id    (允许为空)-(添加时is null, 修改时 is not null)
     * @param name  (不可为空)
     * @return
     *     true : 组织名称存在名称相同
     *     false: 组织名称不存在名称相同(默认值)
     */
    public boolean isExistByName(String pid, String id, String name) {
        if (pid == null || pid.trim().length() == 0) {return false;}
        if (name == null || name.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        //organizeType 组织类型(1:公司 2:部门)
        findMap.put("organizeType", "1");
        findMap.put("name", name);
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Department> objectList = departmentService.findDepartmentList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    /**
     * 企业编码同一层级是否相同
     *
     * @param pid   (不可为空)
     * @param id    (允许为空)-(添加时is null, 修改时 is not null)
     * @param code  (不可为空)
     * @return
     *     true : 组织名称存在名称相同
     *     false: 组织名称不存在名称相同(默认值)
     */
    public boolean isExistByCode(String pid, String id, String code) {
        if (pid == null || pid.trim().length() == 0) {return false;}
        if (code == null || code.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        //organizeType 组织类型(1:公司 2:部门)
        findMap.put("organizeType", "1");
        findMap.put("code", code);
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Department> objectList = departmentService.findDepartmentList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    public Department object2objectDB(Department object, Department objectDB) {
        if (objectDB == null) {objectDB = new Department();}
        if (object == null) {return objectDB;}

        //code:企业编码
        objectDB.setCode(object.getCode());
        //name 企业名称
        objectDB.setName(object.getName());
        //companyType企业性质(字典)
        objectDB.setCompanyType(object.getCompanyType());
        //companyValidityDate有效期
        objectDB.setCompanyValidityDate(object.getCompanyValidityDate());
        //companyUserCount企业用户数
        objectDB.setCompanyUserCount(object.getCompanyUserCount());

        //isdisable是否禁用(1:已禁用 0:启用)
        if (object.getIsdisable() != null && object.getIsdisable().trim().length() > 0) {
            objectDB.setIsdisable(object.getIsdisable().trim());
        }
        //companyShortname 企业简称
        if (object.getCompanyShortname() != null && object.getCompanyShortname().trim().length() > 0) {
            objectDB.setCompanyShortname(object.getCompanyShortname());
        }
        //serialNumber显示顺序
        if (object.getSerialNumber() != null) {
            objectDB.setSerialNumber(object.getSerialNumber());
        }

        return objectDB;
    }

//    public Integer findMaxSerialNumber(String pid) {
//        if (pid == null || pid.trim().length() == 0) {return Integer.valueOf(0);}
//
//        PageData findMap = new PageData();
//        findMap.put("pid", pid);
//        findMap.put("mapSize", Integer.valueOf(findMap.size()));
//
//        List<Department> objectList = null;
//        try {
//            objectList = departmentService.findDepartmentList(findMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (objectList != null && objectList.size() > 0) {
//            return Integer.valueOf(objectList.size());
//        }
//
//        return Integer.valueOf(0);
//    }

    /**
     * check企业ID是否允许删除
     * 当前企业ID(子节点)-是否使用
     *
     * 创建人：陈刚
     * 创建时间：2018-08-06
     * @param ids
     * @return
     */
    public String checkDeleteCompanyByIds(String ids) {
        if (ids == null || ids.trim().length() == 0) {return new String();}
        String[] id_arry = ids.split(",");

        String msgTemp = "第&nbsp;{0}&nbsp;行:&nbsp;存在子企业或部门不可禁用！<br/>";
        StringBuffer msgBuf = new StringBuffer();
        for (int i = 0; i < id_arry.length; i++) {
            String id = id_arry[i];

            //当前企业ID(子节点)-是否使用
            List<Department> deptList = departmentService.findDepartmentListByPid(id);
            if (deptList != null && deptList.size() > 0) {
                String msg_Str = MessageFormat.format(msgTemp, (i+1));
                msgBuf.append(msg_Str);
            }
        }

        return  msgBuf.toString();
    }

}
