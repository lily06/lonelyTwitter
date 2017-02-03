/*
 * Copyright (c) 2017. TeamX, CMPUT301University of Alberta. All rights Reserved You may use,
 * distribute or modify this code under terms and conditions of Code of Student Behaviour. You can
 * find a copy of the license in this project. Otherwise, please contact contact@contact.ca.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

//import Tweet;

/**
 * The type Normal tweet.
 * This class will return false to isImportant() once its called.
 * @author zhi6
 * @version 1.0
 * @see Tweet
 * @since 0.5
 */
public class NormalTweet extends Tweet {
    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message for tweet
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param date    the date
     * @param message the message
     */
    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant(){
        return false;
    }
}