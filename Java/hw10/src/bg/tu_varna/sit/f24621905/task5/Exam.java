package bg.tu_varna.sit.f24621905.task5;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Exam {
    private Discipline discipline;

    public Exam(Discipline discipline) {
        this.discipline = discipline;
    }

    public Map<Student, Integer> run() {
        Map<Student, Integer> finalResults = new TreeMap<>();
        Map<Student, Integer> currentStudents = discipline.getStudents();
        Random random = new Random();

        for (Map.Entry<Student, Integer> entry : currentStudents.entrySet()) {
            Student student = entry.getKey();
            int currentPoints = entry.getValue();
            int examPoints = random.nextInt(41);

            finalResults.put(student, currentPoints + examPoints);
        }

        return finalResults;
    }
}