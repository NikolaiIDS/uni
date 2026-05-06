package bg.tu_varna.sit.f24621905.task3;

public class Cheese extends Item {
    private final int gramsPerPackage;

    public Cheese(String name, int daysToExpire, int availableQuantity, int gramsPerPackage) {
        super(name, daysToExpire, availableQuantity, ItemType.food);
        this.gramsPerPackage = gramsPerPackage;
    }


    @Override
    public boolean needsDelivery() {
        return getAvailableQuantity() < 10 && gramsPerPackage <= 400;
    }
}

