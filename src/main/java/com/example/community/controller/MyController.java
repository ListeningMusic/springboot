package com.example.community.controller;


import com.example.community.Provider.GithubProvider;
import com.example.community.bean.GithubUser;
import com.example.community.dto.AccessTokenDTO;
import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Provider;
import java.util.UUID;

@Controller
public class MyController {

    @RequestMapping("/index")
    //验证index页面是否有cookie信息，做持久化登录
    public String index(HttpServletRequest request){
        //在页面中查找cookie信息
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                //和数据库中的token做比对
                String token = cookie.getValue();
                User user = userMapper.getUser(token);
                if(user!=null){
                    //在数据库中查到相关信息，就写入session让thmeleaf可以取到session值
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        return "index";



    }


    @Autowired
    GithubProvider githubProvider;

    @Autowired
    UserMapper userMapper;


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
        if(githubUser!=null){
            User user=new User();
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setCreateTime(System.currentTimeMillis());
            user.setModifiedTime(user.getCreateTime());
            userMapper.inserUser(user);

            //写入cookie，写入数据库就相当于写session
            response.addCookie(new Cookie("token", token));
            return "redirect:index";
        }
        else{
            return "redirect:index";
        }


    }
}


