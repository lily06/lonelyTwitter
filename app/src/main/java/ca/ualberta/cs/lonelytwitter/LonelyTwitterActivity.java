package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<Tweet> adapter;
	private ArrayList<Tweet> tweetList;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

////in lab thursday


		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();
//				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();

			}
		});
	}
////		in lab thursday


//		in lab tuesday
//		try {
//			Tweet tweet = new NormalTweet("First tweet"); //(error after abstract),error gone after make Tweet to Normal Tweet
//			tweet.setMessage("sdfsdfsfsdfs");
//			ImportantTweet importantTweet = new ImportantTweet ("gsggdsg");
//			importantTweet.getDate();
//
//			NormalTweet normalTweet = new NormalTweet ("im normal");
//
//			ArrayList<Tweet> arrayList = new ArrayList<Tweet>();
//			arrayList.add(tweet);
//			arrayList.add((Tweet) importantTweet);
//			arrayList.add(normalTweet);
//			if (tweet.isImportant()){
//				tweet.setMessage("better string");
//			}
//
//

//		} catch (TweetTooLongException e) {
//			e.printStackTrace();
//		}
		// Tweet tweet2 = new Tweet(new Date(), "My second tweet");
// in lab
//		saveButton.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//				setResult(RESULT_OK);
//				String text = bodyText.getText().toString();
//				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();
//
//			}
//		});
//	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();

		//tweetList = new ArrayList<Tweet>();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			//Take from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylist
			//2017-01-24 18:19
			Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();
			tweetList = gson.fromJson(in,new TypeToken<ArrayList<Tweet>>(){}.getType());

		} catch (FileNotFoundException e) {
			// TODO: Handle the exception later
			tweetList = new ArrayList<Tweet>();
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO: Handle the exception later
			throw new RuntimeException();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO: Handle the exception later
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}