/*
 * @author Aishah Qureshi aishah.s.qureshi@gmail.com | 200100227
 */

package com.company.src.main.java.com.example.mentormatching.model;

public class AdministrativeAccount extends Account {
    public AdministrativeAccount(String email, String password, String pin) {
        super(email, password, pin);
    }

    public AdministrativeAccount(String email, String password) {
        super(email, password);
    }
}
