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
        logger.info("Enter   email Id :");
        String emailId = s.nextLine();
        arrli.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, emailId));
    }

    void displayContact() {
        logger.info(arrli);

    }

    void editContact(Scanner s) {
        logger.info("Enter first name of Contact to search : ");
        String search = s.nextLine();
        Contact matchedContact = null;
        for (int i = 0; i < arrli.size(); i++) {
            Contact contact = arrli.get(i);
            String currentName = contact.getFirstName();
            if (currentName.equals(search)) {
                matchedContact = contact;
                break;
            }
        }

        logger.info("Found" + matchedContact);
        if (matchedContact != null) {
            logger.info(
                    "Select what field to edit 1: first name 2: last name 3: address 4: city 5: state 6: zip 7: phone number 8: email Id");
            String change;
            int choice = Integer.parseInt(s.nextLine());

            switch (choice) {
                case 1:
                    logger.info("Give new first name:");
                    change = s.nextLine();
                    matchedContact.setFirstName(change);
                    logger.info("Updated Contact: " + matchedContact);
                    break;
                case 2:
                    logger.info("Give new last name:");
                    change = s.nextLine();
                    matchedContact.setLastName(change);
                    logger.info("Updated Contact: " + matchedContact);
                    break;
                case 3:
                    logger.info("Give new address:");
                    change = s.nextLine();
                    matchedContact.setAddress(change);
                    logger.info("Updated Contact: " + matchedContact);
                    break;
                case 4:
                    logger.info("Give new city:");
                    change = s.nextLine();
                    matchedContact.setCity(change);
                    logger.info("Updated Contact: " + matchedContact);
                    break;
                case 5:
                    logger.info("Give new state:");
                    change = s.nextLine();
                    matchedContact.setState(change);
                    logger.info("Updated Contact: " + matchedContact);
                    break;
                case 6:
                    logger.info("Give new zip code:");
                    change = s.nextLine();
                    matchedContact.setZip(change);
                    logger.info("Updated Contact: " + matchedContact);
                    break;
                case 7:
                    logger.info("Give new phone number:");
                    change = s.nextLine();
                    matchedContact.setPhoneNumber(change);
                    logger.info("Updated Contact: " + matchedContact);
                    break;
                case 8:
                    logger.info("Give new email Id:");
                    change = s.nextLine();
                    matchedContact.setEmailId(change);
                    logger.info("Updated Contact: " + matchedContact);
                    break;
            }
        }

    }

}

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        AddressBook a = new AddressBook();

        while (true) {
            Scanner s = new Scanner(System.in);
            logger.info("Welcome to Address Book Program");
            logger.info("Give choice 1. Create a contact: 2: Display Contacts 3: Edit a Contact");
            String str = s.nextLine(); // get the number as a single line

            int choice = Integer.parseInt(str);

            switch (choice) {
                case 1:
                    a.addContact(s);
                    break;
                case 2:
                    a.displayContact();
                    break;
                case 3:
                    a.editContact(s);
                    break;
            }
        }
    }
}