package com.xy.vmes.deecoop.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.RoleButton;
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_role_button:角色按钮 Mapper.java
* 创建人：陈刚 自动创建
* 创建时间：2018-07-30
*/
@Mapper
@Repository
public interface RoleButtonMapper extends BaseMapper<RoleButton> {


	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-07-30
	*/
    @Select("datalistPage")
    List<RoleButton> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
	@Select("dataList")
	List<RoleButton> dataList(PageData pd);

	/**
	* 创建人：陈刚 自动创建，禁止修改
	* 创建时间：2018-07-30
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：陈刚 自动创建，禁止修改
    * 创建时间：2018-07-30
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
	/**
	 * 创建人：陈刚
	 * 创建时间：2018-07-31
	 */
	@Select("deleteRoleButtonByRoleId")
	void deleteRoleButtonByRoleId(String roleId);

	/**
	 * 创建人：陈刚
	 * 创建时间：2018-07-31
	 */
	@Select("updateDisableByRoleId")
	void updateDisableByRoleId(String roleId);
}


