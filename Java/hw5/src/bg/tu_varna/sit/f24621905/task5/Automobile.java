package bg.tu_varna.sit.f24621905.task5;

public class Automobile {
    private String brand;
    private String model;
    private String color;
    private int power;
    private String engineType;
    private String transmission;
    private int yearOfManufacture;
    private double mileage;

    public Automobile(String brand, String model, int power, String engineType, String transmission, int yearOfManufacture) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.engineType = engineType;
        this.transmission = transmission;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = 0.0;
        this.color = "CCCCCC";
    }

    public boolean startup() {
        return true;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public int getPower() { return power; }
    public String getEngineType() { return engineType; }
    public String getTransmission() { return transmission; }
    public int getYearOfManufacture() { return yearOfManufacture; }
    public double getMileage() { return mileage; }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
