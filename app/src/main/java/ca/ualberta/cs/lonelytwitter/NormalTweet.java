package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

//import Tweet;

/**
 * Created by zhi6 on 1/17/17.
 * in lab2
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant(){
        return false;
    }
}