package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.domain.Subject;

public class StudentPrinter implements Printer {
    @Override
    public void printInfo(Person p) {
        Student s = (Student) p;
        StringBuilder sb = new StringBuilder();
        sb.append(
            s.getFirstName() + " " + s.getSecondName() + ", age=" + s.getAge() +
            ", phone=" + (s.getPhone() == null ? "-" : s.getPhone()) +
            ", group=" + s.getGroup() + ", course=" + s.getCourse()
        );

        if (!s.getSubjects().isEmpty()) {
            sb.append(", subjects=[");
            boolean first = true;
            for (Subject subj : s.getSubjects()) {
                if (!first) sb.append(", ");
                sb.append(subj.toString());
                first = false;
            }
            sb.append("]");
        }

        System.out.println(sb.toString());
    }
}


