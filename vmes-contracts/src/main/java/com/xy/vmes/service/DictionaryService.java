package com.xy.vmes.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.entity.TreeEntity;
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：数据字典 接口类
* 创建人：刘威 自动生成
* 创建时间：2018-07-31
*/
public interface DictionaryService {


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    void save(Dictionary dictionary) throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    void update(Dictionary dictionary) throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    void updateAll(Dictionary dictionary) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    void deleteById(String id) throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-23
     */
    void deleteByIds(String[] ids) throws Exception;


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    Dictionary selectById(String id) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    List<Dictionary> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    List<Dictionary> dataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    List<Map> findDataList(PageData pd) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    void deleteByColumnMap(Map columnMap) throws Exception;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    List<Dictionary> selectByColumnMap(Map columnMap) throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    List<LinkedHashMap> getColumnList() throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    List<Map> getDataList(PageData pd) throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception;

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-07-31
     */
    void updateToDisableByIds(String[] ids)throws Exception;


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：刘威
     * 创建时间：2018-08-01
     */
    List<TreeEntity> getTreeList(PageData pd)throws Exception;

    Dictionary findDictionary(PageData object);
    Dictionary findDictionaryById(String id);

    List<Dictionary> findDictionaryList(PageData object);
    List<Dictionary> findDictionaryListByPid(String pid);

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
    boolean isExistByName(String pid, String id, String name);

    Dictionary id2DictionaryByLayer(String id, Integer layer, Dictionary objectDB);
    Dictionary paterObject2ObjectDB(Dictionary paterObject, Dictionary objectDB);
    Dictionary clearDictionaryByPath(Dictionary objectDB);
    Dictionary object2objectDB(Dictionary object, Dictionary objectDB);

    Integer findMaxSerialNumber(String pid);

    /**
     * check字典列表List<Dictionary>是否允许删除
     * 当前字典节点下是否含有子节点
     *
     * 创建人：陈刚
     * 创建时间：2018-08-06
     * @param ids
     * @return
     */
    String checkDeleteDictionaryByIds(String ids);
}



