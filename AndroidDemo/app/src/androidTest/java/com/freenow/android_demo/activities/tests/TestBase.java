package com.freenow.android_demo.activities.tests;

import android.Manifest;

import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;

import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.activities.pageobjects.MainScreen;
import com.freenow.android_demo.models.TestUser;
import com.freenow.android_demo.utils.network.HttpClient;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;

public class TestBase {

    protected static String RANDOM_USER_SEED = "a1f30d446f820665";
    protected static TestUser mUser;

    @Rule
    public GrantPermissionRule rule = GrantPermissionRule.grant(Manifest.permission.ACCESS_FINE_LOCATION);

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @BeforeClass
    public static void beforeClass() {
        HttpClient mHttpClient = new HttpClient();
        mUser = mHttpClient.fecthTestUser(RANDOM_USER_SEED);
    }

    @Before
    public void beforeEach() {
        cleanUpApp();
    }

    protected void cleanUpApp() {
        MainScreen ms = new MainScreen();

        if (ms.isMainActivityScreenDisplayed()) {
            ms.logout();
        }
    }


}
