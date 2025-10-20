package bg.tu_varna.sit.f24621905_task2;


class Application {
    public static void main(String[] args) {
        Item item1 = new Item("Milk", 10, 1.5, 7);
        Item item2 = new Item("Bread", 20, 0.8, 3);
        Item item3 = new Item("Eggs", 30, 0.2, 14);

        Item[] itemArray = {item1, item2, item3};

        ItemArray items = new ItemArray(itemArray);

        System.out.println("All items:");
        items.printAllItems();

        double avgPrice = items.calculateAveragePrice();
        System.out.println("\nAverage price: " + avgPrice);
    }
}

class Item {
    private String type;
    private int quantity;
    private double price;
    private int expirationDays;

    public Item(String type, int quantity, double price, int expirationDays) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.expirationDays = expirationDays;
    }

    public String getType() { return type; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public int getExpirationDays() { return expirationDays; }

    public void setType(String type) { this.type = type; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }
    public void setExpirationDays(int expirationDays) { this.expirationDays = expirationDays; }

    public void printInfo() {
        System.out.println("Type: " + type + ", Quantity: " + quantity +
                ", Price: " + price + ", ExpirationDays: " + expirationDays);
    }
}

class ItemArray {
    private Item[] items;

    public ItemArray(Item[] items) {
        this.items = items;
    }

    public double calculateAveragePrice() {
        if (items.length == 0) return 0;

        double sum = 0;
        for (int i = 0; i < items.length; i++) {
            sum += items[i].getPrice();
        }
        return sum / items.length;
    }

    public void printAllItems() {
        for (int i = 0; i < items.length; i++) {
            items[i].printInfo();
        }
    }
}
