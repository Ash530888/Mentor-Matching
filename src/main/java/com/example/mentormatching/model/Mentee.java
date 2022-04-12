package com.example.mentormatching.model;

import java.util.List;

public class Mentee {


    private MenteeRelationship currentMentor = new MenteeRelationship();
    private User user;
    private boolean connected = false;


    public Mentee(User user){
        this.user = user;
    }



    public MenteeRelationship getCurrentMentor() {
        return currentMentor;
    }

    public void setCurrentMentor(MenteeRelationship currentMentor) {
        this.currentMentor = currentMentor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void createRelation(){
        this.currentMentor = new MenteeRelationship();
    }


    public void rejected(){
        this.currentMentor = null;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
