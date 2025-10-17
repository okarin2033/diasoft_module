package ru.diasoft.repository;

import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.InvalidPhoneNumberException;
import ru.diasoft.domain.Student;
import ru.diasoft.domain.Subject;

public class FacultyRepository {
    private final Faculty faculty;

    public FacultyRepository() {
        this.faculty = new Faculty("Engineering");

        try {
            Student s1 = new Student("Ann", "Smith", 20, "+7-900-111-11-11", "ENG-201", 2);
            s1.addSubjects(java.util.List.of(new Subject("Physics", 5), new Subject("Math", 4)));

            Student s2 = new Student("Bob", "Johnson", 21, "ENG-202", 3);
            s2.addSubjects(java.util.List.of(new Subject("Algebra", 5), new Subject("Biology", 3)));

            Student s3 = new Student("Kate", "Brown", 18, "+7-900-222-22-22", "ENG-101", 1);
            s3.addSubjects(java.util.List.of(new Subject("Programming", 5), new Subject("Databases", 4)));

            Student s4 = new Student("Max", "Davis", 19, "ENG-102", 1);
            s4.addSubjects(java.util.List.of(new Subject("History", 3), new Subject("Chemistry", 4)));

            Student s5 = new Student("Olga", "Wilson", 22, "+7-900-333-33-33", "ENG-301", 4);
            s5.addSubjects(java.util.List.of(new Subject("Networks", 5), new Subject("Security", 5)));

            Student s6 = new Student("Ivan", "Petrov", 19, "+7-900-444-44-44", "ENG-101", 1);
            s6.addSubjects(java.util.List.of(new Subject("Math", 5), new Subject("Physics", 5), new Subject("Programming", 5)));

            Student s7 = new Student("Ivan", "Sidorov", 20, "+7-900-555-55-55", "ENG-201", 2);
            s7.addSubjects(java.util.List.of(new Subject("Algebra", 4), new Subject("Geometry", 5)));

            Student s8 = new Student("Anna", "Ivanova", 21, "+7-900-666-66-66", "ENG-202", 2);
            s8.addSubjects(java.util.List.of(new Subject("Chemistry", 5), new Subject("Biology", 5), new Subject("Physics", 5)));

            Student s9 = new Student("Dmitry", "Andreev", 22, "ENG-301", 3);
            s9.addSubjects(java.util.List.of(new Subject("Networks", 4), new Subject("Security", 4)));

            Student s10 = new Student("Elena", "Zaharova", 19, "ENG-102", 1);
            s10.addSubjects(java.util.List.of(new Subject("English", 5), new Subject("Literature", 5)));

            faculty.addStudent(s1);
            faculty.addStudent(s2);
            faculty.addStudent(s3);
            faculty.addStudent(s4);
            faculty.addStudent(s5);
            faculty.addStudent(s6);
            faculty.addStudent(s7);
            faculty.addStudent(s8);
            faculty.addStudent(s9);
            faculty.addStudent(s10);
        } catch (InvalidPhoneNumberException e) {
            throw new RuntimeException("Invalid seed data", e);
        }
    }

    public Faculty getFaculty() {
        return faculty;
    }
}


