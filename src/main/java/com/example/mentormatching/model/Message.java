/*
 * @author Aishah Qureshi aishah.s.qureshi@gmail.com | 200100227
 */

package com.company.src.main.java.com.example.mentormatching.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class Message {
    private String text;
    private LocalDate date;
    private LocalTime time;

    /*
     * Constructor
     *
     * @param  String  text
     * @return void
     */
    public Message(String text){
        this.text=text;
        this.date=LocalDate.now();
        this.time=LocalTime.now();
    }
}
