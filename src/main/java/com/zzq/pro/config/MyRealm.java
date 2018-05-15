package com.zzq.pro.config;

import com.zzq.pro.mapper.MyUserMapper;
import com.zzq.pro.model.MyUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Configuration
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private MyUserMapper myUserMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(username);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        MyUser user = myUserMapper.getUserByUsername(username);
        if (StringUtils.isEmpty(username)) {
            throw new AuthenticationException("username didn't allow to be empty");
        }
        if (Objects.isNull(user)) {
            throw new AuthenticationException("user does not exsit");
        }
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),user.getUsername());
    }
}
