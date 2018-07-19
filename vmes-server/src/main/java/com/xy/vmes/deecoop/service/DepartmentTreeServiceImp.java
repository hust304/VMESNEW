package com.xy.vmes.deecoop.service;

import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.DepartmentService;
import com.xy.vmes.service.DepartmentTreeService;
import com.yvan.PageData;
import com.yvan.common.util.StringUtil;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前部门节点和该部门节点下所有子部门-的树形结构
 * 1. 查询(vmes_department:系统部门表)-查询次数(当前部门节点-最低层叶子部门节点)层数
 * 2. 每次递归查询pid-(通过','逗号分隔的字符串)-得到下一层部门节点List集合-存入对应的层的List结构体中
 * 3. 递归结束条件()
 *
 * 部门树结构生成
 * 创建人：陈刚
 * 创建时间：2018-07-19
 */
public class DepartmentTreeServiceImp implements DepartmentTreeService {

    @Autowired
    private DepartmentService departmentService;

    //最大部门级别-系统最大支持6层-部门级别[0-5](0:默认层)
    private Integer maxLayer;
    //递归计数器-递归执行次数
    private Integer count;
    //当前递归执行所在层
    private Integer execute_layer;

    private List<Department> list_0;
    private List<Department> list_1;
    private List<Department> list_2;
    private List<Department> list_3;
    private List<Department> list_4;
    private List<Department> list_5;

    /**
     * 初始化方法
     * 创建人：陈刚
     * 创建时间：2018-07-19
     */
    public void initialization() {
        this.maxLayer = Integer.valueOf(6);
        this.count = Integer.valueOf(0);
        this.execute_layer = Integer.valueOf(-1);

        list_0 = new ArrayList<Department>();
        list_1 = new ArrayList<Department>();
        list_2 = new ArrayList<Department>();
        list_3 = new ArrayList<Department>();
        list_4 = new ArrayList<Department>();
        list_5 = new ArrayList<Department>();
    }

    /**
     * 根据部门对象<Department>当前部门节点下面所有节点生成树形结构
     * 1. 该方法为递归调用
     * 2. 递归执行次数: count := 0 获取当前节点--
     * 3. 根据(pids)获取下一层<Department>List
     * 4. 递归结束条件(递归执行次数 > 6 or 查询无子节点)
     *
     * @param pids  (','分隔的字符串)
     * @return
     * @throws RestException
     *
     * 创建人：陈刚
     * 创建时间：2018-07-19
     *
     */
    public void findDeptTree(String pids) throws RestException {
        if (pids == null || pids.trim().length() == 0) {
            throw new RestException("", "参数错误:部门pid为空或空字符串！");
        }

        //1. count := 0 获取当前节点<Department>(vmes_department:系统部门表)对象
        if (count == 0) {
            try {
                Department deptObj = departmentService.findDepartmentById(pids);
                if (deptObj == null) {
                    return;
                }
                if (deptObj.getLayer() == null || deptObj.getLayer() == -1) {
                    throw new RestException("", "参数错误:部门id:" + pids + "部门级别为空或等于-1，请与管理员联系！");
                }

                //放入List结构体中
                List<Department> objectList = new ArrayList<Department>();
                objectList.add(deptObj);
                this.execute_layer = deptObj.getLayer();
                this.findLayerList(objectList, this.execute_layer);

                //执行次数+1
                this.count = Integer.valueOf(this.count.intValue() + 1);
            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }
        }

        //2. 根据pids获取下一层<Department>List
        pids = StringUtil.stringTrimSpace(pids);
        pids = "'" + pids.replace(",", "','") + ",";
        String pidQuery = "pid in (" + pids + ")";

        PageData findMap = new PageData();
        findMap.put("queryStr", pidQuery);
        List<Department> childList = null;
        try {
            childList = departmentService.dataList(findMap);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        //递归结束条件: 递归执行次数 > 6 or 查询无子节点
        if (count > 6 || childList == null || childList.size() == 0) {
            return;
        }

        //execute_layer递归执行所在层 +1
        this.execute_layer = Integer.valueOf(this.execute_layer.intValue() + 1);
        //子部门<Department>List-生成id字符串(','分隔的字符串)
        String chid_ids = departmentService.findDeptidByDeptList(childList);
        //递归调用: findDeptTree()
        this.findDeptTree(chid_ids);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-07-19
     */
    public TreeEntity dept2Tree(Department dept, TreeEntity tree) {
        if (tree == null) {tree = new TreeEntity();}
        if (dept == null) {return tree;}

        //id 当前节点ID
        if (dept.getId() != null && dept.getId().trim().length() > 0) {
            tree.setId(dept.getId().trim());
        }
        //text当前节点名称
        if (dept.getName() != null && dept.getName().trim().length() > 0) {
            tree.setText(dept.getName().trim());
        }
        //layer 当前节点-部门级别
        if (dept.getLayer() != null) {
            tree.setLayer(dept.getLayer());
        }

        //state 当前节点状态 'closed'
        //isChild 是否有孩子
        //iconCls 节点图标

        return tree;
    }


    public List<Department> getList_0() {
        return list_0;
    }

    public void setList_0(List<Department> list_0) {
        this.list_0 = list_0;
    }

    public List<Department> getList_1() {
        return list_1;
    }

    public void setList_1(List<Department> list_1) {
        this.list_1 = list_1;
    }

    public List<Department> getList_2() {
        return list_2;
    }

    public void setList_2(List<Department> list_2) {
        this.list_2 = list_2;
    }

    public List<Department> getList_3() {
        return list_3;
    }

    public void setList_3(List<Department> list_3) {
        this.list_3 = list_3;
    }

    public List<Department> getList_4() {
        return list_4;
    }

    public void setList_4(List<Department> list_4) {
        this.list_4 = list_4;
    }

    public List<Department> getList_5() {
        return list_5;
    }

    public void setList_5(List<Department> list_5) {
        this.list_5 = list_5;
    }

    ///////////////////////////////////////////////////////////////////////////
    private void findLayerList(List<Department> objectList, Integer execute_layer) {
        if (objectList == null || objectList.size() == 0) {return;}
        if (execute_layer == null || -1 == execute_layer.intValue()) {return;}

        if (0 == execute_layer.intValue()) {this.setList_0(objectList);}
        if (1 == execute_layer.intValue()) {this.setList_1(objectList);}
        if (2 == execute_layer.intValue()) {this.setList_2(objectList);}
        if (3 == execute_layer.intValue()) {this.setList_3(objectList);}
        if (4 == execute_layer.intValue()) {this.setList_4(objectList);}
        if (5 == execute_layer.intValue()) {this.setList_5(objectList);}
    }
}
