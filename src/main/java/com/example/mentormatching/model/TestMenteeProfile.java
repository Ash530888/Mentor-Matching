package com.example.mentormatching.model;

public class TestMenteeProfile {

    String careerGoal;
    String preferredMentorGender;
    String preferredMentorAge;
    String preferredMentorPosition;
    String[] strengths;
    String[] weaknesses;
    //    String[] preferredLanguage;
    String preferredLanguage;


    public String getPreferredMentorPosition() {
        return preferredMentorPosition;
    }

    public void setPreferredMentorPosition(String preferredMentorPosition) {
        this.preferredMentorPosition = preferredMentorPosition;
    }

    public String getCareerGoal() {
        return careerGoal;
    }

    public void setCareerGoal(String careerGoal) {
        this.careerGoal = careerGoal;
    }

    public String getPreferredMentorGender() {
        return preferredMentorGender;
    }

    public void setPreferredMentorGender(String preferredMentorGender) {
        this.preferredMentorGender = preferredMentorGender;
    }

    public String getPreferredMentorAge() {
        return preferredMentorAge;
    }

    public void setPreferredMentorAge(String preferredMentorAge) {
        this.preferredMentorAge = preferredMentorAge;
    }


    public String[] getStrengths() {
        return strengths;
    }

    public void setStrengths(String[] strengths) {
        this.strengths = strengths;
    }

    public String[] getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String[] weaknesses) {
        this.weaknesses = weaknesses;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }
}
