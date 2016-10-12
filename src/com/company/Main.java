package com.company;

import com.sun.org.apache.xpath.internal.operations.Mod;
import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main{
    public static final int PAGE = 20;
    public static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        parseTxt("people.txt");
        Spark.get(
                "/",
                (request, response) -> {
                    int offSetNum = 0;
                    String offSetString = request.queryParams("offset");
                    if (offSetString != null) {
                        offSetNum = Integer.valueOf(offSetString);
                    }
                    HashMap m = new HashMap();
                    ArrayList<Person> offSet = new ArrayList<>(people.subList(offSetNum, offSetNum + PAGE));
                    m.put("offSetPrevious", offSetNum - PAGE);
                    m.put("offSetNext", offSetNum + PAGE);
                    m.put("Previous", offSetNum > 0);
                    m.put("Next", offSetNum + PAGE < people.size());
                    m.put("offSet", offSet);

                    return new ModelAndView(m, "home.html");
                },
                new MustacheTemplateEngine()
        );

        Spark.get(
                "/person",
                (request, response) -> {
                    int id = Integer.valueOf(request.queryParams("id"))-1;
                    Person p = people.get(id);
                    return new ModelAndView(p, "person.html");
                },
                new MustacheTemplateEngine()
        );
    }

    public static ArrayList<Person> parseTxt(String fileName) throws FileNotFoundException {
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
            people.add(person);
        }
        return people;
    }
}