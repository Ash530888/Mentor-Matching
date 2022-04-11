package com.example.mentormatching.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MentorProfileFacade extends ProfileFacade{
    String preferredMenteeGender;
    String preferredMenteeAge;
    String preferredMenteeRole;
    String[] preferredLanguage;

    public MentorProfileFacade(Profile profile){
        super(profile);
        this.preferredMenteeAge = profile.getField("Preferred Mentee Age").getData().get(0);
        this.preferredMenteeGender = profile.getField("Preferred Mentee Gender").getData().get(0);
        this.preferredMenteeRole = profile.getField("Preferred Mentee Role").getData().get(0);
        this.preferredLanguage = convertArrayList(profile.getField("Preferred Language").getData());
    }


    public String getPreferredMenteeGender() {
        return preferredMenteeGender;
    }

    public void setPreferredMenteeGender(String preferredMenteeGender) {
        this.preferredMenteeGender = preferredMenteeGender;
        profile.editField("Preferred Mentee Gender", preferredMenteeGender);
    }

    public String getPreferredMenteeAge() {
        return preferredMenteeAge;
    }

    public void setPreferredMenteeAge(String preferredMenteeAge) {
        this.preferredMenteeAge = preferredMenteeAge;
        profile.editField("Preferred Mentor Age", preferredMenteeAge);
    }

    public String getPreferredMenteeRole() {
        return preferredMenteeRole;
    }

    public void setPreferredMenteeRole(String preferredMenteeRole) {
        this.preferredMenteeRole = preferredMenteeRole;
        profile.editField("Preferred Mentee Role", preferredMenteeRole);
    }


    public String[] getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String[] preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
        profile.editField("Preferred Language", new ArrayList<>(Arrays.asList(preferredLanguage)));
    }
}
