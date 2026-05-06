package bg.tu_varna.sit.f24621905.task3;

public class Application {
    public static void main(String[] args) {
        System.out.println("----- Демонстрация на Магазин -----");

        Item b1 = new Bread("B1", 3, 5, 80);
        Item b2 = new Bread("B2", 10, 50, 50);
        Item c1 = new Cheese("C1", 20, 8, 350);
        Item c2 = new Cheese("C2", 20, 8, 500);
        Item m1 = new Milk("M1", 10, 5, 3.5);
        Item m2 = new Milk("M2", 20, 5, 3.5);
        Item w1 = new Water("W1", 30, 25, 150);
        Item w2 = new Water("W2", 15, 50, 200);

        Item[] itemArray = {b1, b2, c1, c2, m1, m2, w1, w2};
        Shop shop = new Shop(itemArray);

        int deliveryCount = shop.getItemCountDelivery();
        double avgExpire = shop.getAverageDaysToExpire();
        int drinksCount = shop.getAvailableDrinksCount();

        System.out.println("\n--- Резултати от Клас Shop ---");
        System.out.printf("Брой стоки за доставка: %d\n", deliveryCount);
        System.out.printf("Среден срок на годност: %.2f дни\n", avgExpire);
        System.out.printf("Налични напитки: %d\n", drinksCount);
        System.out.println("---------------------------------");
    }
}
