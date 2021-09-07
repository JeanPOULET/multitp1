package com.pam.tp1.alert;

import com.pam.tp1.format.SimpleFormatMessage;
import com.pam.tp1.format.SimpleMailFormat;
import com.pam.tp1.format.SplitFormatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MailSenderService {

    @Autowired
    SimpleFormatMessage simpleFormatMessage;

    @Autowired
    SplitFormatMessage splitFormatMessage;

    @Autowired
    SimpleMailFormat simpleMailFormat;

    @Autowired
    public JavaMailSender mailSender;


    public void sendMail(String msg) {

        System.out.println(msg);

        String[] msgs = simpleMailFormat.parseResponse(msg);

        System.out.println(Arrays.toString(msgs));

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(simpleFormatMessage.removeWhiteSpace(msgs[0]));
        mail.setSubject(msgs[1]);
        mail.setText(msgs[2]);
        mailSender.send(mail);
    }
}
