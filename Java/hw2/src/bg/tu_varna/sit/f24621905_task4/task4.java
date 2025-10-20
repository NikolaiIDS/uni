package bg.tu_varna.sit.f24621905_task4;

class Application {
    public static void main(String[] args) {
        StudentGroup sg1 = new StudentGroup("Computer Science", 1, "CS101", 30);
        StudentGroup sg2 = new StudentGroup("Computer Science", 2, "CS201", 25);
        StudentGroup sg3 = new StudentGroup("Mathematics", 1, "M101", 35);
        StudentGroup sg4 = new StudentGroup("Computer Science", 1, "CS102", 40);
        StudentGroup sg5 = new StudentGroup("Mathematics", 2, "M201", 20);

        StudentGroup[] groupsArray = {sg1, sg2, sg3, sg4, sg5};

        Faculty faculty = new Faculty(groupsArray);

        StudentGroup maxGroup = faculty.getGroupWithMaxStudentsByCourse(1);
        System.out.println("Group with max students in course 1:");
        StudentGroup max2Group = faculty.getGroupWithMaxStudentsByCourse(2);
        System.out.println("Group with max students in course 2:");
        maxGroup.printInfo();
    }
}

class StudentGroup {
    private String specialty;
    private int course;
    private String group;
    private int numberOfStudents;

    public StudentGroup(String specialty, int course, String group, int numberOfStudents) {
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.numberOfStudents = numberOfStudents;
    }

    public String getSpecialty() { return specialty; }
    public int getCourse() { return course; }
    public String getGroup() { return group; }
    public int getNumberOfStudents() { return numberOfStudents; }

    public void printInfo() {
        System.out.println("Specialty: " + specialty + ", Course: " + course +
                ", Group: " + group + ", Students: " + numberOfStudents);
    }
}

class Faculty {
    private StudentGroup[] groups;

    public Faculty(StudentGroup[] groups) {
        this.groups = groups;
    }

    public StudentGroup getGroupWithMaxStudentsByCourse(int course) {
        StudentGroup maxGroup = null;
        int maxStudents = -1;

        for (StudentGroup group : groups) {
            if (group.getCourse() == course && group.getNumberOfStudents() > maxStudents) {
                maxStudents = group.getNumberOfStudents();
                maxGroup = group;
            }
        }

        return maxGroup;
    }
}
