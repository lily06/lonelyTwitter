package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String str = extras.getString("tweet");
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(str);
        }
    }
}
