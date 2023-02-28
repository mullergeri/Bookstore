package com.progmatic.jpadolog.model;

import com.progmatic.jpadolog.Controller;
import jakarta.persistence.*;

@Entity
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "passport")
    private Passport passport;

    private String name;

    private String dob;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        String sb = "Person " + "Id: " + id + "\n" +
                "name: " + name + "\n" +
                "Date of Birth: " + dob + "\n" +
                "passport: " + passport + "\n";
        return sb;
    }
}
