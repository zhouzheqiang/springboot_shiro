package com.zzq.pro.mapper;

import com.zzq.pro.model.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyUserMapper {

    @Select("select id, username, password from myUser where username=#{username}")
    MyUser getUserByUsername(String username);

    @Select("select id, username, password from myUser")
    List<MyUser> getALL();

    @Select("select id, username, password from myUser where username=#{username} and password=#{password}")
    MyUser login(String username, String password);
}
