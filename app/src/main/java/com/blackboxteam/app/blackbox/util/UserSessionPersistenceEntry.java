package com.blackboxteam.app.blackbox.util;

/**
 * Created by emmanuelshaibu on 23/04/2018.
 *
 * Model class containing user information that will be saved to SharedPreferences.
 */

public class UserSessionPersistenceEntry {

    private String email;
    private String token;

    public UserSessionPersistenceEntry(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}
