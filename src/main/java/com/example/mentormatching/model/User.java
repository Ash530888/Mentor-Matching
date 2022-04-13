package com.example.mentormatching.model;

import com.example.mentormatching.security.UserDetail;

public class User extends Account {



    private String userRole; // current role
//    private MentorProfileFacade mentorProfileFacade;
//    private MenteeProfileFacade menteeProfileFacade;


    private TestProfile testProfile;
    private TestMenteeProfile testMenteeProfile;
    private  TestMentorProfile testMentorProfile;

    private Mentee mentee;
    private Mentor mentor;



    public User(){
        mentor = new Mentor(this);
        mentee  = new Mentee(this);

    }




    public Mentee getMentee() {
        return this.mentee;
    }

    public void setMentee(Mentee mentee) {
        this.mentee = mentee;
    }

    public Mentor getMentor() {
        return this.mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public String[] allRole = {"None", "None"};

    public User(String email, String password, String role, String userRole){

        super(email,password,"",  role);
//        menteeProfileFacade = new MenteeProfileFacade();
//        mentorProfileFacade = new MentorProfileFacade();
//        this.testMenteeProfile = new TestMenteeProfile();
//        this.testMentorProfile = new TestMentorProfile();

        this.testProfile = new TestProfile();
        this.userRole = userRole;
        if (userRole != null){
            if (this.userRole.equals("MENTOR")) setMentorStatus();
            else setMenteeStatus();
        }

        mentor = new Mentor(this);
        mentee  = new Mentee(this);



    }


    public String getRoleStatus(){
        if (allRole[0] == "MENTOR" && allRole[1] == "MENTEE") return "BOTH";
        else if (allRole[0] == "MENTOR") return "MENTOR";
        else if (allRole[1] == "MENTEE") return "MENTEE";
        else return  "NULL";
    }
    public void setMentorStatus(){this.allRole[0] = "MENTOR";}
    public void setMenteeStatus(){this.allRole[1] = "MENTEE";}


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public TestProfile getTestProfile() {
        return testProfile;
    }

    public void setTestProfile(TestProfile testProfile) {
        this.testProfile = testProfile;
    }

    public TestMenteeProfile getTestMenteeProfile() {
        return testMenteeProfile;
    }

    public void setTestMenteeProfile(TestMenteeProfile testMenteeProfile) {
        this.testMenteeProfile = testMenteeProfile;
    }

    public TestMentorProfile getTestMentorProfile() {
        return testMentorProfile;
    }

    public void setTestMentorProfile(TestMentorProfile testMentorProfile) {
        this.testMentorProfile = testMentorProfile;
    }



    //    public MentorProfileFacade getMentorProfileFacade() {
//        return mentorProfileFacade;
//    }
//
//    public void setMentorProfileFacade(MentorProfileFacade mentorProfileFacade) {
//        this.mentorProfileFacade = mentorProfileFacade;
//    }
//
//    public MenteeProfileFacade getMenteeProfileFacade() {
//        return menteeProfileFacade;
//    }
//
//    public void setMenteeProfileFacade(MenteeProfileFacade menteeProfileFacade) {
//        this.menteeProfileFacade = menteeProfileFacade;
//    }


}
