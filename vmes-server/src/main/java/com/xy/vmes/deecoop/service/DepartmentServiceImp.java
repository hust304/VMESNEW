package com.xy.vmes.deecoop.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.dao.DepartmentMapper;
import com.xy.vmes.entity.Department;
import com.xy.vmes.service.DepartmentService;
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

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void save(Department department) throws Exception{
        departmentMapper.save(department);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void delete(Department department) throws Exception{
        departmentMapper.delete(department);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void update(Department department) throws Exception{
        departmentMapper.update(department);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    @Cacheable(cacheNames = "department", key = "''+#id")
    public Department selectById(String id) throws Exception{
        return departmentMapper.selectById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void deleteById(String id) throws Exception{
        departmentMapper.deleteById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public Department findById(PageData pd) throws Exception{
        return departmentMapper.findById(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public List<Department> dataListPage(PageData pd,Pagination pg) throws Exception{
        return departmentMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public List<Department> dataList(PageData pd) throws Exception{
        return departmentMapper.dataList(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        departmentMapper.deleteByIds(ids);
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return departmentMapper.findColumnList();
    }

    /**
    * 创建人：自动创建
    * 创建时间：2018-07-18
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return departmentMapper.findDataList(pd);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-18
     *
     */
    public Department findDepartmentById(String id) throws RestException {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id.trim());

        List<Department> objectList = null;
        try {
            objectList = this.dataList(findMap);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        if (objectList != null && objectList.size() > 0) {return objectList.get(0);}

        return null;
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-18
     *
     */
    public List<Department> findDepartmentListByPid(String pid) throws RestException {
        List<Department> objectList = new ArrayList<Department>();
        if (pid == null || pid.trim().length() == 0) {return objectList;}

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
     *    (允许为空)Department.pid   上级部门id
     *    (允许为空)Department.code  上级部门编码
     *    (允许为空)Department.name  上级部门名称
     *    (允许为空)Department.layer 上级部门级别
     * 3. (pid,code,name,layer) 不可同时为空
     *     pid is not null pid对应的部门+pid下面所有子部门
     *     pid is null (code,layer) is not null or (name,layer) is not null
     *
     *
     *
     * 创建人：陈刚
     * 创建时间：2018-07-18
     * @param object  允许为空-<Department>对象(vmes_department:系统部门表)
     * @return
     */
    public Tree<Department> findTree(Department object) throws RestException {
        PageData findMap = null;

//        //1. 参数非空判断
//        if (object.getPid() != null && object.getPid().trim().length() > 0) {
//            findMap = new PageData();
//            findMap.put("pid", object.getPid().trim());
//        } else if (object.getCode() != null && object.getCode().trim().length() > 0 && object.getLayer() != null) {
//            findMap = new PageData();
//            findMap.put("code", object.getCode().trim());
//            findMap.put("layer", object.getLayer());
//        } else if (object.getName() != null && object.getName().trim().length() > 0 && object.getLayer() != null) {
//            findMap = new PageData();
//            findMap.put("name", object.getName().trim());
//            findMap.put("layer", object.getLayer());
//        } else if (object.getCode() != null && object.getCode().trim().length() > 0
//            && object.getName() != null && object.getName().trim().length() > 0
//            && object.getLayer() != null
//        ) {
//            findMap = new PageData();
//            findMap.put("code", object.getCode().trim());
//            findMap.put("name", object.getName().trim());
//            findMap.put("layer", object.getLayer());
//        }
//
//        if (findMap == null || findMap.size() == 0) {
//            String msgStr = "参数错误:Department(pid,code,name,layer) 参数为空或空字符串，请与管理员联系！";
//            throw RestException("", msgStr);
//        }
//
//        //2. 根据参数查询(vmes_department:系统部门表)--获得返回树结构根节点
//        List<Department> objectList = this.dataList(findMap);
//        if (objectList == null || objectList.size() == 0) {
//            String msgStr = "参数错误:Department(pid,code,name,layer) 查询无数据，请与管理员联系！";
//            throw RestException("", msgStr);
//        }
//        Department root_obj = objectList.get(0);



        return null;
    }


}



