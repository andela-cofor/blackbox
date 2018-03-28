package com.blackboxteam.app.blackbox;

import android.support.test.espresso.intent.Intents;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * Test for sign up screen activity
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SignUpScreenActivityTest {

    @Rule
    public ActivityTestRule<SignUpScreenActivity> mActivityRule = new ActivityTestRule<>(
            SignUpScreenActivity.class);

    @Before
    public void setup() throws Exception {
        Intents.init();
    }

    @After
    public void releaseIntents() throws Exception {
        Intents.release();
    }

    @Test
    public void goToLaunchScreenOnBackButtonPress() {
        pressBack();
        intended(hasComponent(LaunchScreenActivity.class.getName()));
    }
}
