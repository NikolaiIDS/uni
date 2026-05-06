package bg.tu_varna.sit.f24621905.task3;

public abstract class Item implements Delivery {
    protected String name;
    protected int daysToExpire;
    protected int availableQuantity;

    public Item(String name, int daysToExpire, int availableQuantity) {
        this.name = name;
        this.daysToExpire = daysToExpire;
        this.availableQuantity = availableQuantity;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }
}