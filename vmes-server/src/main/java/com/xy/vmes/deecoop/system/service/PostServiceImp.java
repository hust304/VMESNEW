package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.system.dao.PostMapper;
import com.xy.vmes.entity.CoderuleEntity;
import com.xy.vmes.entity.Post;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.PostService;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.yvan.Conv;

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
    @Autowired
    private CoderuleService coderuleService;

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

//    /**
//     * 生成岗位编码
//     *
//     * 创建人：刘威
//     * 创建时间：2018-07-26
//     *
//     * @param companyID  公司ID-组织架构ID
//     * @return
//     */
//    @Override
//    public String createCoder(String companyID) {
//        //(企业编号+前缀字符+日期字符+流水号)-(company+prefix+date+code)
//        //(无需+前缀字符+无需+流水号)-W000142
//        CoderuleEntity object = new CoderuleEntity();
//        //tableName 业务名称(表名)
//        object.setTableName("vmes_post");
//        //companyID 公司ID
//        object.setCompanyID(companyID);
//        //length 指定位数(5)
//        object.setLength(Common.CODE_RULE_LENGTH_DEFAULT);
//        //firstName 第一个编码名称
//        object.setFirstName("prefix");
//
//        //separator 分隔符
//        //object.setSeparator("-");
//        //filling 填充字符(0)
//        object.setFilling(Common.CODE_RULE_DEFAULT_FILLING);
//
//        //isNeedPrefix 是否需要前缀
//        object.setIsNeedPrefix(Boolean.TRUE);
//        object.setIsNeedDate(Boolean.TRUE);
//        object.setDateFormat("");
//        //prefix 前缀字符
//        object.setPrefix("P");
//
//        return coderuleService.findCoderule(object);
//    }

    public Post findPost(PageData object) {
        if (object == null) {return null;}

        List<Post> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        if (objectList != null && objectList.size() > 0) {
            return objectList.get(0);
        }

        return null;
    }
    public List<Post> findPostList(PageData object) {
        if (object == null) {return null;}

        List<Post> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    public List<Post> findPostListByDeptId(String deptId) {
        if (deptId == null || deptId.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("deptId", deptId);
        //是否禁用(1:已禁用 0:启用)
        findMap.put("isdisable", "0");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findPostList(findMap);
    }

}



