package com.example.bracelet.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "health_record")
public class HealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    private User user;

    private double temp;
    private int ps;


    private int pd;
    private int fc;

    @Column(name = "recorded_at")
    private LocalDateTime recordedAt;

    public HealthRecord(){

      }

    public HealthRecord( User user, double temp, int ps, int pd, int fc, LocalDateTime recordedAt) {
        super();
        this.user = user;
        this.temp = temp;
        this.ps = ps;
        this.pd = pd;
        this.fc = fc;
        this.recordedAt = recordedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
    // Define a DateTimeFormatter for formatting LocalDateTime




}