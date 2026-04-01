package com.example.seproject;

public class User {

    private String fullName;
    private String role;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String cnicNumber;
    public User() {}

    public User(String fullName, String role, String dobString, String email,
                String phoneNumber, String cnicNumber) {
        this.fullName = fullName;
        this.role = role;
        this.dateOfBirth = dobString;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cnicNumber = cnicNumber;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getCnicNumber() { return cnicNumber; }
    public void setCnicNumber(String cnicNumber) { this.cnicNumber = cnicNumber; }
}
