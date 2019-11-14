package com.example.lifewirehours;


import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoMainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void espressoMainActivityTest() {

        /*
         * Check instantiation of the application and UI elements.
         */

        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.calcButton), withText("Calculate"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView2), withText("Be Positive! Be Generous!"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        textView2.check(matches(withText("Be Positive! Be Generous!")));

        ViewInteraction button = onView(
                allOf(withId(R.id.calcButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction view = onView(
                allOf(withId(R.id.action_bar),
                        childAtPosition(
                                allOf(withId(R.id.action_bar_container),
                                        childAtPosition(
                                                withId(R.id.decor_content_parent),
                                                0)),
                                0),
                        isDisplayed()));
        view.check(matches(isDisplayed()));

        String texCheck = "@string/display_Hours";

        onView(withId(R.id.displayHours)).check(matches(isDisplayed()));
        onView(withId(R.id.editText))
                .check(matches(withText(texCheck)))
                .check(matches(isDisplayed()));
        onView(withId(R.id.userYears)).check(matches(isDisplayed()));
        onView(withId(R.id.userAge)).check(matches(isDisplayed()));
        onView(withId(R.id.outputText)).check(matches(withText("")));
        onView(withId(R.id.calcButton)).check(matches(isDisplayed()));
        onView(withId(R.id.textView2))
                .check(matches(withText("@string/be_positive_be_generous")))
                .check(matches(isDisplayed()));


        /*
         * The second test checks the user input of years entered Assertion == integers only
         * Then String ABC
         */

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.userYears),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.userYears),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.calcButton), withText("Calculate"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.userYears), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("202"));

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.userYears), withText("202"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());



        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.userYears), withText("202"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText5.perform(longClick());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.userYears),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText21.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.userYears), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText20.perform(click());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.userYears), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText19.perform(replaceText("69"));

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.userYears), withText("69"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText18.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.userYears), withText("69"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText17.perform(click());
        appCompatEditText17.perform(replaceText("ABC"));
        appCompatEditText17.perform(closeSoftKeyboard());

        // Click Calculate button to execute code and logic conversion
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.calcButton), withText("Calculate"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.userYears), withText("123"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        for (int i = 1; i <= 15; i++ ){

            int randInt = (int) Math.random()*(500 - 1);
            String randomInt = String.valueOf(randInt);

            ViewInteraction appCompatEditText80 = onView(
                    allOf(withId(R.id.userYears),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    3),
                            isDisplayed()));
            appCompatEditText80.perform(replaceText(randomInt));

            ViewInteraction appCompatButton40 = onView(
                    allOf(withId(R.id.calcButton), withText("Calculate"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0),
                                    0),
                            isDisplayed()));
            appCompatButton40.perform(click());

            appCompatEditText8.perform(pressImeActionButton());
        }

        /*
        * Test User Age inputs to all conform to the type int.
        * */
        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.userAge),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("20"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.userAge), withText("20"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText10.perform(pressImeActionButton());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.userAge), withText("20"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText11.perform(click());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.userAge), withText("20"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("25"));

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.userAge), withText("25"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText13.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.userAge), withText("25"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText14.perform(pressImeActionButton());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.userAge), withText("25"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText15.perform(longClick());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.userAge), withText("25"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText16.perform(longClick());

        ViewInteraction appCompatEditText43 = onView(
                allOf(withId(R.id.userAge), withText("25"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText43.perform(replaceText("30"));

        ViewInteraction appCompatEditText44 = onView(
                allOf(withId(R.id.userAge), withText("30"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText44.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText45 = onView(
                allOf(withId(R.id.userAge), withText("30"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText45.perform(pressImeActionButton());

        ViewInteraction appCompatEditText40 = onView(
                allOf(withId(R.id.userYears), withText("123"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText40.perform(replaceText("1"));

        ViewInteraction appCompatEditText41 = onView(
                allOf(withId(R.id.userYears), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText41.perform(closeSoftKeyboard());

        pressBack();


        /*
         To test that User age is saved across multiple user sessions, and displayed when app starts.
         We relaunch the app,
         */
        String ageTest = "30";

        onView(withId(R.id.userAge)).perform((typeText(ageTest)));

        mActivityTestRule.getActivity().finish();
        mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

        onView(withId(R.id.userAge)).check(matches(withText(ageTest)));


        /*
        Test Toast pop up notification message Messages
        */
        onView(withText(R.string.toast_text)).inRoot(withDecorView(not(mActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));

        /*
        Test Message strings displayed on screen depending on Logic
        */

        ViewInteraction textView = onView(
                allOf(withId(R.id.outputText), withText("You've got hours! Remember to live a little. 30 is still young, but make the seconds count!"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        textView.check(matches(withText("You've got hours! Remember to live a little. 30 is still young, but make the seconds count!")));


        /*
        * Change screen orientation.
        * */
        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);




    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
