package com.freenow.android_demo.activities.pageobjects;


import com.freenow.android_demo.R;

import org.hamcrest.Matcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class AuthenticationScreen {

    private final Matcher edt_username = withId(R.id.edt_username);
    private final Matcher edt_password = withId(R.id.edt_password);
    private final Matcher btn_login = withId(R.id.btn_login);

    public AuthenticationScreen() {
    }

    private void performLogin(String username, String password) {
        onView(edt_username).perform(typeText(username));
        onView(edt_password).perform(typeText(password));
        onView(btn_login).perform(click());
    }

    public AuthenticationScreen LoginExpectingError(String username, String password) {
        performLogin(username, password);
        return this;
    }

    public MainScreen LoginSuccess(String username, String password) {
        performLogin(username, password);
        MainScreen ms = new MainScreen();
        ms.waitUntilDisplayed();
        return ms;
    }

}
