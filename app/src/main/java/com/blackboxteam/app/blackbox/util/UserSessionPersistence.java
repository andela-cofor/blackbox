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
    public void saveUserInfo(String username, String password) {
        sharedPreferences = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", username);
        editor.putString("password", password);
        editor.apply();
    }

    // get user information
    public boolean checkLoginStatus(String sharedPrefName) {
        sharedPreferences = mContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);

        boolean isEmailEmpty = sharedPreferences.getString("email", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("Password", "").isEmpty();

        return isEmailEmpty || isPasswordEmpty;
    }

}
