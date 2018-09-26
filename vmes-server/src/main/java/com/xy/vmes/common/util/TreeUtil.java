package com.xy.vmes.common.util;

import com.xy.vmes.entity.TreeEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TreeUtil {

    /**
     * 指定节点ID-及该指定节点ID下所有节点和子节点-生成树形结构
     * 当(指定节点ID)is null 或空字符串 -从根节点(root)开始生成树形结构
     *
     * @param nodeId     (允许为空)指定节点ID
     * @param objectList (业务数据List-全部有效业务数据)-(菜单,组织架构,字典)
     * @return
     */
    public static TreeEntity switchTree(String nodeId, List<TreeEntity> objectList) {
        if (objectList == null || objectList.size() == 0) {return new TreeEntity();}
        if (nodeId == null || nodeId.trim().length() == 0) {nodeId = new String("root");}

        //获得当前节点对象
        TreeEntity nodeObject = findNodeById(nodeId, objectList);
        createTree(nodeObject, objectList);

        return nodeObject;
    }

    public static List<TreeEntity> listSwitchTree(String nodeId, List<TreeEntity> objectList) {
        List<TreeEntity> treeList = new ArrayList<TreeEntity>();
        if (objectList == null || objectList.size() == 0) {return treeList;}
        if (nodeId == null || nodeId.trim().length() == 0) {nodeId = new String("root");}

        TreeEntity tree = switchTree(nodeId, objectList);
        if (tree != null && tree.getChildren() != null) {
            treeList = tree.getChildren();
        }

        return treeList;
    }

    /**
     * 本方法为递归调用:
     * @param nodeObject
     * @param objectList
     * @return
     */
    private static void createTree(TreeEntity nodeObject, List<TreeEntity> objectList) {
        //获得当前节点id下的所有孩子
        List<TreeEntity> childList = findChildListById(nodeObject.getId(), objectList);
        if(childList.size()>0){
            List<TreeEntity> childListNew = new ArrayList<TreeEntity>();
            for(int i = 0; i < childList.size(); i++){
                TreeEntity child = childList.get(i);
                createTree(child, objectList);
                childListNew.add(child);
            }
            nodeObject.setChildren(childListNew);
        }else{
            //nodeObject.setChildren(null);
            return;
        }
    }

    /**
     * 获得当前节点id下的所有孩子节点List
     * @param id
     * @return
     */
    private static List<TreeEntity> findChildListById(String id, List<TreeEntity> objectList) {
        List<TreeEntity> childList = new ArrayList<TreeEntity>();
        if (id == null || id.trim().length() == 0) {return childList;}

        for (TreeEntity nodeObj : objectList) {
            if (id.equals(nodeObj.getPid())) {
                childList.add(nodeObj);
            }
        }

        //按菜单排列顺序升序排列
        orderAcsTreeBySerialNumber(childList);

        return childList;
    }

    /**
     * 获得当前节点id对象
     * @param id
     * @return
     */
    private static TreeEntity findNodeById(String id, List<TreeEntity> objectList) {
        if (id == null || id.trim().length() == 0) {return null;}
        for (TreeEntity nodeObj : objectList) {
            if (id.equals(nodeObj.getId())) {
                return nodeObj;
            } else if ("root".equals(id) && id.equals(nodeObj.getPid())) {
                return nodeObj;
            }
        }
        return null;
    }

    private static void orderAcsTreeBySerialNumber(List<TreeEntity> objectList) {
        Collections.sort(objectList, new Comparator<Object>() {
            public int compare(Object arg0, Object arg1) {
                TreeEntity object_0 = (TreeEntity)arg0;
                TreeEntity object_1 = (TreeEntity)arg1;
                return object_0.getSerialNumber().compareTo(object_1.getSerialNumber());
            }
        });
    }

    private static void orderAcsTreeByLayer(List<TreeEntity> objectList) {
        Collections.sort(objectList, new Comparator<Object>() {
            public int compare(Object arg0, Object arg1) {
                TreeEntity object_0 = (TreeEntity)arg0;
                TreeEntity object_1 = (TreeEntity)arg1;
                return object_0.getLayer().compareTo(object_1.getLayer());
            }
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 遍历树形结构体List<TreeEntity>，获取树节点List<TreeEntity>
     *     nodeType:= "root" 获取所有根节点
     *     nodeType:= "leaf" 获取所有叶子节点
     *
     *
     * @param nodeType  节点类型(root leaf)
     * @param treeList  树形结构体
     * @return
     */
    public static List<TreeEntity> findNodeListByTreeList(String nodeType, List<TreeEntity> treeList, List<TreeEntity> nodeList) {
        if (nodeList == null) {nodeList = new ArrayList<TreeEntity>();}
        if (treeList == null) {return nodeList;}
        if (nodeType == null || nodeType.trim().length() == 0) {return nodeList;}

        if ("root".equals(nodeType)) {
            findRootNodeListByTreeList(treeList, nodeList);
        } else if ("leaf".equals(nodeType)) {
            findLeafNodeListByTreeList(treeList, nodeList);
        }

        //按菜单级别升序排列
        orderAcsTreeByLayer(nodeList);

        return nodeList;

    }

    /**
     * 获取所有根节点List
     * 本方法为递归调用:
     *
     * @param treeList   树形结构List
     * @param nodeList   返回值根节点List
     */
    private static void findRootNodeListByTreeList(List<TreeEntity> treeList, List<TreeEntity> nodeList) {
        for (TreeEntity treeNode : treeList) {
            //获取当前节点下所有孩子List
            List<TreeEntity> childList = treeNode.getChildren();
            if (childList != null && childList.size() > 0) {
                //获取当前节点-如果是根节点
                TreeEntity rootNode = treeNode.clone();
                rootNode.setChildren(null);
                nodeList.add(rootNode);

                findRootNodeListByTreeList(childList, nodeList);
            }
        }
    }

    /**
     * 获取所有叶子节点List
     * 本方法为递归调用:
     *
     * @param treeList   树形结构List
     * @param nodeList   返回值根节点List
     */
    private static void findLeafNodeListByTreeList(List<TreeEntity> treeList, List<TreeEntity> nodeList) {
        for (TreeEntity treeNode : treeList) {
            //获取当前节点下所有孩子List
            List<TreeEntity> childList = treeNode.getChildren();
            if (childList != null && childList.size() > 0) {
                findLeafNodeListByTreeList(childList, nodeList);
            } else {
                TreeEntity leafNode = treeNode.clone();
                nodeList.add(leafNode);
            }
        }
    }
}
