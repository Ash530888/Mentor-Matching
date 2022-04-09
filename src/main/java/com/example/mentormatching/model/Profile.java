
    package com.example.mentormatching.model;

    import java.util.ArrayList;
    import java.util.Arrays;

    public class Profile {
        private User profileUser;
        private ArrayList<Field<ArrayList<String>>> fields;

        /*
         * Constructor
         *
         * @param  User  profileUser
         * @return null
         */
        public Profile(){
            this.fields = new ArrayList<Field<ArrayList<String>>>();
        }

        public User getProfileUser(){
            return profileUser;
        }

        public Field<ArrayList<String>> getField(String fieldName){
            for (Field<ArrayList<String>> field : fields) {
                if ((field.getName()).equals(fieldName)){
                    return field;
                }
            }
            return null;
        }

        public void editField(String fieldName, ArrayList<String> newData){
            getField(fieldName).setData(newData);
        }

        public void editField(String fieldName, String newData){
            getField(fieldName).setData(new ArrayList<>(Arrays.asList(newData)));
        }

        public ArrayList<Field<ArrayList<String>>> getFields(){
            return fields;
        }

        public void addField(Field<ArrayList<String>> field){
            fields.add(field);
        }

        public boolean hasField(String fieldName){
            for (Field<ArrayList<String>> field : fields){
                if (fieldName.equals(field.getName())){
                    return true;
                }
            }
            return false;
        }
    }
