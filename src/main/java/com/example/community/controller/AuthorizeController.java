package com.example.community.controller;


import com.example.community.Provider.GithubProvider;
import com.example.community.bean.GithubUser;
import com.example.community.dto.AccessTokenDTO;
import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.service.QuestionService;
import com.example.community.service.UserService;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    QuestionService questionService;


    @Autowired
    GithubProvider githubProvider;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;


    @Value("${github.client.id}")  //从配置文件中注入变量值
    public String clientId;

    @Value("${github.client.secret}")
    public String clientSecret;

    @Value("${github.redirect.uri}")
    public String redirectUri;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){

        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        //System.out.println(user.getBio());
        if(githubUser != null && githubUser.getId() != null){
            User user=new User();
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userService.createOrUpdate(user);

            //写入cookie，写入数据库就相当于写session
            response.addCookie(new Cookie("token", token));

            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }


    @GetMapping("/logout")  //退出登录，移除session、cookie信息
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){

        request.getSession().removeAttribute("user");
        Cookie cookie=new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "redirect:/";
    }
}
