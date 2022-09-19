package com.addressbook;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        AddressBook a = new AddressBook();

        while (true) {
            Scanner s = new Scanner(System.in);
            logger.info("Welcome to Address Book Program");
            logger.info(
                    "Give choice 1. Create a contact: 2: Display Contacts 3: Edit a Contact 4: Delete a contact 5: Add Multiple contacts");
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
                case 4:
                    a.deleteContact(s);
                    break;
                case 5:
                    a.addMultipleContacts(s);
            }
        }
    }
}