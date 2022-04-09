package com.example.mentormatching.model;

public class User extends Account {



    private String userRole; // current role
    private MentorProfileFacade mentorProfileFacade;
    private MenteeProfileFacade menteeProfileFacade;

    private Mentee mentee;
    private Mentor mentor;

    private String[] allRole = {"None", "None"};

    public User(String email, String password, String role, String userRole){
        super(email,password,"",  role);
        menteeProfileFacade = new MenteeProfileFacade();
        mentorProfileFacade = new MentorProfileFacade();
        this.userRole = userRole;

    }
    public User(){
        mentor = new Mentor(this);
        mentee  = new Mentee(this);
    }

    public String giveRoleStatus(){
        if (allRole[0] == "MENTOR" && allRole[1] == "MENTEE") return "BOTH";
        else if (allRole[0] == "MENTOR") return "MENTOR";
        else return "MENTEE";
    }
    public void setMentorStatus(){this.allRole[0] = "MENTOR";}
    public void setMenteeStatus(){this.allRole[1] = "MENTEE";}


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public MentorProfileFacade getMentorProfileFacade() {
        return mentorProfileFacade;
    }

    public void setMentorProfileFacade(MentorProfileFacade mentorProfileFacade) {
        this.mentorProfileFacade = mentorProfileFacade;
    }

    public MenteeProfileFacade getMenteeProfileFacade() {
        return menteeProfileFacade;
    }

    public void setMenteeProfileFacade(MenteeProfileFacade menteeProfileFacade) {
        this.menteeProfileFacade = menteeProfileFacade;
    }

    public String getRole(){
        return "USER";
    }
}
