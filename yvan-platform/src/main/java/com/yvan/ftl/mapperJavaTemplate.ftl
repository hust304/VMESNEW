package ${classPath};

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.${objectName};
import com.yvan.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：${TITLE} Mapper.java
* 创建人：${author} 自动创建
* 创建时间：${nowDate?string("yyyy-MM-dd")}
*/
@Mapper
@Repository
public interface ${objectName}Mapper extends BaseMapper<${objectName}> {


	/**
	* 创建人：${author} 自动创建，禁止修改
	* 创建时间：${nowDate?string("yyyy-MM-dd")}
	*/
    @Select("datalistPage")
    List<${objectName}> dataListPage(PageData pd,Pagination pg);

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
	@Select("dataList")
	List<${objectName}> dataList(PageData pd);

	/**
	* 创建人：${author} 自动创建，禁止修改
	* 创建时间：${nowDate?string("yyyy-MM-dd")}
	*/
	@Delete("deleteByIds")
	void deleteByIds(String[] ids);

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Select("findColumnList")
    List<LinkedHashMap> findColumnList();


    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Select("findDataList")
    List<Map> findDataList(PageData pd);



    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
    * 创建人：${author} 自动创建，可以修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Select("getColumnList")
    List<LinkedHashMap> getColumnList();


    /**
    * 创建人：${author} 自动创建，可以修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Select("getDataList")
    List<Map> getDataList(PageData pd);


    /**
    * 创建人：${author} 自动创建，可以修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Select("updateToDisableByIds")
    void updateToDisableByIds(String[] ids);
}


