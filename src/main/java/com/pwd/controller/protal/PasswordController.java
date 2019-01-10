package com.pwd.controller.protal;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pwd.common.Const;
import com.pwd.common.ServerResponse;
import com.pwd.pojo.Password;
import com.pwd.pojo.User;
import com.pwd.pojo.UserManager;
import com.pwd.service.IPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/password/")
public class PasswordController {

    @Autowired
    IPasswordService iPasswordService;

    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getUserPasswordList(@RequestParam(defaultValue = "5") int pageSize
            , @RequestParam(defaultValue = "1") int pageNum, HttpSession session){
//        UserManager currentUserManager= (UserManager) session.getAttribute(Const.CURRENT_USER_MANAGER);
//        if(currentUserManager==null){
//            return ServerResponse.createByErrorMsg("当前无管理员登录，请登录");
//        }
//        PageHelper.startPage(pageNum, pageSize);
//        List<User> users=iUserManagerService.getAllUsers();
//        PageInfo page = new PageInfo(users,pageSize);
//        return ServerResponse.createBySuccessMsg(page);
        ServerResponse reponse=iPasswordService.getUserPasswordList(session);
        if(!reponse.isSuccess()){
            return reponse;
        }
        List<Password> userPasswordList= (List<Password>) reponse.getData();
        PageInfo page=new PageInfo(userPasswordList,pageSize);
        return ServerResponse.createBySuccessMsg(page);

    }

    @RequestMapping(value = "add_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addPassword(Password password){
        //todo
        return null;
    }

    @RequestMapping(value="search_password.do",method = RequestMethod.POST)
    @ResponseBody
   public ServerResponse<Password> searchPassword(Integer passwordId){
        return iPasswordService.selectWithId(passwordId);
   }
}
