package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.TemplateMapper;
import com.xy.vmes.entity.Template;
import com.xy.vmes.service.TemplateService;
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
* 说明：vmes_template:标准开发模板 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-08-23
*/
@Service
@Transactional(readOnly = false)
public class TemplateServiceImp implements TemplateService {


    @Autowired
    private TemplateMapper templateMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public void save(Template template) throws Exception{
        template.setId(Conv.createUuid());
        template.setCdate(new Date());
        template.setUdate(new Date());
        templateMapper.insert(template);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public void update(Template template) throws Exception{
        template.setUdate(new Date());
        templateMapper.updateById(template);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    //@Cacheable(cacheNames = "template", key = "''+#id")
    public Template selectById(String id) throws Exception{
        return templateMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public void deleteById(String id) throws Exception{
        templateMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        templateMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public List<Template> dataListPage(PageData pd,Pagination pg) throws Exception{
        return templateMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public List<Template> dataList(PageData pd) throws Exception{
        return templateMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return templateMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return templateMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        templateMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public List<Template> selectByColumnMap(Map columnMap) throws Exception{
    List<Template> templateList =  templateMapper.selectByMap(columnMap);
        return templateList;
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return templateMapper.getColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return templateMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return templateMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-23
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        templateMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}



