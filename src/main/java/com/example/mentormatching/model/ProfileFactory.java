package com.example.mentormatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileFactory {
    Profile profile;
    public static final String[] defaultFieldNames = new String[]{
            "Name", "Age", "Job Position", "Gender", "Location", "Field of Work", "Description", "Disabilities",
            "Skills", "Past Jobs", "Languages"};

    public static final String[] menteeFieldNames = new String[]{
            "Career Goal", "Preferred Mentor Gender", "Preferred Mentor Age", "Preferred Mentor Role", "Strengths",
            "Weaknesses", "Preferred Language"};

    public static final String[] mentorFieldNames = new String[]{
            "Preferred Mentee Gender", "Preferred Mentee Age", "Preferred Mentee Role", "Preferred Language"};


    public ProfileFactory(Profile profile){
        this.profile = profile;
    }
    public void createDefaultProfile(){
        for (String fieldName : defaultFieldNames){
            profile.addField(new Field<>(fieldName, new ArrayList<>(List.of(""))) );
        }
    }


    public void createMenteeProfile(){
        for (String fieldName : menteeFieldNames){
            profile.addField(new Field<>(fieldName, new ArrayList<>(List.of("")),
                    FieldTypeState.MenteeField,  FieldPrivacyState.All));
        }
    }

    public void createMentorProfile(){
        for (String fieldName : mentorFieldNames){
            profile.addField(new Field<>(fieldName, new ArrayList<>(List.of("")),
                    FieldTypeState.MentorField,  FieldPrivacyState.All));
        }
    }

    public Profile getProfile(){
        return profile;
    }

}
