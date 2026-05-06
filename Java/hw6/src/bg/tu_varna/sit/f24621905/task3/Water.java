package bg.tu_varna.sit.f24621905.task3;

public class Water extends Item implements Drink {
    private double mineralContent;

    public Water(String name, int daysToExpire, int availableQuantity, double mineralContent) {
        super(name, daysToExpire, availableQuantity);
        this.mineralContent = mineralContent;
    }

    @Override
    public boolean needsDelivery() {
        return availableQuantity < 30 || daysToExpire < 20;
    }

    @Override
    public boolean isDrink() {
        return true;
    }
}
