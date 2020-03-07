package com.xy.vmes.deecoop.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceTest {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("chen_gang7906@163.com");//发送邮箱
        mailMessage.setTo("chen_gang7906@163.com");//接收邮箱

        mailMessage.setSubject("测试邮件主题"); //邮件主题
        mailMessage.setText("邮件正文"); //邮件正文

        mailSender.send(mailMessage);
    }
}
