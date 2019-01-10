package com.pwd.controller.protal;

import com.pwd.common.ServerResponse;
import com.pwd.pojo.Password;
import com.pwd.service.IPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/password/")
public class PasswordController {

    @Autowired
    IPasswordService iPasswordService;

    @RequestMapping(value = "add_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addPassword(Password password){
        //todo
        return null;
    }
}
