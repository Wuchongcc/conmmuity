package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;//上一页
    private boolean showFirstPage;//首页
    private boolean showNext;//下一页
    private boolean showEndPage;//结束页
    private Integer page;//当前页数
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;//初始化总页数
    private Integer offset;

    //分页数量
    public void setPage(Integer toltalCount, Integer page, Integer size) {
        offset = size * (page-1);
        if (toltalCount % size == 0) {
            totalPage = toltalCount / size;
        } else {
            totalPage = toltalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page >= totalPage) {
            page = totalPage;
        }

        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 2; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }


        //是否展示上一页
        if (page == 1) {//当前页等于第一页
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否展示下一页
        if (page == totalPage) {//当前页等于总页数
            showNext = false;
        } else {
            showNext = true;
        }
        //是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
