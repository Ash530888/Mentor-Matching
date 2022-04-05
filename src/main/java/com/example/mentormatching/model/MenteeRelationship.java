package com.company.src.main.java.com.example.mentormatching.model;

import java.util.LinkedList;
import java.util.List;

public class MenteeRelationship {

    String creationDate;
    Mentor mentor;
    Mentee mentee;
    String requestMessage;

    List<Message> messages = new LinkedList<>();


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

    public void addMessage(Message msg){
        messages.add(msg);
    }

    public List<Message> getMessages(){
        return this.messages;
    }
}
