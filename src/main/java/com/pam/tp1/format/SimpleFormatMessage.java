package com.pam.tp1.format;

import org.springframework.stereotype.Component;

@Component
public class SimpleFormatMessage implements ISimpleFormat {

    public String removeWhiteSpace(String msg){
        return msg.replaceAll("\\s+","");
    }

    public String removeNonWantedChars(String msg){
        return msg.replaceAll("\\+"," ").replaceAll("%40","@");
    }

    public String removeReturns(String msg){
        return  msg.replaceAll("\\n","");
    }

}
