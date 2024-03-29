package com.xy.vmes.deecoop.kanban.controller;

import com.xy.vmes.service.KanbanVisualizationService;
import com.xy.vmes.entity.KanbanVisualization;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
* 说明：vmes_kanban_visualization:销售开票Controller
* @author 刘威 自动生成
* @date 2020-01-06
*/
@RestController
@Slf4j
public class KanbanVisualizationController {

    private Logger logger = LoggerFactory.getLogger(KanbanVisualizationController.class);

    @Autowired
    private KanbanVisualizationService kanbanVisualizationService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-01-06
    */
    @GetMapping("/kanban/visualization/selectUserKanban/{id}")
    public ResultModel selectUserKanban(@PathVariable("id") String id)  throws Exception {

        logger.info("################/kanban/visualization/selectUserKanban 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        KanbanVisualization kanbanVisualization = kanbanVisualizationService.selectById(id);
        model.putResult(kanbanVisualization);
        Long endTime = System.currentTimeMillis();
        logger.info("################/kanban/visualization/selectUserKanban 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-01-06
    */
    @PostMapping("/kanban/visualization/addUserEditedKanban")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addUserEditedKanban()  throws Exception {

        logger.info("################/kanban/visualization/addUserEditedKanban 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        KanbanVisualization kanbanVisualization = (KanbanVisualization)HttpUtils.pageData2Entity(pd, new KanbanVisualization());
        kanbanVisualization.setCompanyId(pd.getString("currentCompanyId"));
        kanbanVisualizationService.save(kanbanVisualization);
        Long endTime = System.currentTimeMillis();
        logger.info("################/kanban/visualization/addUserEditedKanban 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2020-01-06
     */
    @PostMapping("/kanban/visualization/updateUserKanban")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateUserKanban()  throws Exception {

        logger.info("################/kanban/visualization/updateUserKanban 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        KanbanVisualization kanbanVisualization = (KanbanVisualization)HttpUtils.pageData2Entity(pd, new KanbanVisualization());
        kanbanVisualizationService.update(kanbanVisualization);
        Long endTime = System.currentTimeMillis();
        logger.info("################/kanban/visualization/updateUserKanban 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2020-01-06
    */
    @PostMapping("/kanban/visualization/deleteUserKanban")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteUserKanban()  throws Exception {

        logger.info("################/kanban/visualization/deleteUserKanban 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        String id = pd.getString("id");
        if(!StringUtils.isEmpty(id)){
            kanbanVisualizationService.deleteById(pd.getString("id"));
        }else{
            model.putCode("1");
            model.putMsg("删除对象不能为空！");
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/kanban/visualization/deleteUserKanban 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，可以修改
    * @date 2020-01-06
    */
    @PostMapping("/kanban/visualization/listUserEditedKanban")
    public ResultModel listUserEditedKanban()  throws Exception {
        logger.info("################/kanban/visualization/listUserEditedKanban 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();
        PageData pageData = new PageData();
        pageData.put("company_id",pd.getString("currentCompanyId"));
        pageData.put("cuser",pd.getString("currentUserId"));
        List<KanbanVisualization> kanbanVisualizationList = kanbanVisualizationService.selectByColumnMap(pageData);
        if(kanbanVisualizationList!=null&&kanbanVisualizationList.size()>0){
            model.putResult(kanbanVisualizationList);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/kanban/visualization/listUserEditedKanban 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
     * @author 刘威 自动创建，可以修改
     * @date 2020-01-06
     */
    @PostMapping("/kanban/visualization/userKanbanList")
    public ResultModel userKanbanList()  throws Exception {
        logger.info("################/kanban/visualization/userKanbanList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();
        PageData pageData = new PageData();
        pageData.put("company_id",pd.getString("currentCompanyId"));
        List<KanbanVisualization> kanbanVisualizationList = kanbanVisualizationService.selectByColumnMap(pageData);
        if(kanbanVisualizationList!=null&&kanbanVisualizationList.size()>0){
            model.putResult(kanbanVisualizationList);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################/kanban/visualization/userKanbanList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



