package com.example.community.mapper;


import com.example.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into testdb (name,account_id,token,create_time,modified_time) values (#{name},#{accountId},#{token},#{createTime},#{modifiedTime})")
    public void inserUser(User user);
}
