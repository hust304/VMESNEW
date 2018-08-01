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

import java.util.Date;
import com.yvan.Conv;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：${TITLE} 实现类
* 创建人：${author} 自动创建
* 创建时间：${nowDate?string("yyyy-MM-dd")}
*/
@Service
@Transactional(readOnly = false)
public class ${objectName}ServiceImp implements ${objectName}Service {


    @Autowired
    private ${objectName}Mapper ${objectNameLower}Mapper;

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void save(${objectName} ${objectNameLower}) throws Exception{
        ${objectNameLower}.setId(Conv.createUuid());
        ${objectNameLower}.setCdate(new Date());
        ${objectNameLower}.setUdate(new Date());
        ${objectNameLower}Mapper.insert(${objectNameLower});
    }


    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void update(${objectName} ${objectNameLower}) throws Exception{
        ${objectNameLower}.setUdate(new Date());
        ${objectNameLower}Mapper.updateById(${objectNameLower});
    }

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    //@Cacheable(cacheNames = "${objectNameLower}", key = "''+#id")
    public ${objectName} selectById(String id) throws Exception{
        return ${objectNameLower}Mapper.selectById(id);
    }

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void deleteById(String id) throws Exception{
        ${objectNameLower}Mapper.deleteById(id);
    }

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        ${objectNameLower}Mapper.deleteByIds(ids);
    }

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<${objectName}> dataListPage(PageData pd,Pagination pg) throws Exception{
        return ${objectNameLower}Mapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<${objectName}> dataList(PageData pd) throws Exception{
        return ${objectNameLower}Mapper.dataList(pd);
    }

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return ${objectNameLower}Mapper.findColumnList();
    }

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return ${objectNameLower}Mapper.findDataList(pd);
    }


    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        ${objectNameLower}Mapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：${author} 自动创建，禁止修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<${objectName}> selectByColumnMap(Map columnMap) throws Exception{
    List<${objectName}> ${objectNameLower}List =  ${objectNameLower}Mapper.selectByMap(columnMap);
        return ${objectNameLower}List;
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/

    /**
    * 创建人：${author} 自动创建，可以修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<LinkedHashMap> getColumnList() throws Exception{
        return ${objectNameLower}Mapper.getColumnList();
    }

    /**
    * 创建人：${author} 自动创建，可以修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return ${objectNameLower}Mapper.getDataList(pd);
    }

    /**
    * 创建人：${author} 自动创建，可以修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return ${objectNameLower}Mapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：${author} 自动创建，可以修改
    * 创建时间：${nowDate?string("yyyy-MM-dd")}
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        ${objectNameLower}Mapper.updateToDisableByIds(ids);
    }
}



