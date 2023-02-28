package com.progmatic.jpadolog.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "passport")
    private Person person;

    private String national;

    private String createdAt;

    private String validUntil;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public String toString() {
        return "\nnational: " + national + "\n"
                + "created at: " + createdAt + "\n"
                + "valid until: " + validUntil + "\n";
    }
}
