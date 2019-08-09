package com.example.community.mapper;


import com.example.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into testdb (name,account_id,token,create_time,modified_time) values (#{name},#{accountId},#{token},#{createTime},#{modifiedTime})")
    public void inserUser(User user);


    @Select("select * from testdb where token= #{token}")
    public User getUser(@Param("token") String token);//当参数是java文件中的bean对象时，#{token}可以取到对象中的参数
                                                       //如果不是对象 要加@param（“参数名”）
}
