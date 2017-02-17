package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by zhi6 on 2/16/17.
 */

public class TweetList {
    private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();
    public void add(NormalTweet tweet){
        tweets.add(tweet);
    }
    public boolean hasTweet(NormalTweet tweet){
        // return true if there is a tweet that equals() another tweet
        return tweets.contains(tweet);
    }

    public NormalTweet getTweet(int index){
//        return new NormalTweet ("not the tweet");
        return tweets.get(index);
    }

    public void delete (NormalTweet tweet){
        tweets.remove(tweet);
    }

    //exercise
    public boolean addTweet(NormalTweet tweet){
        //throw an IllegalArgumentException when one tries to add a duplicate tweet
        if (this.hasTweet(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
            return true;
        }
    }

        //return a list of tweets in chronological order
        public void getTweets() {

            Collections.sort(tweets, new Comparator<NormalTweet>() {
                public int compare(NormalTweet tweet, NormalTweet tweet1) {
                    return tweet.getDate().compareTo(tweet1.getDate());
                }
            });
        }

    public int getCount(){
        //accurately count up the tweets
        return tweets.size();
    }
}
