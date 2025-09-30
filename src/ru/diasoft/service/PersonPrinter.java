package ru.diasoft.service;

import ru.diasoft.domain.Person;

public final class PersonPrinter {
    private PersonPrinter() {}

    public static void printFI(Person person) {
        System.out.println(person.getFirstName() + " " + person.getSecondName());
    }

    public static void printInfo(Person person) {
        System.out.println(
            "First name: " + person.getFirstName() + ", " +
            "Second name: " + person.getSecondName() + ", " +
            "Age: " + person.getAge() + ", " +
            "Phone: " + (person.getPhone() == null ? "-" : person.getPhone())
        );
    }
}


