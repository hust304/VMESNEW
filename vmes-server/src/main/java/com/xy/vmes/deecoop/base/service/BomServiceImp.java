package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.base.dao.BomMapper;
import com.xy.vmes.entity.Bom;
import com.xy.vmes.service.BomService;
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
* 说明：操作日志 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-09-29
*/
@Service
@Transactional(readOnly = false)
public class BomServiceImp implements BomService {


    @Autowired
    private BomMapper bomMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void save(Bom bom) throws Exception{
        bom.setId(Conv.createUuid());
        bom.setCdate(new Date());
        bom.setUdate(new Date());
        bomMapper.insert(bom);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void update(Bom bom) throws Exception{
        bom.setUdate(new Date());
        bomMapper.updateById(bom);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void updateAll(Bom bom) throws Exception{
        bom.setUdate(new Date());
        bomMapper.updateAllColumnById(bom);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    //@Cacheable(cacheNames = "bom", key = "''+#id")
    public Bom selectById(String id) throws Exception{
        return bomMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void deleteById(String id) throws Exception{
        bomMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        bomMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Bom> dataListPage(PageData pd,Pagination pg) throws Exception{
        return bomMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Bom> dataList(PageData pd) throws Exception{
        return bomMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return bomMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return bomMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        bomMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Bom> selectByColumnMap(Map columnMap) throws Exception{
    List<Bom> bomList =  bomMapper.selectByMap(columnMap);
        return bomList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return bomMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return bomMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return bomMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-29
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        bomMapper.updateToDisableByIds(ids);
    }



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


    @Override
    public void updateToNotDefaultByPorId(String prodId) throws Exception {
        bomMapper.updateToNotDefaultByPorId(prodId);
    }
}



