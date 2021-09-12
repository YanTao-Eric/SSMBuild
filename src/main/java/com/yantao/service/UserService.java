package com.yantao.service;

import com.yantao.pojo.User;

/**
 * Created by IntelliJ IDEA.
 *
 * @author YanTao
 * @date 2021/9/12
 * @time 21:11
 */
public interface UserService {
    User selectUserById(String id);
}
