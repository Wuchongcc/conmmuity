package com.example.demo.controller;

import com.example.demo.mapper.QuestionMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/dopublish")
    public String doPublish(@RequestParam("title")String title,
                            @RequestParam("description")String description,
                            @RequestParam("tag")String tag,
                            HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        User user = null;
        if(cookies!=null&&cookies.length>0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }if(user == null){
            model.addAttribute("error","用户未登录。");
            return "publish";
        }
        Question question1 = new Question();
        question1.setTitle(title);
        question1.setDescription(description);
        question1.setTag(tag);
        question1.setGmt_create(System.currentTimeMillis());
        question1.setCreator(user.getId());
        question1.setGmt_modified(question1.getGmt_create());
        questionMapper.create(question1);
        return "redirect:/";
    }
}
