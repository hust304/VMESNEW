package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.deecoop.system.dao.CoderuleMapper;
import com.xy.vmes.entity.Coderule;
import com.xy.vmes.entity.CoderuleEntity;
import com.xy.vmes.entity.Department;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.DepartmentService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.common.Common;
import com.yvan.common.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_coderule:系统编码规则表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-07-26
*/
@Service
@Transactional(readOnly = false)
public class CoderuleServiceImp implements CoderuleService {

    @Autowired
    private CoderuleMapper coderuleMapper;
    @Autowired
    private DepartmentService departmentService;


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public void save(Coderule coderule) throws Exception{
        coderuleMapper.insert(coderule);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public void update(Coderule coderule) throws Exception{
        coderuleMapper.updateById(coderule);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-26
    */
    @Override
    public List<Coderule> dataList(PageData pd) throws Exception {
        return coderuleMapper.dataList(pd);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-07-26
     */
    public List<Map<String, Object>> findDataList(PageData pd) throws Exception {
        return coderuleMapper.findDataList(pd);
    }

    public Coderule findCoderule(PageData pd) {
        List<Coderule> objectList = null;
        try {
            objectList = this.dataList(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (objectList == null || objectList.size() == 0) {return null;}

        return objectList.get(0);
    }

    public Map<String, Object> findCoderuleMap(PageData pd) {
        List<Map<String, Object>> objectList = null;
        try {
            objectList = this.findDataList(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (objectList == null || objectList.size() == 0) {return null;}

        return objectList.get(0);
    }

    public Integer updateCoderule(PageData pd) throws Exception {
        return coderuleMapper.updateCoderule(pd);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 获取业务编号-根据通用编码规则(企业编号+前缀字符+日期字符+流水号)
     *
     * 参数说明:
     *   <SysCoderuleEntity>object
     *     (不可为空)SysCoderuleEntity.tableName  业务名称(表名)
     *     (不可为空)SysCoderuleEntity.did1                       一级部门ID
     *     (不可为空)SysCoderuleEntity.firstName  第一个编码名称
     *     (不可为空)SysCoderuleEntity.type       类别(表名:=produce_workflow 有意义)
     *     (允许为空)SysCoderuleEntity.separator  分隔符
     *     (允许为空)SysCoderuleEntity.filling    填充字符
     *     (允许为空)SysCoderuleEntity.length     指定位数
     *     (允许为空)SysCoderuleEntity.prefix     前缀字符
     *     (允许为空)SysCoderuleEntity.dateFormat 日期格式
     *
     *     (允许为空)SysCoderuleEntity.isNeedCompany
     *     (允许为空)SysCoderuleEntity.isNeedPrefix
     *     (允许为空)SysCoderuleEntity.isNeedDate
     *     (允许为空)SysCoderuleEntity.isNeedCode
     *
     * @param object  生成编码-通用编码规则需要的参数对象
     * @return
     */
    public String findCoderule(CoderuleEntity object) throws Exception {
        if (object.getTableName() == null || object.getTableName().trim().length() == 0) {return new String();}
        if (object.getCompanyID() == null || object.getCompanyID().trim().length() == 0) {return new String();}
        if (object.getFirstName() == null || object.getFirstName().trim().length() == 0) {return new String();}
        if (object.getLength() == null || object.getLength().intValue() == 0) {return new String();}
        if ("produce_workflow".equals(object.getTableName().trim())
                && (object.getType() == null || object.getType().trim().length() == 0)
                ) {
            return new String();
        }

        //编码字符串前缀 prefix
        String prefix = "";
        if (object.getPrefix() != null && object.getPrefix().trim().length() > 0) {
            prefix = object.getPrefix();
        }

        //编码规则(分隔符) separator
        String separator = "";
        if (object.getSeparator() != null && object.getSeparator().trim().length() > 0) {
            separator = object.getSeparator();
        }

        //获取默认填充字符-filling 编码规则(填充字符)
        String filling = Common.CODE_RULE_DEFAULT_FILLING;
        if (object.getFilling() != null && object.getFilling().trim().length() > 0) {
            filling = object.getFilling();
        }

        //A. 企业编号(company)-(是否需要企业编号-isNeedCompany)
        String companyNumber = "";
        if (object.getIsNeedCompany() != null && object.getIsNeedCompany().booleanValue()) {
            Department deptObj = null;
            try {
                //Department = departmentService.getDepartmentById(Long.valueOf(object.getDid1()));
                PageData findMap = new PageData();
                findMap.put("id", object.getCompanyID());
                findMap.put("mapSize", Integer.valueOf(findMap.size()));
                deptObj = departmentService.findDepartment(findMap);
                if (deptObj != null && deptObj.getCode() != null && deptObj.getCode().trim().length() > 0) {
                    companyNumber = deptObj.getCode().trim();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (companyNumber.trim().length() > 0) {
                companyNumber = companyNumber.toLowerCase();
                if (!"company".equals(object.getFirstName().trim())) {
                    companyNumber = separator + companyNumber;
                }
            }
        }

        //B. 前缀字符(prefix)-(是否需要前缀-isNeedPrefix)
        String prefix_str = "";
        if (object.getIsNeedPrefix() != null && object.getIsNeedPrefix().booleanValue() && prefix.trim().length() > 0) {
            prefix_str = prefix;
            if (!"prefix".equals(object.getFirstName().trim())) {
                prefix_str = separator + prefix;
            }
        }

        //C. 日期字符(date)-(是否需要日期-isNeedDate)
        String date_str = "";
        if (object.getIsNeedDate() != null && object.getIsNeedDate().booleanValue()) {
            //获取当前系统日期-默认日期格式
            date_str = DateFormat.date2String(new Date(), Common.CODE_RULE_DATEFORMAT_DEFAULT);
            try {
                if (object.getDateFormat() != null && object.getDateFormat().trim().length() > 0) {
                    date_str = DateFormat.date2String(new Date(), object.getDateFormat().trim());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (date_str.trim().length() > 0 && !"date".equals(object.getFirstName().trim())) {
                date_str = separator + date_str;
            }
        }

        //1. (业务名称,一级部门ID)查询(sys_codeRule)-获取当前最新Code编码
        PageData findMap = new PageData();
        findMap.put("tableName", object.getTableName());
        findMap.put("companyId", object.getCompanyID());
        if (object.getType() != null && object.getType().trim().length() > 0) {
            findMap.put("type", object.getType());
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        Map<String, Object> objectMap = this.findCoderuleMap(findMap);
        Coderule coderuleDB = new Coderule();
        coderuleDB = (Coderule) HttpUtils.pageData2Entity(objectMap, coderuleDB);
        Long sysNewCode = this.findNewCode(coderuleDB, object.getLength().intValue());

        //2. 获取最新流水号编码
        String newCode = this.findCodeByLength(sysNewCode, object.getLength().intValue(), filling);

        //D. 流水号(code)-(是否需要流水号-isNeedCode)
        String code_str = "";
        if (newCode != null && newCode.trim().length() > 0) {
            code_str = newCode;
            if (!"code".equals(object.getFirstName().trim())) {
                code_str = separator + newCode;
            }
        }

        //4. 获取最新业务编码-通用编码规则-"{0}{1}{2}{3}"-(企业编号+前缀+yyMMdd+流水号)
        //0:企业编号
        //1:编码字符串前缀
        //2:日期字符串
        //3:编码流水号
        String businessCode = MessageFormat.format(Common.CODE_RULE_DEFAULT,
                companyNumber,
                prefix_str,
                date_str,
                code_str
        );

        //5. 插入数据库(sys_codeRule)
        if (coderuleDB == null) {
            Coderule addObject = new Coderule();
            addObject.setTableName(object.getTableName().trim());
            addObject.setCompanyId(object.getCompanyID().trim());
            addObject.setCode(newCode);
            addObject.setBusinessCode(businessCode);
            addObject.setCdate(new Date());
            if (object.getType() != null && object.getType().trim().length() > 0) {
                addObject.setType(object.getType().trim());
            }
            this.save(addObject);
        } else {
            PageData pageData = new PageData();
            pageData = HttpUtils.entity2PageData(coderuleDB, pageData);
            pageData.put("udate", new Date());
            pageData.put("code", newCode);
            pageData.put("businessCode", businessCode);
            this.updateCoderule(pageData);
        }

        return businessCode;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    private Long findNewCode(Coderule object, int length) {
        if (object == null) {return new Long(1L);}

        //1.获取指定位数最大值
        Long maxLong = this.findMaxByLength(length);

        //2. 获取系统当前最大值
        String max_value_str = "";
        if (object.getCode() != null && object.getCode().trim().length() > 0) {
            max_value_str = object.getCode().trim();
        }

        long max_value_long = -1;
        try {
            max_value_long = Long.valueOf(max_value_str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (max_value_long == maxLong.longValue()) {return new Long(1L);}

        return new Long(max_value_long + 1L);
    }

    /**
     * 获取最大值-指定位数
     * @param length
     * @return
     */
    private Long findMaxByLength(int length) {
        Long maxLong = new Long(0L);

        String maxValue = "";
        for (int i = 0; i < length; i++) {
            maxValue = maxValue + "9";
        }

        if (maxValue.trim().length() > 0) {
            try {
                maxLong = Long.valueOf(maxValue);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return maxLong;
    }

    /**
     * 获取最新流水号，前补充
     * @param code     编码
     * @param length   编码规则(指定位数)
     * @param filling  编码规则(填充字符)
     * @return
     */
    private String findCodeByLength(Long code, int length, String filling) {
        if (code == null || 0L == code.longValue()) {return new String();}
        if (length == 0) {return new String();}
        if (code.toString().length() > length) {return new String();}

        String fill_string = "";
        //1. 获取补充字符串个数
        int fill_length = length - code.toString().length();
        for (int i = 0; i < fill_length; i++) {
            fill_string = fill_string + filling;
        }

        return fill_string + code.toString();
    }

}



