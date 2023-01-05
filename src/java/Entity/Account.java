/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author ANHDUC
 */
public class Account {
    private int accountID;
    private String username;
    private String password;
    private boolean gender;
    private Date dob;
    private String address;
    private String email;
    private String phone;
    private int role;
    private boolean active;
    private int question;
    private String answer;

    public Account() {
    }

    public Account(int accountID, String username, String password, boolean gender, Date dob, String address, String email, String phone, int role, boolean active, int question, String answer) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.active = active;
        this.question = question;
        this.answer = answer;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
    
    public String outTable(String gender, String role, String ques) {
        return "<td>" + accountID + "</td>"
                + "<td>" + username + "</td>"
                +"<td>" + password +"</td>"
                +"<td>" + gender + "</td>"
                +"<td>" + dob + "</td>"
                +"<td>" + address + "</td>"
                +"<td>" + email + "</td>"
                +"<td>" + phone + "</td>"
                +"<td>" + role + "</td>"
                +"<td>" + active + "</td>"
                +"<td>" + ques + "</td>"
                +"<td>" + answer + "</td>";
    }
}
