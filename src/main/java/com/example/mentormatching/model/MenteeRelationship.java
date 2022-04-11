package com.example.mentormatching.model;

import java.util.LinkedList;
import java.util.List;

public class MenteeRelationship {

    String creationDate;
    Mentor mentor;
    Mentee mentee;
    String requestMessage;

    private boolean connected = false;



    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public Mentee getMentee() {
        return mentee;
    }

    public void setMentee(Mentee mentee) {
        this.mentee = mentee;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }


    public void requestMentee(Mentee mentee){
        setMentee(mentee);
        // below date

    }


}
