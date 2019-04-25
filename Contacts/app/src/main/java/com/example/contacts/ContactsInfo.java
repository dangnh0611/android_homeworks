package com.example.contacts;

public class ContactsInfo {
    private String name;
    private String email;
    private String street;
    private String city;

    public ContactsInfo(String name, String email, String street, String city) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.street + " street, " + this.city + " city";
    }
}
