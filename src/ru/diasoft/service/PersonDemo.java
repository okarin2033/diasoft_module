package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.domain.InvalidPhoneNumberException;

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

        try {
            person.setPhone("BAD-PHONE");
        } catch (InvalidPhoneNumberException ex) {
            System.out.println("Failed to set person phone: " + ex.getMessage());
        }

        try {
            person.setPhone("+7-900-000-00-00");
            System.out.println("Person phone updated successfully");
        } catch (InvalidPhoneNumberException ex) {
            System.out.println("Unexpected error: " + ex.getMessage());
        }
        PersonPrinter.printInfo(person);

        Printer printer = new StudentPrinter();

        try {
            student.setPhone("123");
        } catch (InvalidPhoneNumberException ex) {
            System.out.println("Failed to set student phone: " + ex.getMessage());
        }

        try {
            student.setPhone("+7-901-111-11-11");
        } catch (InvalidPhoneNumberException ex) {
            System.out.println("Unexpected error: " + ex.getMessage());
        }

        printer.printInfo(student);
    }
}


