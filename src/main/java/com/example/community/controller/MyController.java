package com.example.community.controller;


import com.example.community.Provider.GithubProvider;
import com.example.community.bean.GithubUser;
import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.PageDTO;
import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.service.QuestionService;
import com.example.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Provider;
import java.util.List;
import java.util.UUID;

@Controller
public class MyController {

    @Autowired
    QuestionService questionService;


    @Autowired
    GithubProvider githubProvider;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;


    @RequestMapping("/")
    //验证index页面是否有cookie信息，做持久化登录
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name="size" ,defaultValue = "3") Integer size) {

        //将页数和每页显示的数量传给questionmapper，查询数据库，将结果返回给前端页面显示
        PageDTO pageDTO = questionService.list(page, size);
        model.addAttribute("pagedto",pageDTO );

        return "index";


    }



}


