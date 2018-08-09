package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.LoginfoMapper;
import com.xy.vmes.entity.Loginfo;
import com.xy.vmes.service.LoginfoService;
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
* 说明：vmes_loginfo:系统日志表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-08-08
*/
@Service
@Transactional(readOnly = false)
public class LoginfoServiceImp implements LoginfoService {
    @Autowired
    private LoginfoMapper loginfoMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    @Override
    public void save(Loginfo loginfo) throws Exception{
        loginfo.setId(Conv.createUuid());
        loginfo.setCdate(new Date());
        loginfoMapper.insert(loginfo);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    @Override
    public List<Loginfo> dataList(PageData pd) throws Exception{
        return loginfoMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    @Override
    public List<LinkedHashMap<String, String>> getColumnList() throws Exception{
        return loginfoMapper.getColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-08
    */
    @Override
    public List<Map<String, Object>> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return loginfoMapper.getDataListPage(pd,pg);
    }

}



