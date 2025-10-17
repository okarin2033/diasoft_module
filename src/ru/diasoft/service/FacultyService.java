package ru.diasoft.service;

import ru.diasoft.domain.Faculty;
import ru.diasoft.domain.Student;

import java.util.List;

public interface FacultyService {
    
    List<Student> findStudentsByFirstName(Faculty faculty, String firstName);
    
    List<Student> sortStudentsByLastName(Faculty faculty);
    
    List<Student> findExcellentStudents(Faculty faculty);
}

