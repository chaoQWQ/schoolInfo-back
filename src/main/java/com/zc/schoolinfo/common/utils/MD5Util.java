package com.zc.schoolinfo.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description TODO
 * @Author zc
 * @Date 2019/4/19 16:04
 * @Version 1.0
 **/
public class MD5Util {
    public static String MD5EncodeWithSalt(String credentials,String salt) {
        String hashAlgorithmName = "MD5";
        int hashIterations = 1;
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        return obj.toString();
    }
}
