package com.example.community.dto;


import com.example.community.model.Question;
import com.example.community.model.User;
import lombok.Data;


@Data
public class QuestionDTO {

    Question question;
    User user;
}
