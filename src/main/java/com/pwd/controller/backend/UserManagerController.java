package com.pwd.controller.backend;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pwd.common.Const;
import com.pwd.common.ServerResponse;
import com.pwd.dao.UserMapper;
import com.pwd.pojo.User;
import com.pwd.pojo.UserManager;
import com.pwd.service.IUserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 后台->管理员用户模块
 */
@Controller
@RequestMapping("/manage/user/")
public class UserManagerController {

    @Autowired
    IUserManagerService iUserManagerService;

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserManager> login(int managerId, String managerPwd, HttpSession session){
        return iUserManagerService.login(managerId,managerPwd,session);
    }

    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        UserManager userManager= (UserManager) session.getAttribute(Const.CURRENT_USER_MANAGER);
        if(userManager==null){
            return ServerResponse.createByErrorMsg("当前无管理员登录");
        }else{
            return ServerResponse.createBySuccessMsg("退出成功");
        }
    }

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getUserList(@RequestParam(defaultValue = "5") int pageSize
            ,@RequestParam(defaultValue = "1") int pageNum,HttpSession session){
        UserManager currentUserManager= (UserManager) session.getAttribute(Const.CURRENT_USER_MANAGER);
        if(currentUserManager==null){
            return ServerResponse.createByErrorMsg("当前无管理员登录，请登录");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<User> users=iUserManagerService.getAllUsers();
        PageInfo page = new PageInfo(users,pageSize);
        return ServerResponse.createBySuccessMsg(page);
    }
}
