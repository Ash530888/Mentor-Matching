/*
 * @author Aishah Qureshi aishah.s.qureshi@gmail.com | 200100227
 */

package com.example.mentormatching.model;

public class AdministrativeAccount extends Account {

    /*
     * Constructor
     *
     * @param  String  email
     * @param  String  password
     * @param  String  pin
     * @return void
     */
    public AdministrativeAccount(String email, String password, String pin) {
        super(email, password, pin);
    }

    /*
     * Constructor
     *
     * @param  String  email
     * @param  String  password
     * @return void
     */
    public AdministrativeAccount(String email, String password) {
        super(email, password);
    }
}
