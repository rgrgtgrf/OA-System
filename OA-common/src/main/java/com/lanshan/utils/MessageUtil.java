package com.lanshan.utils;

import com.alibaba.fastjson.JSON;
import com.lanshan.Result.MessageResult;

import java.text.MessageFormat;

public class MessageUtil {

    public static String getMessage(boolean isSystemMessage, String fromName, Object message){

        MessageResult result = new MessageResult();
        result.setSystem(isSystemMessage);
        result.setMessage(message);
        if(fromName != null){
            result.setFromName(fromName);
        }
        return JSON.toJSONString(result);
    }
}
