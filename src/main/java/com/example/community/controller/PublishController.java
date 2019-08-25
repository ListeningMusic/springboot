package com.example.community.controller;


import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import com.example.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {



    @Autowired
    QuestionService questionService;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/publish")
    public String publish(){
        return "publish";
    }


    @PostMapping("/publish")
    public String dopublish(@RequestParam(value="title" ,required = false) String title,
                            @RequestParam(value="description",required = false) String description,
                            @RequestParam(value="tag",required = false) String tag,
                            @RequestParam(value="id",required = false) Long id,
                            HttpServletRequest request,
                            Model model){
        User user = (User)request.getSession().getAttribute("user");

        if(user==null){
            model.addAttribute("error","用户未登录" );
            return "publish";
        }

        Question question =new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreateTime(System.currentTimeMillis());
        question.setModifiedTime(question.getCreateTime());
        question.setCreatorId(user.getId());
        question.setId(id);
        question.setLikeNumber(0);
        question.setViewCount(0);
        question.setCommentNumber(0);
        questionService.createOrUpdate(question);

        return "redirect:/";
    }

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable("id") Long id,
                       Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        model.addAttribute("title", questionDTO.getQuestion().getTitle());
        model.addAttribute("description", questionDTO.getQuestion().getDescription());
        model.addAttribute("tag", questionDTO.getQuestion().getTag());
       model.addAttribute("id", questionDTO.getQuestion().getId());

        return "publish";
    }


}
