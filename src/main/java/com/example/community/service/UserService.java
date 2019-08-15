package com.example.community.service;


import com.example.community.mapper.UserMapper;
import com.example.community.model.User;
import com.example.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> userByAccountId = userMapper.selectByExample(userExample);

        if(userByAccountId.size() == 0){
            //查询数据库中没有该用户
            user.setCreateTime(System.currentTimeMillis());
            user.setModifiedTime(user.getCreateTime());
            userMapper.insert(user);
        }else {
            //有该用户 就执行更新操作
            User user1 = userByAccountId.get(0);
            User updataUser =new User();
            updataUser.setModifiedTime(System.currentTimeMillis());
            updataUser.setName(user.getName());
            updataUser.setToken(user.getToken());
            UserExample userExample1 =new UserExample();
            userExample1.createCriteria().andIdEqualTo(user1.getId());
            userMapper.updateByExampleSelective(updataUser,userExample1);

        }

    }
}
