package com.ski.mvp.thymeleaf.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class AuthUtil {

    @Value("${bcm.auth.roles}")
    String[] bcmAuthRoles;
    @Value("${bcm.token.key}")
    String bcmTokenKey;
	
    @SuppressWarnings("all")
    public boolean checkCookieAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(request.getServerName().equals("localhost") && 1==2) {
            return true;
        } else {

            Cookie[] list = request.getCookies();
            String payload = "";
            int trueCount = 0;
            
            if(list != null) {
                
                for(Cookie cookie: list) {

                    if(cookie.getName().equals(bcmTokenKey)) {
                        payload = CommonUtil.getJwtPayload(cookie.getValue());

                        JsonParser jsonParser = new BasicJsonParser();
                        Map<String, Object> jsonArray = jsonParser.parseMap(payload);

                        log.info("==================== Check Auth authorities ====================");
                        if(jsonArray.containsKey("authorities")) {
                            List<String> authorities = (List<String>) jsonArray.get("authorities");
                            for(String authority: authorities) {
                                for(String role: bcmAuthRoles) {
                                    if(authority.equals(role)) {
                                        log.info("Found authority: " + authority);
                                        trueCount++;
                                    }
                                }
                            }
                        } else {
                            log.info("No authorities: authorities list not found");
                            response.sendRedirect("/notauth");
                            return false;
                        }
                    } 
                }
            }
            
            if(trueCount > 0) {
                log.info("Found " + trueCount + " authorities");
                return true;
            } else {
                log.info("No authorities: matched role found");
                response.sendRedirect("/notauth");
                return false;
            }
        }
	}

}
