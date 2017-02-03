/*
 * Copyright (c) 2017. TeamX, CMPUT301University of Alberta. All rights Reserved You may use,
 * distribute or modify this code under terms and conditions of Code of Student Behaviour. You can
 * find a copy of the license in this project. Otherwise, please contact contact@contact.ca.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is an abstract class of current mood.
 * This class can get/set dates.
 * Also call representMood() to get a string representation of current mood.
 * @author zhi6
 * @version 1.0
 * @since 0.5
 */
public abstract class Mood {
    private Date date;

    /**
     * Instantiates a new Mood.
     *
     * @param date the date
     */
    public Mood(Date date) {
        this.date = date;
    }

    /**
     * Instantiates a new Mood.
     */
    public Mood(){this.date = new Date();}

    /**
     * Represent mood string.
     *
     * @return the string
     */
    public abstract String representMood();

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

}