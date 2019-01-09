package com.pwd.service.impl;

import com.pwd.common.ServerResponse;
import com.pwd.dao.KeyMapper;
import com.pwd.service.IKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iKeyService")
public class KeyServiceImpl implements IKeyService {

    @Autowired
    KeyMapper keyMapper;

    @Override
    public ServerResponse<String> createSecretKey(int keyLoginid) {
        int count=keyMapper.selectByKeyLoginid(keyLoginid);
        if(count>0){
            return ServerResponse.createByErrorMsg("用户秘钥已存在");
        }else{

        }
        return null;
    }
}
