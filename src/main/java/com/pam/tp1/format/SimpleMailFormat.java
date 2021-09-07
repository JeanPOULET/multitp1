package com.pam.tp1.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleMailFormat {

    @Autowired
    SimpleFormatMessage simpleFormat;

    public String mailMoche() {

        String mail;

        mail = "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>c pt</title>" +
                "</head>" +
                "<body>" +
                "<form action=\"/accueil/sendMail\" method=\"post\">" +

                "<label for=\"mail\"> Mail du monsieur</label>" +
                "<input type=\"text\" id=\"mail\" name=\"mail\">" +

                "<label for=\"obj\"> Obj pour le monsieur</label>" +
                "<input type=\"text\" id=\"obj\" name=\"obj\">" +

                "<label for=\"msg\"> Msg pour le monsieur</label>" +
                "<input type=\"text\" id=\"msg\" name=\"msg\">" +

                "<input type=\"submit\" value=\"Submit\">" +
                "</form>" +

                "</body>" +
                "</html>";

        return mail;
    }

    public String[] parseResponse(String msg) {
        String[] response = msg.split("&");

        response[0] = simpleFormat.removeNonWantedChars(response[0].replaceAll("mail=", ""));
        response[1] = simpleFormat.removeNonWantedChars(response[1].replaceAll("obj=", ""));
        response[2] = simpleFormat.removeNonWantedChars(response[2].replaceAll("msg=", ""));


        return response;
    }
}
