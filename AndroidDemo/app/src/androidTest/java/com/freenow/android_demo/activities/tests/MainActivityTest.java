package com.freenow.android_demo.activities.tests;


import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.activities.pageobjects.AuthenticationScreen;
import com.freenow.android_demo.activities.utility.IntentVerifier;
import com.freenow.android_demo.activities.utility.Utility;
import com.freenow.android_demo.models.Driver;
import com.freenow.android_demo.utils.network.HttpClient;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest extends TestBase {

    @Rule
    public IntentsTestRule<MainActivity> mActivityTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void mainActivitySearchTest() throws Exception {
        HttpClient mHttpClient = new HttpClient();

        String targetDriver = "Samantha Reed";
        Driver driver = Utility.getDriverByName(mHttpClient.fecthTestDriver(), targetDriver);

        AuthenticationScreen as = new AuthenticationScreen();

        as.LoginSuccess(mUser.getUsername(), mUser.getPassword())
                .search(targetDriver.substring(0, 2).toLowerCase()) //Look up for "sa"
                .selectSearchedItem(targetDriver) //Look up for "Samantha Reed"
                .verifyDriverInfo(driver) // Verify 3 fields (name, registered date, location ) in Driver Info Activity
                .dialDriver(); //Dial the driver

        IntentVerifier.VerifyIntentAction(Intent.ACTION_DIAL, "tel:" + driver.getPhone());
    }
}
