package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body), "Test tweet!");

        solo.clickOnButton("Save");//it will find a button with text "Save" on it

        solo.clearEditText(((EditText) solo.getView(R.id.body)));

        assertTrue(solo.waitForText("Test tweet!"));

        solo.clickOnButton("Clear");

        assertFalse(solo.searchText("Test tweet!"));
    }

    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body), "Test tweet!");

        solo.clickOnButton("Save");//it will find a button with text "Save" on it
        solo.waitForText("Test tweet!");

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("Test tweet!",tweet.getMessage());

        solo.clickInList(0);


        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);

        solo.goBack();//back button at bottom
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
    }

    public void testEditActivity(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body), "Test tweet!");

        solo.clickOnButton("Save");//it will find a button with text "Save" on it
        solo.waitForText("Test tweet!");

        solo.clickInList(0);

        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);
        assertTrue(solo.waitForText("Test tweet!"));

        solo.goBack();//back button at bottom
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

}