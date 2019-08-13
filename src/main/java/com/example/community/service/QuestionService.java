package com.example.community.service;


import com.example.community.dto.PageDTO;
import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    UserMapper userMapper;

    public PageDTO list(Integer page,Integer size) {

        //分页查询公式 第一页应该查询到的数据
        Integer offset=size*(page-1);
        List<Question> questions = questionMapper.list(offset,size);
        //定义一个用来存放questiondto的列表
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PageDTO pageDTO =new PageDTO();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreatorId());
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setQuestion(question);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }
        pageDTO.setQuestions(questionDTOList);

        Integer count = questionMapper.count();
        pageDTO.setPagination(count,page,size);


        return pageDTO;
    }


    public PageDTO list(Integer id, Integer page, Integer size) {


        //分页查询公式 第一页应该查询到的数据
        Integer offset=size*(page-1);
        List<Question> questions = questionMapper.listByID(id,offset,size);
        //定义一个用来存放questiondto的列表
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PageDTO pageDTO =new PageDTO();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreatorId());
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setQuestion(question);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }
        pageDTO.setQuestions(questionDTOList);

        Integer countByUserId = questionMapper.countByUserId(id);
        pageDTO.setPagination(countByUserId,page,size);


        return pageDTO;
    }
}