package com.company;

import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main implements List {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Person> people = parseTxt("people.txt");

        Spark.get(
                "/",
                (request,response) -> {
                    String id = request.queryParams("id");
                    HashMap m = new HashMap();
                    for (Person person : people) {
                        int firstPersonId = 0;
                        int lastPersonId = 19;
                        List<Person> offList = people.subList(firstPersonId,lastPersonId);
                        m.put("offList",offList);
                        m.put("firstName",person.firstName);
                        m.put("lastName",person.lastName);
                        if (id != null ) {
                            person.id = Integer.valueOf(id);
                            m.put("idNum", person.id);
                        }
                    }
                    return new ModelAndView(m,"home.html");
                },
                new MustacheTemplateEngine()
        );

        Spark.get(
                "/person",
                (request,response) -> {
                    return null;
                }
        );
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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
