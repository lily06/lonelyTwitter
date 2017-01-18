package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by zhi6 on 1/17/17.
 * in lab2
 */

public class ImportantTweet extends Tweet{
    public ImportantTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    public ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }

    public Boolean isImportant(){
        return Boolean.TRUE;
    }

    @Override           //meant to protect from misspell of the parent....'s method
    public String getMessage(){
        return super.getMessage() + " !!!!";
    }
}
