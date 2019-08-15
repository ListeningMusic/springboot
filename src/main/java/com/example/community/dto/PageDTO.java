package com.example.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class PageDTO {

    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Long page;//记录当前页的页数
    private List<Long> pages=new ArrayList<>();//需要在列表中展示的页
    Long totalPage ;//总页数

    public void setPagination(Long totalCount,Long page,Integer size){
        this.page=page;//把当前点击的页数 传给pagedto的page属性


        if(totalCount%size==0){
            totalPage=totalCount/size;

        }else{
            totalPage=totalCount/size+1;
        }

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        // 是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        // 是否展示下一页
        if (page == totalPage ) {
            showNext = false;
        } else {
            showNext = true;
        }

        // 是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        // 是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}