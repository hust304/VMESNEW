package com.xy.vmes.deecoop.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.dao.DepartmentMapper;
import com.xy.vmes.entity.Department;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.DepartmentTreeService;
import com.yvan.PageData;
import com.yvan.Tree;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 说明：部门表 实现类
 * 创建人：自动创建
 * 创建时间：2018-07-18
 */
@Service
@Transactional(readOnly = true)
public class DepartmentServiceImp implements DepartmentService {


    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentTreeService deptTreeService;

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public void save(Department department) {
        departmentMapper.save(department);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public void delete(Department department) {
        departmentMapper.delete(department);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    @Cacheable(cacheNames = "department", key = "''+#id")
    public Department selectById(String id) {
        return departmentMapper.selectById(id);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public void deleteById(String id) {
        departmentMapper.deleteById(id);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public Department findById(PageData pd) {
        return departmentMapper.findById(pd);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public List<Department> dataListPage(PageData pd, Pagination pg) {
        return departmentMapper.dataListPage(pd, pg);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public List<Department> dataList(PageData pd) {
        return departmentMapper.dataList(pd);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public void deleteByIds(String[] ids) {
        departmentMapper.deleteByIds(ids);
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public List<LinkedHashMap> findColumnList() {
        return departmentMapper.findColumnList();
    }

    /**
     * 创建人：自动创建
     * 创建时间：2018-07-18
     */
    @Override
    public List<Map> findDataList(PageData pd) {
        return departmentMapper.findDataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-18
     */
    public Department findDepartmentById(String id) {
        if (id == null || id.trim().length() == 0) {
            return null;
        }

        PageData findMap = new PageData();
        findMap.put("id", id.trim());

        List<Department> objectList = null;
        try {
            objectList = this.dataList(findMap);
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
    public List<Department> findDepartmentListByPid(String pid) {
        List<Department> objectList = new ArrayList<Department>();
        if (pid == null || pid.trim().length() == 0) {
            return objectList;
        }

        PageData findMap = new PageData();
        findMap.put("pid", pid.trim());
        try {
            objectList = this.dataList(findMap);
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
     * 3. (pid,code,name,layer) 不可同时为空
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
        PageData findMap = null;

        if (detp == null) {
            findMap = new PageData();
            findMap.put("pid", "root");
        } else if (detp != null) {
            //1. 参数非空判断
            if (detp.getPid() != null && detp.getPid().trim().length() > 0) {
                findMap = new PageData();
                findMap.put("id", detp.getPid().trim());
            } else if (detp.getId1() != null && detp.getId1().trim().length() > 0
                    && detp.getCode() != null && detp.getCode().trim().length() > 0
                    && detp.getLayer() != null
                    ) {
                findMap = new PageData();
                findMap.put("id1", detp.getId1().trim());
                findMap.put("code", detp.getCode().trim());
                findMap.put("layer", detp.getLayer());
            } else if (detp.getId1() != null && detp.getId1().trim().length() > 0
                    && detp.getName() != null && detp.getName().trim().length() > 0
                    && detp.getLayer() != null
                    ) {
                findMap = new PageData();
                findMap.put("id1", detp.getId1().trim());
                findMap.put("name", detp.getName().trim());
                findMap.put("layer", detp.getLayer());
            } else if (detp.getId1() != null && detp.getId1().trim().length() > 0
                    && detp.getCode() != null && detp.getCode().trim().length() > 0
                    && detp.getName() != null && detp.getName().trim().length() > 0
                    && detp.getLayer() != null
                    ) {
                findMap = new PageData();
                findMap.put("id1", detp.getId1().trim());
                findMap.put("code", detp.getCode().trim());
                findMap.put("name", detp.getName().trim());
                findMap.put("layer", detp.getLayer());
            }
        }

        if (findMap == null || findMap.size() == 0) {
            throw new RestException("", "参数错误:Department(pid,id_1,code,name,layer) 参数为空或空字符串，请与管理员联系！");
        }

        //2. 根据参数查询(vmes_department:系统部门表)--获得返回树结构根节点
        List<Department> objectList = this.dataList(findMap);
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



