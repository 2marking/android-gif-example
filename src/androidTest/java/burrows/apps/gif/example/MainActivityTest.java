package burrows.apps.gif.example;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import burrows.apps.gif.example.ui.activity.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.Thread.sleep;

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
  @Rule public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

  @Test public void testLoadTrendingCache() throws InterruptedException {
    onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));

    // Wait for the internet
    sleep(2000);
  }

  @Test public void testLoadTrendingClickOpenDialog() {
    onView(withId(R.id.recycler_view))
      .check(matches(isDisplayed()))
      .perform(actionOnItemAtPosition(0, click()));

    // Make sure dialog view is displayed
    onView(withId(R.id.gif_dialog_image)).check(matches(isDisplayed()));
  }

  @Test public void testLoadSearchResults() {
    onView(withId(R.id.menu_search)).perform(click());
    // App Compat SearchView widget does not use the same id as in the regular
    // android.widget.SearchView. R.id.search_src_text is the id created by appcompat
    // search widget.
    onView(withId(R.id.search_src_text)).perform(typeText("cat"), ViewActions.closeSoftKeyboard());

    onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
  }

  @Test public void testLoadSearchResultsClickOpenDialog() {
    onView(withId(R.id.menu_search)).perform(click());
    // App Compat SearchView widget does not use the same id as in the regular
    // android.widget.SearchView. R.id.search_src_text is the id created by appcompat
    // search widget.
    onView(withId(R.id.search_src_text)).perform(typeText("cat"), ViewActions.closeSoftKeyboard());

    onView(withId(R.id.recycler_view))
      .check(matches(isDisplayed()))
      .perform(actionOnItemAtPosition(0, click()));

    // Make sure dialog view is displayed
    onView(withId(R.id.gif_dialog_image)).check(matches(isDisplayed()));
  }

  @Test public void testLoadTrendingThenSearchThenBackToTrending() {
    onView(withId(R.id.menu_search)).perform(click());
    // App Compat SearchView widget does not use the same id as in the regular
    // android.widget.SearchView. R.id.search_src_text is the id created by appcompat
    // search widget.
    onView(withId(R.id.search_src_text)).perform(typeText("dog"), ViewActions.closeSoftKeyboard());

    // Go back to trending screen
    pressBack();

    onView(withId(R.id.search_close_btn)).perform(click());

    closeSoftKeyboard();

    onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
  }
}
