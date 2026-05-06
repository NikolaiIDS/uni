package bg.tu_varna.sit.f24621905.task5;

public class Teacher extends Person {
    private AcademicPositions academicPositions;

    public Teacher(String name, AcademicPositions academicPositions) throws PersonException {
        super(name);
        this.academicPositions = academicPositions;
    }

    public AcademicPositions getAcademicPositions() {
        return academicPositions;
    }
}