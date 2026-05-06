package bg.tu_varna.sit.f24621905.task5;

public class Application {
    public static void main(String[] args) {
        SoftDrink coke = new SoftDrink("Coca-Cola", 12.0, 0.25, false);
        AlcoholicBeverage whiskey = new AlcoholicBeverage("Jack Daniel's", 4.0, 0.05, 40.0);

        System.out.println(coke);
        System.out.println(whiskey);

        System.out.println("\nServing drinks...");
        coke.serve(5);
        whiskey.serve(100);

        System.out.println("\nAfter serving:");
        System.out.println(coke);
        System.out.println(whiskey);

        System.out.println("\nDelivering drinks...");
        coke.deliver(5.0);
        whiskey.deliver(2.0);

        System.out.println("\nAfter delivery:");
        System.out.println(coke);
        System.out.println(whiskey);
    }
}