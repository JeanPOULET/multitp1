package com.pam.tp1.controller;

import com.pam.tp1.alert.MailSenderService;
import com.pam.tp1.format.SimpleMailFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    MailSenderService mailSender;

    @Autowired
    SimpleMailFormat formatMail;

    @GetMapping("/accueil")
    public String acc(){
        return formatMail.mailMoche();
    }

    @PostMapping("/accueil/sendMail")
    public String envoyerMail(@RequestBody String response){
        mailSender.sendMail(response);
        return formatMail.mailMoche() +"<div> franchement degeu</div>";
    }

}
