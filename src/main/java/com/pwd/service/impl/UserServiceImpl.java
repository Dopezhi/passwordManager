package com.pwd.service.impl;

import com.pwd.common.Const;
import com.pwd.common.ServerResponse;
import com.pwd.common.TokenCache;
import com.pwd.dao.UserMapper;
import com.pwd.pojo.User;
import com.pwd.service.IUserService;
import com.pwd.util.MD5Util;
import net.sf.jsqlparser.schema.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(int loginId, String password) {
        int resultCount=userMapper.checkUserLoginId(loginId);
//        int resultCount=userMapper.checkUsername(username);
        if(resultCount==0){
            return ServerResponse.createByErrorMsg("登录账号不存在");
        }
        //MD5密码加密
        password=MD5Util.MD5EncodeUtf8(password);
        User user=userMapper.selectLogin(loginId,password);
        if(user==null){
            return  ServerResponse.createByErrorMsg("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccessMsg(user);
    }

    @Override
    public ServerResponse<String> register(User user) {
        //用户名  Email
        ServerResponse flag=checkValid(user.getLoginid(),Const.LOGIN_ID);
        if(!flag.isSuccess()){
            return ServerResponse.createByErrorMsg("用户已存在");
        }

        flag=checkValid(user.getEmail(),Const.EMAIL);
        if(!flag.isSuccess()){
            return ServerResponse.createByErrorMsg("Email已存在");
        }

        user.setRole(Const.Role.ROLE_CUTSOMER);

        //MD5加密之后再存入数据库
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int num=userMapper.insert(user);
        if(num==0){
            return ServerResponse.createByErrorMsg("发生错误");
        }
        return  ServerResponse.createBySuccessMsg("注册成功");
    }

    public ServerResponse<String> checkValid(int loginId,String type){
        //开始校验
        if(type.equals(Const.LOGIN_ID)){
            String regex="^[a-z0-9_-]{8}$";
            if(!String.valueOf(loginId).matches(regex)){
                return ServerResponse.createByErrorMsg("登录账号必须是数字且是8位");
            }
            int count=userMapper.checkUserLoginId(loginId);
            if(count>0){
                return ServerResponse.createByErrorMsg("用户账号已存在");
            }
        }
        return ServerResponse.createBySuccessMsg("校验成功");
    }

    public ServerResponse<String> checkValid(String str,String type){
        //开始校验
        if(type.equals(Const.EMAIL)){
            String regex="^[a-z\\d]+(\\.[a-z\\d]+)*@([\\da-z](-[\\da-z])?)+(\\.{1,2}[a-z]+)+$";
            if(!str.matches(regex)){
                return ServerResponse.createByErrorMsg("Email格式不合法");
            }
            int count=userMapper.checkEmail(str);
            if(count>0){
                return ServerResponse.createByErrorMsg("Email已存在");
            }
        }else if(type.equals(Const.USERNAME)){
            String regex="^[a-z0-9_-]{2,6}$&^[\\u2E80-\\u9FFF]+$";
            if(!str.matches(regex)){
                return ServerResponse.createByErrorMsg("用户名长度必须是2到6的中文或者英文字符");
            }
        }
        return ServerResponse.createBySuccessMsg("校验成功");
    }

    @Override
    public ServerResponse<String> selectQuestion(int loginId){
        //校验用户名的合法性
        ServerResponse validResponse=checkValid(loginId,Const.LOGIN_ID);
        if(!validResponse.isSuccess()){
            String question=userMapper.selectQuestionByloginId(loginId);
            if(StringUtils.isNotBlank(question)){
                return ServerResponse.createBySuccessMsg(question);
            }else{
                return ServerResponse.createByErrorMsg("该用户未设置找回密码问题");
            }
        }
        return ServerResponse.createByErrorMsg("用户不存在");
    }

    @Override
    public ServerResponse<String> checkAnswer(int loginId, String question, String answer) {
        int count=userMapper.checkAnswer(loginId,question,answer);
        if(count==0){
            return ServerResponse.createByErrorMsg("问题答案错误");
        }
        //正确了不会返回密码，直接返回密码不安全，可以返回一个存储在本地token，传递接口
        String forgetToken=UUID.randomUUID().toString();
        TokenCache.setKey(TokenCache.TOKEN_PREFIX+loginId,forgetToken);
        return ServerResponse.createBySuccessMsg(forgetToken);
    }

    @Override
    public ServerResponse<String> forgetResetPassword(int loginId, String passwordNew, String forgetToken) {
        if (StringUtils.isBlank(forgetToken)) {
            return ServerResponse.createByErrorMsg("token为空");
        }
        ServerResponse flag = checkValid(loginId, Const.LOGIN_ID);
        if (flag.isSuccess()) {
            return ServerResponse.createByErrorMsg("用户不存在");
        }
        String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + loginId);
        if (StringUtils.isBlank(token)) {
            return ServerResponse.createByErrorMsg("token不存在或者已失效");
        }
        if(StringUtils.equals(token,forgetToken)){
            String passwordNewMD5=MD5Util.MD5EncodeUtf8(passwordNew);
           int count = userMapper.updatePasswordWithLoginId(loginId,passwordNewMD5);
           if(count>0) {
               return ServerResponse.createBySuccessMsg("修改密码成功");
           }

        }
        return ServerResponse.createByErrorMsg("修改密码失败");
    }

    @Override
    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user) {
        passwordOld=MD5Util.MD5EncodeUtf8(passwordOld);
        User selectUser=userMapper.selectLogin(user.getLoginid(),passwordOld);
        if(selectUser==null){
            return ServerResponse.createByErrorMsg("密码输入错误");
        }else{
            String passwordNewMD5=MD5Util.MD5EncodeUtf8(passwordNew);
            userMapper.updatePasswordWithLoginId(user.getLoginid(),passwordNewMD5);
            return ServerResponse.createBySuccessMsg("修改密码成功");
        }
    }

    @Override
    public ServerResponse<String> updateInformation(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return ServerResponse.createBySuccessMsg("更新个人信息成功");
    }


}
