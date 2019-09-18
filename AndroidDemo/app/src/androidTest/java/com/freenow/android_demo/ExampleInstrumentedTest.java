package com.freenow.android_demo;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.os.SystemClock;
import android.support.design.internal.NavigationMenuItemView;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.view.View;
import android.widget.ListView;

import com.freenow.android_demo.activities.AuthenticationActivity;
import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.adapters.DriverAdapter;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.freenow.android_demo", appContext.getPackageName());
    }

    @Test
    public void testLogin() throws InterruptedException {
        onView(allOf(withId(R.id.edt_username))).perform(typeText("crazydog335"));
        onView(allOf(withId(R.id.edt_password))).perform(typeText("venture"));
        onView(allOf(withId(R.id.btn_login))).perform(click());
        SystemClock.sleep(1000);


        // to ensure login is success
        onView(allOf(withId(R.id.textSearch))).check(matches(isDisplayed()));
        // searching text
        onView(allOf(withId(R.id.textSearch))).perform(typeText("sa"));


        SystemClock.sleep(1000);

        onView(withText("Sarah Scott")).inRoot(RootMatchers.isPlatformPopup()).perform(click());

        Espresso.pressBack();
        SystemClock.sleep(500);
        onView(allOf(withId(R.id.toolbar))).check(matches(isDisplayed()));
        onView(withContentDescription("Open navigation drawer")).perform(click());
        SystemClock.sleep(1000);

      /*  onData(allOf(is(instanceOf(LauncherActivity.ListItem.class)), (containsString("s"))))
                .inAdapterView(allOf(isAssignableFrom(ListView.class), withId(R.id.textSearch)))
                .perform(click());*/

    }


}
