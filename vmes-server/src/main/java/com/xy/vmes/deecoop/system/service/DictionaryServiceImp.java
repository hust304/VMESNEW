package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.DictionaryMapper;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.DictionaryService;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import com.yvan.Conv;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        dictionary.setId(Conv.createUuid());
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



    /**
     * 创建人：刘威
     * 创建时间：2018-08-01
     */
    @Override
    public List<TreeEntity>  getTreeList(PageData pd)throws Exception{
        return  dictionaryMapper.getTreeList(pd);
    }
}



