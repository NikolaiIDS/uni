package bg.tu_varna.sit.f24621905.task5;

public class Person {
    private String name;

    public Person(String name) throws PersonException {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) throws PersonException {
        if (name == null) {
            throw new PersonException();
        }
        String[] parts = name.split(" ");
        if (parts.length < 2) {
            throw new PersonException();
        }
        for (String part : parts) {
            if (part.isEmpty() || !Character.isUpperCase(part.charAt(0))) {
                throw new PersonException();
            }
        }
    }

    public String getName() {
        return name;
    }
}