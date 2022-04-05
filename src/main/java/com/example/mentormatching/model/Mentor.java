/*
 * @author Aishah Qureshi aishah.s.qureshi@gmail.com | 200100227
 */

package com.company.src.main.java.com.example.mentormatching.model;

import java.util.List;

public class Mentor {

    private List<MenteeRelationship> pendingRequest;
    private List<MenteeRelationship> connectedMentees;
    private boolean available;
    private User user;

    /*
     * Constructor
     *
     * @param  User user
     * @return void
     */
    public Mentor(User user){
        this.user = user;
        addMentorFieldsToProfile(user.getProfile());
    }

    /*
     * Allows the mentor to accept mentorship request from pending
     *
     * Removes the relationship from pending and adds it to connected
     *
     * @param  MenteeRelationship mentee
     * @return void
     */
    public void acceptRequest(MenteeRelationship mentee){
        pendingRequest.remove(mentee);
        connectedMentees.add(mentee);
    }

    /*
     * Remove mentee relationship from connectedMentees
     *
     * @param  Mentee mentee
     * @return boolean
     */
    public boolean removeMentee(Mentee mentee){
        boolean removed = false;
        for(MenteeRelationship menteeR : connectedMentees){
            if(menteeR.getMentee() == mentee) {
                connectedMentees.remove(menteeR);
                removed = true;
            }
        }

        return removed;
    }

    /*
     * Adds mentorship relationship to pendingRequest
     *
     * @param  MenteeRelationship mentee
     * @return void
     */
    public void sendMentorRequest(MenteeRelationship mentee){
        pendingRequest.add(mentee);
    }

    /*
     * Getter for mentor's current connected mentees
     *
     * @return List<MenteeRelationship>
     */
    public List<MenteeRelationship> getConnectedMentees() {
        return connectedMentees;
    }

    /*
     * Getter for mentor's availability status
     *
     * @return boolean
     */
    public boolean getStatus() {
        return available;
    }

    /*
     * Change mentor's availability
     *
     * @return void
     */
    public void changeStatus(){
        available=!available;
    }

    /*
     * Adds mentor fields to profile
     *
     * @param Profile profile
     *
     * @return Profile
     */
    public Profile addMentorFieldsToProfile(Profile profile){
        profile.addField(new Field( "Mentee age", "Mentor", "private"));
        profile.addField(new Field( "Mentee program", "Mentor", "public"));
        profile.addField(new Field( "Mentee position", "Mentor", "public"));
        profile.addField(new Field( "Mentee gender", "Mentor", "private"));
    }

}
