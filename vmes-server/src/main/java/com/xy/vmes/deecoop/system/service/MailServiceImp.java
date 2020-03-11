package com.xy.vmes.deecoop.system.service;

import com.xy.vmes.service.MailService;
import com.yvan.common.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImp implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    /**
     *
     * @param subject    邮件主题
     * @param content    邮件内容
     * @param toWho      主送人 ';'分隔的字符串
     * @param ccPeoples  抄送人 ';'分隔的字符串
     */
    public void sendSimpleMail(String subject, String content, String toWho, String ccPeoples) {
        if (subject == null || subject.trim().length() == 0) {return;}
        if (content == null || content.trim().length() == 0) {return;}
        if (toWho == null || toWho.trim().length() == 0) {return;}

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(subject); //邮件主题
        mailMessage.setText(content); //邮件正文
        mailMessage.setFrom(Common.SYS_MAIL_SEND);//发送邮箱

        String[] toArry = toWho.split("\\;");
        mailMessage.setTo(toArry);//主送人 setTo(String[] to) 支持多人

        if (ccPeoples != null && ccPeoples.trim().length() > 0) {
            String[] ccArry = ccPeoples.split("\\;");
            mailMessage.setCc(ccArry);//抄送人 setCc(String[] cc) 支持多人
        }

        mailSender.send(mailMessage);
    }

    public static void main(String[] args) throws Exception {
        String strTmp = "111222;333444;";
        String[] toArry = strTmp.split("\\;");

        System.out.println();
    }
}
