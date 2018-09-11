package com.xy.vmes.deecoop.system.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.system.dao.MenuButtonMapper;
import com.xy.vmes.entity.MenuButton;
import com.xy.vmes.service.MenuButtonService;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.*;

import com.yvan.Conv;

/**
* 说明：vmes_menu_button:菜单按钮表 实现类
* 创建人：陈刚 自动创建
* 创建时间：2018-08-03
*/
@Service
@Transactional(readOnly = false)
public class MenuButtonServiceImp implements MenuButtonService {


    @Autowired
    private MenuButtonMapper menuButtonMapper;

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public void save(MenuButton menuButton) throws Exception{
        menuButton.setId(Conv.createUuid());
        menuButton.setCdate(new Date());
        menuButton.setUdate(new Date());
        menuButtonMapper.insert(menuButton);
    }


    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-08-03
     */
    @Override
    public void update(MenuButton menuButton) throws Exception{
        menuButton.setUdate(new Date());
        menuButtonMapper.updateById(menuButton);
    }

    /**
     * 创建人：陈刚 自动创建，禁止修改
     * 创建时间：2018-08-03
     */
    @Override
    public void updateAll(MenuButton menuButton) throws Exception{
        menuButton.setUdate(new Date());
        menuButtonMapper.updateAllColumnById(menuButton);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    //@Cacheable(cacheNames = "menuButton", key = "''+#id")
    public MenuButton selectById(String id) throws Exception{
        return menuButtonMapper.selectById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public void deleteById(String id) throws Exception{
        menuButtonMapper.deleteById(id);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        menuButtonMapper.deleteByIds(ids);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public List<MenuButton> dataListPage(PageData pd,Pagination pg) throws Exception{
        return menuButtonMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public List<MenuButton> dataList(PageData pd) throws Exception{
        return menuButtonMapper.dataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return menuButtonMapper.findColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return menuButtonMapper.findDataList(pd);
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        menuButtonMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public List<MenuButton> selectByColumnMap(Map columnMap) throws Exception{
    List<MenuButton> menuButtonList =  menuButtonMapper.selectByMap(columnMap);
        return menuButtonList;
    }


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return menuButtonMapper.getColumnList();
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return menuButtonMapper.getDataList(pd);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public List<Map> getDataListPage(PageData pd, Pagination pg) throws Exception{
        return menuButtonMapper.getDataListPage(pd, pg);
    }

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-08-03
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        menuButtonMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    public List<MenuButton> findMenuButtonList(PageData object) {
        List<MenuButton> objectList = new ArrayList<MenuButton>();
        if (object == null) {return objectList;}

        try {
            objectList = this.dataList(object);
        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }

        return objectList;
    }

    public List<MenuButton> findMenuButtonListByIds(String ids) {
        List<MenuButton> objectList = new ArrayList<MenuButton>();
        if (ids == null || ids.trim().length() == 0) {return objectList;}

        ids = StringUtil.stringTrimSpace(ids);
        ids = "'" + ids.replace(",", "','") + "'";
        String queryStr = "id in (" + ids + ") ";

        PageData findMap = new PageData();
        findMap.put("queryStr", queryStr);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        return this.findMenuButtonList(findMap);
    }
    /**
     * 根据ID-查询菜单按钮表(vmes_menu_button)
     * @param id
     * @return
     */
    public MenuButton findMenuButtonById(String id) {
        if (id == null || id.trim().length() == 0) {return null;}

        PageData findMap = new PageData();
        findMap.put("id", id);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<MenuButton> objectList = this.findMenuButtonList(findMap);
        if (objectList != null && objectList.size() > 0) {return objectList.get(0);}

        return null;
    }

    /**
     * 遍历List<MenuButton>-获取(修改禁用属性主键ID,物理删除主键ID)
     * 启用状态改为(禁用)-禁用执行物理删除
     * Map<String, String>
     *     "updateDisableIds"
     *     "deleteIds"
     *
     * @param objectList
     * @return
     */
    public Map<String, String> checkDeleteMenuButtonByList(List<MenuButton> objectList) {
        Map<String, String> mapObject = new HashMap<String, String>();
        if (objectList == null || objectList.size() == 0) {return mapObject;}

        StringBuffer updateIds = new StringBuffer();
        StringBuffer deleteIds = new StringBuffer();
        for (MenuButton object : objectList) {
            String id = object.getId();
            //是否禁用(0:已禁用 1:启用) 数据字典:sys_isdisable
            if ("1".equals(object.getIsdisable())) {
                updateIds.append(id);
                updateIds.append(",");
            } else {
                deleteIds.append(id);
                deleteIds.append(",");
            }
        }

        String strTemp_1 = updateIds.toString();
        //去掉最后一个','
        if (strTemp_1.lastIndexOf(",") != -1) {
            strTemp_1 = strTemp_1.substring(0, strTemp_1.lastIndexOf(","));
        }
        mapObject.put("updateDisableIds", strTemp_1);

        String strTemp_2 = deleteIds.toString();
        //去掉最后一个','
        if (strTemp_2.lastIndexOf(",") != -1) {
            strTemp_2 = strTemp_2.substring(0, strTemp_2.lastIndexOf(","));
        }
        mapObject.put("deleteIds", strTemp_2);

        return mapObject;
    }

    /**
     * 根据菜单ID-删除菜单按钮
     * 创建人：陈刚
     * 创建时间：2018-08-01
     */
    public void deleteMenuButtonByMenuId(String menuId) throws Exception {
        menuButtonMapper.deleteMenuButtonByMenuId(menuId);
    }

    /**
     * 修改禁用属性(isdisable)
     * 根据菜单ID-修改菜单按钮
     * 创建人：陈刚
     * 创建时间：2018-08-01
     */
    public void updateDisableByMenuId(String menuId) {
        menuButtonMapper.updateDisableByMenuId(menuId);
    }

    /**
     * 创建人：陈刚
     * 创建时间：2018-08-03
     * @param object
     * @return
     */
    public String checkColumnByAdd(MenuButton object) {
        if (object == null) {return new String();}

        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "按钮名称");
            msgBuf.append(str_isnull);
        }
        if (object.getNameEn() == null || object.getNameEn().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "按钮英文名称");

            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }
    /**
     * 创建人：陈刚
     * 创建时间：2018-08-03
     * @param object
     * @return
     */
    public String checkColumnByEdit(MenuButton object) {
        StringBuffer msgBuf = new StringBuffer();
        String column_isnull = "({0})输入为空或空字符串，({0})是必填字段不可为空！" + Common.SYS_ENDLINE_DEFAULT;

        if (object.getId() == null || object.getId().trim().length() == 0) {
            msgBuf.append("id为空或空字符串！");
            msgBuf.append(Common.SYS_ENDLINE_DEFAULT);
        }
        if (object.getName() == null || object.getName().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "按钮名称");
            msgBuf.append(str_isnull);
        }
        if (object.getNameEn() == null || object.getNameEn().trim().length() == 0) {
            String str_isnull = MessageFormat.format(column_isnull, "按钮英文名称");
            msgBuf.append(str_isnull);
        }

        return msgBuf.toString();
    }

    /**
     * 菜单ID-按钮名称是否相同
     *
     * @param menuId  (不可为空)
     * @param id      (允许为空)-(添加时is null, 修改时 is not null)
     * @param name    (不可为空)
     * @return
     *     true : 菜单名称存在名称相同
     *     false: 菜单名称不存在名称相同(默认值)
     */
    public boolean isExistByName(String menuId, String id, String name) {
        if (menuId == null || menuId.trim().length() == 0) {return false;}
        if (name == null || name.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("menuId", menuId);
        findMap.put("name", name);
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<MenuButton> objectList = this.findMenuButtonList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    /**
     * 菜单ID-按钮属性值是否相同
     *
     * @param menuId  (不可为空)
     * @param id      (允许为空)-(添加时is null, 修改时 is not null)
     * @param nameEn  (不可为空)-按钮英文名称
     * @return
     *     true : 菜单名称存在名称相同
     *     false: 菜单名称不存在名称相同(默认值)
     */
    public boolean isExistByNameEn(String menuId, String id, String nameEn) {
        if (menuId == null || menuId.trim().length() == 0) {return false;}
        if (nameEn == null || nameEn.trim().length() == 0) {return false;}

        PageData findMap = new PageData();
        findMap.put("menuId", menuId);
        findMap.put("nameEn", nameEn);
        if (id != null && id.trim().length() > 0) {
            findMap.put("id", id);
            findMap.put("isSelfExist", "true");
        }
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<MenuButton> objectList = this.findMenuButtonList(findMap);
        if (objectList != null && objectList.size() > 0) {return true;}

        return false;
    }

    public Integer findMaxSerialNumber(String menuId) {
        if (menuId == null || menuId.trim().length() == 0) {return Integer.valueOf(0);}

        PageData findMap = new PageData();
        findMap.put("menuId", menuId);
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<MenuButton> objectList = null;
        try {
            objectList = this.findMenuButtonList(findMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (objectList != null && objectList.size() > 0) {
            return Integer.valueOf(objectList.size());
        }

        return Integer.valueOf(0);
    }

    public MenuButton object2objectDB(MenuButton object, MenuButton objectDB) {
        if (objectDB == null) {objectDB = new MenuButton();}
        if (object == null) {return objectDB;}

        objectDB.setName(object.getName());
        objectDB.setCode(object.getCode());
        //serialNumber按钮顺序
        if (object.getSerialNumber() != null) {
            objectDB.setSerialNumber(object.getSerialNumber());
        }

        return objectDB;
    }
}



