package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Menu;
import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.cache.RedisClient;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：vmes_menu:系统功能菜单Controller
* @author 陈刚 自动生成
* @date 2018-08-01
*/
@RestController
@Slf4j
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private MenuButtonService menuButtonService;
    @Autowired
    private MenuTreeService menuTreeService;
    @Autowired
    private ColumnService columnService;
    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @GetMapping("/menu/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################menu/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Menu menu = menuService.selectById(id);
        model.putResult(menu);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @PostMapping("/menu/save")
    public ResultModel save()  throws Exception {

        logger.info("################menu/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Menu menu = (Menu)HttpUtils.pageData2Entity(pd, new Menu());
        menuService.save(menu);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @PostMapping("/menu/update")
    public ResultModel update()  throws Exception {

        logger.info("################menu/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Menu menu = (Menu)HttpUtils.pageData2Entity(pd, new Menu());
        menuService.update(menu);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @GetMapping("/menu/deleteById/{id}")
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################menu/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        menuService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @PostMapping("/menu/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################menu/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Menu> menuList = menuService.dataListPage(pd,pg);
        model.putResult(menuList);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @PostMapping("/menu/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################menu/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Menu> menuList = menuService.dataList(pd);
        model.putResult(menuList);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 陈刚 自动创建，禁止修改
    * @date 2018-08-01
    */
    @GetMapping("/menu/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################menu/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = menuService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                //List<Map> varList = menuService.findDataList(pd);
                    //request.setAttribute("varList", varList);
                }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    @Autowired
    RedisClient redisClient;

    /**
     * 菜单列表分页
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/listPageMenus")
    public ResultModel listPageMenus() throws Exception {
        logger.info("################menu/listPageMenus 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        Map<String, Object> mapObj = new HashMap<String, Object>();

        //1. 查询遍历List列表
        List<Column> columnList = columnService.findColumnList("menu");
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
        mapObj.put("hideTitles", titlesHideList);
        mapObj.put("titles", YvanUtil.toJson(titlesList));

        //2. 分页查询数据List
        List<Map<String, String>> varMapList = new ArrayList<Map<String, String>>();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varList = menuService.getDataListPage(pd, pg);
        if(varList != null && varList.size() > 0) {
            for (Map<String, Object> map : varList) {
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMapList.add(varMap);
            }
        }
        mapObj.put("varList", YvanUtil.toJson(varMapList));
        mapObj.put("pageData", YvanUtil.toJson(pg));

        model.putResult(mapObj);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/listPageMenus 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * Excel导出功能：
     * 1. 勾选指定行导出-(','逗号分隔的id字符串)
     * 2. 按查询条件导出(默认查询方式)
     * 参数说明:
     *   ids          : 业务id字符串-(','分隔的字符串)
     *   queryColumn  : 查询字段(sql where 子句)
     *   showFieldcode: 导出Excel字段Code-显示顺序按照字符串排列顺序-(','分隔的字符串)

     * 注意: 参数(ids,queryColumn)这两个参数是互斥的，(有且有一个参数不为空)
     *
     * @throws Exception
     */
    @GetMapping("/menu/exportExcelMenus")
    public void exportExcelMenus() throws Exception {
        logger.info("################menu/exportExcelMenus 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        //1. 获取Excel导出数据查询条件
        PageData pd = HttpUtils.parsePageData();
        String ids = pd.getString("ids");
        String queryColumn = pd.getString("queryColumn");
        List<Column> columnList = columnService.findColumnList("menu");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //3. 根据查询条件获取业务数据List
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        if (queryColumn != null && queryColumn.trim().length() > 0) {
            queryStr = queryStr + queryColumn;
        }

        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        //分页参数默认设置100000
        pg.setSize(100000);

        List<Map> dataList = menuService.getDataListPage(pd,pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response  = HttpUtils.currentResponse();


        //查询数据-Excel文件导出
        //String fileName = "Excel数据字典数据导出";
        String fileName = "ExcelMenu";
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/exportExcelMenus 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");

    }

    /**
     * 新增菜单
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/addMenu")
    public ResultModel addMenu() throws Exception {
        logger.info("################menu/addMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");
            return model;
        }

        Menu menuObj = (Menu)HttpUtils.pageData2Entity(pageData, new Menu());
        if (menuObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 菜单对象Menu 异常！");
            return model;
        }

        String msgStr = menuService.checkColumnByAdd(menuObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Menu>
        String pid = "root";
        if (menuObj.getPid() != null && menuObj.getPid().trim().length() > 0) {
            pid = menuObj.getPid().trim();
        }

        Menu paterObj = null;
        if ("root".equals(pid)) {
            List<Menu> objList = menuService.findMenuListByPid(pid);
            if (objList != null && objList.size() > 0) {paterObj = objList.get(0);}
        } else {
            paterObj = menuService.findMenuById(pid);
        }

        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(pid:"+ menuObj.getPid() + ")系统中无数据，请与管理员联系！");
            return model;
        }

        //2. (菜单名称)在同一层名称不可重复
        if (menuService.isExistByName(menuObj.getPid(), null, menuObj.getName())) {
            String msgTemp = "上级菜单名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "菜单名称: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            String str_isnull = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    menuObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(str_isnull);
            return model;
        }

        //3. 添加菜单
        String id = Conv.createUuid();
        menuObj.setId(id);
        menuObj = menuService.id2MenuByLayer(id,
                Integer.valueOf(paterObj.getLayer().intValue() + 1),
                menuObj);
        menuObj = menuService.paterObject2ObjectDB(paterObj, menuObj);

        //获取菜单编码
        //String code = menuService.createCoder("1");
        //menuObj.setCode(code);

        //设定上级节点ID
        menuObj.setPid(paterObj.getId());

        //设置菜单级别
        menuObj.setLayer(Integer.valueOf(paterObj.getLayer().intValue() + 1));
        //设置菜单默认显示顺序
        if (menuObj.getSerialNumber() == null) {
            Integer maxCount = menuService.findMaxSerialNumberByPid(menuObj.getPid());
            menuObj.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }

        menuService.save(menuObj);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/addMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改菜单
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/updateMenu")
    public ResultModel updateMenu() throws Exception {
        logger.info("################menu/updateMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");

            return model;
        }

        Menu menuObj = (Menu)HttpUtils.pageData2Entity(pageData, new Menu());
        if (menuObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：Map 转 菜单对象Menu 异常！");

            return model;
        }

        String msgStr = menuService.checkColumnByEdit(menuObj);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //pid 获取父节点对象<Menu>
        String pid = "root";
        if (menuObj.getPid() != null && menuObj.getPid().trim().length() > 0) {
            pid = menuObj.getPid().trim();
        }

        Menu paterObj = null;
        if ("root".equals(pid)) {
            List<Menu> objList = menuService.findMenuListByPid(pid);
            if (objList != null && objList.size() > 0) {paterObj = objList.get(0);}
        } else {
            paterObj = menuService.findMenuById(pid);
        }
        if (paterObj == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("(pid:"+ menuObj.getPid() + ")系统中无数据，请与管理员联系！");

            return model;
        }

        //2. (菜单名称)在同一层名称不可重复
        if (menuService.isExistByName(menuObj.getPid(), menuObj.getId(), menuObj.getName())) {
            String msgTemp = "上级菜单名称: {0}" + Common.SYS_ENDLINE_DEFAULT +
                    "菜单名称: {1}" + Common.SYS_ENDLINE_DEFAULT +
                    "在系统中已经重复！" + Common.SYS_ENDLINE_DEFAULT;
            msgTemp = MessageFormat.format(msgTemp,
                    paterObj.getName(),
                    menuObj.getName());
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgTemp);
            return model;
        }

        //3. 修改菜单属性值
        Menu menuDB = menuService.findMenuById(menuObj.getId());
        menuDB = menuService.object2objectDB(menuObj, menuDB);
        menuDB = menuService.clearMenuByPath(menuDB);
        menuDB = menuService.id2MenuByLayer(menuDB.getId(),
                Integer.valueOf(paterObj.getLayer().intValue() + 1),
                menuDB);
        menuDB = menuService.paterObject2ObjectDB(paterObj, menuDB);

        //设定上级节点ID
        menuDB.setPid(paterObj.getId());
        //设置菜单级别
        menuDB.setLayer(Integer.valueOf(paterObj.getLayer().intValue() + 1));
        //设置菜单默认显示顺序
        if (menuObj.getSerialNumber() == null) {
            Integer maxCount = menuService.findMaxSerialNumberByPid(menuObj.getPid());
            menuObj.setSerialNumber(Integer.valueOf(maxCount.intValue() + 1));
        }
        menuService.update(menuDB);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/updateMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**修改菜单(禁用)状态
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/updateDisableMenu")
    public ResultModel updateDisableMenu() throws Exception {
        logger.info("################menu/updateDisableMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");

            return model;
        }

        String id = (String)pageData.get("id");
        String isdisable = (String)pageData.get("isdisable");

        String msgStr = new String();
        if (id == null || id.trim().length() == 0) {
            msgStr = msgStr + "id为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (isdisable == null || isdisable.trim().length() == 0) {
            msgStr = msgStr + "isdisable为空或空字符串！" + Common.SYS_ENDLINE_DEFAULT;
        }
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //2. 当前菜单ID(菜单按钮)中是否使用中
        msgStr = menuService.checkDeleteMenuByIds(id);
        if (msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        //3. 修改菜单(禁用)状态
        Menu objectDB = menuService.findMenuById(id);
        objectDB.setIsdisable(isdisable);
        objectDB.setUdate(new Date());
        menuService.update(objectDB);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/updateDisableMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**删除菜单
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/deleteMenus")
    public ResultModel deleteMenus() throws Exception {
        logger.info("################menu/deleteMenus 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //1. 非空判断
        if (pageData == null || pageData.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：用户登录参数(pageData)为空！");

            return model;
        }

        String ids = (String)pageData.get("ids");
        if (ids == null || ids.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("参数错误：请至少选择一行数据！");

            return model;
        }

        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");

//        //2. 当前菜单ID(菜单按钮)中是否使用中
//        String msgStr = menuService.checkDeleteMenuByIds(id_str);
//        if (msgStr.trim().length() > 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg(msgStr);
//            return model;
//        }

        for (int i = 0; i < id_arry.length; i++) {
            String menuId = id_arry[i];
            try {
                //1. 删除(vmes_menu_button)菜单按钮表
                menuButtonService.deleteMenuButtonByMenuId(menuId);

                //2. 删除(vmes_role_menu)角色菜单表
                roleMenuService.deleteRoleMenuByMenuId(menuId);
            } catch (Exception e) {
                throw new RestException("", e.getMessage());
            }
        }

        //3. 删除(vmes_menu)菜单表
        menuService.deleteByIds(id_arry);

        Long endTime = System.currentTimeMillis();
        logger.info("################menu/deleteMenus 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**
//     * 菜单Excel导出
//     *
//     * @author 陈刚
//     * @date 2018-08-01
//     */
//    @PostMapping("/menu/exportExcelMenus")
//    public ResultModel exportExcelMenus() throws Exception {
//        logger.info("################menu/exportExcelMenus 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        try {
//        } catch (Exception e) {
//            throw new RestException("", e.getMessage());
//        }
//        Long endTime = System.currentTimeMillis();
//        logger.info("################menu/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /**
     * 菜单Excel导入
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    @PostMapping("/menu/importExcelMenus")
    public ResultModel importExcelMenus(@RequestParam(value="excelFile") MultipartFile file) {
        logger.info("################menu/importExcelMenus 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        //HttpServletRequest Request = HttpUtils.currentRequest();

        try {
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

        } catch (Exception e) {
            throw new RestException("", e.getMessage());
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/importExcelMenus 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 菜单树
     * 1. 从Redis缓存中获取-当前用户(角色ID)-','逗号分隔的字符串
     * 2. (角色ID字符串)-获取菜单List<Meun>
     *
     * @author 陈刚
     * @date 2018-08-01
     */
    //@GetMapping("/menu/treeMeuns")
    @PostMapping("/menu/treeMeuns")
    public ResultModel treeMeuns() {
        logger.info("################menu/treeMeuns 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

//            String userRole = "";
//            try {
//                //String sessionID = "c0d5f53e95a848899f93810732c80004:0:deecoop:userLoginMap";  //测试代码-真实环境无此代码
//                String sessionID = (String)pageData.get("sessionID");
//                System.out.println("treeMeuns()-sessionID: " + sessionID);
//                userRole = RedisUtils.getUserRoleInfoBySessionID(redisClient, sessionID);
//            } catch (Exception e) {
//                throw new RestException("", e.getMessage());
//            }
//            if (userRole == null || userRole.trim().length() == 0) {
//                model.putCode(Integer.valueOf(1));
//                model.putMsg("当前用户无配置角色(用户角色)，请于管理员联系！");
//                return model;
//            }


        //1. 获取当前登录用户所有角色ID
        // 用户角色(当前用户)-(角色ID','分隔的字符串)
        PageData pageData = HttpUtils.parsePageData();
        String roleIds = (String)pageData.get("roleIds");

        String userRole = "";
        String userType = (String)pageData.get("userType");
        //(userType_admin:超级管理员 userType_company:企业管理员 userType_employee:普通用户 userType_outer:外部用户)
        if (!Common.DICTIONARY_MAP.get("userType_admin").equals(userType) && roleIds != null && roleIds.trim().length() > 0) {
            userRole = roleIds;
            userRole = StringUtil.stringTrimSpace(userRole);
        }

        //2. 获取当前用户角色所有菜单List
        String queryStr = "";
        if (userRole != null && userRole.trim().length() > 0) {
            String strTemp = "'" + userRole.replace(",", "','" + ",") + "'";
            queryStr = "b.role_id in (" + strTemp + ")";
        }

        PageData findMap = new PageData();
        if (queryStr.trim().length() > 0) {
            findMap.put("queryStr", queryStr);
            findMap.put("isdisable", "1");
        }
        //vmes_role_menu ADD INDEX IDX_ROLE_MENU(索引)
        findMap.put("menuIsdisable", "1");
        //findMap.put("orderStr", "b.layer asc,b.serial_number asc");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<Map<String, Object>> mapList = roleMenuService.findRoleMenuMapList(findMap);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前登录用户id:" + pageData.getString("cuser") + Common.SYS_ENDLINE_DEFAULT +
                        "1.没有配置角色" + Common.SYS_ENDLINE_DEFAULT +
                        "2.角色没有绑定菜单" + Common.SYS_ENDLINE_DEFAULT);
            return model;
        }

        List<Menu> menuList = roleMenuService.mapList2MenuList(mapList, new ArrayList<Menu>());
        //遍历菜单List<Menu>-获取菜单最大级别
        Integer maxLayer = menuService.findMaxLayerByMenuList(menuList);

        //3. 生成菜单树
        menuTreeService.initialization();
        menuTreeService.findMenuTreeByList(menuList, maxLayer);
        List<TreeEntity> treeList = menuTreeService.creatMenuTree(maxLayer, null, null);

        String treeJsonStr = YvanUtil.toJson(treeList);
        //System.out.println("treeJsonStr: " + treeJsonStr);
        model.putResult(treeJsonStr);
        Long endTime = System.currentTimeMillis();
        logger.info("################menu/treeMeuns 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



