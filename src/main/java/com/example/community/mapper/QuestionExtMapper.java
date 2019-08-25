package com.example.community.mapper;

import com.example.community.model.Question;


public interface QuestionExtMapper {
    int addoneView(Question record);

    void incCommentCount(Question record);
}