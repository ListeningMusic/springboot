package com.example.community.dto;

import com.example.community.model.Comment;
import com.example.community.model.User;
import lombok.Data;


@Data
public class CommentDTO {

    private Comment comment;
    private User user;
}
