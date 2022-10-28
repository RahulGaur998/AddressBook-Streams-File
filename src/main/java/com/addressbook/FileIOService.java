package com.addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileIOService {

    private static final Logger log = LogManager.getLogger(FileIOService.class);

    public void write(AddressBook newAddressBook, String ADDRESSBOOK_FILE_NAME) {
        StringBuffer contactBuffer = new StringBuffer();

        ((Iterable<Path>) newAddressBook).forEach(person -> {
            String contactDataString = person.toString().concat("\n");
            contactBuffer.append(contactDataString);
        });
        try {
            log.info("writing to file " + ADDRESSBOOK_FILE_NAME);
            Files.write(Paths.get(ADDRESSBOOK_FILE_NAME), contactBuffer.toString().getBytes());
        } catch (IOException x) {
            x.printStackTrace();
        }
    }

    public ArrayList<Contact> readData(String ADDRESSBOOK_FILE_NAME) {
        ArrayList<Contact> contactsList = new ArrayList<Contact>();
        Contact[] newContact = new Contact[1];
        newContact[0] = null;

        try {
            log.info("reading from file " + ADDRESSBOOK_FILE_NAME);
            Files.lines(new File(ADDRESSBOOK_FILE_NAME).toPath())
                    .map(line -> line.trim())
                    .forEach(line -> {
                        String[] lineElements = line.split(":");
                        System.out.println(lineElements.length);
                        if (lineElements.length == 2) {

                            switch (lineElements[0].trim()) {
                                case "first name":
                                    newContact[0].setFirstName(lineElements[1].trim());
                                    break;
                                case "last name":
                                    newContact[0].setLastName(lineElements[1].trim());
                                    break;
                                case "address":
                                    newContact[0].setAddress(lineElements[1].trim());
                                    break;
                                case "city":
                                    newContact[0].setCity(lineElements[1].trim());
                                    break;
                                case "state":
                                    newContact[0].setState(lineElements[1].trim());
                                    break;
                                case "zip":
                                    newContact[0].setZip(lineElements[1].trim());
                                    break;
                                case "phone number":
                                    newContact[0].setPhoneNumber(lineElements[1].trim());
                                    break;
                                case "Email":
                                    newContact[0].setEmailId(lineElements[1].trim());
                                    break;
                            }
                        }
                        if (lineElements.length == 1 && newContact[0] != null) {

                            contactsList.add(newContact[0]);
                            newContact[0] = null;
                        }

                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        contactsList.add(newContact[0]);
        return contactsList;
    }
}