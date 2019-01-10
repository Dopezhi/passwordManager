package com.pwd.controller.protal;

import com.pwd.common.Const;
import com.pwd.common.ServerResponse;
import com.pwd.dao.UserMapper;
import com.pwd.pojo.User;
import com.pwd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pwd.util.MD5Util;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 门户->用户模块
 */
@Controller
@RequestMapping("/user/")
//controller ->service ->dao
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    UserMapper userMapper;

    /**
     * 登录操作
     * @param loginId
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String loginId, String password, HttpSession session){
        ServerResponse<User> response=iUserService.login(Integer.valueOf(loginId),password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    /**
     *登出操作
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        User currentUser= (User) session.getAttribute(Const.CURRENT_USER);
        if(currentUser!=null){
            session.removeAttribute(Const.CURRENT_USER);
            return ServerResponse.createBySuccessMsg("登出成功");
        }else{
            return ServerResponse.createByErrorMsg("当前无登录用户");
        }
    }

    /**
     * 注册操作
     * @param user
     * @return
     */
    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }

    /**
     * 获取用户登录信息
     * 因为没有涉及到service层以及dao层，可以直接在controller中写逻辑
     * @param session
     * @return
     */
    @RequestMapping(value = "get_user_info.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session){
        User user=(User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMsg("用户未登录,无法获取当前用户信息");
        }
        return ServerResponse.createBySuccessMsg(user);
    }

    /**
     * 忘记密码操作一：获取‘忘记密码的问题’
     * @param loginId
     * @return
     */
    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(int loginId){
        return iUserService.selectQuestion(loginId);
    }

    /**
     * 忘记密码操作二：提交问题答案
     * @param loginId
     * @param question
     * @param answer
     * @return
     */
    @RequestMapping(value = "forget_check_answer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(int loginId,String question,String answer){
        return iUserService.checkAnswer(loginId,question,answer);
    }


    /**
     * 忘记密码操作三：重置密码
     * @param loginId
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    @RequestMapping(value = "forget_reset_password.do",method = RequestMethod.POST)
    @ResponseBody
        public ServerResponse<String> forgetResetPassword(int loginId,String passwordNew,String forgetToken){
        return iUserService.forgetResetPassword(loginId,passwordNew,forgetToken);
    }

    /**
     * 登录状态中重置密码
     * @param passwordOld 输入的旧密码
     * @param passwordNew
     * @param session
     * @return
     */
    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(String passwordOld,String passwordNew,HttpSession session){
        User user=(User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMsg("用户不存在");
        }
        //到dao层实现
        return iUserService.resetPassword(passwordOld,passwordNew,user);
    }

    /**
     * 登录状态更新个人信息
     * 注意这里的user不是当前currentUser，是页面表单中提交的半成品user，给他添加属性是方便后面返回user的时候数据的完整性
     * @param user 修改的只能是username email  question answer
     * @param session
     * @return
     */
    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> updateInformation(User user,HttpSession session){
        User currentUser=(User) session.getAttribute(Const.CURRENT_USER);
        if(currentUser==null){
            return ServerResponse.createByErrorMsg("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setLoginid(currentUser.getLoginid());
        user.setRole(currentUser.getRole());
        ServerResponse serverResponse=iUserService.updateInformation(user);
        if(serverResponse.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,(User)serverResponse.getData());
        }
        return serverResponse;
    }

    @RequestMapping(value = "check_valid.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(int loginId,String type){
        return iUserService.checkValid(loginId,type);
    }


    @RequestMapping(value = "create.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createObject(){
        String str;
        StringBuilder email;
        String passwordMD5;
        StringBuilder pre;
        User user=new User();
        for(int i=10;i<=50;i++){
            str=UUID.randomUUID().toString().substring(0,8);
            email=new StringBuilder(str).append("@qq.com");

            pre=new StringBuilder("1615432").append(String.valueOf(i));

            user.setLoginid(Integer.valueOf(pre.toString()));
            user.setUsername(str);
            //password要加密
            passwordMD5=MD5Util.MD5EncodeUtf8(str.toString());
            user.setPassword(passwordMD5);
            user.setEmail(email.toString());
            user.setQuestion(str);
            user.setAnswer(str);
            user.setRole(0);
            userMapper.insertSelective(user);

        }
        return ServerResponse.createBySuccessMsg("添加成功");
    }


}
