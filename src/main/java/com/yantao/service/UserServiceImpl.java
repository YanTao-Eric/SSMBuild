package com.yantao.service;

import com.yantao.dao.UserMapper;
import com.yantao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @author YanTao
 * @date 2021/9/12
 * @time 21:15
 */
@Service
public class UserServiceImpl implements UserService{
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }
}
