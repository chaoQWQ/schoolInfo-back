package com.zc.schoolinfo.serviece.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/5/6 20:26
 * @Version 1.0
 **/
@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerifyMail(String to,String code){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            String html = "<div style=\"padding: 0px 0px 0px 20px;box-sizing: border-box;color: #333333;font-family: \"microsoft yahei\";font-size: 14px\">" +
                    "<h3 style=\"font-weight: normal;margin-top: 0px;margin-bottom: 0px;:font-size: 17px;\">亲爱的重邮校园活动信息网 账户</h3>" +
                    "<div style=\"margin-top: 25px;\">要验证电子邮件，请使用此验证代码:<em style=\"font-style: normal;font-weight: 600;\">"+code+"</em></div>" +
                    "<div style=\"margin-top: 25px;\">如果你没有知悉这封邮件，请忽略这封电子邮件。</div>" +
                    "<div style=\"margin-top: 0px;\">—校园活动信息网</div>" +
                    "</div>";
            helper.setFrom("chaoQWQ@163.com");
            helper.setTo(to);

            helper.setSubject("邮箱验证");
            helper.setText(html,true);
            mailSender.send(message);
            System.out.println(to+"邮件发送成功");
        } catch (MessagingException e) {
            System.out.println(to+"邮件发送失败");
        }

    }

    public void sendResetPassWordEmail(String email,String username,String password) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            String html = "<div style=\"padding: 0px 0px 0px 20px;box-sizing: border-box;color: #333333;font-family: \"microsoft yahei\";font-size: 14px\">" +
                    "<h3 style=\"font-weight: normal;margin-top: 0px;margin-bottom: 0px;:font-size: 17px;\">亲爱的"+username+" 账户</h3>" +
                    "<div style=\"margin-top: 25px;\">您重置后的密码为<em style=\"font-style: normal;font-weight: 600;\">"+password+"</em></div>" +
                    "<div style=\"margin-top: 25px;\">如果你没有知悉这封邮件，请忽略这封电子邮件。</div>" +
                    "<div style=\"margin-top: 0px;\">—校园活动信息网</div>" +
                    "</div>";
            helper.setFrom("chaoQWQ@163.com");
            helper.setTo(email);
            helper.setSubject("重置密码");
            helper.setText(html,true);
            mailSender.send(message);
            System.out.println(email+"邮件发送成功");
        } catch (MessagingException e) {
            System.out.println(email+"邮件发送失败");
        }
    }
}
