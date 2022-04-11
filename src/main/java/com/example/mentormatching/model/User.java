package com.example.mentormatching.model;

public class User extends Account {


    private Profile profile;
    private String userRole; // current role
    private MentorProfileFacade mentorProfileFacade;
    private MenteeProfileFacade menteeProfileFacade;

    private Mentee mentee;
    private Mentor mentor;

    private String[] allRole = {"None", "None"};

    public User(String email, String password, String role, String userRole){
        super(email,password,"",  role);
        ProfileFactory factory = new ProfileFactory(new Profile());
        factory.createDefaultProfile();factory.createMentorProfile(); factory.createMenteeProfile();
        profile = factory.getProfile();
        menteeProfileFacade = new MenteeProfileFacade(profile);
        mentorProfileFacade = new MentorProfileFacade(profile);
        this.userRole = userRole;

    }
    public User(){
        ProfileFactory factory = new ProfileFactory(new Profile());
        factory.createDefaultProfile();factory.createMentorProfile(); factory.createMenteeProfile();
        profile = factory.getProfile();
        menteeProfileFacade = new MenteeProfileFacade(profile);
        mentorProfileFacade = new MentorProfileFacade(profile);
        mentor = new Mentor(this);
        mentee  = new Mentee(this);
    }

    public String giveRoleStatus(){
        if (allRole[0].equals("MENTOR") && allRole[1].equals("MENTEE")) return "BOTH";
        else if (allRole[0].equals("MENTOR")) return "MENTOR";
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
