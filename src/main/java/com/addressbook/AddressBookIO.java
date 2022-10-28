package com.addressbook;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddressBookIO {
    public static void writeJSONData(String fileURL, String name, AddressBook newAddressBook)
            throws IOException, ParseException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(name, newAddressBook);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);

        FileWriter writer = new FileWriter(fileURL);
        writer.write(jsonArray.toJSONString());
        writer.close();
    }

    public void readJSONFile(String fileURL, String searchKey)
            throws IOException, org.json.simple.parser.ParseException {

        List<String> lines = Collections.emptyList();
        try {
            Scanner s = new Scanner(System.in);
            lines = Files.readAllLines(Paths.get(fileURL), StandardCharsets.UTF_8);
            AddressBook addressBook = new AddressBook();
            addressBook.accessAddressBook((AddressBook) lines, s);
        } catch (IOException e) {

        }
    }
}
