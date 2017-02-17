package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

/**
 * Created by zhi6 on 2/16/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddtweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet ("some tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet ("some tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }
    public void testGetTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet ("some tweet");

        tweets.add(tweet);
        NormalTweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet ("some tweet");

        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet ("some tweet");
        tweets.addTweet(tweet);
        try {
            tweets.addTweet(tweet);
            fail();
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
    public void testGetTweets(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");
        NormalTweet tweet1 = new NormalTweet("some tweet2");

        tweets.add(tweet);
        tweets.add(tweet1);

        ArrayList<NormalTweet> rTweet = tweets.getTweets();
        assertEquals(rTweet, tweets);
    }
    public void testgetCount(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet ("some tweet");
        tweets.add(tweet);
        if (1==tweets.getCount()){
            assertTrue(true);
        }else {
            fail();
        }
    }
}

