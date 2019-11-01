package com.freenow.android_demo.activities.utility;

import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

public class ViewHelper {

    private static long VIEW_TIMEOUT = 10000;

    public static boolean isDisplayed(Matcher matcher) {
        try {
            onView(matcher).check(matches(ViewMatchers.isDisplayed()));
        } catch (Exception ex) {
            return false;
        }

        return true;
    }


    public static void waitUntilDisplayed(Matcher matcher) {

        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < VIEW_TIMEOUT) {
            if (isDisplayed(matcher)) {
                return;
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

