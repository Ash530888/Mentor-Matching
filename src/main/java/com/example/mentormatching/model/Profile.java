/*
 * @author Leena Neyazi ec20300@qmul.ac.uk | 200201188
 */

package com.example.mentormatching.model;

import java.util.ArrayList;

public class Profile {
//    private User profileUser;
    private ArrayList<Field<Object>> fields;

     /*
     * Constructor
     *
     * @param  User  profileUser
     * @return null
     */
   /* public Profile(User profileUser){
        this.profileUser = profileUser;
    }

    public User getProfileUser(){
        return profileUser;
    }

    public Field getField(String fieldName){
        int n = fields.length;
        for (int i = 0; i < n; i++) {
            if ((fields[i].getName()).equals(fieldName)){
                return fields[i];
            }
        }
    }*/

    public <T> void editField(String fieldName, Field<T> newField, T newData){
        newField.setData(newData);
    }

    public ArrayList<Field<Object>> getFields(){
        return fields;
    }

    public void addField(Field<Object> field){
        fields.add(field);
    }

    public boolean hasField(String fieldName){
        boolean found = false;
        for (Field<Object> field : fields){
            if (fieldName.equals(field.getName())){
                found = true;
                break;
            }
        }
        return found;
    }
}
