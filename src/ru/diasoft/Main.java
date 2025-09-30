package ru.diasoft;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.service.PersonDemo;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanov", 30, "+7-900-000-00-00");
        Student student = new Student("Petr", "Petrov", 19, "+7-901-111-11-11", "IT-101", 1);
        PersonDemo demo = new PersonDemo(person, student);
        demo.demo();
    }
}


