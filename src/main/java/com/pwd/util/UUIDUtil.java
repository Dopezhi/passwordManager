package com.pwd.util;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().substring(0,8);
    }

//    private static String createUUID(){
//        String str=UUID.randomUUID().toString().substring(0,8);
//    }
}
