package com.example.mentormatching.model;

import java.util.ArrayList;
import java.util.List;

public class Mentee {


    private MenteeRelationship currentMentor = new MenteeRelationship();
    private User user;
    private boolean connected = false;
    private List<Mentor> suggestedMentor = new ArrayList<>();


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

    public List<Mentor> getSuggestedMentor() {
        return suggestedMentor;
    }

    public void setSuggestedMentor(List<Mentor> suggestedMentor) {
        this.suggestedMentor = suggestedMentor;
    }

    public void addSuggestedMentor(Mentor mentor){ this.suggestedMentor.add(mentor);}

}
