package com.blackboxteam.app.blackbox;

import android.content.Context;
import android.content.SharedPreferences;

import com.blackboxteam.app.blackbox.util.UserSessionPersistence;
import com.blackboxteam.app.blackbox.util.UserSessionPersistenceEntry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

/**
 * Tests for UserSessionPersistenceClass
 */
@RunWith(MockitoJUnitRunner.class)
public class UserSessionPersistenceTest {

    private static final String TEST_TOEKN = "abcdef";
    private static final String TEST_EMAIL = "test@email.com";

    private UserSessionPersistenceEntry mUserSessionPersistenceEntry;
    private UserSessionPersistence mMockUserSessionPersistence;
    private UserSessionPersistence mMockUserSessionPersistenceWithBrokenSharedPreference;
    private UserSessionPersistence mMockUserSessionPersistenceNoPassedSharedPreference;

    @Mock
    private SharedPreferences mMockSharedPreferences;

    @Mock
    private SharedPreferences mMockBrokenSharedPreferences;

    @Mock
    private SharedPreferences.Editor mMockEditor;

    @Mock
    private SharedPreferences.Editor mMockBrokenEditor;

    @Mock
    private Context mMockContext;


    @Before
    public void setup() {
        mUserSessionPersistenceEntry = new UserSessionPersistenceEntry(TEST_EMAIL, TEST_TOEKN);
        mMockUserSessionPersistenceNoPassedSharedPreference = createMockedUserSessionPersistenceNoPassedSharedPreference();
        mMockUserSessionPersistence = createMockSharedPreference();
        mMockUserSessionPersistenceWithBrokenSharedPreference = createBrokenMockSharedPreference();
    }

    @Test
    public void userSessionPersistence_SaveAndReadUserInfo() {
        // Save the personal information to SharedPreferences
        boolean success = mMockUserSessionPersistence.saveUserInfo(mUserSessionPersistenceEntry);

        assertThat("Checking that SharedPreferenceEntry.save... returns true",
                success, is(true));

        // Read user info from SharedPreferences
        UserSessionPersistenceEntry savedUserSessionPersistenceEntry =
                mMockUserSessionPersistence.getUserInfo();

        // Make sure both written and retrieved personal information are equal.
        assertThat("Checking that UserSessionPersistenceEntry.token has been persisted and read correctly",
                mUserSessionPersistenceEntry.getToken(),
                is(equalTo(savedUserSessionPersistenceEntry.getToken())));
        assertThat("Checking that UserSessionPersistenceEntry.email has been persisted and read "
                        + "correctly",
                mUserSessionPersistenceEntry.getEmail(),
                is(equalTo(savedUserSessionPersistenceEntry.getEmail())));
    }

    @Test
    public void userSessionPersistence_SaveUserInfoFailed_ReturnsFalse() {
        // Read user info from a broken SharedPreferencesHelper
        boolean success =
                mMockUserSessionPersistenceWithBrokenSharedPreference.saveUserInfo(mUserSessionPersistenceEntry);
        assertThat("Makes sure writing to a broken SharedPreferencesHelper returns false", success,
                is(false));
    }

    /**
     * Mock UserSessionPersistence when SharedPreferences not passed in constructor
     */
    private UserSessionPersistence createMockedUserSessionPersistenceNoPassedSharedPreference() {
        mMockSharedPreferences = Mockito.mock(SharedPreferences.class);
        mMockContext = Mockito.mock(Context.class);
        Mockito.when(mMockContext.getSharedPreferences(anyString(), anyInt())).thenReturn(mMockSharedPreferences);

        return new UserSessionPersistence(mMockContext);
    }

    /**
     * Creates a mocked SharedPreferences.
     */
    private UserSessionPersistence createMockSharedPreference() {
        mMockContext = Mockito.mock(Context.class);
        // Mocking reading the SharedPreferences as if mMockSharedPreferences was previously written
        // correctly.
        Mockito.when(mMockSharedPreferences.getString(eq(UserSessionPersistence.USER_EMAIL), anyString()))
                .thenReturn(mUserSessionPersistenceEntry.getEmail());
        Mockito.when(mMockSharedPreferences.getString(eq(UserSessionPersistence.USER_TOKEN), anyString()))
                .thenReturn(mUserSessionPersistenceEntry.getToken());

        // Mocking a successful commit.
        Mockito.when(mMockEditor.commit()).thenReturn(true);

        // Return the MockEditor when requesting it.
        Mockito.when(mMockSharedPreferences.edit()).thenReturn(mMockEditor);
        return new UserSessionPersistence(mMockContext, mMockSharedPreferences);
    }

    /**
     * Creates a mocked SharedPreferences that fails when writing.
     */
    private UserSessionPersistence createBrokenMockSharedPreference() {
        mMockContext = Mockito.mock(Context.class);
        // Mocking a commit that fails.
        Mockito.when(mMockBrokenEditor.commit()).thenReturn(false);

        // Return the broken MockEditor when requesting it.
        Mockito.when(mMockBrokenSharedPreferences.edit()).thenReturn(mMockBrokenEditor);
        return new UserSessionPersistence(mMockContext, mMockBrokenSharedPreferences);
    }

}