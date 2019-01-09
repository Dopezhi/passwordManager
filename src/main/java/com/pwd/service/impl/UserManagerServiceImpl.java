package com.pwd.service.impl;

import com.pwd.common.Const;
import com.pwd.common.ServerResponse;
import com.pwd.dao.UserManagerMapper;
import com.pwd.dao.UserMapper;
import com.pwd.pojo.User;
import com.pwd.pojo.UserManager;
import com.pwd.service.IUserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("iUserManagerService")
public class UserManagerServiceImpl implements IUserManagerService {

    @Autowired
    UserManagerMapper userManagerMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse<UserManager> login(int managerId, String managerPwd, HttpSession session) {
        //todo MD5加密

        UserManager userManager=userManagerMapper.selectWithPwd(managerId,managerPwd);
        if(userManager==null){
            return ServerResponse.createByErrorMsg("账户不存在或密码错误");
        }else{
            session.setAttribute(Const.CURRENT_USER_MANAGER,userManager);
            userManager.setManagerPwd("");
            return ServerResponse.createBySuccessMsg(userManager);
        }
    }


    public ServerResponse<String> checkValid(int managerId, String type) {
        if(type.equals(Const.MANAGER_ID)){

        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        ArrayList<User> userList= (ArrayList<User>) userMapper.selectAllUsers();
        for (int i=0;i<userList.size();i++){
            ((User) userList.get(i)).setPassword("");
        }
        return userList;
    }
}
