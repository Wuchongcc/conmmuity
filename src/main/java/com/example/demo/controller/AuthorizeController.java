package com.example.demo.controller;

import com.example.demo.dto.AccessTokenDTO;
import com.example.demo.dto.GithubUser;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @Value("${github.redirect.uri}")
    private String redirect_uri;

    @GetMapping("/logincallback")
    public String Callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String  accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser != null){
            //登录成功，写cookie和session
            User user = new User();
            user.setName(githubUser.getName());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setGmt_modified(System.currentTimeMillis());//系统生成的时间
            user.setGmt_create(user.getGmt_modified());
            user.setAvatarUrl(githubUser.getAvatar_url());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            response.addCookie(new Cookie("token",token));
            userMapper.addUser(user);
            return "redirect:/";
        }else{
            //登录失败，请重新登录
            return "redirect:/";
        }

    }
}
