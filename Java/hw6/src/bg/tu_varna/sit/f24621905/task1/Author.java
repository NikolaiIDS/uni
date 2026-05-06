package bg.tu_varna.sit.f24621905.task1;

public class Author {
    private String firstName;
    private String lastName;
    private String country;

    public Author(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public boolean compare(Author other) {
        return this.firstName.equals(other.firstName) &&
                this.lastName.equals(other.lastName) &&
                this.country.equals(other.country);
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
}