package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by zhi6 on 1/17/17.
 */

public interface Tweetable {
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;
}