package com.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The AddressBook class shas multiple methods to store, read, search, etc
 * contacts in ArrayList of type contact
 * 
 */

public class AddressBook {
    private static final Logger logger = LogManager.getLogger(App.class);

    ArrayList<Contact> arrli = new ArrayList<Contact>();

    /**
     * This method adds contact to the list of contacts
     * 
     * @param Scanner s pass scanner object
     */
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
        boolean exists = arrli.stream()
                .anyMatch(arrliItem -> arrliItem.getFirstName().contains(firstName));
        if (exists) {
            System.out.println("Duplicate contact");
        } else {
            arrli.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, emailId));
        }
    }

    void displayContact() {
        logger.info(arrli);
    }

    /**
     * This method edits contact from the list of contacts/addressbook matching to
     * first name
     * 
     * @param Scanner s pass scanner object
     * 
     */

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

    /**
     * This method deletes/ removes contact from the list of contacts
     * 
     * @param Scanner s pass scanner object
     */

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

    /**
     * This method searches contact from the list of contacts matching with city
     * 
     * @param Scanner s pass scanner object
     * 
     */
    void searchByCityState(Scanner s) {
        logger.info("Enter City/State of Contacts to search : ");
        String search = s.nextLine();
        Stream<Contact> exists = arrli.stream()
                .filter(arrliItem -> arrliItem.getCity().contains(search));
        if (!exists.equals(null)) {
            exists.forEach(System.out::println);
        }
    }

    /**
     * This method counts contact from the list of contacts matching with city
     * 
     * @param Scanner s pass scanner object
     * 
     */
    void countByCityState(Scanner s) {
        logger.info("Enter City/State of Contacts to search : ");
        String search = s.nextLine();
        long count = arrli.stream()
                .filter(arrliItem -> arrliItem.getCity().contains(search))
                .count();
        System.out.println("Count for search by " + search + " is " + count);
    }

    /**
     * This method sorts contact from the list of contacts with names
     * 
     * @param Scanner s pass scanner object
     * 
     */
    void sortByName() {
        System.out.println("printing the sorted address book by name");
        arrli.stream()
                .sorted(Comparator.comparing(Contact::getFirstName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // arrli.forEach(System.out::println);
    }

    /**
     * This method sorts contact from the list of contacts with cities
     * 
     * @param Scanner s pass scanner object
     * 
     */
    void sortByCity() {
        System.out.println("printing the sorted address book by city");
        arrli.stream()
                .sorted(Comparator.comparing(Contact::getCity))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // arrli.forEach(System.out::println);
    }

    /**
     * Access particular addressbook
     *
     * @param addressbook it contains all the individual contacts
     * 
     */

    void accessAddressBook(AddressBook addressBook, Scanner s) {
        while (true) {
            logger.info("Welcome to Address Book Program");
            logger.info(
                    "Give choice 1. Create a contact: 2: Display Contacts 3: Edit a Contact 4: Delete a contact 5: Add Multiple contacts 6: Search by city/state 7: Count of searched element 8: Sort By Name 9: Sort By City/State 10: Go back");
            String str = s.nextLine(); // get the number as a single line

            int choice = Integer.parseInt(str);

            switch (choice) {
                case 1:
                    addressBook.addContact(s);
                    break;
                case 2:
                    addressBook.displayContact();
                    break;
                case 3:
                    addressBook.editContact(s);
                    break;
                case 4:
                    addressBook.deleteContact(s);
                    break;
                case 5:
                    addressBook.addMultipleContacts(s);
                    break;
                case 6:
                    addressBook.searchByCityState(s);
                    break;
                case 7:
                    addressBook.countByCityState(s);
                    break;
                case 8:
                    addressBook.sortByName();
                    break;
                case 9:
                    addressBook.sortByCity();
                    break;
                case 10:
                    return;
            }
        }
    }
}