package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.system.dao.DictionaryMapper;
import com.xy.vmes.entity.Department;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.entity.Post;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.DictionaryService;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：数据字典 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-07-31
*/
@Service
@Transactional(readOnly = false)
public class DictionaryServiceImp implements DictionaryService {


    @Autowired
    private DictionaryMapper dictionaryMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void save(Dictionary dictionary) throws Exception{
        dictionary.setCdate(new Date());
        dictionary.setUdate(new Date());
        dictionaryMapper.insert(dictionary);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void update(Dictionary dictionary) throws Exception{
        dictionary.setUdate(new Date());
        dictionaryMapper.updateById(dictionary);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    @Override
    public void updateAll(Dictionary dictionary) throws Exception{
        dictionary.setUdate(new Date());
        dictionaryMapper.updateAllColumnById(dictionary);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    //@Cacheable(cacheNames = "dictionary", key = "''+#id")
    public Dictionary selectById(String id) throws Exception{
        return dictionaryMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void deleteById(String id) throws Exception{
        dictionaryMapper.deleteById(id);
    }
    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-23
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        dictionaryMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Dictionary> dataListPage(PageData pd,Pagination pg) throws Exception{
        return dictionaryMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Dictionary> dataList(PageData pd) throws Exception{
        return dictionaryMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return dictionaryMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return dictionaryMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        dictionaryMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Dictionary> selectByColumnMap(Map columnMap) throws Exception{
    List<Dictionary> dictionaryList =  dictionaryMapper.selectByMap(columnMap);
        return dictionaryList;
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return dictionaryMapper.getColumnList();
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return dictionaryMapper.getDataList(pd);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return dictionaryMapper.getDataListPage(pd,pg);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        dictionaryMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    private Map<String, String> keyNameMap;
    private Map<String, String> nameKeyMap;

    public Map<String, String> getKeyNameMap() {
        return keyNameMap;
    }
    public Map<String, String> getNameKeyMap() {
        return nameKeyMap;
    }

    public void createBusinessMap() {
        this.keyNameMap = new HashMap<String, String>();
        this.nameKeyMap = new HashMap<String, String>();
    }
    public void implementBusinessMapByParentID(String parentId, String companyId) {
        this.createBusinessMap();

        PageData findMap = new PageData();
        if (parentId != null && parentId.trim().length() > 0) {
            findMap.put("pid", parentId.trim());
        }
        if (companyId != null && companyId.trim().length() > 0) {
            findMap.put("currentCompanyId", companyId.trim());
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Dictionary> objectList = this.findDictionaryList(findMap);
        if (objectList == null || objectList.size() == 0) {return;}

        for (Dictionary object : objectList) {
            String mapKey = object.getId();
            String mapName = object.getName();
            if (mapName != null && mapName.trim().length() > 0) {
                this.keyNameMap.put(mapKey, mapName);
                this.nameKeyMap.put(mapName, mapKey);
            }
        }
    }

    /**
     * 创建人：刘威
     * 创建时间：2018-08-01
     */
    @Override
    public List<TreeEntity>  getTreeList(PageData pd)throws Exception{
        return  dictionaryMapper.getTreeList(pd);
    }

    public Dictionary findDictionary(PageData object) {
        if (object == null) {return null;}

        List<Dictionary> objectList = this.findDictionaryList(object);
        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public Dictionary findDictionaryById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findDictionary(findMap);
    }

    public List<Dictionary> findDictionaryList(PageData object) {
        if (object == null) {return null;}

        List<Dictionary> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    public List<Dictionary> findDictionaryListByPid(String pid) {
        List<Dictionary> objectList = new ArrayList<Dictionary>();
        if (pid == null || pid.trim().length() == 0) {return objectList;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        //是否禁用(0:已禁用 1:启用) 数据字典:sys_isdisable
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findDictionaryList(findMap);
    }

    /**
     * 字典名称同一层级是否相同
     *
     * @param pid   (不可为空)
     * @param id    (允许为空)-(添加时is null, 修改时 is not null)
     * @param name  (不可为空)
     * @return
     *     true : 组织名称存在名称相同
     *     false: 组织名称不存在名称相同(默认值)
     */
    public boolean isExistByName(String pid, String id, String name, String currentCompanyId) {
        if (pid == null || pid.trim().length() == 0) {return false;}
        if (name == null || name.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        findMap.put("name", name);
        findMap.put("currentCompanyId",currentCompanyId);
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Dictionary> objectList = this.findDictionaryList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    public Dictionary id2DictionaryByLayer(String id, Integer layer, Dictionary objectDB) {
        if (objectDB == null) {objectDB = new Dictionary();}
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

    public Dictionary paterObject2ObjectDB(Dictionary paterObject, Dictionary objectDB) {
        if (objectDB == null) {objectDB = new Dictionary();}
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
    public Dictionary clearDictionaryByPath(Dictionary objectDB) {
        if (objectDB == null) {objectDB = new Dictionary();}

        objectDB.setId0(null);
        objectDB.setId1(null);
        objectDB.setId2(null);
        objectDB.setId3(null);
        objectDB.setId4(null);
        objectDB.setId5(null);
        objectDB.setLayer(null);

        return objectDB;
    }

    public Dictionary object2objectDB(Dictionary object, Dictionary objectDB) {
        if (objectDB == null) {objectDB = new Dictionary();}
        if (object == null) {return objectDB;}

        objectDB.setPid(object.getPid());
        objectDB.setName(object.getName());
        objectDB.setRemark(object.getRemark());
        objectDB.setIsdisable(object.getIsdisable());
        if (object.getSerialNumber() != null) {
            objectDB.setSerialNumber(object.getSerialNumber());
        }
        return objectDB;
    }

    public Integer findMaxSerialNumber(String pid) {
        if (pid == null || pid.trim().length() == 0) {return Integer.valueOf(0);}

        PageData findMap = new PageData();
        findMap.put("pid", pid);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Dictionary> objectList = this.findDictionaryList(findMap);
        if (objectList != null && objectList.size() > 0) {
            return Integer.valueOf(objectList.size());
        }

        return Integer.valueOf(0);
    }

    /**
     * check字典列表List<Dictionary>是否允许删除
     * 当前字典节点下是否含有子节点
     *
     * 创建人：陈刚
     * 创建时间：2018-08-06
     * @param ids
     * @return
     */
    public String checkDeleteDictionaryByIds(String ids) {
        if (ids == null || ids.trim().length() == 0) {return new String();}

        String msgTemp_1 = "第 {0} 行: 存在子节点不可禁用！" + Common.SYS_ENDLINE_DEFAULT;

        StringBuffer msgBuf = new StringBuffer();
        String[] id_arry = ids.split(",");
        for (int i = 0; i < id_arry.length; i++) {
            String id = id_arry[i];
            List<Dictionary> childList = this.findDictionaryListByPid(id);
            //1. 查询当前字典节点下是否含有子节点
            if (childList != null && childList.size() > 0) {
                String msg_Str = MessageFormat.format(msgTemp_1, (i+1));
                msgBuf.append(msg_Str);
            }

        }

        return  msgBuf.toString();
    }
}



