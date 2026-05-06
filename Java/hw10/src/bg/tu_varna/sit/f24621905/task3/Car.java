package bg.tu_varna.sit.f24621905.task3;

import java.util.Objects;

public class Car {
    private String registrationNumber;
    private Color color;
    private String brand;
    private String model;
    private Fuel fuel;

    public Car(String registrationNumber, Color color, String brand, String model, Fuel fuel) throws CarDataException {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) throw new CarDataException("Invalid Registration");
        if (color == null) throw new CarDataException("Invalid Color");
        if (brand == null || brand.trim().isEmpty()) throw new CarDataException("Invalid Brand");
        if (model == null || model.trim().isEmpty()) throw new CarDataException("Invalid Model");
        if (fuel == null) throw new CarDataException("Invalid Fuel");

        this.registrationNumber = registrationNumber;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Color getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Fuel getFuel() {
        return fuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(registrationNumber, car.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "Reg: '" + registrationNumber + '\'' +
                ", Brand: '" + brand + '\'' +
                ", Model: '" + model + '\'' +
                ", Color: " + color +
                ", Fuel: " + fuel +
                '}';
    }
}