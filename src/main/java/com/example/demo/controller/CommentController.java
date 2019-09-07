package com.example.demo.controller;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.ResultDTO;
import com.example.demo.dto.commentCreateDTO;
import com.example.demo.enums.CommentTypeEnum;
import com.example.demo.exception.CustomizeErrorCode;
import com.example.demo.model.Comment;
import com.example.demo.model.Likecount;
import com.example.demo.model.User;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Object post(@RequestBody commentCreateDTO commentCreateDTO, HttpServletRequest request){

        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParent_id(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmt_create(System.currentTimeMillis());
        comment.setGmt_modified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        commentService.insert(comment);
        return ResultDTO.okOf();
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object Comment(@PathVariable(name="id")Long id){
        List<CommentDTO> commentDTO = commentService.commentList(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTO);
    }

    @RequestMapping(value = "/likecount", method = RequestMethod.POST)
    @ResponseBody
    public String commentlike(@RequestBody Likecount likecount,HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            return "Nologin";
        }
        String result = commentService.likeCount(likecount);
        return result;
    }
}
