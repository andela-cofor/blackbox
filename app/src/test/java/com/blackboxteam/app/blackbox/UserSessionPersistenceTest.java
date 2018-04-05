package com.blackboxteam.app.blackbox;

import android.content.Context;
import android.content.SharedPreferences;

import com.blackboxteam.app.blackbox.util.UserSessionPersistence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Tests for UserSessionPersistenceClass
 */
@RunWith(MockitoJUnitRunner.class)
public class UserSessionPersistenceTest {

    private UserSessionPersistence mMockUserSessionPersistence;

    @Mock
    Context mMockContext;

    SharedPreferences mockedSharedPreference;

    SharedPreferences.Editor mockedEditor = Mockito.mock(SharedPreferences.Editor.class);


    @Before
    public void setup() {
        mockedSharedPreference = Mockito.mock(SharedPreferences.class);
        mMockUserSessionPersistence = new UserSessionPersistence(mMockContext);
    }

    @Test
    public void saveUserInfo_shouldSaveUserInfo(){

        Mockito.when(mMockContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE)).thenReturn(mockedSharedPreference);

        Mockito.when(mockedSharedPreference.edit()).thenReturn(mockedEditor);

        mMockUserSessionPersistence.saveUserInfo("email", "password");

        Mockito.verify(mockedEditor).commit();
    }

}