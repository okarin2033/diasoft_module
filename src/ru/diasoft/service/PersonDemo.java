package ru.diasoft.service;

import ru.diasoft.domain.Person;
import ru.diasoft.domain.Student;
import ru.diasoft.domain.InvalidPhoneNumberException;
import ru.diasoft.domain.Subject;
import ru.diasoft.domain.Faculty;
import ru.diasoft.repository.FacultyRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonDemo {
    private final Person person;
    private final Student student;

    public PersonDemo(Person person, Student student) {
        this.person = person;
        this.student = student;
    }

    public void demo() {
        PersonPrinter.printFI(person);
        PersonPrinter.printInfo(person);

        try {
            person.setPhone("BAD-PHONE");
        } catch (InvalidPhoneNumberException ex) {
            System.out.println("Failed to set person phone: " + ex.getMessage());
        }

        try {
            person.setPhone("+7-900-000-00-00");
            System.out.println("Person phone updated successfully");
        } catch (InvalidPhoneNumberException ex) {
            System.out.println("Unexpected error: " + ex.getMessage());
        }
        PersonPrinter.printInfo(person);

        Printer printer = new StudentPrinter();

        try {
            student.setPhone("123");
        } catch (InvalidPhoneNumberException ex) {
            System.out.println("Failed to set student phone: " + ex.getMessage());
        }

        try {
            student.setPhone("+7-901-111-11-11");
        } catch (InvalidPhoneNumberException ex) {
            System.out.println("Unexpected error: " + ex.getMessage());
        }

        printer.printInfo(student);

        student.addSubjects(java.util.List.of(
            new Subject("Programming", 5),
            new Subject("Algorithms", 4),
            new Subject("Databases", 5)
        ));
        System.out.println("-- Provided student with subjects --");
        printer.printInfo(student);

        FacultyRepository repository = new FacultyRepository();
        Faculty faculty = repository.getFaculty();
        System.out.println("-- Faculty: " + faculty.getName() + " --");
        for (Student st : faculty.getStudents()) {
            printer.printInfo(st);
        }

        System.out.println("-- Faculty students sorted (course desc, group asc, last name asc) --");
        List<Student> sortedStudents = new ArrayList<>(faculty.getStudents());
        sortedStudents.sort(
            Comparator.comparingInt(Student::getCourse)
                .reversed()
                .thenComparing(Student::getGroup, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Student::getSecondName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Student::getFirstName, String.CASE_INSENSITIVE_ORDER)
        );
        for (Student st : sortedStudents) {
            printer.printInfo(st);
        }

        System.out.println("-- Provided student subjects sorted (grade desc, name asc) --");
        List<Subject> subjectsSorted = new ArrayList<>(student.getSubjects());
        subjectsSorted.sort(
            Comparator.comparingInt(Subject::getGrade)
                .reversed()
                .thenComparing(Subject::getName, String.CASE_INSENSITIVE_ORDER)
        );
        StringBuilder sb = new StringBuilder("subjects=[");
        boolean firstSubj = true;
        for (Subject subj : subjectsSorted) {
            if (!firstSubj) sb.append(", ");
            sb.append(subj.toString());
            firstSubj = false;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}


