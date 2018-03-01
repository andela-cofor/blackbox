package com.blackboxteam.app.blackbox;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

/**
 * Test fo launch screen activity
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LaunchScreenTest {

    @Rule
    public ActivityTestRule<LaunchScreenActivity> mActivityRule = new ActivityTestRule<>(
            LaunchScreenActivity.class);

    @Test
    public void navigateToLogin() {
        // Clicks a button to navigate to login screen
        Intents.init();
        onView(withId(R.id.launchScreenLoginButton)).perform(click());
        intended(hasComponent(LoginScreenActivity.class.getName()));
        Intents.release();
    }
}
