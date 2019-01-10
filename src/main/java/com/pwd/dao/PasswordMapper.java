package com.pwd.dao;

import com.pwd.pojo.Password;

import java.util.List;

public interface PasswordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Password record);

    int insertSelective(Password record);

    Password selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Password record);

    int updateByPrimaryKey(Password record);

    List<Password> selectAllPassword(int loginId);
}