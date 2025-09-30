package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;

public class PersonDemo {
    private final Person person;
    private final Student student;

    public PersonDemo(Person person, Student student) {
        this.person = person;
        this.student = student;
    }

    public void demo() {
        PersonPrinter.printFI(person);
        PersonPrinter.printInfo(person);

        Printer printer = new StudentPrinter();
        printer.printInfo(student);
    }
}


