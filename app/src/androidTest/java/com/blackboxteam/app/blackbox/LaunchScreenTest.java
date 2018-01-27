package com.blackboxteam.app.blackbox;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by oforchinedu on 1/29/18.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LaunchScreenTest {

    @Rule
    public ActivityTestRule<LaunchScreenActivity> mActivityRule = new ActivityTestRule<>(
            LaunchScreenActivity.class);

//    @Rule
//    // third parameter is set to false which means the activity is not started automatically
//    public ActivityTestRule<LoginScreenActivity> rule =
//            new ActivityTestRule(LoginScresenActivity.class, true, false);

    @Test
    public void navigateToLogin() {
        // Clicks a button to navigate to login screen
        onView(withId(R.id.launchScreenLoginButton)).perform(click());

    }

}
