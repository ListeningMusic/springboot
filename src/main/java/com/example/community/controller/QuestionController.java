package com.example.community.controller;


import com.example.community.dto.QuestionDTO;
import com.example.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {



    @Autowired
    QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Integer id,
                           Model model){

        //更新操作在查询之前，保证浏览次数正确
        questionService.addoneView(id);
        QuestionDTO questionDTO = questionService.getById(id);
        //每次进入此链接，就累加一次阅读数


        model.addAttribute("question", questionDTO);


        return "question";
    }
}
