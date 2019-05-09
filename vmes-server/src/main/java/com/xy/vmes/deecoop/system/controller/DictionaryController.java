package com.xy.vmes.deecoop.system.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.*;
import com.xy.vmes.entity.*;
import com.xy.vmes.entity.Dictionary;
import com.xy.vmes.service.*;
import com.yvan.*;
import com.yvan.springmvc.ResultModel;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
* 说明：数据字典Controller
* @author 刘威 自动生成
* @date 2018-07-31
*/
@RestController
@Slf4j
public class DictionaryController {
    private Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    RoleMenuService roleMenuService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @GetMapping("/system/dictionary/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################dictionary/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        Dictionary dictionary = dictionaryService.selectById(id);
        model.putResult(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/system/dictionary/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################dictionary/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());
        dictionaryService.save(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/systemdictionary/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################dictionary/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Dictionary dictionary = (Dictionary)HttpUtils.pageData2Entity(pd, new Dictionary());
        dictionaryService.update(dictionary);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @GetMapping("/system/dictionary/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################dictionary/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        dictionaryService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/system/dictionary/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################dictionary/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Dictionary> dictionaryList = dictionaryService.dataListPage(pd,pg);
        model.putResult(dictionaryList);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @PostMapping("/system/dictionary/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################dictionary/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<Dictionary> dictionaryList = dictionaryService.dataList(pd);
        model.putResult(dictionaryList);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-07-31
    */
    @GetMapping("/system/dictionary/excelExport")
    public void excelExport()  throws Exception {

        logger.info("################dictionary/excelExport 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();

        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
            @Override
            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
                // TODO Auto-generated method stub
                PageData pd = HttpUtils.parsePageData();
                List<LinkedHashMap> titles = dictionaryService.findColumnList();
                request.setAttribute("titles", titles.get(0));
                //List<Map> varList = dictionaryService.findDataList(pd);
                //request.setAttribute("varList", varList);
            }
        });
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/excelExport 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/



    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/addDictionary")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addDictionary()  throws Exception {
        logger.info("################dictionary/addDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.addDictionary(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/addDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/updateDictionary")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDictionary()  throws Exception {
        logger.info("################dictionary/updateDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.updateDictionary(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/updateDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**修改组织架构(禁用)状态
     *
     * @author 陈刚
     * @date 2018-07-27
     */
    @PostMapping("/system/dictionary/updateDisableDictionary")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateDisableDictionary() throws Exception {
        logger.info("################dictionary/updateDisableDictionary 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.updateDisableDictionary(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/dictionary/updateDisableDictionary 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/deleteDictionarys")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteDictionarys()  throws Exception {
        logger.info("################dictionary/deleteDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.deleteDictionarys(pd);

        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/deleteDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/listPageDictionarys")
    public ResultModel listPageDictionarys()  throws Exception {

        logger.info("################dictionary/listPageDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = dictionaryService.listPageDictionarys(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/listPageDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-08-01
     */
//    @GetMapping("/system/dictionary/exportExcelDictionarys")
//    public void exportExcelDictionarys()  throws Exception {
//
//        logger.info("################dictionary/exportExcelDictionarys 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        HttpServletResponse response  = HttpUtils.currentResponse();
//        HttpServletRequest request  = HttpUtils.currentRequest();
//
//        ExcelUtil.buildDefaultExcelDocument( request, response,new ExcelAjaxTemplate() {
//            @Override
//            public void execute(HttpServletRequest request, HSSFWorkbook workbook) throws Exception {
//                // TODO Auto-generated method stub
//                PageData pd = HttpUtils.parsePageData();
//                List<LinkedHashMap> titles = dictionaryService.getColumnList();
//                request.setAttribute("titles", titles.get(0));
//                List<Map> varList = dictionaryService.getDataList(pd);
//                request.setAttribute("varList", varList);
//            }
//        });
//        Long endTime = System.currentTimeMillis();
//        logger.info("################dictionary/exportExcelDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//    }

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
    @PostMapping("/system/dictionary/exportExcelDictionarys")
    public void exportExcelDictionarys() throws Exception {
        logger.info("################dictionary/exportExcelDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        dictionaryService.exportExcelDictionarys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/exportExcelDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/treeDictionarys")
    public ResultModel treeDictionarys()  throws Exception {
        logger.info("################dictionary/treeDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.treeDictionarys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/treeDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/getDictionarys")
    public ResultModel getDictionarys()  throws Exception {
        logger.info("################dictionary/getDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.getDictionarys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/getDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-07-31
     */
    @PostMapping("/system/dictionary/dataListDictionarys")
    public ResultModel dataListDictionarys()  throws Exception {

        logger.info("################dictionary/dataListDictionarys 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = dictionaryService.dataListDictionarys(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################dictionary/dataListDictionarys 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 根据当前登录用户角色获取字典列表
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/system/dictionary/findListDictionaryByRoleMenu")
    public ResultModel findListDictionaryByRoleMenu() throws Exception {
        logger.info("################/system/dictionary/findListDictionaryByRoleMenu 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();

        PageData findMap = new PageData();
        findMap.put("orderStr", "serial_number asc");
        String companyId = pd.getString("currentCompanyId");
        findMap.put("companyId", companyId);

        String isglobal = pd.getString("isglobal");
        findMap.put("isglobal", isglobal);
        if ("1".equals(isglobal)) {
            findMap.put("companyId", null);
        } else {
            findMap.put("isglobal", null);
        }

        String dictionaryKey = pd.getString("dictionaryKey");
        String id = Common.DICTIONARY_MAP.get(dictionaryKey);
        findMap.put("pid", id);
        findMap.put("selfQueryStr", "id = '" + id + "'");

        List<TreeEntity> treeList = dictionaryService.getTreeList(findMap);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String cuser = pd.getString("cuser");
        String roleIds = userRoleService.findRoleIdsByByUserID(cuser);

        findMap = new PageData();
        findMap.put("roleId", roleIds);
        //是否禁用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()).toString());
        List<RoleMenu> roleMenuList = roleMenuService.findRoleMenuList(findMap);

        //获取当前用户角色全部菜单idMap
        Map<String, String> userRoleMenuMap = new HashMap<String, String>();
        for (RoleMenu roleMenu : roleMenuList) {
            String menuId = roleMenu.getMenuId();
            if (menuId != null && menuId.trim().length() > 0) {
                userRoleMenuMap.put(menuId, menuId);
            }
        }

//        //获取收费菜单idMap
//        Map<String, String> paymentMenuMap = new HashMap<String, String>();
//        for (Iterator iterator = Common.SYS_MENU_PAYMENT_MAP.keySet().iterator(); iterator.hasNext();) {
//            String mapKey = (String) iterator.next();
//            String menuId = Common.SYS_MENU_PAYMENT_MAP.get(mapKey);
//            paymentMenuMap.put(menuId, menuId);
//        }
//
//        Map<String, String> notPaymentMenuMap = new HashMap<String, String>();
//        for (Iterator iterator = userRoleMenuMap.keySet().iterator(); iterator.hasNext();) {
//            String menuId = (String) iterator.next();
//
//            if (paymentMenuMap.get(menuId) == null) {
//                notPaymentMenuMap.put(menuId, menuId);
//            }
//        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<TreeEntity> newTreeList = new ArrayList<TreeEntity>();
        if (treeList != null && treeList.size() > 0) {
            for (TreeEntity tree : treeList) {
                String treeId = tree.getId();

                //入库类型
                //sale 销售 94caec1bca7e4131b16bfcee9b1351e2 --> (saleRetreatIn 81907167d5c8498692e6c4f3694c5cfa 销售退货入库)
                if (userRoleMenuMap.get(Common.SYS_MENU_MAP.get("sale")) != null
                    && Common.DICTIONARY_MAP.get("saleRetreatIn").equals(treeId)
                ) {
                    continue;
                } else if (userRoleMenuMap.get(Common.SYS_MENU_MAP.get("purchase")) != null
                    && Common.DICTIONARY_MAP.get("purchaseIn").equals(treeId)
                        ) {
                    //purchase 采购 3f5e1bcd2d3745998773413ccbded554 --> (purchaseIn d78ceba5beef41f5be16f0ceee775399 采购入库)
                    continue;
                }

                //出库类型
                //sale 销售 94caec1bca7e4131b16bfcee9b1351e2 --> (saleOut 9459be975cd94ada8443cdf32f52c2be 销售发货出库)
                if (userRoleMenuMap.get(Common.SYS_MENU_MAP.get("sale")) != null
                        && Common.DICTIONARY_MAP.get("saleOut").equals(treeId)
                        ) {
                    continue;
                } else if (userRoleMenuMap.get(Common.SYS_MENU_MAP.get("purchase")) != null
                        && Common.DICTIONARY_MAP.get("purchaseOut").equals(treeId)
                        ) {
                    //purchase 采购 3f5e1bcd2d3745998773413ccbded554 --> (purchaseOut 4cba5d3815644b26920777512a20474b 采购退货出库)
                    continue;
                }

                newTreeList.add(tree);

//                boolean isDisabled = false;
//                for (Iterator iterator = notPaymentMenuMap.keySet().iterator(); iterator.hasNext();) {
//                    String menuId = (String) iterator.next();
//
//                    //sale 销售 94caec1bca7e4131b16bfcee9b1351e2 --> (saleRetreatIn 81907167d5c8498692e6c4f3694c5cfa 销售退货入库)
//                    if (Common.SYS_MENU_MAP.get("sale").equals(menuId)
//                            && Common.DICTIONARY_MAP.get("saleRetreatIn").equals(treeId)
//                            ) {
//                        isDisabled = true;
//                        break;
//                    } else if (Common.SYS_MENU_MAP.get("purchase").equals(menuId)
//                            && Common.DICTIONARY_MAP.get("purchaseIn").equals(treeId)
//                            ) {
//                        //purchase 采购 3f5e1bcd2d3745998773413ccbded554 --> (purchaseIn d78ceba5beef41f5be16f0ceee775399 采购入库)
//                        isDisabled = true;
//                        break;
//                    }
//                }
//
//                if (!isDisabled) {
//                    newTreeList.add(tree);
//                }
            }
        }

        TreeEntity treeObj = TreeUtil.switchTree(id, newTreeList);
        dictionaryService.dealWithTreeEntityChildren(treeObj);

        Map result = new HashMap();
        result.put("options", treeObj.getChildren());
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################/system/dictionary/findListDictionaryByRoleMenu 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



