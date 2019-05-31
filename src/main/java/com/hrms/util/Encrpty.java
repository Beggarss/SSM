package com.hrms.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrpty {
    public static String encrptyPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 =MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String result =base64Encoder.encode(md5.digest(password.getBytes("utf-8")));
        return  result;
    }
    public static  boolean checkPassword(String inputPassword,String dbPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String result=encrptyPassword(inputPassword);
        if(result.equals(dbPassword)){
            return true;
        }else{
            return false;
        }
    }
}
