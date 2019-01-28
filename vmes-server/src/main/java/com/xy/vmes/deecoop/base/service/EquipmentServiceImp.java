package com.xy.vmes.deecoop.base.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.base.dao.EquipmentMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Equipment;
import com.xy.vmes.service.CoderuleService;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.EquipmentService;
import com.xy.vmes.service.FileService;
import com.yvan.*;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
* 说明：操作日志 实现类
* 创建人：刘威 自动创建
* 创建时间：2018-09-20
*/
@Service
@Transactional(readOnly = false)
public class EquipmentServiceImp implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private ColumnService columnService;

    @Autowired
    private FileService fileService;

    @Autowired
    private CoderuleService coderuleService;
    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void save(Equipment equipment) throws Exception{
        equipment.setId(Conv.createUuid());
        equipment.setCdate(new Date());
        equipment.setUdate(new Date());
        equipmentMapper.insert(equipment);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void update(Equipment equipment) throws Exception{
        equipment.setUdate(new Date());
        equipmentMapper.updateById(equipment);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void updateAll(Equipment equipment) throws Exception{
        equipment.setUdate(new Date());
        equipmentMapper.updateAllColumnById(equipment);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    //@Cacheable(cacheNames = "equipment", key = "''+#id")
    public Equipment selectById(String id) throws Exception{
        return equipmentMapper.selectById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void deleteById(String id) throws Exception{
        equipmentMapper.deleteById(id);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void deleteByIds(String[] ids) throws Exception{
        equipmentMapper.deleteByIds(ids);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Equipment> dataListPage(PageData pd,Pagination pg) throws Exception{
        return equipmentMapper.dataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Equipment> dataList(PageData pd) throws Exception{
        return equipmentMapper.dataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<LinkedHashMap> findColumnList() throws Exception{
        return equipmentMapper.findColumnList();
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Map> findDataList(PageData pd) throws Exception{
        return equipmentMapper.findDataList(pd);
    }


    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void deleteByColumnMap(Map columnMap) throws Exception{
        equipmentMapper.deleteByMap(columnMap);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Equipment> selectByColumnMap(Map columnMap) throws Exception{
    List<Equipment> equipmentList =  equipmentMapper.selectByMap(columnMap);
        return equipmentList;
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Map> getDataList(PageData pd) throws Exception{
        return equipmentMapper.getDataList(pd);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public List<Map> getDataListPage(PageData pd,Pagination pg) throws Exception{
        return equipmentMapper.getDataListPage(pd,pg);
    }

    /**
    * 创建人：刘威 自动创建，禁止修改
    * 创建时间：2018-09-20
    */
    @Override
    public void updateToDisableByIds(String[] ids)throws Exception{
        equipmentMapper.updateToDisableByIds(ids);
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    @Override
    public ResultModel listPageEquipments(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        Map result = new HashMap();
        List<Column> columnList = columnService.findColumnList("Equipment");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if(columnList!=null&&columnList.size()>0){
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.getDataListPage(pd,pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        return model;
    }

    @Override
    public void exportExcelEquipments(PageData pd, Pagination pg) throws Exception {
        List<Column> columnList = columnService.findColumnList("Equipment");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        pg.setSize(100000);
        List<Map> dataList = this.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelEquipment";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
    }

    @Override
    public ResultModel importExcelEquipments(MultipartFile file) throws Exception {
        ResultModel model = new ResultModel();
        //HttpServletRequest Request = HttpUtils.currentRequest();

        if (file == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请上传Excel文件！");
            return model;
        }

        // 验证文件是否合法
        // 获取上传的文件名(文件名.后缀)
        String fileName = file.getOriginalFilename();
        if (fileName == null
                || !(fileName.matches("^.+\\.(?i)(xlsx)$")
                || fileName.matches("^.+\\.(?i)(xls)$"))
                ) {
            String failMesg = "不是excel格式文件,请重新选择！";
            model.putCode(Integer.valueOf(1));
            model.putMsg(failMesg);
            return model;
        }

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        return model;
    }

    @Override
    public ResultModel addEquipment(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Equipment equipment = (Equipment)HttpUtils.pageData2Entity(pd, new Equipment());
        String url = fileService.createQRCode("equipment", YvanUtil.toJson(equipment));
        if(StringUtils.isEmpty(pd.getString("currentCompanyId"))){
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户公司ID为空！");
            return model;
        }
        equipment.setCompanyId(pd.getString("currentCompanyId"));
        String code = coderuleService.createCoder(pd.getString("currentCompanyId"),"vmes_equipment","E");
        equipment.setCode(code);
        equipment.setQrcode(url);
        this.save(equipment);
        return model;
    }
}



