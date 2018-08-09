package com.xy.vmes.service;

import com.xy.vmes.entity.TreeEntity;

import java.util.List;

public interface TreeService {
    /**
     * 指定节点ID-及该指定节点ID下所有节点和子节点-生成树形结构
     * 当(指定节点ID)is null 或空字符串 -从根节点(root)开始生成树形结构
     *
     * @param id          (允许为空)指定节点ID
     * @param objectList  (业务数据List-全部有效业务数据)-(菜单,组织架构,字典)
     * @return
     */
    TreeEntity findTree(String id, List<TreeEntity> objectList);
}
