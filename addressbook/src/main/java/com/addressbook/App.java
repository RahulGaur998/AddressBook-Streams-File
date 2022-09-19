package com.addressbook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Contact { // Contact class is used to create Contact
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String emailId;

    Contact(String firstName, String lastName, String address, String city, String state, String zip,
            String phoneNumber, String emailId) { // constructor assigns default contact
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        Contact c = new Contact("Rahul", "Gaur", "Khandala", "Pune", "Maharashtra", "410-301", "9689516995",
                "gaur.rahul996@gmail.com");

        logger.info("Welcome to Address Book Program");
        logger.info(c.getFirstName()); // accessing default values
        logger.info(c.getLastName());
        logger.info(c.getAddress());
        logger.info(c.getCity());
        logger.info(c.getState());
        logger.info(c.getZip());
        logger.info(c.getPhoneNumber());
        logger.info(c.getEmailId());

    }
}