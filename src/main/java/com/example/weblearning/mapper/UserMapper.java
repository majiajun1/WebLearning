package com.example.weblearning.mapper;

import com.example.weblearning.enetity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from users where username=#{username} and password=#{password}")
    Users getUser(@Param("username") String username, @Param("password") String password);
}
