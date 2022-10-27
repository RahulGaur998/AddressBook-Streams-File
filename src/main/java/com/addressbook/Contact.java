package com.addressbook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Contact {
    private static final Logger logger = LogManager.getLogger(App.class);
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String emailId;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Contact [address=" + address + ", city=" + city + ", emailId=" + emailId + ", firstName=" + firstName
                + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", state=" + state + ", zip=" + zip + "]";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    Contact(String firstName, String lastName, String address, String city, String state, String zip,
            String phoneNumber, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    void displayContact() {
        logger.info("First Name: " + getFirstName());
        logger.info("Last Name: " + getLastName());
        logger.info("Address: " + getAddress());
        logger.info("City: " + getCity());
        logger.info("State: " + getState());
        logger.info("Zip Code: " + getZip());
        logger.info("Phone Number: " + getPhoneNumber());
        logger.info("Email Id: " + getEmailId());
    }

}
