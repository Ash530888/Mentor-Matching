///*
// * @author Leena Neyazi ec20300@qmul.ac.uk | 200201188
// */
//
//package com.example.mentormatching.model;
//
//public class Profile {
//    private User profileUser;
//    private Field[] fields;
//
//     /*
//     * Constructor
//     *
//     * @param  User  profileUser
//     * @return null
//     */
//    public Profile(User profileUser){
//        this.profileUser = profileUser;
//    }
//
//    public User getProfileUser(){
//        return profileUser;
//    }
//
//    public Field getField(String fieldName){
//        int n = fields.length;
//        for (int i = 0; i < n; i++) {
//            if ((fields[i].getName()).equals(fieldName)){
//                return fields[i];
//            }
//        }
//    }
//
//    public void editField(String fieldName, Field newField){
//
//    }
//
//    public Field[] getFields(){
//        return fields;
//    }
//
//    public void addField(Field field){
//        int n = fields.length;
//        Field newArr[] = new Field[n + 1];
//        for (int i = 0; i < n; i++) {
//            newArr[i] = fields[i];
//        }
//        newArr[n] = field;
//        fields = newArr;
//    }
//
//    public boolean hasField(String fieldName){
//        int n = fields.length;
//        for (int i = 0; i < n; i++) {
//            if ((fields[i].getName()).equals(fieldName)){
//                return true;
//            }
//        }
//        return false;
//    }
//}
