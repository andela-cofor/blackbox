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
    private SharedPreferences mSharedPreferences;

    public static final String USER_EMAIL = "USER_EMAIL";
    public static final String USER_TOKEN = "USER_TOKEN";
    static final String LOGGED_USER_PREFERENCES = "USER_INFO";

    public UserSessionPersistence(Context context) {
        this.mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(LOGGED_USER_PREFERENCES, Context.MODE_PRIVATE);
    }

    public UserSessionPersistence(Context context, SharedPreferences sharedPreferences) {
        this.mContext = context;
        this.mSharedPreferences = sharedPreferences;
    }

    /**
     * Saves the given user info to SharedPreference
     * @param userSessionPersistenceEntry contains data to save
     * @return boolean
     */
    public boolean saveUserInfo(UserSessionPersistenceEntry userSessionPersistenceEntry) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(USER_EMAIL, userSessionPersistenceEntry.getEmail());
        editor.putString(USER_TOKEN, userSessionPersistenceEntry.getToken());
        return editor.commit();
    }

    /**
     * Retrieves the UserSessionPersistenceEntry containing the user information
     * @return the retrieved UserSessionPersistenceEntry
     */
    public UserSessionPersistenceEntry getUserInfo() {
        String email = mSharedPreferences.getString(USER_EMAIL, "");
        String token = mSharedPreferences.getString(USER_TOKEN, "");

        return new UserSessionPersistenceEntry(email, token);
    }

}
