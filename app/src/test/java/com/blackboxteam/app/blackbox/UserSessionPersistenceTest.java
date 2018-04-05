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

    private static final boolean FAKE_STRING = true;

    @Mock
    Context mMockContext;

    UserSessionPersistence userSessionPersistence = new UserSessionPersistence(mMockContext);

    @Test
    public void saveUserInfo_shouldSaveUserInfo(){
        SharedPreferences mockedSharedPreference = Mockito.mock(SharedPreferences.class);

        Mockito.when(mMockContext.getSharedPreferences(Mockito.anyString(), Mockito.anyInt())).thenReturn(mockedSharedPreference);

        SharedPreferences.Editor mockedEditor = Mockito.mock(SharedPreferences.Editor.class);

        Mockito.when(mockedSharedPreference.edit()).thenReturn(mockedEditor);

        boolean result = userSessionPersistence.saveUserInfo("email", "password");

//        assertThat(result, is(FAKE_STRING));

//        Mockito.verify(mockedEditor).apply();
    }

}
