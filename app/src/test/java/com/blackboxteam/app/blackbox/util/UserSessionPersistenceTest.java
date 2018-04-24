package com.blackboxteam.app.blackbox.util;

import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Tests for UserSessionPersistenceClass
 */
public class UserSessionPersistenceTest {

    @Mock
    private SharedPreferences mSharedPreference;

    @Mock
    private SharedPreferences.Editor mEditor;

    private UserSessionPersistence mUserSessionPersistence;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mUserSessionPersistence = new UserSessionPersistence(mSharedPreference);
    }

    @Test
    public void isActiveUserSession_returnsTrue_whenUserLoggedIn() {
        // GIVEN that user is logged in
        Mockito.when(mSharedPreference.getBoolean(UserSessionPersistence.ACTIVE_USER_SESSION, false))
            .thenReturn(true);

        // WHEN we call mUserSessionPersistence.isActiveUserSession
        boolean result = mUserSessionPersistence.isActiveUserSession();

        // THEN assert result is true
        assertTrue(result);

        // THEN verify that result was retrieved from SharedPreference
        Mockito.verify(mSharedPreference).getBoolean(UserSessionPersistence.ACTIVE_USER_SESSION, false);
    }

    @Test
    public void isActiveUserSession_returnsFalse_whenUserNotLoggedIn() {
        // GIVEN that user is not logged in
        Mockito.when(mSharedPreference.getBoolean(UserSessionPersistence.ACTIVE_USER_SESSION, false))
            .thenReturn(false);

        // WHEN we call mUserSessionPersistence.isActiveUserSession
        boolean result = mUserSessionPersistence.isActiveUserSession();

        // THEN assert result is false
        assertFalse(result);

        // THEN verify that result was retrieved from SharedPreference
        Mockito.verify(mSharedPreference).getBoolean(UserSessionPersistence.ACTIVE_USER_SESSION, false);
    }

    @Test
    public void setActiveUserSession() {
        // GIVEN a 'UserSessionPersistence' state
        boolean isActiveUserSession = true;

        // GIVEN a SharedPreference Editor
        Mockito.when(mSharedPreference.edit()).thenReturn(mEditor);

        // WHEN we call mUserSessionPersistence.setActiveUserSession
        mUserSessionPersistence.setActiveUserSession(isActiveUserSession);

        // THEN verify that 'isActiveUserSession' is saved in SharedPreference
        Mockito.verify(mEditor).putBoolean(UserSessionPersistence.ACTIVE_USER_SESSION, isActiveUserSession);
        Mockito.verify(mEditor).apply();
    }
}