package com.example.demo.mapper;

import com.example.demo.model.Comment;

public interface CommentExtMapper {
    void updateByCommentCount(Comment comment);
    void updateByLikeCountUp(Comment comment);
    void updateByLikeCountDown(Comment comment);
}
