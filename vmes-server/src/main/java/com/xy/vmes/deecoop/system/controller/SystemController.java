package com.xy.vmes.deecoop.system.controller;

import com.xy.vmes.common.util.DateFormat;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Date;

@RestController
@Slf4j
public class SystemController {
    private Logger logger = LoggerFactory.getLogger(SystemController.class);

    @PostMapping("/system/findSystemDateTime")
    public ResultModel findSystemDateTime() throws Exception {
        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String dateFormat = pageData.getString("dateFormat");
        if (dateFormat == null || dateFormat.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("日期格式为空或空字符串！");
            return model;
        }

        String dateStr = DateFormat.date2String(new Date(), dateFormat);
        if (dateStr == null || dateStr.trim().length() == 0) {
            String msgTemp = "系统时间转换错误，日期格式({0})";
            String msgStr = MessageFormat.format(msgTemp, dateFormat);

            model.putCode("1");
            model.putMsg(msgStr);
            return model;
        }

        model.set("sysDateTime", dateStr);
        return model;
    }
}
