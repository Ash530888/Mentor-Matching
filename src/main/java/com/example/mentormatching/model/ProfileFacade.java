package com.example.mentormatching.model;

import java.util.ArrayList;
import java.util.Arrays;
// general
public class ProfileFacade {

    Profile profile;
    String name;
    String location;
    String age;
    String jobPosition;
    String gender;
    String fieldOfWork;
    String description;
    String disabilities;
//    String[] skills;
    String skills;
    String[] pastJobs;
//    String[] languages;
    String languages;


    public ProfileFacade(Profile profile){
        this.profile = new ProfileFactory().createDefaultProfile();
        this.name = profile.getField("Name").getData().get(0);
        this.location = profile.getField("Location").getData().get(0);
        this.age = profile.getField("Age").getData().get(0);
        this.jobPosition = profile.getField("Job Position").getData().get(0);
        this.gender = profile.getField("Gender").getData().get(0);
        this.fieldOfWork = profile.getField("Field of Work").getData().get(0);
        this.description = profile.getField("Description").getData().get(0);
//        this.disabilities = convertArrayList(profile.getField("Disabilities").getData());
//        this.skills = convertArrayList(profile.getField("Skills").getData());
//        this.pastJobs = convertArrayList(profile.getField("Past Jobs").getData());
//        this.languages = convertArrayList(profile.getField("Languages").getData());
    }


    public ProfileFacade(){
    }


    public String[] convertArrayList(ArrayList<String> arr){
        return arr.toArray(new String[arr.size()]);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
//        profile.editField("Name", name);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
//        profile.editField("Location", location);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
//        profile.editField("Age", age);
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
//        profile.editField("Job Position", jobPosition);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
//        profile.editField("Gender", gender);
    }

    public String getFieldOfWork() {
        return fieldOfWork;
    }

    public void setFieldOfWork(String fieldOfWork) {
        this.fieldOfWork = fieldOfWork;
//        profile.editField("Field of Work", fieldOfWork);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
//        profile.editField("Description", description);
    }

    public String getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(String disabilities) {
        this.disabilities = disabilities;
//        profile.editField("Disabilities", new ArrayList<>(Arrays.asList(disabilities)));
    }

//    public String[] getSkills() {
//        return skills;
//    }
    public String getSkills() {
        return skills;
    }


    //    public void setSkills(String[] skills) {
//
//        this.skills = skills;
//        profile.editField("Skills", new ArrayList<>(Arrays.asList(skills)));
//
//    }
    public void setSkills(String skills) {
        this.skills = skills;
//        profile.editField("Skills", new ArrayList<>(Arrays.asList(skills)));

    }

    public String[] getPastJobs() {
        return pastJobs;
    }

    public void setPastJobs(String[] pastJobs) {
        this.pastJobs = pastJobs;
//        profile.editField("Past Jobs", new ArrayList<>(Arrays.asList(pastJobs)));

    }
//
//    public String[] getLanguages() {
//        return languages;
//    }
//
//    public void setLanguages(String[] languages) {
//        this.languages = languages;
////        profile.editField("Languages", new ArrayList<>(Arrays.asList(languages)));
//
//    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
//        profile.editField("Languages", new ArrayList<>(Arrays.asList(languages)));

    }




}
