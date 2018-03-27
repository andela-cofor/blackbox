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

    // Save the user login/signIp info
    public void saveUserInfo(String username, String password) {
        SharedPreferences sharedPreferences;
        sharedPreferences = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }

    // get user information
    public boolean getUserInfo(String sharedPrefName) {
        SharedPreferences sharedPreferences;
        sharedPreferences = mContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);

        return sharedPreferences == null;
    }

}
