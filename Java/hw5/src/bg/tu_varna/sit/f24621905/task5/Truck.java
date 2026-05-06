package bg.tu_varna.sit.f24621905.task5;

public class Truck extends Automobile {

    private double capacity;
    private int elapsedTime;

    public Truck(String brand, String model, int power, String engineType, String transmission, int yearOfManufacture, double capacity) {
        super(brand, model, power, engineType, transmission, yearOfManufacture);
        this.capacity = capacity;
        this.elapsedTime = 0;
    }

    @Override
    public boolean startup() {
        return this.elapsedTime < 6;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}