package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Contact {
    private static final Logger logger = LogManager.getLogger(App.class);
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String emailId;

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

class AddressBook {
    private static final Logger logger = LogManager.getLogger(App.class);

    ArrayList<Contact> arrli = new ArrayList<Contact>();

    void addContact(Scanner s) {

        logger.info("Enter first name :");
        String firstName = s.nextLine();
        logger.info("Enter last name :");
        String lastName = s.nextLine();
        logger.info("Enter address :");
        String address = s.nextLine();
        logger.info("Enter city :");
        String city = s.nextLine();
        logger.info("Enter state :");
        String state = s.nextLine();
        logger.info("Enter zip code :");
        String zip = s.nextLine();
        logger.info("Enter phone number :");
        String phoneNumber = s.nextLine();
        logger.info("Enter email Id :");
        String emailId = s.nextLine();
        arrli.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, emailId));
    }

    void displayContact() {
        logger.info(arrli);

    }

}

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        AddressBook a = new AddressBook();

        while (true) {
            Scanner s = new Scanner(System.in);
            logger.info("Welcome to Address Book Program");
            logger.info("Give choice 1. Create a contact: 2: Display Contacts");
            String str = s.nextLine(); // get the number as a single line

            int choice = Integer.parseInt(str);

            switch (choice) {
                case 1:
                    a.addContact(s);
                    break;
                case 2:
                    a.displayContact();
                    break;
            }
        }
    }
}