package com.zzq.pro.config;

import org.apache.shiro.authc.AuthenticationToken;

public class MyAuthenticationToken implements AuthenticationToken{
    private String token;

    public MyAuthenticationToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
