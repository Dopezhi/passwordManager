package com.pwd.service;

import com.pwd.common.ServerResponse;
import com.pwd.pojo.User;
import com.pwd.pojo.UserManager;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IUserManagerService {
    ServerResponse<UserManager> login(int managerId, String managerPwd, HttpSession session);
    List<User> getAllUsers();
//    ServerResponse<String> checkValid(int managerId,String type);
}
