package com.zzq.pro.controller;

import com.zzq.pro.config.MyAuthenticationToken;
import com.zzq.pro.mapper.MyUserMapper;
import com.zzq.pro.model.MyUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("myUser")
public class MyUserController {

    @Autowired
    private MyUserMapper myUserMapper;

    @GetMapping("getUserByUsername")
    public MyUser getUserByUsername(@RequestParam("username") String username) {
        return myUserMapper.getUserByUsername(username);
    }

    @GetMapping
    @RequiresRoles("admin")
    public List<MyUser> getAll() {
        return myUserMapper.getALL();
    }

    //自定义登录则需要shiroconfig增加自定义拦截器
    /*@PostMapping("login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        MyUser user = myUserMapper.login(username, password);
        if (Objects.isNull(user)) {
            throw new UnauthenticatedException("error username or password");
        }
        MyAuthenticationToken token = new MyAuthenticationToken(user.getUsername());
        SecurityUtils.getSubject().login(token);
        return "success";
    }*/

    @PostMapping("loginOut")
    public String loginOut() {

        SecurityUtils.getSubject().logout();
        return "success";
    }
}
