package com.freenow.android_demo.activities.tests;


import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.freenow.android_demo.activities.pageobjects.AuthenticationScreen;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class AuthenticationActivityTest extends TestBase {

    @Test
    public void authenticationActivityTest() {
        AuthenticationScreen as = new AuthenticationScreen();

        as.LoginSuccess(mUser.getUsername(), mUser.getPassword())
                .verifyMainScreenIsDisplayed();
    }

}
