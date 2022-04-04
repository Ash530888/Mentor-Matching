package com.example.mentormatching.model;

import java.util.List;

public class Mentor {

    private List<MenteeRelationship> pendingRequest;
    private List<MenteeRelationship> connectedMentees;


    public void addMentee(MenteeRelationship mentee){
        connectedMentees.add(mentee);
    }

    public void addPendingRequest(MenteeRelationship mentee){
        pendingRequest.add(mentee);
    }




}
