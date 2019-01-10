package com.pwd.service.impl;

import com.pwd.common.Const;
import com.pwd.common.ServerResponse;
import com.pwd.dao.PasswordMapper;
import com.pwd.pojo.Password;
import com.pwd.pojo.User;
import com.pwd.service.IPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("iPasswordService")
public class PasswordServiceImpl implements IPasswordService {

    @Autowired
    PasswordMapper passwordMapper;

    @Override
    public ServerResponse<List<Password>> getUserPasswordList(HttpSession session) {
        User currentUser= (User) session.getAttribute(Const.CURRENT_USER);
        if(currentUser==null){
            return ServerResponse.createByErrorMsg("当前无登录用户");
        }else{
            List<Password> passwordList=passwordMapper.selectAllPassword(currentUser.getLoginid());
            return ServerResponse.createBySuccessMsg(passwordList);
        }

    }
}
