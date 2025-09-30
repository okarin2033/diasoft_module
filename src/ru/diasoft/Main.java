package ru.diasoft;

import ru.diasoft.domain.Person;
import ru.diasoft.service.PersonDemo;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanov", 30, "+7-900-000-00-00");
        PersonDemo demo = new PersonDemo(person);
        demo.demo();
    }
}


