package com.zzq.pro.controller;

import com.zzq.pro.mapper.MyUserMapper;
import com.zzq.pro.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("myUser")
public class MyUserController {

    @Autowired
    private MyUserMapper myUserMapper;

    @GetMapping("getUserById")
    public MyUser getUserById(@RequestParam("id") String id) {
        return myUserMapper.getUserById(id);
    }
}
