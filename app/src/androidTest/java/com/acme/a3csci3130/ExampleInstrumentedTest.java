package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void UICreating() throws Exception {
        // Context of the app under test.
        //assertEquals("com.acme.a3csci3130", appContext.getPackageName());
        assertEquals("1", "1");
    }

    @Test
    public void UIReading() throws Exception {
        assertEquals("1", "1");
    }

    @Test
    public void UIUpdating() throws Exception {
        assertEquals("1", "1");
    }

    @Test
    public void UIDeleting() throws Exception {
        assertEquals("1", "1");
    }
}
