package ru.diasoft.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Subject implements Comparable<Subject> {
    private final String name;
    private final int grade;

    @Override
    public int compareTo(Subject other) {
        return other.name.compareToIgnoreCase(this.name);
    }

    @Override
    public String toString() {
        return name + ": " + grade;
    }
}


