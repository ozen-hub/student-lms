package com.devstack.lms.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordManager {
    public static String hash(String passwordText){
        return BCrypt.hashpw(passwordText, BCrypt.gensalt());
    }
}
