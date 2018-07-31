package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.MenuMapper;
import com.xy.vmes.entity.Menu;
import com.xy.vmes.service.MenuService;
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
* 说明：vmes_menu:系统功能菜单 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-07-31
*/
@Service
@Transactional(readOnly = false)
public class MenuServiceImp implements MenuService {


    @Autowired
    private MenuMapper menuMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void save(Menu menu) throws Exception{
        menu.setId(Conv.createUuid());
        menu.setCdate(new Date());
        menu.setUdate(new Date());
        menuMapper.insert(menu);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void update(Menu menu) throws Exception{
        menu.setUdate(new Date());
        menuMapper.updateById(menu);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    //@Cacheable(cacheNames = "menu", key = "''+#id")
    public Menu selectById(String id) throws Exception{
        return menuMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public void deleteById(String id) throws Exception{
        menuMapper.deleteById(id);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Menu> dataListPage(PageData pd,Pagination pg) throws Exception{
        return menuMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Menu> dataList(PageData pd) throws Exception{
        return menuMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return menuMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-31
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return menuMapper.findDataList(pd);
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
}



