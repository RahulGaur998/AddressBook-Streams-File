package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressBook {
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

    void deleteContact(Scanner s) {
        logger.info("Enter first name of Contact to delete : ");
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
        arrli.remove(matchedContact);
        displayContact();
    }

    void addMultipleContacts(Scanner s) {
        String input = "yes";
        while (input.equalsIgnoreCase("yes")) {
            addContact(s);
            logger.info("Add More yes/no?");
            input = s.nextLine();
        }
    }
}