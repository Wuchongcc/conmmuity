package com.example.demo.mapper;

import com.example.demo.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    //自定义扩展阅读数
    int updateByViewCount(Question question);
    //自定义回复内容数
    int updateByCommentCount(Question question);
    //自定义相关话题
    List<Question>  selectRelated(Question question);
}
