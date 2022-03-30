package com.example.mentormatching.model;


/**
 * @author Fatin Kazi <ec20431@qmul.ac.uk> | ec20431
 *
 * Adminstrator class is responsible verifying admin accout request, setting system domain,
 * exporting profile and user data , and importing data
 */
public class Administrator extends AdministrativeUser {


    /**
     * Verify given admin account
     * @param givenAccountToVerify account passed to verify
     */
    public void verifyAdminAccountRequest(AdministrartiveUser givenAccountToVerify){

    }

    /**
     * set email domain
     */
    public void setSystemEmailDomain(){

    }

    /**
     * export profiles data
     * @param profiles profiles correspond to mentee and mentor profile
     */
    public void exportData(Profile[] profiles){

    }


    /**
     * export user data
     * @param users both mentor and mentee
     */
    public void exportData(User[] users){

    }

    /**
     * Verify given admin account
     * @param filePath account passed to verify
     */
    public void importData(String filePath){

    }
}
