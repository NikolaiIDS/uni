package bg.tu_varna.sit.f24621905.task5;

import java.util.Objects;

public class Student extends Person implements Comparable<Student> {
    private Course course;
    private String facultyNumber;

    public Student(String name, Course course, String facultyNumber) throws PersonException {
        super(name);
        this.course = course;
        this.facultyNumber = facultyNumber;
    }

    public Course getCourse() {
        return course;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    public int compareTo(Student other) {
        return this.facultyNumber.compareTo(other.facultyNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(facultyNumber, student.facultyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyNumber);
    }

    @Override
    public String toString() {
        return getName() + " (" + facultyNumber + ")";
    }
}