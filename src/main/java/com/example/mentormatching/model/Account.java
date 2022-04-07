/*
 * @author Aishah Qureshi aishah.s.qureshi@gmail.com | 200100227
 */

package com.example.mentormatching.model;

public class Account {
    private String email;
    private String password;
    private String pin;
    private String role;


    /*
     * Constructor
     *
     * @param  String  email
     * @param  String  password
     * @param  String  pin
     * @param  String  role
     * @return void
     */
    public Account(String email, String password, String pin, String role){
        this.email=email;
        this.password=password;
        this.pin=pin;
        this.role = role;
    }

    public Account(){}

    /*
     * Constructor
     *
     * @param  String  email
     * @param  String  password
     * @param  String  pin
     * @return void
     */
    public Account(String email, String password, String pin){
        this.email=email;
        this.password=password;
        this.pin=pin;
    }

    /*
     * Constructor
     *
     * @param  String  email
     * @param  String  password
     * @return void
     */
    public Account(String email, String password){
        this.email=email;
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPin() {
        return pin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
