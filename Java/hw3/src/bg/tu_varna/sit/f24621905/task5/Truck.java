package bg.tu_varna.sit.f24621905.task5;

public class Truck extends Car {
    private double loadCapacity;
    private double elapsedTime;

    public Truck(String brand, String model, int color, int power, String engineType, String gearboxType, int yearOfManufacture, double loadCapacity) {
        super(brand, model, color, power, engineType, gearboxType, yearOfManufacture);
        this.loadCapacity = loadCapacity;
        this.elapsedTime = 0;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public boolean checkIfCanBeStarted() {
        return elapsedTime < 6;
    }
}
