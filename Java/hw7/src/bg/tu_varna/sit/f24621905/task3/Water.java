package bg.tu_varna.sit.f24621905.task3;

public class Water extends Item {
    private final double mineralContent;

    public Water(String name, int daysToExpire, int availableQuantity, double mineralContent) {
        super(name, daysToExpire, availableQuantity, ItemType.drink);
        this.mineralContent = mineralContent;
    }


    @Override
    public boolean needsDelivery() {
        return getAvailableQuantity() < 30 || getDaysToExpire() < 20;
    }
}
