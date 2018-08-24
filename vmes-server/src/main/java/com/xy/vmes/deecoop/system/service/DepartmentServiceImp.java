package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.DepartmentMapper;
import com.xy.vmes.entity.CoderuleEntity;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Post;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.DepartmentTreeService;
import com.xy.vmes.service.PostService;
import com.yvan.PageData;
import com.yvan.Tree;
import com.yvan.HttpUtils;
import com.xy.vmes.common.util.Common;
import com.yvan.platform.RestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

/**
* 说明：vmes_department:系统部门表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-07-23
*/
@Service
@Transactional(readOnly = false)
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private PostService postService;
    @Autowired
    private CoderuleService coderuleService;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void save(Department department) throws Exception{
        department.setCdate(new Date());
        departmentMapper.insert(department);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void update(Department department) throws Exception{
        department.setUdate(new Date());
        departmentMapper.updateById(department);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    @Cacheable(cacheNames = "department", key = "''+#id")
    public Department selectById(String id) throws Exception{
        return departmentMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void deleteById(String id) throws Exception{
        departmentMapper.deleteById(id);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<Department> dataListPage(PageData pd,Pagination pg) throws Exception{
        return departmentMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<Department> dataList(PageData pd) throws Exception{
        return departmentMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return departmentMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return departmentMapper.findDataList(pd);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    /**
     * 创建人：刘威
     * 创建时间：2018-08-01
     */
    @Override
    public List<TreeEntity>  getTreeList(PageData pd)throws Exception{
        return  departmentMapper.getTreeList(pd);
    }



    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-07-23
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        departmentMapper.deleteByIds(ids);
    }

    @Autowired
    private DepartmentTreeService deptTreeService;

    /**
     * 创建人：陈刚
     * 创建时间：2018-08-08
     */
    @Override
    public List<LinkedHashMap<String, String>> getColumnList() throws Exception{
        return departmentMapper.getColumnList();
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-08-08
     */
    @Override
    public List<Map<String, Object>> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return departmentMapper.getDataListPage(pd, pg);
    }

    /**
     * 批量修改组织架构信息为禁用状态
     *
     * 创建人：陈刚
     * 创建时间：2018-07-27
     */
    public void updateDisableByIds(String[] ids) throws Exception {
        departmentMapper.updateDisableByIds(ids);
    }

    /**
     * 生成部门编码
     *
     * 创建人：陈刚
     * 创建时间：2018-07-27
     *
     * @param companyID  公司ID-组织架构ID
     * @return
     */
    public String createCoder(String companyID) {
        //(企业编号+前缀字符+日期字符+流水号)-(company+prefix+date+code)
        //(无需+前缀字符+无需+流水号)-W000142
        CoderuleEntity object = new CoderuleEntity();
        //tableName 业务名称(表名)
        object.setTableName("vmes_department");
        //companyID 公司ID
        object.setCompanyID(companyID);
        //length 指定位数(5)
        object.setLength(Common.CODE_RULE_LENGTH_DEFAULT);
        //firstName 第一个编码名称
        object.setFirstName("prefix");

        //separator 分隔符
        //object.setSeparator("-");
        //filling 填充字符(0)
        object.setFilling(Common.CODE_RULE_DEFAULT_FILLING);

        //isNeedPrefix 是否需要前缀
        object.setIsNeedPrefix(Boolean.TRUE);
        //prefix 前缀字符
        object.setPrefix("D");

        return coderuleService.findCoderule(object);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-27
     * @param object
     * @return
     */
    public String checkColumnByAdd(Department object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        if (object.getPid() == null || object.getPid().trim().length() == 0) {
            msgBuf.append("pid为空或空字符串！");
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "部门名称");
            msgBuf.append(str_isnull);
        }
//        if (object.getSerialNumber() == null) {
//            String str_isnull = MessageFormat.format(column_isnull, "显示顺序");
//            msgBuf.append(str_isnull);
//        }
        if (object.getDeptType() == null || object.getDeptType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "部门类型");
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
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        if (object.getId() == null || object.getId().trim().length() == 0) {
            msgBuf.append("id为空或空字符串！");
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getPid() == null || object.getPid().trim().length() == 0) {
            msgBuf.append("pid为空或空字符串！");
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "部门名称");
            msgBuf.append(str_isnull);
        }
//        if (object.getSerialNumber() == null) {
//            String str_isnull = MessageFormat.format(column_isnull, "显示顺序");
//            msgBuf.append(str_isnull);
//        }
        if (object.getDeptType() == null || object.getDeptType().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "部门类型");
            msgBuf.append(str_isnull);
        }
        if (object.getIsdisable() == null || object.getIsdisable().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "是否禁用");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    /**
     * 组织名称同一层级是否相同
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
        findMap.put("name", name);
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Department> objectList = this.findDepartmentList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-18
     */
    public Department findDepartment(PageData object) {
        if (object == null) {return null;}

        List<Department> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public Department findDepartmentById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Department> objectList = this.findDepartmentList(findMap);
        if (objectList != null && objectList.size() > 0) {return objectList.get(0);}

        return null;
    }
    public Department findDepartmentByRoot() {
        PageData findMap = new PageData();
        findMap.put("pid", "root");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Department> objectList = this.findDepartmentList(findMap);
        if (objectList != null && objectList.size() > 0) {return objectList.get(0);}

        return null;
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-18
     */
    public List<Department> findDepartmentList(PageData object) {
        if (object == null) {return null;}

        List<Department> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    public List<Department> findDepartmentListByPid(String pid) {
        List<Department> objectList = new ArrayList<Department>();
        if (pid == null || pid.trim().length() == 0) {return objectList;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        //是否禁用(0:已禁用 1:启用) 数据字典:sys_isdisable
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        objectList = this.findDepartmentList(findMap);

        return objectList;
    }

    public Integer findMaxSerialNumber(String pid) {
        if (pid == null || pid.trim().length() == 0) {return Integer.valueOf(0);}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Department> objectList = null;
        try {
            objectList = this.findDepartmentList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (objectList != null && objectList.size() > 0) {
            return Integer.valueOf(objectList.size());
        }

        return Integer.valueOf(0);
    }

    /**
     * 根据部门对象<Department>当前部门节点下面所有节点生成树形结构
     * 1. <Department>对象为空时-生成整棵树-(pid:=root)开始-部门级别(0-5)
     * 2. <Department>对象is not null
     * (允许为空)Department.id    当前部门id
     * (允许为空)Department.code  当前部门编码
     * (允许为空)Department.name  当前部门名称
     * (允许为空)Department.id1   当前部门(id_1)-公司id
     * (允许为空)Department.layer 当前部门级别
     * 3. (id,id1,code,name,layer) 不可同时为空
     * pid is not null pid对应的部门+pid下面所有子部门
     * pid is null (code,layer) is not null or (name,layer) is not null
     * <p>
     * <p>
     * <p>
     * 创建人：陈刚
     * 创建时间：2018-07-18
     *
     * @param detp 允许为空-<Department>对象(vmes_department:系统部门表)
     * @return
     */
    public Tree<Department> findTree(Department detp) {
        Department findObj = null;

        if (detp == null) {
            findObj = new Department();
            findObj.setPid("root");
        } else if (detp != null) {
            //1. 参数非空判断
            if (detp.getId() != null && detp.getId().trim().length() > 0) {
                findObj = new Department();
                findObj.setId(detp.getId().trim());
            } else if (detp.getId1() != null && detp.getId1().trim().length() > 0
                    && detp.getCode() != null && detp.getCode().trim().length() > 0
                    && detp.getLayer() != null
                    ) {
                findObj = new Department();
                findObj.setId1(detp.getId1().trim());
                findObj.setCode(detp.getCode().trim());
                findObj.setLayer(detp.getLayer());
            } else if (detp.getId1() != null && detp.getId1().trim().length() > 0
                    && detp.getName() != null && detp.getName().trim().length() > 0
                    && detp.getLayer() != null
                    ) {
                findObj = new Department();
                findObj.setId1(detp.getId1().trim());
                findObj.setName(detp.getName().trim());
                findObj.setLayer(detp.getLayer());
            } else if (detp.getId1() != null && detp.getId1().trim().length() > 0
                    && detp.getCode() != null && detp.getCode().trim().length() > 0
                    && detp.getName() != null && detp.getName().trim().length() > 0
                    && detp.getLayer() != null
                    ) {
                findObj = new Department();
                findObj.setId1(detp.getId1().trim());
                findObj.setCode(detp.getCode().trim());
                findObj.setName(detp.getName().trim());
                findObj.setLayer(detp.getLayer());
            }
        }

        if (findObj == null) {
            throw new RestException("", "参数错误:Department(pid,id_1,code,name,layer) 参数为空或空字符串，请与管理员联系！");
        }

        //2. 根据参数查询(vmes_department:系统部门表)--获得返回树结构根节点
        //isdisable:是否禁用(0:已禁用 1:启用)
        findObj.setIsdisable("1");

        PageData pageData = HttpUtils.entity2PageData(findObj, new PageData());
        List<Department> objectList = this.findDepartmentList(pageData);
        if (objectList == null || objectList.size() == 0) {
            String msgStr = "参数错误:Department(pid,code,name,layer) 查询无数据，请与管理员联系！";
            throw new RestException("", msgStr);
        }
        Department root_obj = objectList.get(0);

        //3. 生成部门树
        deptTreeService.initialization();
        deptTreeService.findDeptTree(root_obj.getId());

        return null;
    }

    /**
     * 获取部门id字符串-(','分隔的字符串)
     * 创建人：陈刚
     * 创建时间：2018-07-19
     *
     */
    public String findDeptidByDeptList(List<Department> objectList) {
        StringBuffer strBuf = new StringBuffer();
        if (objectList == null || objectList.size() == 0) {return strBuf.toString();}

        for (Department dept : objectList) {
            strBuf.append(dept.getId().trim());
            strBuf.append(",");
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.indexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return strBuf.toString();
    }

    /**
     * 获取部门最大级别-遍历部门List<Department>
     *
     * 创建人：陈刚
     * 创建时间：2018-07-24
     * @param objectList
     * @return
     */
    public Integer findMaxLayerByDeptList(List<Department> objectList) {
        if (objectList == null || objectList.size() == 0) {return null;}
        int maxLayer = 0;

        for (Department object : objectList) {
            if (object.getLayer() != null && object.getLayer().intValue() > maxLayer) {
                maxLayer = object.getLayer().intValue();
            }
        }

        if (maxLayer > 0) {return Integer.valueOf(maxLayer);}
        return null;
    }

    /**
     * 遍历List<Department>-获取(长名称,长编码)- 通过'-'练级的字符串
     * @param objectList
     * @return Map<key, String>
     *     "LongName"
     *     "LongCode"
     */
    public Map<String, String> findLongNameCode(List<Department> objectList) {
        Map<String, String> objectMap = new HashMap<String, String>();
        if (objectList == null || objectList.size() == 0) {return objectMap;}

        StringBuffer LongNameBuf = new StringBuffer();
        StringBuffer LongCodeBuf = new StringBuffer();
        for (Department object : objectList) {
            if (object.getName() != null && object.getName().trim().length() > 0) {
                LongNameBuf.append(object.getName().trim());
                LongNameBuf.append("-");
            }
            if (object.getCode() != null && object.getCode().trim().length() > 0) {
                LongCodeBuf.append(object.getCode().trim());
                LongCodeBuf.append("-");
            }
        }

        String nameTemp = LongNameBuf.toString().trim();
        if (nameTemp.lastIndexOf("-") != -1) {
            nameTemp = nameTemp.substring(0, nameTemp.lastIndexOf("-"));
        }
        objectMap.put("LongName", nameTemp);

        String codeTemp = LongCodeBuf.toString().trim();
        if (codeTemp.lastIndexOf("-") != -1) {
            codeTemp = codeTemp.substring(0, codeTemp.lastIndexOf("-"));
        }
        objectMap.put("LongCode", codeTemp);

        return objectMap;
    }

    /**
     * 根据父节点<Department>对象-(id_0,id_1,...,id_5)
     * 查询获得组织架构路径List<Department>
     *
     * @param paterObject
     * @return Map<key, String>
     *     "LongName"
     *     "LongCode"
     */
    public List<Department> findPathListByPater(Department paterObject) {
        List<Department> objectList = new ArrayList<Department>();
        if (paterObject == null) {return objectList;}

        StringBuffer ids = new StringBuffer();
        for (int i = 0; i <= 5; i++) {
            if (i == 0 && paterObject.getId0() != null && paterObject.getId0().trim().length() > 0) {
                ids.append(paterObject.getId0().trim());
                ids.append(",");
            } else if (i == 1 && paterObject.getId1() != null && paterObject.getId1().trim().length() > 0) {
                ids.append(paterObject.getId1().trim());
                ids.append(",");
            } else if (i == 2 && paterObject.getId2() != null && paterObject.getId2().trim().length() > 0) {
                ids.append(paterObject.getId2().trim());
                ids.append(",");
            } else if (i == 3 && paterObject.getId3() != null && paterObject.getId3().trim().length() > 0) {
                ids.append(paterObject.getId3().trim());
                ids.append(",");
            } else if (i == 4 && paterObject.getId4() != null && paterObject.getId4().trim().length() > 0) {
                ids.append(paterObject.getId4().trim());
                ids.append(",");
            } else if (i == 5 && paterObject.getId5() != null && paterObject.getId5().trim().length() > 0) {
                ids.append(paterObject.getId5().trim());
                ids.append(",");
            }
        }

        String idsTemp = ids.toString();
        //去掉最后一个','
        if (idsTemp.lastIndexOf(",") != -1) {
            idsTemp = idsTemp.substring(0, idsTemp.lastIndexOf(","));
        }
        String id_str = "'" + idsTemp.replace(",", "','") + "'";
        String pidQuery = "id in (" + id_str + ")";

        //查询部门表-获得每一层的id-部门集合List<Department>
        PageData pageData = new PageData();
        //isdisable:是否禁用(0:已禁用 1:启用)
        pageData.put("isdisable", "1");
        pageData.put("queryStr", pidQuery);
        pageData.put("mapSize", Integer.valueOf(pageData.size()));

        return this.findDepartmentList(pageData);
    }

    /**
     * 根据父pid父节点<Department>对象-(id_0,id_1,...,id_5)-查询获得组织架构路径List<Department>
     * 遍历List<Department>-获取(长名称,长编码)- 通过'-'练级的字符串
     *
     * @param pid
     * @return Map<key, String>
     *     "LongName"
     *     "LongCode"
     */
    public Map<String, String> findLongNameCodeByPid(String pid) {
        if (pid == null || pid.trim().length() == 0) {return new HashMap<String, String>();}

        //根据父pid获取父节点<Department>对象
        Department paterObject = this.findDepartmentById(pid);
        //查询获得组织架构路径List<Department>
        List<Department> pathList = this.findPathListByPater(paterObject);

        return this.findLongNameCode(pathList);
    }

    /**
     * 根据父节点<Department>对象-(id_0,id_1,...,id_5)-查询获得组织架构路径List<Department>
     * 遍历List<Department>-获取(长名称,长编码)- 通过'-'练级的字符串
     *
     * @param Pater
     * @return Map<key, String>
     *     "LongName"
     *     "LongCode"
     */
    public Map<String, String> findLongNameCodeByPater(Department Pater) {
        if (Pater == null) {return new HashMap<String, String>();}
        List<Department> pathList = this.findPathListByPater(Pater);
        return this.findLongNameCode(pathList);
    }

    public Department paterObject2ObjectDB(Department paterObject, Department objectDB) {
        if (objectDB == null) {objectDB = new Department();}
        if (paterObject == null) {return objectDB;}

        if (paterObject.getId0() != null && paterObject.getId0().trim().length() > 0) {
            objectDB.setId0(paterObject.getId0().trim());
        }
        if (paterObject.getId1() != null && paterObject.getId1().trim().length() > 0) {
            objectDB.setId1(paterObject.getId1().trim());
        }
        if (paterObject.getId2() != null && paterObject.getId2().trim().length() > 0) {
            objectDB.setId2(paterObject.getId2().trim());
        }
        if (paterObject.getId3() != null && paterObject.getId3().trim().length() > 0) {
            objectDB.setId3(paterObject.getId3().trim());
        }
        if (paterObject.getId4() != null && paterObject.getId4().trim().length() > 0) {
            objectDB.setId4(paterObject.getId4().trim());
        }
        if (paterObject.getId5() != null && paterObject.getId5().trim().length() > 0) {
            objectDB.setId5(paterObject.getId5().trim());
        }

        return objectDB;
    }

    public Department id2DepartmentByLayer(String id, Integer layer, Department objectDB) {
        if (objectDB == null) {objectDB = new Department();}
        if (id == null || id.trim().length() == 0) {return objectDB;}
        if (layer == null) {return objectDB;}

        if (0 == layer.intValue()) {
            objectDB.setId0(id);
        } else if (1 == layer.intValue()) {
            objectDB.setId1(id);
        } else if (2 == layer.intValue()) {
            objectDB.setId2(id);
        } else if (3 == layer.intValue()) {
            objectDB.setId3(id);
        } else if (4 == layer.intValue()) {
            objectDB.setId4(id);
        } else if (5 == layer.intValue()) {
            objectDB.setId5(id);
        }
        return objectDB;
    }

    public Department clearDepartmentByPath(Department objectDB) {
        if (objectDB == null) {objectDB = new Department();}

        objectDB.setId0(null);
        objectDB.setId1(null);
        objectDB.setId2(null);
        objectDB.setId3(null);
        objectDB.setId4(null);
        objectDB.setId5(null);

        objectDB.setLongCode(null);
        objectDB.setLongName(null);
        objectDB.setLayer(null);

        return objectDB;
    }

    public Department object2objectDB(Department object, Department objectDB) {
        if (objectDB == null) {objectDB = new Department();}
        if (object == null) {return objectDB;}

        objectDB.setPid(object.getPid());
        objectDB.setName(object.getName());
        objectDB.setOrganizeType("2");
        objectDB.setDeptType(object.getDeptType());
        objectDB.setIsdisable(object.getIsdisable());

        if (object.getSerialNumber() != null) {
            objectDB.setSerialNumber(object.getSerialNumber());
        }
        return objectDB;
    }

    /**
     * check部门列表List<Department>是否允许删除
     * 当前组织节点下是否含有子节点
     * 当前节点下是否含有岗位
     *
     * 创建人：陈刚
     * 创建时间：2018-08-06
     * @param ids
     * @return
     */
    public String checkDeleteDeptByIds(String ids) {
        if (ids == null || ids.trim().length() == 0) {return new String();}

        String msgTemp_1 = "第&nbsp;{0}&nbsp;行:&nbsp;存在子企业或子部门不可禁用！" + Common.SYS_ENDLINE_DEFAULT;
        String msgTemp_2 = "第&nbsp;{0}&nbsp;行:&nbsp;存在岗位不可禁用！" + Common.SYS_ENDLINE_DEFAULT;

        StringBuffer msgBuf = new StringBuffer();
        String[] id_arry = ids.split(",");
        for (int i = 0; i < id_arry.length; i++) {
            String id = id_arry[i];
            List<Department> childList = this.findDepartmentListByPid(id);
            //1. 查询当前组织节点下是否含有子节点
            if (childList != null && childList.size() > 0) {
                String msg_Str = MessageFormat.format(msgTemp_1, (i+1));
                msgBuf.append(msg_Str);
            }

            //2. 当前节点下是否含有岗位
            List<Post> postList = postService.findPostListByDeptId(id);
            if (postList != null && postList.size() > 0) {
                String msg_Str = MessageFormat.format(msgTemp_2, (i+1));
                msgBuf.append(msg_Str);
            }
        }

        return  msgBuf.toString();
    }
}



