package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;

public class StudentPrinter implements Printer {
    @Override
    public void printInfo(Person p) {
        Student s = (Student) p;
        System.out.println(
            s.getFirstName() + " " + s.getSecondName() + ", age=" + s.getAge() +
            ", phone=" + (s.getPhone() == null ? "-" : s.getPhone()) +
            ", group=" + s.getGroup() + ", course=" + s.getCourse()
        );
    }
}


