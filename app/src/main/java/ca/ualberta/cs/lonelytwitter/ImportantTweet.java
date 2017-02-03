/*
 * Copyright (c) 2017. TeamX, CMPUT301University of Alberta. All rights Reserved You may use,
 * distribute or modify this code under terms and conditions of Code of Student Behaviour. You can
 * find a copy of the license in this project. Otherwise, please contact contact@contact.ca.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is a tweet type important tweet.
 * This class will return true to isImportant() once its called.
 * @author zhi6
 * @version 1.0
 * @see Tweet
 * @since 0.5
 */

public class ImportantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param date    the date
     * @param message the message
     */
    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant(){
        return true;
    }
}