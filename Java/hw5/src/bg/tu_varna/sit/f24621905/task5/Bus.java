package bg.tu_varna.sit.f24621905.task5;

public class Bus extends Automobile {

    private int seats;
    private int courses;
    private static final int MAX_COURSES_PER_DAY = 10;

    public Bus(String brand, String model, int power, String engineType, String transmission, int yearOfManufacture, int seats) {
        super(brand, model, power, engineType, transmission, yearOfManufacture);
        this.seats = seats;
        this.courses = 0;
    }

    @Override
    public boolean startup() {
        int remainder = this.courses % MAX_COURSES_PER_DAY;
        return remainder < 5;
    }

    public int getSeats() {
        return seats;
    }

    public int getCourses() {
        return courses;
    }

    public void setCourses(int courses) {
        this.courses = courses;
    }
}