package bg.tu_varna.sit.f24621905.task3;

import java.util.Objects;

public class Person implements Competency {
    private String egn;
    private String firstName;
    private String lastName;
    private int age;

    public Person(String egn, String firstName, String lastName, int age) throws PersonalDataException {
        if (egn == null || egn.length() != 10) {
            throw new PersonalDataException("Invalid EGN");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new PersonalDataException("Invalid First Name");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new PersonalDataException("Invalid Last Name");
        }
        if (age <= 0) {
            throw new PersonalDataException("Invalid Age");
        }
        this.egn = egn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getEgn() {
        return egn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean hasCompetence() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(egn, person.egn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(egn);
    }
}
