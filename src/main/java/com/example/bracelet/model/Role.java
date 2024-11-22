package com.example.bracelet.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role() {

    }
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Collection<User> user;



    public Role(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}