package bg.tu_varna.sit.f24621905.task3;

public class Milk extends Item {
    private final double fatPercentage;

    public Milk(String name, int daysToExpire, int availableQuantity, double fatPercentage) {
        super(name, daysToExpire, availableQuantity, ItemType.drink);
        this.fatPercentage = fatPercentage;
    }


    @Override
    public boolean needsDelivery() {
        return getDaysToExpire() <= 15 &&
                getAvailableQuantity() < 10 &&
                fatPercentage > 2;
    }
}