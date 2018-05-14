package com.zzq.pro.mapper;

import com.zzq.pro.model.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyUserMapper {

    @Select("select id, username, password from myUser where id=#{id}")
    MyUser getUserById(String id);
}
