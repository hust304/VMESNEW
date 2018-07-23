package com.xy.vmes.deecoop.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.dao.DepartmentMapper;
import com.xy.vmes.entity.Department;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.DepartmentTreeService;
import com.yvan.PageData;
import com.yvan.Tree;
import com.yvan.HttpUtils;
import com.yvan.platform.RestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void save(Department department) throws Exception{
        departmentMapper.insert(department);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-23
    */
    @Override
    public void update(Department department) throws Exception{
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
    @Autowired
    private DepartmentTreeService deptTreeService;

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
        //isdisable:是否禁用(1:已禁用 0:启用)
        findObj.setIsdisable("0");

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
}



