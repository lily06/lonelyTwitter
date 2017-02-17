package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

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
        NormalTweet tweet1 = new NormalTweet("2016");
        tweet1.setDate(new Date(2016,2,17));
        NormalTweet tweet2 = new NormalTweet("2017");
        tweet2.setDate(new Date(2017,2,17));
        NormalTweet tweet3 = new NormalTweet("2018");
        tweet3.setDate(new Date(2018,2,17));

        tweets.addTweet(tweet1);
        tweets.addTweet(tweet2);
        tweets.addTweet(tweet3);

        tweets.getTweets();
        if (tweets.getTweet(1).getDate().compareTo(tweets.getTweet(2).getDate()) < 0){
            assertTrue(true);
        } else assertTrue(false);
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

