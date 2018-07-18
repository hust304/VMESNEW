package ${classPath};

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.${projectName}.dao.${objectName}Mapper;
import com.xy.vmes.entity.${objectName};
import com.xy.vmes.service.${objectName}Service;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：${TITLE} 实现类
* 创建人：自动创建
* 创建时间：${nowDate?string("yyyy-MM-dd")}
*/
@Service
@Transactional(readOnly = true)
public class ${objectName}ServiceImp implements ${objectName}Service {


    @Autowired
    private ${objectName}Mapper ${objectNameLower}Mapper;

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void save(${objectName} ${objectNameLower}) throws Exception{
        ${objectNameLower}Mapper.save(${objectNameLower});
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void delete(${objectName} ${objectNameLower}) throws Exception{
        ${objectNameLower}Mapper.delete(${objectNameLower});
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void update(${objectName} ${objectNameLower}) throws Exception{
        ${objectNameLower}Mapper.update(${objectNameLower});
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    @Cacheable(cacheNames = "${objectNameLower}", key = "''+#id")
    public ${objectName} selectById(String id) throws Exception{
        return ${objectNameLower}Mapper.selectById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void deleteById(String id) throws Exception{
        ${objectNameLower}Mapper.deleteById(id);
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public ${objectName} findById(PageData pd) throws Exception{
        return ${objectNameLower}Mapper.findById(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<${objectName}> dataListPage(PageData pd,Pagination pg) throws Exception{
        return ${objectNameLower}Mapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<${objectName}> dataList(PageData pd) throws Exception{
        return ${objectNameLower}Mapper.dataList(pd);
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        ${objectNameLower}Mapper.deleteByIds(ids);
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return ${objectNameLower}Mapper.findColumnList();
    }

    /**
    * 创建人：自动创建
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return ${objectNameLower}Mapper.findDataList(pd);
    }

}



