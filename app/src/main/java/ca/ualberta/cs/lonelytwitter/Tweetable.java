/*
 * Copyright (c) 2017. TeamX, CMPUT301University of Alberta. All rights Reserved You may use,
 * distribute or modify this code under terms and conditions of Code of Student Behaviour. You can
 * find a copy of the license in this project. Otherwise, please contact contact@contact.ca.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by zhi6 on 1/17/17.
 */
public interface Tweetable {
    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Sets message.
     *
     * @param string the string
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String string) throws TweetTooLongException;
}