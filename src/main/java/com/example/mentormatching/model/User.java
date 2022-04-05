/*
 * @author Aishah Qureshi aishah.s.qureshi@gmail.com | 200100227
 */

package com.company.src.main.java.com.example.mentormatching.model;

import java.util.ArrayList;

public class User extends Account {
    private Mentee menteeRole;
    private Mentor mentorRole;
    private ArrayList<Profile> savedProfiles;
    private Profile profile;
    private ArrayList<Message> messagesReceived;

    /*
     * Constructor
     *
     * @param  String  email
     * @param  String  password
     * @param  String  pin
     * @param  boolean isMentee
     * @param  boolean isMentor
     * @return void
     */
    public User(String email, String password, String pin, boolean isMentee, boolean isMentor) {
        super(email, password, pin);
        addMenteeRole(isMentee);
        addMentorRole(isMentor);
    }

    /*
     * Constructor
     *
     * @param  String  email
     * @param  String  password
     * @param  boolean isMentee
     * @param  boolean isMentor
     * @return void
     */
    public User(String email, String password, boolean isMentee, boolean isMentor) {
        super(email, password);
        addMenteeRole(isMentee);
        addMentorRole(isMentor);
    }

    /*
     * If the user is a mentee, adds a mentee role.
     *
     * @param  boolean isMentee
     * @return void
     */
    public void addMenteeRole(boolean isMentee){
        if(isMentee){
            menteeRole=new Mentee(this);
        }
    }

    /*
     * If the user is a mentor, adds a mentor role.
     *
     * @param  boolean isMentor
     * @return void
     */
    public void addMentorRole(boolean isMentor){
        if(isMentor){
            menteeRole=new Mentor(this);
        }
    }

    /*
     * Makes the mentor role null
     *
     * @return void
     */
    public void removeMentorRole(){
        mentorRole=null;
    }

    /*
     * Makes the mentee role null
     *
     * @return void
     */
    public void removeMenteeRole(){
        menteeRole=null;
    }

    /*
     * Changes the user's program if they are a mentee.
     *
     * @param Program program
     * @return void
     */
    public void changeProgram(Program program){
        if(menteeRole != null){
            menteeRole.addProgram(program, profile);
        }
    }

    /*
     * Saves the specified profile to the user's list of saved profiles
     *
     * @param Profile profile
     * @return void
     */
    public void saveProfile(Profile profile){
        savedProfiles.add(profile);
    }

    /*
     * Returns if a user is a mentee
     *
     * @return boolean
     */
    public boolean isMentee(){return menteeRole != null}

    /*
     * Returns if a user is a mentor
     *
     * @return boolean
     */
    public boolean isMentor(){return mentorRole != null}

    /*
     * Sends a message to another user
     *
     * @param  String message
     * @param  User user
     * @return void
     */
    public void sendMessage(String message, User user){
        user.receiveMessage(message, this);
    }

    /*
     * Saves a message from specified sender to log of messages (messagesReceived)
     *
     * @param  String message
     * @param  User sender
     * @return void
     */
    public void receiveMessage(String message, User sender){
        messagesReceived.add(new Message(message, sender));
    }

    /*
     * Gets all messages the user has sent to a specified user
     *
     * This will be used when constructing messages pages for users
     *
     * @param  User user
     * @return ArrayList<Message>
     */
    public ArrayList<Message> getMessagesTo(User user){
        ArrayList<Message> myMessages=new ArrayList<Message>();
        for(Message message: user.messagesReceived){
            if(message.getSender()==this){
                myMessages.add(message);
            }
        }
        return myMessages;
    }

    /*
     * Getter for profile
     *
     * @return Profile
     */
    public Profile getProfile() {
        return profile;
    }
}