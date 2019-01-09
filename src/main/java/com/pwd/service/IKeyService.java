package com.pwd.service;

import com.pwd.common.ServerResponse;

public interface IKeyService {
    ServerResponse<String> createSecretKey(int keyLoginid);
}
