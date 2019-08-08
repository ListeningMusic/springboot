package com.example.community.controller;


import com.example.community.Provider.GithubProvider;
import com.example.community.bean.GithubUser;
import com.example.community.dto.AccessTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){

        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setClient_id("edcf01497196ffdf1467");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret("924cc4d6232a2eb9888e9d33f31100c059f52b27");
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getBio());

        return "index";
    }
}


