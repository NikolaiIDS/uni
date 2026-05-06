package bg.tu_varna.sit.f24621905.task3;

public class Cheese extends Item implements Food {
    private double gramsPerPackage;

    public Cheese(String name, int daysToExpire, int availableQuantity, double gramsPerPackage) {
        super(name, daysToExpire, availableQuantity);
        this.gramsPerPackage = gramsPerPackage;
    }

    @Override
    public boolean needsDelivery() {
        return availableQuantity < 10 && gramsPerPackage <= 400;
    }

    @Override
    public boolean isFood() {
        return true;
    }
}
