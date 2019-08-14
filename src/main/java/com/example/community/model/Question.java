package com.example.community.model;


import lombok.Data;

@Data
public class Question {

    private Integer id;
    private String title;
    private String description;
    private Long createTime;
    private Long modifiedTime;
    private Integer creatorId;
    private Integer commentNumber;
    private Integer likeNumber;
    private String tag;
    private Long viewCount;


}
