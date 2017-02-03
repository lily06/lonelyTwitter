
/*
 * Copyright (c) 2017. TeamX, CMPUT301University of Alberta. All rights Reserved You may use,
 * distribute or modify this code under terms and conditions of Code of Student Behaviour. You can
 * find a copy of the license in this project. Otherwise, please contact contact@contact.ca.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by zhi6 on 1/17/17.
 * in lab2
 * Tweet class is a super class that implements Tweetable.
 */
public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param date    the date
     * @param message the message
     */
    public Tweet(Date date, String message){
        this.message = message;
        this.date = date;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

    @Override
    public String toString(){
        return date.toString() +" | " + message;
    }
}