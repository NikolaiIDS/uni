package bg.tu_varna.sit.f24621905.task5;

public class Car {
    private String brand;
    private String model;
    private int color;
    private int power;
    private String engineType;
    private String gearboxType;
    private int yearOfManufacture;
    private int mileage;

    public Car(String brand, String model, int color, int power, String engineType, String gearboxType, int yearOfManufacture) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.power = power;
        this.engineType = engineType;
        this.gearboxType = gearboxType;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = 0;
    }

    public Car(String brand, String model, int power, String engineType, String gearboxType, int yearOfManufacture) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.engineType = engineType;
        this.gearboxType = gearboxType;
        this.yearOfManufacture = yearOfManufacture;
        this.color = 0;
        this.mileage = 0;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getColor() {
        return color;
    }
    public int getPower() {
        return power;
    }
    public String getEngineType() {
        return engineType;
    }
    public String getGearboxType() {
        return gearboxType;
    }
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public int getMileage() {
        return mileage;
    }

    public void setColor(int color) {
        this.color = color;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}

