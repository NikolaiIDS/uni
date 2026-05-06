package bg.tu_varna.sit.f24621905.task3;

public class Bread extends Item implements Food {
    private double whiteFlourPercentage;

    public Bread(String name, int daysToExpire, int availableQuantity, double whiteFlourPercentage) {
        super(name, daysToExpire, availableQuantity);
        this.whiteFlourPercentage = whiteFlourPercentage;
    }

    @Override
    public boolean needsDelivery() {
        return (daysToExpire < 5 && whiteFlourPercentage > 75) || availableQuantity < 10;
    }

    @Override
    public boolean isFood() {
        return true;
    }
}
