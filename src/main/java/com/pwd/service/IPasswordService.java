package com.pwd.service;

import com.pwd.common.ServerResponse;
import com.pwd.pojo.Password;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IPasswordService {
    ServerResponse<List<Password>> getUserPasswordList(HttpSession session);
}
