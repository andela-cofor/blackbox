package com.blackboxteam.app.blackbox.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * UserSessionPersistence
 *
 * Manages user session
 */
public class UserSessionPersistence {
    private Context mContext;
    private SharedPreferences sharedPreferences;

    private static final String USER_EMAIL = "USER_EMAILE";
    private static final String USER_PAAWORD = "USER_EMAILE";

    public UserSessionPersistence(Context context) {
        mContext = context;
    }

    // Save the user login/signIp info
    public boolean saveUserInfo(String email, String password) {
        sharedPreferences = mContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_EMAIL, email);
        editor.putString(USER_PAAWORD, password);
        return editor.commit();
    }

    // returns user login status
    public boolean checkLoginStatus(String sharedPrefName) {
        sharedPreferences = mContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);

        return sharedPreferences != null;
    }

}
