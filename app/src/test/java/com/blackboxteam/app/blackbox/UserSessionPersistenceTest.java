package com.blackboxteam.app.blackbox;

import android.content.Context;
import android.content.SharedPreferences;

import com.blackboxteam.app.blackbox.util.UserSessionPersistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for UserSessionPersistenceClass
 */
@RunWith(MockitoJUnitRunner.class)
public class UserSessionPersistenceTest {

    private UserSessionPersistence mMockUserSessionPersistence;

    @Mock
    Context mMockContext;

    UserSessionPersistence userSessionPersistence = new UserSessionPersistence(mMockContext);


    @Test
    public void saveUserInfo_shouldSaveUserInfo(){
        SharedPreferences mockedSharedPreference = Mockito.mock(SharedPreferences.class);

        Mockito.when(mMockContext.getSharedPreferences("userInfo", Context.MODE_PRIVATE)).thenReturn(mockedSharedPreference);

        SharedPreferences.Editor mockedEditor = Mockito.mock(SharedPreferences.Editor.class);

        Mockito.when(mockedSharedPreference.edit()).thenReturn(mockedEditor);

        boolean success =
                mMockUserSessionPersistence.saveUserInfo("email", "password");
        assertThat( success,
                is(true));

//        userSessionPersistence.saveUserInfo("email", "password");

//        Mockito.verify(mockedEditor).commit();
        return new mMockUserSessionPersistence(mockedSharedPreference);


    }

}
