package com.example.mentormatching.model;


/**
 *
 * @author KennethMartin <k.a.martin@se20.qmul.ac.uk> | ec20844
 *
 * Generic class for storing arbitrary type data for profile fields.
 *
 * The data is payload is of a generic type. When initializing a new field instance, one must do the following:
 * <code> Field <String> newField = new Field(param1, param2, param3, param4); </code>.
 * It contains additional parameters describing the field's name, type, and privacy.
 *
 */
public class Field<T>{

    /**
     * The main data payload of the Field. It can be any type, from arraylist to primitive.
     */
    private T data;
    /**
     * The name of the Field, which is how different fields are differentiated, and labeled (in GUI for instance)
     */
    private String name;
    /**
     * The type of the Field, referring to None, Mentor, Mentee.
     * TODO Create an enum for the possible types of this class field
     */
    private FieldTypeState type;
    /**
     * The privacy of the Field, referring to All, Mentors, currentMentor, Private
     * TODO refine the possible types of this field, and add enum for them
     */
    private FieldPrivacyState privacy;

    /**
     * Constructor for the class Field with established data payload
     * @param data the data payload stored in the field
     * @param name the label/name of the field
     */
    public Field(T data, String name) {
        this.data = data;
        this.name = name;
        this.type = FieldTypeState.DefaultField;
        this.privacy = FieldPrivacyState.All;
    }
    /**
     * Overloaded constructor for the class with an empty data field
     * @param name the label/name of the field
     */
    public Field(String name) {
        this.name = name;
        this.type = FieldTypeState.DefaultField;
        this.privacy = FieldPrivacyState.All;
    }

    /**
     * Overloaded constructor for the class with an empty data field
     * @param name the label/name of the field
     * @param type the type of field, corresponding to Mentor/Mentee/All
     * @param privacyState the privacy of the field, can have the possible privacy levels of the class
     */
    public Field(String name, String type, FieldPrivacyState privacyState) {
        this.name = name;
        this.type = FieldTypeState.DefaultField;
        this.privacy = privacyState;
    }

    /**
     * Getter for the Field Type
     * @return String Type
     */
    public FieldTypeState getType() {
        return type;
    }

    /**
     * Getter for the Field name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the Field T; warning! Generic typed
     * @return data of the field
     */
    public T getData() throws NullPointerException{
        return data;
    }

    /**
     * Setter for the Field T; warning! Must match Type of Field
     * @param data the data payload to set the Field too
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *  Getter for the privacy class field
     * @return the privacy of the field
     */
    public FieldPrivacyState getPrivacy() {
        return privacy;
    }
}
enum FieldPrivacyState{
    All,
    Mentors,
    CurrentMentor,
    Private
}

enum FieldTypeState {
    MenteeField,
    MentorField,
    DefaultField
}