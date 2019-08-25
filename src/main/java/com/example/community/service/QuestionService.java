package com.example.community.service;


import com.example.community.dto.PageDTO;
import com.example.community.dto.QuestionDTO;
import com.example.community.exception.CustomizeErrorCode;
import com.example.community.exception.CustomizeException;
import com.example.community.mapper.QuestionExtMapper;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.QuestionExample;
import com.example.community.model.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    UserMapper userMapper;

    public PageDTO list(Long page, Integer size) {

        //分页查询公式 第一页应该查询到的数据
        Integer offset = (int) (size * (page - 1));
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, size));
        //定义一个用来存放questiondto的列表
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PageDTO pageDTO = new PageDTO();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreatorId());
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setQuestion(question);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setQuestions(questionDTOList);

        Long count = questionMapper.countByExample(new QuestionExample());
        pageDTO.setPagination(count, page, size);
        return pageDTO;
    }


    public PageDTO list(Long userId, Long page, Integer size) {


        //分页查询公式 第一页应该查询到的数据
        Integer offset = (int) (size * (page - 1));
        QuestionExample example = new QuestionExample();
        example.createCriteria().andCreatorIdEqualTo(userId);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));
        //定义一个用来存放questiondto的列表
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PageDTO pageDTO = new PageDTO();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreatorId());
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setQuestion(question);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }
        pageDTO.setQuestions(questionDTOList);
        QuestionExample example1 = new QuestionExample();
        example1.createCriteria().andCreatorIdEqualTo(userId);
        long countByUserId = questionMapper.countByExample(example1);
        pageDTO.setPagination(countByUserId, page, size);
        return pageDTO;
    }

    public QuestionDTO getById(Long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if(question==null){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestion(question);
        User user = userMapper.selectByPrimaryKey(question.getCreatorId());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            //第一次创建
            question.setCreateTime(System.currentTimeMillis());
            question.setModifiedTime(question.getCreateTime());
            questionMapper.insert(question);
        } else {
            //更新
            question.setModifiedTime(System.currentTimeMillis());
            QuestionExample example = new QuestionExample();
            example.createCriteria().andIdEqualTo(question.getId());
            questionMapper.updateByExampleSelective(question, example);

        }
    }

    public void addoneView(Long id) {
        //将数据库中值null的该为数值1
        Question questionById = questionMapper.selectByPrimaryKey(id);
        if(questionById.getViewCount()==null){
            questionById.setViewCount(0);
            QuestionExample example = new QuestionExample();
            example.createCriteria().andIdEqualTo(id);
            questionMapper.updateByExampleSelective(questionById, example);
        }
        Question question=new Question();
       question.setId(id);
       question.setViewCount(1);
       questionExtMapper.addoneView(question);
    }
}