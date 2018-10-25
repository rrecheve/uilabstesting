package es.unex.giiis.asee.uilabs_m;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITest {

    @Rule
    public ActivityTestRule<ToDoManagerActivity> mActivityRule =
            new ActivityTestRule<>(ToDoManagerActivity.class);


    @Test
    public void shouldAddToDoItemToRecyclerView(){
        String testingString = "Test Text";
        // Perform a click() action on R.id.fab
        onView(withId(R.id.fab)).perform(click());
        // Perform typeText() and closeSoftKeyboard() actions on R.id.title
        onView(withId(R.id.title)).perform(typeText(testingString), closeSoftKeyboard());
        //TODO - Perform a click() action on R.id.submitButton

        // Check that R.id.my_recycler_view hasDescendant withId R.id.titleView
        onView(withId(R.id.my_recycler_view)).check(matches(hasDescendant(withId(R.id.titleView))));
        //TODO - Check that R.id.my_recycler_view hasDescendant with the input text

        // Check that R.id.my_recycler_view hasDescendant withId R.id.statusCheckBox
        onView(withId(R.id.my_recycler_view)).check(matches(hasDescendant(withId(R.id.statusCheckBox))));
        // Open Contextual Action Mode Overflow Menu
        openContextualActionModeOverflowMenu();
        //TODO - Perform a click() action on the view withText "Delete all" (Should be a R.string.* reference)
        
    }
}
