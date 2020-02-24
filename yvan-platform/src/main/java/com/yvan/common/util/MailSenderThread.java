package com.yvan.common.util;

public class MailSenderThread extends Thread {
    private MailUtil sender;
    private String content;

    public MailSenderThread (MailUtil sender,String content){
        this.sender =sender;
        this.content = content;
    }

    @Override
    public void run() {
        super.run();
        try {
            this.sender.sendHtmlMail(content, "text/html; charset=gbk"); //sendHtmlMail方法用于发送html邮件,必须指定MIME信息,如"text/html; charset=gbk"
            sender.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
