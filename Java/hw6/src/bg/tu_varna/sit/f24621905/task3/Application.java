package bg.tu_varna.sit.f24621905.task3;

public class Application {
    public static void main(String[] args) {
        Item[] items = {
                new Bread("White Bread", 4, 50, 80.0),
                new Cheese("Feta", 30, 8, 350.0),
                new Milk("Full Fat Milk", 10, 5, 3.5),
                new Water("Mineral Water", 100, 25, 150.0)
        };

        Shop shop = new Shop(items);

        System.out.println("Items needing delivery: " + shop.getItemCountDelivery());
        System.out.println("Average days to expire: " + shop.getAverageDaysToExpire());
        System.out.println("Total available drinks: " + shop.getAvailableDrinksCount());

        if (items[2] instanceof Drink) {
            System.out.println("Milk is a drink: " + ((Drink) items[2]).isDrink());
        }
    }
}
