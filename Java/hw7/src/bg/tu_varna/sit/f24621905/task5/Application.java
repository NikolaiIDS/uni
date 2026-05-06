package bg.tu_varna.sit.f24621905.task5;

public class Application {
    public static void main(String[] args) {
        SoftDrink fanta = new SoftDrink("Fanta", 12.0, 0.33, false, Fragrances.ORANGE);

        System.out.println(fanta.toString());
        System.out.println("---");

        System.out.println("Serving 10 units...");
        fanta.serve(10);
        System.out.println(fanta.toString());
        System.out.println("---");

        System.out.println("Serving 30 units (not enough)...");
        fanta.serve(30);
        System.out.println(fanta.toString());
        System.out.println("---");

        System.out.println("Delivering 50L...");
        fanta.deliver(50);
        System.out.println(fanta.toString());
        System.out.println("---");

        System.out.println("####################");

        AlcoholicBeverage whiskey = new AlcoholicBeverage("Whiskey", 4.5, 0.05, 40.0);
        System.out.println(whiskey.toString());
        System.out.println("---");

        System.out.println("Proper for 17: " + whiskey.isProper(17));
        System.out.println("Proper for 20: " + whiskey.isProper(20));
        System.out.println("Proper for 45: " + whiskey.isProper(45));
        System.out.println("Proper for 71: " + whiskey.isProper(71));
        System.out.println("---");

        AlcoholicBeverage wine = new AlcoholicBeverage("Wine", 10.0, 0.15, 9.5);
        System.out.println(wine.toString());
        System.out.println("Proper (Wine) for 20: " + wine.isProper(20));
        System.out.println("Proper (Wine) for 71: " + wine.isProper(71));
    }
}
