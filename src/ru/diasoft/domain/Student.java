package ru.diasoft.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
public class Student extends Person {
    private String group;
    private int course;
    private final TreeSet<Subject> subjects = new TreeSet<>();

    public Student(String firstName, String secondName, int age, String group, int course) {
        super(firstName, secondName, age);
        this.group = group;
        this.course = course;
    }

    public Student(String firstName, String secondName, int age, String phone, String group, int course) throws InvalidPhoneNumberException {
        super(firstName, secondName, age, phone);
        this.group = group;
        this.course = course;
    }

    public Set<Subject> getSubjects() {
        return Collections.unmodifiableSet(subjects);
    }

    public void addSubject(Subject subject) {
        if (subject != null) {
            subjects.add(subject);
        }
    }

    public void addSubjects(Iterable<Subject> subjectsIterable) {
        if (subjectsIterable == null) return;
        for (Subject s : subjectsIterable) {
            addSubject(s);
        }
    }
}


