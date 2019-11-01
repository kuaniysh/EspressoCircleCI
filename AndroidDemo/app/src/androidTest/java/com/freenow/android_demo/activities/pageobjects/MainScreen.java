package com.freenow.android_demo.activities.pageobjects;

import androidx.test.espresso.matcher.RootMatchers;

import com.freenow.android_demo.R;
import com.freenow.android_demo.activities.utility.ViewHelper;

import org.hamcrest.Matcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class MainScreen {

    private final Matcher textSearch = withId(R.id.textSearch);
    private final Matcher toolbarMenu = withContentDescription("Open navigation drawer");
    private final Matcher nav_logout = withText("Logout");


    public boolean isMainActivityScreenDisplayed() {
        return ViewHelper.isDisplayed(textSearch);
    }

    public MainScreen verifyMainScreenIsDisplayed(){
        onView(textSearch).check(matches(isDisplayed()));
        onView(toolbarMenu).check(matches(isDisplayed()));
        return this;
    }

    public MainScreen waitUntilDisplayed() {
        ViewHelper.waitUntilDisplayed(textSearch);
        return this;
    }

    public AuthenticationScreen logout() {
        onView(toolbarMenu).perform(click());
        onView(nav_logout).perform(click());

        return new AuthenticationScreen();
    }

    public MainScreen search(String input) {
        onView(textSearch).perform(typeText(input));
        return this;
    }

    public DriverProfileScreen selectSearchedItem(String item) {
        onView(withText(item))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());

        return new DriverProfileScreen();
    }

}
