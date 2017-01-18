package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by zhi6 on 1/17/17.
 * in lab2
 */

public abstract class Tweet implements Tweetable{ //abstact means you can't make a Tweet object but can make Tweet a super class
   // private final  setMessage;
    private Date date;
    public String message;


    public Tweet(Date date, String message) throws TweetTooLongException{
        this.date = date;
        setMessage(message);
    }

    public Tweet(String message) throws TweetTooLongException {
        setMessage(message);
        //this.setMessage(message);
        this.date = new Date(); //current time and date
    }

    public abstract Boolean isImportant();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if(message.length()>144){
            // todo throw new error here
            throw new TweetTooLongException();
        }else {
            this.message = message;
        }
    }
}
