package com.pwd.controller.protal;

import com.pwd.common.ServerResponse;
import com.pwd.pojo.Key;
import com.pwd.service.IKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class KeyController {

    @Autowired
    IKeyService iKeyService;


}
