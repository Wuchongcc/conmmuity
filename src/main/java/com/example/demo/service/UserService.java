package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccount_idEqualTo(user.getAccount_id());
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null){//插入
            user.setGmt_modified(System.currentTimeMillis());//系统生成的时间
            user.setGmt_create(user.getGmt_modified());
            userMapper.insert(user);
        }else {//更新
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setGmt_modified(System.currentTimeMillis());
            System.out.println(dbUser.getId());
            UserExample userExample1 = new UserExample();
            userExample1.createCriteria().andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser,userExample1);
        }
    }
}
