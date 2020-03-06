package com.example.mapper;

import com.example.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Create by Administrator on 2020/3/6.
 */
@Repository
public interface UserMapper {
    User getUserByName(String s);

    int addUser(User user);
}
