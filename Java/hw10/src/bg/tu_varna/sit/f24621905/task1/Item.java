package bg.tu_varna.sit.f24621905.task1;

public abstract class Item implements Comparable<Item>, Delivery {
    private ItemType itemType;
    private double itemPrice;
    private int availableQuantity;

    public Item(ItemType itemType, double itemPrice, int availableQuantity) {
        this.itemType = itemType;
        this.itemPrice = itemPrice;
        this.availableQuantity = availableQuantity;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(itemPrice, item.itemPrice) == 0 && availableQuantity == item.availableQuantity && itemType == item.itemType;
    }

    @Override
    public int compareTo(Item i) {
        return Integer.compare(this.availableQuantity, i.availableQuantity);
    }

    @Override
    public abstract boolean needsDelivery();
}
