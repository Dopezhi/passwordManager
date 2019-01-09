package com.pwd.dao;

import com.pwd.pojo.User;
import com.pwd.pojo.UserManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserManager record);

    int insertSelective(UserManager record);

    UserManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserManager record);

    int updateByPrimaryKey(UserManager record);

    UserManager selectWithPwd(@Param("managerId") int managerId, @Param("managerPwd") String managerPwd);

}