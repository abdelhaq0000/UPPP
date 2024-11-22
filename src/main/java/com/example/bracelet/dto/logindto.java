package com.example.bracelet.dto;


public class logindto {


    private String idbracelet;
    private String password;

    public logindto(String idbracelet, String password) {
        this.idbracelet = idbracelet;
        this.password = password;
    }

    public logindto() {

    }

    public String getIdbracelet() {
        return idbracelet;
    }

    public void setIdbracelet(String idbracelet) {
        this.idbracelet = idbracelet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


