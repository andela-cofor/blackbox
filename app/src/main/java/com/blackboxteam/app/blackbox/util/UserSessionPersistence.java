package com.blackboxteam.app.blackbox.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * UserSessionPersistence
 *
 * Manages user session
 */
public class UserSessionPersistence {
    private Context mContext;
    private String user;
    private SharedPreferences sharedPreferences;

    public UserSessionPersistence(Context context) {
        mContext = context;
    }

    // Save the user login/signIp info
    public void saveUserInfo(String email, String password) {
        sharedPreferences = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }

    // returns user login status
    public boolean checkLoginStatus(String sharedPrefName) {
        sharedPreferences = mContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);

        return sharedPreferences == null;
    }

    // returns user email
    public String getEmail(String sharedPrefName) {
        sharedPreferences = mContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);

        String isEmailEmpty = sharedPreferences.getString("email", "");

        return isEmailEmpty;
    }

    // returns user password
    public String getPassword(String sharedPrefName) {
        sharedPreferences = mContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);

        String isPasswordEmpty = sharedPreferences.getString("password", "");

        return isPasswordEmpty;
    }

}
