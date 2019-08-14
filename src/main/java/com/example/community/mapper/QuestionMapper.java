package com.example.community.mapper;

import com.example.community.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {


    @Insert("insert into question (title,description,create_time,modified_time,creator_id,tag) " +
            "values (#{title},#{description},#{createTime},#{modifiedTime},#{creatorId},#{tag})")
     void create(Question question);


    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value="offset") Integer offset,
                        @Param(value="size") Integer size);

    @Select("select count(1) from question")
    Integer count();


    @Select("select * from question where creator_id=#{userId} limit #{offset},#{size}")
    List<Question> listByID(@Param("userId") Integer userId,
                        @Param("offset") Integer offset,
                        @Param("size") Integer size);


    @Select("select count(1) from question where creator_id =#{id}")
    Integer countByUserId( @Param("id") Integer id);

    @Select("select * from question where id=#{id}")
    Question getById(@Param("id") Integer id);

    @Update("update question set title= #{title},description=#{description},create_time=#{modifiedTime},tag=#{tag} where id=#{id}")
    void update(Question question);
}
