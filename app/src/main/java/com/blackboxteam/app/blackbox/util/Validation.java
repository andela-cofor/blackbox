package com.blackboxteam.app.blackbox.util;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by andeladeveloper on 07/06/2017.
 */

public class Validation {

    public static boolean validateIfEmpty(String name) {
        return !TextUtils.isEmpty(name);
    }

    public static boolean validateMinLength(String name, int valueLength) {
        return !(name.length() < valueLength);
    }

    public static boolean validateEmail(String string) {
        return !(TextUtils.isEmpty(string) || !Patterns.EMAIL_ADDRESS.matcher(string).matches());
    }
}
