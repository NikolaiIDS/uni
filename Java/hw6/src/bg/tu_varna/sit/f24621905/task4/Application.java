package bg.tu_varna.sit.f24621905.task4;

public class Application {
    public static void main(String[] args) {
        Fish[] lakeFish = {
                new EdibleFish("Carp", 50.0, 20.0),
                new NonEdibleFish("Piranha", 5.0, "Dangerous predator")
        };

        Fish[] riverFish = {
                new EdibleFish("Trout", 15.0, 30.0),
                new EdibleFish("Salmon", 8.0, 25.0)
        };

        WaterBody lake = new Lake("Lake Superior", 10.0, lakeFish, 1500.0, 2000.0);
        WaterBody river = new River("Danube", 4.0, riverFish, 10.0);

        System.out.println(lake.name + " is floaty: " + lake.isFloaty());
        System.out.println(lake.name + " is productable: " + lake.isProductable());
        System.out.println(lake.name + " max production: " + lake.calculateProduction());

        System.out.println("---");

        System.out.println(river.name + " is floaty: " + river.isFloaty());
        System.out.println(river.name + " is productable: " + river.isProductable());
        System.out.println(river.name + " max production: " + river.calculateProduction());
    }
}