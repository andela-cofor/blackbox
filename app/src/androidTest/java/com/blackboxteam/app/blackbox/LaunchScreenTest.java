package com.blackboxteam.app.blackbox;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.intent.Intents;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Test fo launch screen activity
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LaunchScreenTest {

    @Rule
    public ActivityTestRule<LaunchScreenActivity> mActivityRule = new ActivityTestRule<>(
            LaunchScreenActivity.class);

    @Before
    public void setup() throws Exception {
        Intents.init();
    }

    @After
    public void releaseIntents() throws Exception {
        Intents.release();
    }

    @Test
    public void navigateToLoginScreen() {
        // Clicks a button to navigate to login screen
        onView(withId(R.id.launchScreenLoginButton)).perform(click());
        intended(hasComponent(LoginScreenActivity.class.getName()));
    }

    @Test
    public void navigateToSignupScreen() {
        // Clicks a button to navigate to signup screen
        onView(withId(R.id.launchScreenSignupButton)).perform(click());
        intended(hasComponent(SignUpScreenActivity.class.getName()));
    }
}
