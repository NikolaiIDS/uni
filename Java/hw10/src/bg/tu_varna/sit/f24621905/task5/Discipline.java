package bg.tu_varna.sit.f24621905.task5;

import java.util.*;

public class Discipline {
    private String name;
    private TreeMap<Student, Integer> students;
    private Teacher lector;
    private Set<Teacher> teachers;

    public Discipline(String name, Teacher lector) {
        this.name = name;
        this.lector = lector;
        this.students = new TreeMap<>();
        this.teachers = new HashSet<>();
        this.teachers.add(lector);
    }

    public void addStudent(Student student, int points) throws SemestrialControlException {
        if (points < 0 || points > 60) {
            throw new SemestrialControlException();
        }
        students.put(student, points);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public Map<Student, Integer> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }
}