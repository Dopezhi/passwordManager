package com.pwd.service;

import com.pwd.common.ServerResponse;
import com.pwd.pojo.User;

public interface IUserService {
    ServerResponse<User> login(int loginId, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> selectQuestion(int loginId);
    ServerResponse<String> checkAnswer(int loginId,String question,String answer);
    ServerResponse<String> forgetResetPassword(int loginId,String passwordNew,String forgetToken);
    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);
    ServerResponse<String> updateInformation(User user);
    ServerResponse<String> checkValid(int loginId,String type);
    ServerResponse<String> checkValid(String str,String type);

}
