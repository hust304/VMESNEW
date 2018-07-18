package ${classPath};

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.${objectName};
import com.yvan.PageData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：${TITLE} 接口类
* 创建人：自动生成
* 创建时间：${nowDate?string("yyyy-MM-dd")}
*/
public interface ${objectName}Service {


    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    void save(${objectName} ${objectNameLower}) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    void delete(${objectName} ${objectNameLower}) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    void update(${objectName} ${objectNameLower}) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    void deleteById(String id) throws Exception;
    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    ${objectName} selectById(String id) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    ${objectName} findById(PageData pd) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    List<${objectName}> dataListPage(PageData pd,Pagination pg) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    List<${objectName}> dataList(PageData pd) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    void deleteByIds(String[] ids) throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    List<LinkedHashMap> findColumnList() throws Exception;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    List<Map> findDataList(PageData pd) throws Exception;
}



