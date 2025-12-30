package com.edu_verse.api_edu_verse.service;

import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Value;

public class cookieServiceOffice {
    private static final String COOKE_NAME = "auth_token";

    @Value("${COOKIE_SECRET2}")
    private String secretKey;

    @Value("86400")
    private int expiration;

    public Cookie genCookie(){
        Cookie cookie = new Cookie(COOKE_NAME, secretKey);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(expiration);
        return cookie;
    }

    public boolean isCookieValid(String token){
        return token != null && token.equals(genCookie().getValue());
    }
}
