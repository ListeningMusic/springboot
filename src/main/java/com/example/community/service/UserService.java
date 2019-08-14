package com.example.community.service;


import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public User createOrUpdate(User user) {
        User userByAccountId = userMapper.getUserByAccountId(user.getAccountId());
        if(userByAccountId==null){
            //查询数据库中没有该用户
            user.setCreateTime(System.currentTimeMillis());
            user.setModifiedTime(user.getCreateTime());
            userMapper.insertUser(user);
        }else {
            userByAccountId.setModifiedTime(System.currentTimeMillis());
            userByAccountId.setName(user.getName());
            user.setToken(user.getToken());
            userMapper.update(user);

        }
        return userByAccountId;
    }
}
