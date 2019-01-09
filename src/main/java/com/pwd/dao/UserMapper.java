package com.pwd.dao;

import com.pwd.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserLoginId(int loginId);

    User selectLogin(@Param("loginId")int loginId,@Param("password") String password);

    int checkEmail(String email);

    String selectQuestionByloginId(int loginId);

    int checkAnswer(@Param("loginId")int loginId,@Param("question")String question,@Param("answer")String answer);

    int updatePasswordWithLoginId(@Param("loginId")int loginId,@Param("password")String password);

    List<User> selectAllUsers();
}