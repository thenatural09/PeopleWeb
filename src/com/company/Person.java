package com.company;

/**
 * Created by Troy on 10/11/16.
 */
public class Person {
    int id;
    String firstName;
    String lastName;
    String email;
    String country;
    String ip;

    public Person(int id, String firstName, String lastName, String email, String country, String ip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ip = ip;
    }
}
