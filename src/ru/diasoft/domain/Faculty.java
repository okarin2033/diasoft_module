package ru.diasoft.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Faculty {
    private final String name;
    private final List<Student> students = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}


