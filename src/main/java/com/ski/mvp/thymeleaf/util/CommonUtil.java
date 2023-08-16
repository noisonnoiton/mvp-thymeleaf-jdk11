package com.ski.mvp.thymeleaf.util;

import java.util.Base64;

public class CommonUtil {

    public static String getJwtPayload(String token) {
        String payload = token.split("\\.")[1];
        Base64.Decoder decoder = Base64.getUrlDecoder();
        
        return new String(decoder.decode(payload));
    }
}
