package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.system.dao.PostMapper;
import com.xy.vmes.entity.Post;
import com.xy.vmes.service.PostService;
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
* 说明：vmes_post:岗位管理 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-08-01
*/
@Service
@Transactional(readOnly = false)
public class PostServiceImp implements PostService {


    @Autowired
    private PostMapper postMapper;

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void save(Post post) throws Exception{
        post.setId(Conv.createUuid());
        post.setCdate(new Date());
        post.setUdate(new Date());
        postMapper.insert(post);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void update(Post post) throws Exception{
        post.setUdate(new Date());
        postMapper.updateById(post);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    //@Cacheable(cacheNames = "post", key = "''+#id")
    public Post selectById(String id) throws Exception{
        return postMapper.selectById(id);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    @Override
    public void deleteById(String id) throws Exception{
        postMapper.deleteById(id);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        postMapper.deleteByIds(ids);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<Post> dataListPage(PageData pd,Pagination pg) throws Exception{
        return postMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<Post> dataList(PageData pd) throws Exception{
        return postMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return postMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return postMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        postMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-08-01
    */
    @Override
    public List<Post> selectByColumnMap(Map columnMap) throws Exception{
    List<Post> postList =  postMapper.selectByMap(columnMap);
        return postList;
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return postMapper.getColumnList();
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return postMapper.getDataList(pd);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return postMapper.getDataListPage(pd,pg);
    }

    /**
     * 创建人：刘威 自动创建，禁止修改
     * 创建时间：2018-08-01
     */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        postMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/


}



