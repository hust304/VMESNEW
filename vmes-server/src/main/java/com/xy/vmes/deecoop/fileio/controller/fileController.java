package com.xy.vmes.deecoop.fileio.controller;

import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.template.ExcelAjaxTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：文件IO Controller
 * @author 刘威
 * @date 2018-07-23
 */
@RestController
@Slf4j
public class fileController {
    private Logger logger = LoggerFactory.getLogger(fileController.class);
    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-02
     */
    @GetMapping("/file/uploadFile")
    public void uploadFile()  throws Exception {

        logger.info("################file/uploadFile 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();


        Long endTime = System.currentTimeMillis();
        logger.info("################file/uploadFile 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }




    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-02
     */
    @GetMapping("/file/downloadFile")
    public void downloadFile()  throws Exception {

        logger.info("################file/downloadFile 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();


        Long endTime = System.currentTimeMillis();
        logger.info("################file/downloadFile 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }


    /**
     * @author 刘威 自动创建，禁止修改
     * @date 2018-08-02
     */
    @GetMapping("/file/uploadEmployeeImg")
    public void uploadEmployeeImg()  throws Exception {

        logger.info("################file/uploadEmployeeImg 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        HttpServletResponse response  = HttpUtils.currentResponse();
        HttpServletRequest request  = HttpUtils.currentRequest();


        Long endTime = System.currentTimeMillis();
        logger.info("################file/uploadEmployeeImg 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }
}
