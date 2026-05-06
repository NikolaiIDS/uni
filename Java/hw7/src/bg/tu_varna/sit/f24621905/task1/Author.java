package bg.tu_varna.sit.f24621905.task1;

class Author {
    private String firstName;
    private String lastName;
    private String country;

    public Author(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + country + ")";
    }
}