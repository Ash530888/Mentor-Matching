package com.example.mentormatching.model;

import java.util.ArrayList;
import java.util.List;

public class Mentor {

    private List<MenteeRelationship> pendingRequest;
    private List<MenteeRelationship> connectedMentees;

    private User user;


    public Mentor(User user){

        this.user = user;
        pendingRequest = new ArrayList<>();
        connectedMentees = new ArrayList<>();
    }



    public void addPendingRequest(MenteeRelationship mentee){
        pendingRequest.add(mentee);
    }

    public void addConnectedMentees(MenteeRelationship newRelationship){
        connectedMentees.add(newRelationship);
    }


    //test
    public void getSize(){
        System.out.println(pendingRequest.size());
        System.out.println(connectedMentees.size());
    }

    public List<MenteeRelationship> getPendingRequest() {
        return pendingRequest;
    }

    public void setPendingRequest(List<MenteeRelationship> pendingRequest) {
        this.pendingRequest = pendingRequest;
    }

    public List<MenteeRelationship> getConnectedMentees() {
        return connectedMentees;
    }

    public void setConnectedMentees(List<MenteeRelationship> connectedMentees) {
        this.connectedMentees = connectedMentees;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MenteeRelationship removeMenteeFromPending(String email){
        MenteeRelationship removeFromPending = this.pendingRequest.stream().filter(m -> m.getMentee().getUser().getEmail().equals(email))
                                                                    .findFirst().orElse(null);
        this.pendingRequest.removeIf(m -> email.equals( m.getMentee().getUser().getEmail()));
        return removeFromPending;
    }

    public MenteeRelationship getByName(String name){
        MenteeRelationship relationship = this.connectedMentees.stream().filter(m -> m.getMentee().getUser().getEmail().equals(name))
                .findFirst().orElse(null);
        return relationship;

    }
}
