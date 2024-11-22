package com.example.bracelet.dto;

public class UserRegistrationDto {


    public UserRegistrationDto(String idbracelet, String firstName, String lastName, String mobilenumber, String dateofbirth, String relativeMobileNumber, String password) {
        this.idbracelet = idbracelet;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilenumber = mobilenumber;
        this.dateofbirth = dateofbirth;
        this.relativeMobileNumber = relativeMobileNumber;
        this.password = password;
    }



    private String idbracelet;
    private String firstName;
    private String lastName;
    private String mobilenumber;

    private String dateofbirth;
    private String relativeMobileNumber;



    private String password;

    public UserRegistrationDto() {

    }


    public String getIdbracelet() {
        return idbracelet;
    }

    public void setIdbracelet(String idbracelet) {
        this.idbracelet = idbracelet;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getRelativeMobileNumber() {
        return relativeMobileNumber;
    }

    public void setRelativeMobileNumber(String relativeMobileNumber) {
        this.relativeMobileNumber = relativeMobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
