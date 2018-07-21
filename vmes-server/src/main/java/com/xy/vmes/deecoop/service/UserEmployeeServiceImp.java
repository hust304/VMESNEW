package com.xy.vmes.deecoop.service;

import com.xy.vmes.deecoop.dao.ViewVmesUserEmployeeMapper;
import com.xy.vmes.entity.Employee;
import com.xy.vmes.entity.User;
import com.xy.vmes.entity.ViewVmesUserEmployee;
import com.xy.vmes.service.UserEmployeeService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEmployeeServiceImp implements UserEmployeeService {
    @Autowired
    private ViewVmesUserEmployeeMapper viewUserEmployeeMapper;

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-20
     *
     * @param object
     */
    @Override
    public List<ViewVmesUserEmployee> findViewUserEmployList(ViewVmesUserEmployee object) {
        List<ViewVmesUserEmployee> objectList = new ArrayList<ViewVmesUserEmployee>();
        if (object == null) {return objectList;}

        try {
            PageData pageData = HttpUtils.entity2PageData(object, new PageData());
            objectList = viewUserEmployeeMapper.findViewUserEmployList(pageData);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-20
     *
     * @param viewObject
     * @param object
     */
    @Override
    public User viewObject2User(ViewVmesUserEmployee viewObject, User object) {
        if (object == null) {object = new User();}
        if (viewObject == null) {return object;}

        //user_id--id
        object.setId(viewObject.getUser_id());
        //员工ID user_employId
        object.setEmployId(viewObject.getUser_employId());
        //公司ID-组织架构 user_companyId
        object.setCompanyId(viewObject.getUser_companyId());
        //账号(系统登录账号) user_userCode
        object.setUserCode(viewObject.getUser_userCode());
        //密码(MD5加密)password
        object.setPassword(viewObject.getPassword());

        //用户微信ID openId
        object.setOpenId(viewObject.getOpenId());
        //姓名 userName
        object.setUserName(viewObject.getUserName());
        //是否禁用 user_isdisable
        object.setIsdisable(viewObject.getUser_isdisable());
        //创建时间 user_cdate
        object.setCdate(viewObject.getUser_cdate());
        //创建人账号user_cuser
        object.setCuser(viewObject.getUser_cuser());

        //修改时间user_udate
        object.setUdate(viewObject.getUser_udate());
        //修改人账号user_uuser
        object.setUuser(viewObject.getUser_uuser());
        //预留字段user_column1
        object.setColumn1(viewObject.getUser_column1());
        //预留字段user_column2
        object.setColumn2(viewObject.getUser_column2());
        //预留字段user_column3
        object.setColumn3(viewObject.getUser_column3());

        return object;
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-20
     *
     * @param viewObject
     * @param object
     */
    @Override
    public Employee viewObject2Employee(ViewVmesUserEmployee viewObject, Employee object) {
        if (object == null) {object = new Employee();}
        if (viewObject == null) {return object;}

        //employ_id;
        object.setId(viewObject.getEmploy_id());
        //系统用户ID employ_userId
        object.setUserId(viewObject.getEmploy_userId());
        //公司ID-组织架构 employ_companyId
        object.setCompanyId(viewObject.getEmploy_companyId());
        //员工编号 employ_code
        object.setCode(viewObject.getEmploy_code());
        //员工类型 employ_type
        object.setType(viewObject.getEmploy_type());

        //员工姓名employ_name
        object.setName(viewObject.getEmploy_name());
        //员工英文名employ_nameEn
        object.setNameEn(viewObject.getEmploy_nameEn());
        //员工照片photo
        object.setPhoto(viewObject.getPhoto());
        //员工图片icon
        object.setIcon(viewObject.getIcon());
        //手机号码mobile
        object.setMobile(viewObject.getMobile());

        //邮箱地址email
        object.setEmail(viewObject.getEmail());
        //性别sex
        object.setSex(viewObject.getSex());
        //出生日期birthday
        object.setBirthday(viewObject.getBirthday());
        //入职日期entryDate
        object.setEntryDate(viewObject.getEntryDate());
        //籍贯nativePlace
        object.setNativePlace(viewObject.getNativePlace());

        //政治面貌 political
        object.setPolitical(viewObject.getPolitical());
        //身份证号identityNumber
        object.setIdentityNumber(viewObject.getIdentityNumber());
        //婚姻状况marital
        object.setMarital(viewObject.getMarital());
        //是否禁用employ_isdisable
        object.setIsdisable(viewObject.getEmploy_isdisable());
        //创建时间employ_cdate
        object.setCdate(viewObject.getEmploy_cdate());

        //创建人账号employ_cuser
        object.setCuser(viewObject.getEmploy_cuser());
        //修改时间employ_udate
        object.setUdate(viewObject.getEmploy_udate());
        //修改人账号employ_uuser
        object.setUuser(viewObject.getEmploy_uuser());
        //预留字段employ_column1
        object.setColumn1(viewObject.getEmploy_column1());
        //预留字段employ_column2
        object.setColumn2(viewObject.getEmploy_column2());

        //预留字段employ_column3
        object.setColumn3(viewObject.getEmploy_column3());

        return object;
    }
}
