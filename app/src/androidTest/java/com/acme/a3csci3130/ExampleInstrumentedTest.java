package com.acme.a3csci3130;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private DatabaseReference Firebase;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);
    private MainActivity mainActivity;


    //Clear the database
    @Before
    public void setUp() throws Exception {
        mainActivity = mActivityRule.getActivity();

        Firebase = FirebaseDatabase.getInstance().getReference("contacts");
        Firebase.removeValue();
    }


    //Tests if it can create an object
    @Test
    public void UICreating() throws Exception {
        // Context of the app under test.
        onView(withId(R.id.submitButton)).perform(click());

        Thread.sleep(1000);

        onView(withId(R.id.name)).perform(typeText("Nicholas Mingo"));
        onView(withId(R.id.businessnumber)).perform(typeText("9027592101"));
        onView(withId(R.id.pbusiness)).perform(typeText("Fisher"));
        onView(withId(R.id.address)).perform(typeText("44 seashell lane"));
        onView(withId(R.id.provence)).perform(typeText("NS"), closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());

        Thread.sleep(1000);

//        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
//        onView(withId(R.id.name)).check(matches(withText("Nicholas Mingo")));
//        onView(withId(R.id.businessnumber)).check(matches(withText("9027592101")));
//        onView(withId(R.id.pbusiness)).check(matches(withSpinnerText(containsString("Fisher"))));
//        onView(withId(R.id.address)).check(matches(withText("44 seashell lane")));
//        onView(withId(R.id.provence)).check(matches(withSpinnerText(containsString("NS"))));

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).check(matches(isDisplayed()));


    }


    //Tests if it properly displays the objects in firebase
    @Test
    public void UIReading() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());

        Thread.sleep(1000);

        onView(withId(R.id.name)).perform(typeText("Dahn Balan"));
        onView(withId(R.id.businessnumber)).perform(typeText("9021234567"));
        onView(withId(R.id.pbusiness)).perform(typeText("Distributor"));
        onView(withId(R.id.address)).perform(typeText("Halifax"));
        onView(withId(R.id.provence)).perform(typeText("BC"), closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());

        Thread.sleep(1000);

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        Thread.sleep(1000);

        onView(withId(R.id.name)).check(matches(withText("Dahn Balan")));
        onView(withId(R.id.businessnumber)).check(matches(withText("9021234567")));
        onView(withId(R.id.pbusiness)).check(matches(withText("Distributor")));
        onView(withId(R.id.address)).check(matches(withText("Halifax")));
        onView(withId(R.id.provence)).check(matches(withText("BC")));

    }


    //Tests to see if updateing feature works
    @Test
    public void UIUpdating() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());

        Thread.sleep(1000);

        onView(withId(R.id.name)).perform(typeText("Dahn Balan"));
        onView(withId(R.id.businessnumber)).perform(typeText("9021234567"));
        onView(withId(R.id.pbusiness)).perform(typeText("Distributor"));
        onView(withId(R.id.address)).perform(typeText("Halifax"));
        onView(withId(R.id.provence)).perform(typeText("BC"), closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());

        Thread.sleep(1000);

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        Thread.sleep(1000);

        onView(withId(R.id.name)).perform(replaceText("Alisha MacDonald"),closeSoftKeyboard());

        onView(withId(R.id.updateButton)).perform(click());

        Thread.sleep(1000);

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        onView(withId(R.id.name)).check(matches(withText("Alisha MacDonald")));
        onView(withId(R.id.businessnumber)).check(matches(withText("9021234567")));
        onView(withId(R.id.pbusiness)).check(matches(withText("Distributor")));
        onView(withId(R.id.address)).check(matches(withText("Halifax")));
        onView(withId(R.id.provence)).check(matches(withText("BC")));

    }


    //Tests to see if deleting function works
    @Test
    public void UIDeleting() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());

        Thread.sleep(1000);

        onView(withId(R.id.name)).perform(typeText("Nicholas Mingo"));
        onView(withId(R.id.businessnumber)).perform(typeText("9027592101"));
        onView(withId(R.id.pbusiness)).perform(typeText("Fisher"));
        onView(withId(R.id.address)).perform(typeText("44 seashell lane"));
        onView(withId(R.id.provence)).perform(typeText("NS"), closeSoftKeyboard());

        onView(withId(R.id.submitButton)).perform(click());

        Thread.sleep(1000);

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        Thread.sleep(1000);

        onView(withId(R.id.deleteButton)).perform(click());


        Thread.sleep(1000);

        onView(withId(R.id.listView)).check(matches(not(isDisplayed())));
    }
}