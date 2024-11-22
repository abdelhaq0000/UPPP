package com.example.bracelet.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "idbracelet"))
public class User {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idbracelet;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String mobilenumber;

    private String dateofbirth;



    private String relativeMobileNumber;






    private double temp;
    private int ps;
    private int pd;
    private int fc;

    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<HealthRecord> healthRecords;

    public User() {

    }

    public User( String idbracelet, String firstName, String lastName, String mobilenumber, String dateofbirth, String relativeMobileNumber, String password, Role role) {
        super();
        this.idbracelet = idbracelet;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilenumber = mobilenumber;
        this.dateofbirth = dateofbirth;
        this.relativeMobileNumber = relativeMobileNumber;
        this.password = password;
        this.role = role;
    }








    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getrelativeMobileNumber() {
        return relativeMobileNumber;
    }

    public void setrelativeMobileNumber(String relativeMobileNumber) {
        this.relativeMobileNumber = relativeMobileNumber;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPd() {
        return pd;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // Method to add a health record
    public void addHealthRecord(HealthRecord healthRecord) {
        healthRecords.add(healthRecord);
        healthRecord.setUser(this);
    }



}