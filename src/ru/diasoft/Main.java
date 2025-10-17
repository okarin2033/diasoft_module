package ru.diasoft;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.service.PersonDemo;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanov", 30);
        Student student = new Student("Petr", "Petrov", 19, "IT-101", 1);
        PersonDemo demo = new PersonDemo(person, student);
        demo.demo();
        demo.demonstrateFacultyService();
    }
}


