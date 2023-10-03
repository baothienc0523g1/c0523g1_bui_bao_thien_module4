package com.codegym.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtils {

    //method mã hóa mật khẩu
    public static String encryptingPassword(String passWord) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(passWord);
    }

}
