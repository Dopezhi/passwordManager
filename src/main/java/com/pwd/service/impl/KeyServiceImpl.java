package com.pwd.service.impl;

import com.pwd.common.ServerResponse;
import com.pwd.dao.KeyMapper;
import com.pwd.service.IKeyService;
import com.pwd.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pwd.util.MD5Util;
import com.pwd.pojo.Key;

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
            String uuid=UUIDUtil.getUUID();
            String uuidMD5=MD5Util.MD5EncodeUtf8(uuid);
            keyMapper.insertSelective(new Key(keyLoginid,uuidMD5));
            return ServerResponse.createBySuccessMsg("添加秘钥成功");
        }

    }
}
