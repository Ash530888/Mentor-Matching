package com.example.mentormatching.model;

import java.time.LocalDate;

public class Message {


    private String who;
    private String message;
    private String date;


    public Message(String who, String message) {
        this.who = who;
        this.message = message;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
