package com.freenow.android_demo.activities.pageobjects;

import com.freenow.android_demo.R;
import com.freenow.android_demo.activities.utility.ViewHelper;
import com.freenow.android_demo.models.Driver;

import org.hamcrest.Matcher;

import java.text.SimpleDateFormat;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class DriverProfileScreen {

    private final Matcher textViewDriverName = withId(R.id.textViewDriverName);
    private final Matcher textViewDriverDate = withId(R.id.textViewDriverDate);
    private final Matcher textViewDriverLocation = withId(R.id.textViewDriverLocation);
    private final Matcher fab = withId(R.id.fab);

    public DriverProfileScreen waitUntilDisplayed() {
        ViewHelper.waitUntilDisplayed(textViewDriverName);
        return this;
    }

    public boolean isDriverProfileScreenDisplayed() {
        return ViewHelper.isDisplayed(textViewDriverName);
    }

    public DriverProfileScreen verifyDriverInfo(Driver driver) {
        onView(textViewDriverName).check(matches(withText(driver.getName())));
        onView(textViewDriverDate).check(matches(withText(new SimpleDateFormat("yyyy-MM-dd").format(driver.getRegisteredDate()))));
        onView(textViewDriverLocation).check(matches(withText(driver.getLocation())));
        return this;
    }

    public void dialDriver() {
        onView(fab).perform(click());
    }

}
