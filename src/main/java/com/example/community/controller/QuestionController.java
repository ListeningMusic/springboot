package com.example.community.controller;


import com.example.community.dto.CommentDTO;
import com.example.community.dto.QuestionDTO;
import com.example.community.enums.CommentTypeEnum;
import com.example.community.service.CommentService;
import com.example.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {



    @Autowired
    QuestionService questionService;

    @Autowired
    CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Long id,
                           Model model){



        QuestionDTO questionDTO = questionService.getById(id);
        List<CommentDTO> commentDTO = commentService.listByTargetId(id, CommentTypeEnum.QUESTION);
        //每次进入此链接，就累加一次阅读数
        questionService.addoneView(id);
        model.addAttribute("questionDTO", questionDTO);
        model.addAttribute("commentDTO", commentDTO);

        return "question";
    }
}
