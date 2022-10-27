package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddressBookCollection {
    private static final Logger logger = LogManager.getLogger(App.class);
    HashMap<String, AddressBook> AddressBookSystem = new HashMap<String, AddressBook>();
    Scanner s = new Scanner(System.in);

    void homeMenu() {
        while (true) {
            logger.info(
                    "Welcome to AddressBookSystem: Choose an option 1: Open an Address Book 2: Create an Address Book 3: Delete an AddressBook ");
            int input = Integer.parseInt(s.nextLine());
            switch (input) {
                case 1:
                    openAddressBook();
                    break;
                case 2:
                    createAddressBook();
                    break;
                case 3:
                    deleteAddressBook();
                    break;

            }
        }

    }

    void openAddressBook() { // takes input form user checks inside hashmap if key exits if it does then
                             // store it in a then call addressbook access function

        logger.info("Give name for the addressbook to open :");
        String searchKey = s.nextLine();
        // hashmap checks for key if exists
        AddressBook a = AddressBookSystem.get(searchKey);
        if (a == null) {
            logger.info("Address book does not exist");
        } else {

            logger.info("opening Address Book : " + searchKey);
            a.accessAddressBook(a, s);
        }
    }

    void createAddressBook() { // create new address book with a name
        logger.info("Give name for the addressbook to create :");
        String name = s.nextLine();
        AddressBook newAddressBook = new AddressBook();
        newAddressBook.accessAddressBook(newAddressBook, s);
        AddressBookSystem.put(name, newAddressBook);
    }

    void deleteAddressBook() { // delete address book with name
        logger.info("Give name for the addressbook to delete :");
        String name = s.nextLine();
        if ((AddressBookSystem.get(name)) != null) {
            if (AddressBookSystem.remove(name) == null) {
                logger.info("Address book does not exist");
            } else {

                AddressBookSystem.remove(name);
                logger.info("Address book deleted");
            }
        } else {
            logger.info("Create Address Book first !!");
        }
    }
}
