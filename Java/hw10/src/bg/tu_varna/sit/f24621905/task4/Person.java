package bg.tu_varna.sit.f24621905.task4;

import java.util.Objects;

public class Person {
    private String firstName;
    private String familyName;

    public Person(String firstName, String familyName) {
        this.firstName = firstName;
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(familyName, person.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, familyName);
    }

    @Override
    public String toString() {
        return firstName + " " + familyName;
    }
}