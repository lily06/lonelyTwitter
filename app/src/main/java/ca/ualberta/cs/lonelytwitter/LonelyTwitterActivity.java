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

/**
 * This class is the main view class of the project. <br> In this class, user interaction
 * and file manipulation is performed.
 *
 * All files are in the form of "json" files that are stored in Emulator's accessible from Android Device Monitor
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data -> ca.ualberta.cs.lonelytwitter -> files ->file.sav
 * </pre>
 * <code> begin <br>
 * some pseudo code <br>
 * end.</code>
 * The file name is indicated in the &nbsp &nbsp FILENAME constant.
 * <ul>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 *
 * </ul>
 *
 * <ol>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 *
 * </ol>
 *
 * 	@author zhi6
 * 	@version 1.0
 * 	@see Tweet
 * 	@since 0.5
 */

public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweets are saved here. The format of the file is JSON
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */
	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING, TEXT_DESCENDING};
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayAdapter<Tweet> adapter;
	private ArrayList<Tweet> tweetList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		Button clearButton = (Button) findViewById(R.id.clear);

////in lab thursday

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				text = trimExtraSpaces(text);

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}
////		in lab thursday

//-------------------------------
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

	/**
	 * Trims extre spaces using regular expression.
	 * @param inputString string that needs to be cleared for extra spaces
	 * @return resulting string
     */
	private String trimExtraSpaces(String inputString){
		inputString = inputString.replaceAll("\\s+"," "); //if spaces one or more, replace with one space
		return inputString;
	}

	/**
	 * This method sorts items in the tweet list and refreshed the adapter.
	 * @param ordering ordering to be used
     */
	private void sortTweetListItems(TweetListOrdering ordering){

	}

	/**
	 * Loads tweets from specified file.
	 *
	 * @throws TweetTooLongException if the text is too long.
	 * @exception FileNotFoundException if the file is not created first.
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson(); //new Gson to operate the Json format

			//Take from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			//2017-01-24 18:19
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in,listType);//type is ArrayList<Tweet> but cannot use this so we have to google&include the previous
													//typetoken line

		} catch (FileNotFoundException e) {
			// TODO: Handle the exception later
			tweetList = new ArrayList<Tweet>();//extensiate the tweet list here if there is not load file exist
			// throw new RuntimeException();
		} catch (IOException e) {
			// TODO: Handle the exception later
			throw new RuntimeException();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * Saves tweets to a specified file in JSON format.
	 * @throws FileNotFoundException if file folder doesn't exist
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);//means this file is not accesible to other file, also means this file is over writing the original file

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();//new Gson object
			gson.toJson(tweetList, out);//convert the object to Json text, and update the writer; so that the writer can overwrite the file
			out.flush();//flush the writer so that it is actually writing to the file instead the buffer
			fos.close();//close the file so the file is saved properly(???)
		} catch (FileNotFoundException e) {
			// TODO: Handle the exception later
			throw new RuntimeException(); //stop the process
		} catch (IOException e) {
			throw new RuntimeException(); //stop app from running
		}
	}
}