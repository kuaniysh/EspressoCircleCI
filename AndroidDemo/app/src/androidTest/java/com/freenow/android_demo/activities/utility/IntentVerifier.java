package com.freenow.android_demo.activities.utility;

import android.net.Uri;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static org.hamcrest.Matchers.allOf;

public class IntentVerifier {

    public static void VerifyIntentAction(String action, String data){
        intended(allOf(hasAction(action), hasData(Uri.parse(data))));
    }
}
