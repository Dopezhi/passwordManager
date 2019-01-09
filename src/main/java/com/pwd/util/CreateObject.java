package com.pwd.util;

import com.pwd.dao.UserMapper;
import com.pwd.pojo.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CreateObject {
    @Autowired
    UserMapper userMapper;

    public static void main(String[] args) {
        String str=UUID.randomUUID().toString().substring(0,8);
        String pre=""

    }
}
