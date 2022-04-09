package com.example.mentormatching.model;

import java.util.List;

public class Mentor {

    private List<MenteeRelationship> pendingRequest;
    private List<MenteeRelationship> connectedMentees;

    private User user;


    public Mentor(User user){
        this.user = user;
    }



    public void addPendingRequest(MenteeRelationship mentee){
        pendingRequest.add(mentee);
    }

    public void addConnectedMentees(MenteeRelationship newRelationship){
        connectedMentees.add(newRelationship);
    }




}
