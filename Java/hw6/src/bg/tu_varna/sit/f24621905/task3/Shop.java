package bg.tu_varna.sit.f24621905.task3;

public class Shop {
    private Item[] items;

    public Shop(Item[] items) {
        this.items = items;
    }

    public int getItemCountDelivery() {
        int count = 0;
        for (Item item : items) {
            if (item.needsDelivery()) {
                count++;
            }
        }
        return count;
    }

    public double getAverageDaysToExpire() {
        if (items == null || items.length == 0) {
            return 0;
        }
        double totalDays = 0;
        for (Item item : items) {
            totalDays += item.getDaysToExpire();
        }
        return totalDays / items.length;
    }

    public int getAvailableDrinksCount() {
        int count = 0;
        for (Item item : items) {
            if (item instanceof Drink) {
                count += item.getAvailableQuantity();
            }
        }
        return count;
    }
}