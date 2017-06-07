package com.blackboxteam.app.blackbox.util;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by andeladeveloper on 07/06/2017.
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
}
