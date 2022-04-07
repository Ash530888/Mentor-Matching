package com.example.mentormatching.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MenteeProfileFacade extends ProfileFacade{
    String careerGoal;
    String preferredMentorGender;
    String preferredMentorAge;
    String preferredMentorRole;
    String[] strengths;
    String[] weaknesses;
    String[] preferredLanguage;

    public MenteeProfileFacade(Profile profile){
        super(profile);
        this.careerGoal = profile.getField("Career Goal").getData().get(0);
        this.preferredMentorGender = profile.getField("Preferred Mentor Gender").getData().get(0);
        this.preferredMentorAge = profile.getField("Preferred Mentor Age").getData().get(0);
        this.preferredMentorRole = profile.getField("Preferred Mentor Role").getData().get(0);
        this.strengths = convertArrayList(profile.getField("Strengths").getData());
        this.weaknesses = convertArrayList(profile.getField("Weaknesses").getData());
        this.preferredLanguage = convertArrayList(profile.getField("Preferred Language").getData());
    }

    public String getCareerGoal() {
        return careerGoal;
    }

    public void setCareerGoal(String careerGoal) {
        this.careerGoal = careerGoal;
        profile.editField("Career Goal", careerGoal);

    }

    public String getPreferredMentorGender() {
        return preferredMentorGender;
    }

    public void setPreferredMentorGender(String preferredMentorGender) {
        this.preferredMentorGender = preferredMentorGender;
        profile.editField("Preferred Mentor Gender", preferredMentorGender);
    }

    public String getPreferredMentorAge() {
        return preferredMentorAge;
    }

    public void setPreferredMentorAge(String preferredMentorAge) {
        this.preferredMentorAge = preferredMentorAge;
        profile.editField("Preferred Mentor Age", preferredMentorAge);
    }

    public String getPreferredMentorRole() {
        return preferredMentorRole;
    }

    public void setPreferredMentorRole(String preferredMentorRole) {
        this.preferredMentorRole = preferredMentorRole;
        profile.editField("Preferred Mentor Role", preferredMentorRole);
    }

    public String[] getStrengths() {
        return strengths;
    }

    public void setStrengths(String[] strengths) {
        this.strengths = strengths;
        profile.editField("Strengths", new ArrayList<>(Arrays.asList(strengths)));
    }

    public String[] getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String[] weaknesses) {
        this.weaknesses = weaknesses;
        profile.editField("Weaknesses", new ArrayList<>(Arrays.asList(weaknesses)));
    }

    public String[] getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String[] preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
        profile.editField("Preferred Language", new ArrayList<>(Arrays.asList(preferredLanguage)));
    }
}
