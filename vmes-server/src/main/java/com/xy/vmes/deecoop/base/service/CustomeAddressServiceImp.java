package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.deecoop.base.dao.CustomeAddressMapper;
import com.xy.vmes.entity.CustomeAddress;
import com.xy.vmes.service.CustomeAddressService;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_customer_address 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-09-20
*/
@Service
@Transactional(readOnly = false)
public class CustomeAddressServiceImp implements CustomeAddressService {


    @Autowired
    private CustomeAddressMapper customeAddressMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void save(CustomeAddress customeAddress) throws Exception{
        customeAddress.setId(Conv.createUuid());
        customeAddress.setCdate(new Date());
        customeAddress.setUdate(new Date());
        customeAddressMapper.insert(customeAddress);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void update(CustomeAddress customeAddress) throws Exception{
        customeAddress.setUdate(new Date());
        customeAddressMapper.updateById(customeAddress);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void updateAll(CustomeAddress customeAddress) throws Exception{
        customeAddress.setUdate(new Date());
        customeAddressMapper.updateAllColumnById(customeAddress);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    //@Cacheable(cacheNames = "customeAddress", key = "''+#id")
    public CustomeAddress selectById(String id) throws Exception{
        return customeAddressMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void deleteById(String id) throws Exception{
        customeAddressMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        customeAddressMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<CustomeAddress> dataListPage(PageData pd,Pagination pg) throws Exception{
        return customeAddressMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<CustomeAddress> dataList(PageData pd) throws Exception{
        return customeAddressMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return customeAddressMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return customeAddressMapper.findDataList(pd);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        customeAddressMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<CustomeAddress> selectByColumnMap(Map columnMap) throws Exception {
    List<CustomeAddress> customeAddressList =  customeAddressMapper.selectByMap(columnMap);
        return customeAddressList;
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return customeAddressMapper.getColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return customeAddressMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        customeAddressMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 创建人：陈刚
     * 创建时间：2018-09-20
     * @param object
     * @return
     */
    public String checkColumnByAddEdit(CustomeAddress object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "联系姓名");
            msgBuf.append(str_isnull);
        }
        if (object.getMobile() == null || object.getMobile().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "手机号");
            msgBuf.append(str_isnull);
        }
        if (object.getAddress() == null || object.getAddress().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "详细地址");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    public CustomeAddress findCustomeAddress(PageData object) {
        if (object == null) {return null;}

        List<CustomeAddress> objectList = null;
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
    public CustomeAddress findCustomeAddressById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<CustomeAddress> objectList = this.findCustomeAddressList(findMap);
        if (objectList != null && objectList.size() > 0) {return objectList.get(0);}

        return null;
    }

    public List<CustomeAddress> findCustomeAddressList(PageData object) {
        if (object == null) {return null;}

        List<CustomeAddress> objectList = null;
        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }
    public List<CustomeAddress> findCustomeAddressListByCustId(String custId) {
        List<CustomeAddress> objectList = new ArrayList<CustomeAddress>();
        if (custId == null || custId.trim().length() == 0) {return objectList;}

        PageData findMap = new PageData();
        findMap.put("customerId", custId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        objectList = this.findCustomeAddressList(findMap);

        return objectList;
    }

    public void updateDefaultByCustId(PageData pageData) {
        customeAddressMapper.updateDefaultByCustId(pageData);
    }

    public void deleteCustAddrByCustId(String custId) throws Exception {
        if (custId == null || custId.trim().length() == 0) {return;}

        Map<String, Object> mapObject = new HashMap<String, Object>();
        mapObject.put("customer_id", custId);

        this.deleteByColumnMap(mapObject);
    }
}



