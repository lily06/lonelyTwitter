package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by zhi6 on 1/17/17.
 * in lab2
 */


public class ImportantTweet extends Tweet {
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant(){
        return true;
    }
}