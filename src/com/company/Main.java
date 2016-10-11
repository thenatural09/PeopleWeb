package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Person> people = parseTxt("people.txt");

    }

    public static ArrayList<Person> parseTxt (String fileName) throws FileNotFoundException {
        ArrayList<Person> p = new ArrayList<>();
        File f = new File(fileName);
        Scanner fileScanner = new Scanner(f);
        fileScanner.nextLine();
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\,");
            String id = columns[0];
            String firstName = columns[1];
            String lastName = columns[2];
            String email = columns[3];
            String country = columns[4];
            String ip = columns[5];
            Person person = new Person(Integer.valueOf(id), firstName, lastName, email, country, ip);
            p.add(person);
        }
        return p;
    }
}
