package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

//import Tweet;

/**
 * Created by zhi6 on 1/17/17.
 * in lab2
 */

public class NormalTweet extends Tweet {
    public NormalTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    public NormalTweet(String message) throws TweetTooLongException {
        super(message);
    }

    public Boolean isImportant(){
        return Boolean.FALSE;
    }

}
