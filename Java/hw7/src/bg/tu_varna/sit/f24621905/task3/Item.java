package bg.tu_varna.sit.f24621905.task3;

public abstract class Item implements Delivery {
    private final String name;
    private final int daysToExpire;
    private final int availableQuantity;
    private final ItemType itemType;

    public Item(String name, int daysToExpire, int availableQuantity, ItemType itemType) {
        this.name = name;
        this.daysToExpire = daysToExpire;
        this.availableQuantity = availableQuantity;
        this.itemType = itemType;
    }


    public String getName() {
        return name;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public ItemType getItemType() {
        return itemType;
    }
}