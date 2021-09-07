package com.pam.tp1.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SplitFormatMessage {


    int nb;

    @Autowired
    SimpleFormatMessage formatter;


    public String splitMessage(String msg) {
        char[] tmp = formatter.removeReturns(formatter.removeWhiteSpace(msg)).toCharArray();

        String fin = "";

        for (int i = 0; i < tmp.length; i++) {

            fin += tmp[i];

            if (i != 0 && i % nb == 0)
                fin += "\n";

        }
        return fin;

    }

}
