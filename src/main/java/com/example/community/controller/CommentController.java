package com.example.community.controller;


import com.example.community.dto.CommentCreateDTO;
import com.example.community.dto.CommentDTO;
import com.example.community.dto.ResultDTO;
import com.example.community.enums.CommentTypeEnum;
import com.example.community.exception.CustomizeErrorCode;
import com.example.community.model.Comment;
import com.example.community.model.User;
import com.example.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {


    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    @ResponseBody//将对象转化为json格式，这里是map对象
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request){

        User user = (User)request.getSession().getAttribute("user");
        if(user==null){
            return ResultDTO.errorof(CustomizeErrorCode.NO_LOGIN);
        }

        if(commentCreateDTO==null||commentCreateDTO.getContent()==null||commentCreateDTO.getContent()==""){
            return  ResultDTO.errorof(CustomizeErrorCode.CONTENT_IS_EMPTY);

        }
        //@RequestBody 将json格式请求参数转化为commentdto对象
        Comment comment=new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setCommentator(user.getId());
        comment.setCreateTime(System.currentTimeMillis());
        comment.setModifiedTime(comment.getCreateTime());
        comment.setLikeCount(0L);
        comment.setCommentCount(0);
        commentService.insert(comment);
        //想加强返回的信息，所以自定义了resultDto
        return  ResultDTO.okOf();
    }


    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List> comments(@PathVariable(name = "id") Long id) {
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}
