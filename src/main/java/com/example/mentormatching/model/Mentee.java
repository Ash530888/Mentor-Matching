package com.example.mentormatching.model;

import java.util.List;

public class Mentee {

    List<Mentor> mentors;
    Mentor currentMentor;
    List<Mentee> previousMentor;


    public List<Mentor> getMentors() {
        return mentors;
    }

    public void setMentors(List<Mentor> mentors) {
        this.mentors = mentors;
    }

    public Mentor getCurrentMentor() {
        return currentMentor;
    }

    public void setCurrentMentor(Mentor currentMentor) {
        this.currentMentor = currentMentor;
    }

    public List<Mentee> getPreviousMentor() {
        return previousMentor;
    }

    public void setPreviousMentor(List<Mentee> previousMentor) {
        this.previousMentor = previousMentor;
    }
}
