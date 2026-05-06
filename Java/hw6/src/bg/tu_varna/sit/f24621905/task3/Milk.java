package bg.tu_varna.sit.f24621905.task3;

public class Milk extends Item implements Drink {
    private double fatPercentage;

    public Milk(String name, int daysToExpire, int availableQuantity, double fatPercentage) {
        super(name, daysToExpire, availableQuantity);
        this.fatPercentage = fatPercentage;
    }

    @Override
    public boolean needsDelivery() {
        return daysToExpire <= 15 && availableQuantity < 10 && fatPercentage > 2;
    }

    @Override
    public boolean isDrink() {
        return true;
    }
}
