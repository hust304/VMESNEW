package com.xy.vmes.deecoop.fileio.controller;

import com.xy.vmes.service.FileService;
import com.yvan.FileUploadUtils;
import com.yvan.HttpUtils;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * 说明：文件IO Controller
 * @author 刘威
 * @date 2018-07-23
 */
@RestController
@Slf4j
public class FileController {
    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;
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
     * @author 刘威
     * @date 2018-08-02
     */
    @PostMapping("/file/uploadEmployeePhoto")
    public ResultModel uploadEmployeePhoto(@RequestParam("fileName") MultipartFile file)  throws Exception {
        logger.info("################file/uploadEmployeePhoto 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();

        String photoUrl = fileService.uploadEmployeePhoto(file);

        System.out.println("photoUrl:" + photoUrl);

        model.put("photo",photoUrl);
        model.putMsg("图片上传成功！");

        Long endTime = System.currentTimeMillis();
        logger.info("################file/uploadEmployeePhoto 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    @PostMapping("/file/uploadEmployeePhoto")
//    public ResultModel uploadEmployeePhoto(@RequestParam("fileName") MultipartFile file) throws Exception {
//        HttpServletResponse response  = HttpUtils.currentResponse();
//        HttpServletRequest request  = HttpUtils.currentRequest();
//        System.out.println("in uploadEmployeePhoto()");
//        return null;
//    }

//    public static void main(String[] args) throws Exception {
//        File destFile = new File("D://test111/test222/test333/test.txt");
//        if(!destFile.getParentFile().exists()){				//判断有没有父路径，就是判断文件整个路径是否存在
//            destFile.getParentFile().mkdirs();				//不存在就全部创建
//        }
//        String path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../../../").replaceAll("file:/", "").replaceAll("%20", " ").trim();
//        if(path.indexOf(":") != 1){
//            path = File.separator + path;
//        }
//        System.out.println(path);
//        String absolutePath = path+"vmes-file/";//上传文件的绝对路径
//        System.out.println(absolutePath);
//        String relativePath = "fileUpload/employee/photo/";//上传文件的相对路径
//        System.out.println(relativePath);

//    }
}
