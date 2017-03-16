package com.example.controller;

/**
 * Created by zhuyy on 2017/3/13.
 */

import com.example.common.Constant;
import com.example.common.vo.RspData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.internet.MimeMessage;

@Controller
@RequestMapping("mail")
public class MailController {

    @Autowired
    JavaMailSender mailSender;

    @RequestMapping("sendemail")
    public Object sendEmail() {
        RspData rspData = new RspData();
        try
        {
            final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setFrom("****@126.com");
            message.setTo("****@example.com");
            message.setSubject("测试邮件主题");
            message.setText("测试邮件内容");
            this.mailSender.send(mimeMessage);
            rspData.setCode(Constant.SUCCESS_CODE);
            rspData.setMsg("发送邮件成功");
        }
        catch(Exception ex) {
            rspData.setCode(Constant.EXCEPTION_CODE);
            rspData.setMsg("发送邮件失败");
        }
        return rspData;
    }
}
