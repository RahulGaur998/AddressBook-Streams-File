package com.addressbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;

/**
 * The AddressBookCollection class has multiple addressbooks that can be accesed
 * by the name of addressbook
 * also we can open, delete an addressbook
 * 
 */
public class AddressBookCollection {
    private static final Logger logger = LogManager.getLogger(App.class);
    HashMap<String, AddressBook> AddressBookSystem = new HashMap<String, AddressBook>();
    Scanner s = new Scanner(System.in);
    AddressBookIO addressBookIOObject = new AddressBookIO();

    void homeMenu() throws IOException, ParseException {
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

    /**
     * open a particular addressbook by name.
     *
     */
    void openAddressBook() throws IOException, ParseException {

        logger.info("Give name for the addressbook to open :");
        String searchKey = s.nextLine();
        // hashmap checks for key if exists
        // AddressBook a = AddressBookSystem.get(searchKey);
        // if (a == null) {
        // logger.info("Address book does not exist");
        // } else {

        logger.info("opening Address Book : " + searchKey);
        addressBookIOObject.readJSONFile(
                "C:\\Users\\Rahul\\java\\addressbook\\src\\main\\resources\\addressbook.json", searchKey);

        // }
    }

    /**
     * Create a particular addressbook by name.
     *
     */

    void createAddressBook() throws IOException, ParseException { // create new address book with a name
        logger.info("Give name for the addressbook to create :");
        String name = s.nextLine();
        AddressBook newAddressBook = new AddressBook();

        newAddressBook.accessAddressBook(newAddressBook, s);
        addressBookIOObject
                .writeJSONData("C:\\Users\\Rahul\\java\\addressbook\\src\\main\\resources\\addressbook.json", name,
                        newAddressBook);
        AddressBookSystem.put(name, newAddressBook);
    }

    /**
     * Delete a particular addressbook by name.
     *
     */
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
