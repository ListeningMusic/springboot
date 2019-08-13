package com.example.community.controller;


import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.SysexMessage;

@Controller
public class PublishController {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/publish")
    public String publish(){
        return "publish";
    }


    @PostMapping("/publish")
    public String dopublish(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("tag") String tag,
                            HttpServletRequest request,
                            Model model){
        System.out.println("执行了");
        User user=null;
        //验证用户的cookie信息

        if(request.getCookies()!=null){
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                //和数据库中的token做比对
                String token = cookie.getValue();
                user = userMapper.getUser(token);
                if(user!=null){
                    //在数据库中查到相关信息，就写入session让thmeleaf可以取到session值
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }}

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



        questionMapper.create(question);
        return "redirect:/";
    }
}
