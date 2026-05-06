package bg.tu_varna.sit.f24621905.task5;

public class PersonException extends RuntimeException {
    public PersonException() {
        super("Invalid value for Person name");
    }
}
