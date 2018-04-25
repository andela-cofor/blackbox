package com.blackboxteam.app.blackbox.util;

import android.content.SharedPreferences;

/**
 * UserSessionPersistence
 *
 * Persists user session information
 */
public class UserSessionPersistence {
    private SharedPreferences mSharedPreferences;

    static final String ACTIVE_USER_SESSION = "ACTIVE_USER_SESSION";

    public UserSessionPersistence(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }

    /**
     * Saves the active user session
     * @param isLoggedIn boolean value to save user logged in status
     */
    public void setActiveUserSession(boolean isLoggedIn){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(ACTIVE_USER_SESSION, isLoggedIn);
        editor.apply();
    }

    /**
     * Get the active user session
     * @return boolean - returns the login status
     */
    public boolean isActiveUserSession() {
        return mSharedPreferences.getBoolean(ACTIVE_USER_SESSION, false);
    }
}
