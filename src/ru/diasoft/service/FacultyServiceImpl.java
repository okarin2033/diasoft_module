package ru.diasoft.service;

import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FacultyServiceImpl implements FacultyService {
    
    @Override
    public List<Student> findStudentsByFirstName(Faculty faculty, String firstName) {
        if (faculty == null || firstName == null) {
            return List.of();
        }
        
        return faculty.getStudents().stream()
                .filter(student -> firstName.equalsIgnoreCase(student.getFirstName()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Student> sortStudentsByLastName(Faculty faculty) {
        if (faculty == null) {
            return List.of();
        }
        
        return faculty.getStudents().stream()
                .sorted(Comparator.comparing(Student::getSecondName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Student> findExcellentStudents(Faculty faculty) {
        if (faculty == null) {
            return List.of();
        }
        
        return faculty.getStudents().stream()
                .filter(student -> !student.getSubjects().isEmpty() && 
                        student.getSubjects().stream()
                                .allMatch(subject -> subject.getGrade() == 5))
                .collect(Collectors.toList());
    }
}

