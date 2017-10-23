package com.blackboxteam.app.blackbox.util;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chineduofor on 18/10/2017.
 */

public class Validation {

    public static boolean validateIfEmpty(String name) {
        if (TextUtils.isEmpty(name)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validateMinLength(String name, int valueLength) {
        if (name.length() < valueLength) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validateEmail(String string) {
        if (TextUtils.isEmpty(string) || !Patterns.EMAIL_ADDRESS.matcher(string).matches()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validateSpecialCharacters(String password) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }
}
