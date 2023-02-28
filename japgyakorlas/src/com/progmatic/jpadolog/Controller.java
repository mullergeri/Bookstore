package com.progmatic.jpadolog;

import com.progmatic.jpadolog.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.Date;


public class Controller implements AutoCloseable {

    private HibernateContext model = new HibernateContext();


    public void addPerson(String name, String dob) {

        Person pers = new Person();

        pers.setName(name);
        pers.setDob(dob);

        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        session.persist(pers);

        session.flush();

        session.getTransaction().commit();

        System.out.println("Person added\n Id: " + pers.getId());

    }

    public void addPassportToPerson(Person person, String national, String createdAt, String validUntil) {

        Passport passport = new Passport();


        passport.setPerson(person);
        passport.setNational(national);
        passport.setCreatedAt(createdAt);
        passport.setValidUntil(validUntil);
        person.setPassport(passport);

        Session session = model.getSession();
        Transaction tx = session.getTransaction();

        session.persist(passport);

        session.flush();

        tx.commit();

    }

    public void listAllPerson() {
        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        Query<Person> q = session.createQuery("FROM Person", Person.class);
        for (Person p : q.list()) {
            System.out.println(p);
        }
        session.clear();

        tx.commit();
    }

    public void removePassport(Long id) {

        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        Passport p = session.find(Passport.class, id);
        session.remove(p);

        tx.commit();

    }

    public Person getPersonById(Long id) {

        Session session = model.getSession();

        Transaction tx = session.beginTransaction();


        return session.find(Person.class, id);
    }

    public void listPassports() {
        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        Query<Passport> q = session.createQuery("FROM Passport", Passport.class);
        for (Passport p : q.list()) {
            System.out.println(p);
        }
        session.clear();

        tx.commit();
    }

    @Override
    public void close() throws Exception {
        model.close();
    }

    public void removePerson(Long id) {


        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        Person p = session.find(Person.class, id);
        Passport passport = session.find(Passport.class, p.getPassport().getId());

        session.remove(p);
        session.remove(passport);

        tx.commit();
    }

    public void addUser(String name, Date date) {

        User user = new User();

        user.setName(name);
        user.setRegAt(date);

        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        session.persist(user);

        session.flush();

        session.getTransaction().commit();

        System.out.println("User added\n Id: " + user.getId());
    }

    public User getUserById(Long id) {

        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        return session.find(User.class, id);
    }

    public void addAddressToUser(User user, String country, String city, String street, Integer postalCode) {

        Address address = new Address();

        address.setUser(user);
        address.setCity(city);
        address.setCountry(country);
        address.setPostalCode(postalCode);
        address.setStreet(street);
        user.setAddresses(address);

        Session session = model.getSession();

        Transaction tx = session.getTransaction();

        session.persist(address);

        session.flush();

        tx.commit();
    }

    public void listAllUser() {

        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        Query<User> q = session.createQuery("FROM User", User.class);
        for (User u : q.list()) {
            System.out.println(u);
        }
        session.clear();

        tx.commit();

    }
}
