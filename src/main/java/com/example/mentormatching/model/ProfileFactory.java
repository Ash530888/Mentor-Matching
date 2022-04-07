package com.example.mentormatching.model;

import java.util.ArrayList;

public class ProfileFactory {
    public static final String[] defaultFieldNames = new String[]{
            "Name", "Age", "Job Position", "Gender", "Location", "Field of Work", "Description", "Disabilities",
            "Skills", "Past Jobs", "Languages"};

    public static final String[] menteeFieldNames = new String[]{
            "Career Goal", "Preferred Mentor Gender", "Preferred Mentor Age", " Preferred Mentor Role", "Strengths",
            "Weaknesses", "Preferred Language"};

    public static final String[] mentorFieldNames = new String[]{
            "Preferred Mentee Gender", "Preferred Mentee Age", " Preferred Mentee Role", "Preferred Language"};


    public Profile createDefaultProfile(User user){
        Profile newProfile = new Profile(user);
        for (String fieldName : defaultFieldNames){
            newProfile.addField(new Field<>(new ArrayList<>(), fieldName));
        }
        return newProfile;
    }

    public Profile createMenteeProfile(User user){
        Profile newProfile = createDefaultProfile(user);
        return createMenteeProfile(user, newProfile);
    }

    public Profile createMenteeProfile(User user, Profile profile){
        for (String fieldName : menteeFieldNames){
            profile.addField(new Field<>(fieldName, new ArrayList<>(),
                    FieldTypeState.MenteeField,  FieldPrivacyState.All));
        }
        return profile;
    }

    public Profile createMentorProfile(User user, Profile profile){
        for (String fieldName : mentorFieldNames){
            profile.addField(new Field<>(fieldName, new ArrayList<>(),
                    FieldTypeState.MentorField,  FieldPrivacyState.All));
        }
        return profile;
    }

    public Profile createMentorProfile(User user){
        Profile newProfile = createDefaultProfile(user);
        return createMentorProfile(user, newProfile);
    }

}
