package com.addressbook;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class App {

    public static void main(String[] args) throws IOException, ParseException {

        AddressBookCollection a1 = new AddressBookCollection();
        a1.homeMenu();
    }
}