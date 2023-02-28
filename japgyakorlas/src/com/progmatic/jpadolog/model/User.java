package com.progmatic.jpadolog.model;

import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    List<Address> addresses;

    private String name;

    private Date regAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Address address) {
        addresses.add(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegAt() {
        return regAt;
    }

    public void setRegAt(Date regAt) {
        this.regAt = regAt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", addresses=").append(addresses);
        sb.append(", name='").append(name).append('\'');
        sb.append(", regAt=").append(regAt);
        sb.append('}');
        return sb.toString();
    }
}
