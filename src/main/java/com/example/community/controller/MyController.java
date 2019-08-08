package com.example.community.controller;


import com.example.community.Provider.GithubProvider;
import com.example.community.bean.GithubUser;
import com.example.community.dto.AccessTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Provider;

@Controller
public class MyController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @Autowired
    GithubProvider githubProvider;


    @Value("${github.client.id}")  //从配置文件中注入属性值
    public String clientId;

    @Value("${github.client.secret}")
    public String clientSecret;

    @Value("${github.redirect.uri}")
    public String redirectUri;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){

        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getBio());

        return "index";
    }
}


