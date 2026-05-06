package bg.tu_varna.sit.f24621905.task1;

public class Person {

    protected String firstName;
    protected String secondName;
    protected String thirdName;

    public Person(String firstName, String secondName, String thirdName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
    }

    @Override
    public String toString() {
        return this.firstName + ", " + this.thirdName + " " + this.secondName;
    }
}