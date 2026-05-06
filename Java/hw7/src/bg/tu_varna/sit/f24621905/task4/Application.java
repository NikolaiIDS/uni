package bg.tu_varna.sit.f24621905.task4;

public class Application {
    public static void main(String[] args) {
        Fish[] lake1Fishes = {
                new EdibleFish(FishList.PERCH, 50.0, 60.0),
                new EdibleFish(FishList.TENCH, 8.0, 50.0),
                new NonEdibleFish(FishList.PIRANHA, 2.0, "Dangerous species")
        };
        Lake floatyLake = new Lake("Big Lake", 5.0, lake1Fishes, 1000.0, 1200.0);

        System.out.println("Воден басейн: " + floatyLake.name);
        System.out.println("Продуктивен ли е: " + floatyLake.isProductabe());
        System.out.println("Плаваем ли е: " + floatyLake.isFloaty());
        System.out.println("Изчислен добив: " + floatyLake.calculateProduction() + " тона");

        System.out.println("---");

        Fish[] river1Fishes = {
                new EdibleFish(FishList.CATFISH, 100.0, 70.0)
        };
        River fastRiver = new River("Fast River", 4.0, river1Fishes, 35.0);

        System.out.println("Воден басейн: " + fastRiver.name);
        System.out.println("Продуктивен ли е: " + fastRiver.isProductabe());
        System.out.println("Плаваем ли е: " + fastRiver.isFloaty());
        System.out.println("Изчислен добив: " + fastRiver.calculateProduction() + " тона");

        System.out.println("---");

        Fish[] lake2Fishes = {
                new EdibleFish(FishList.ESTER, 9.0, 50.0)
        };
        Lake smallYieldLake = new Lake("Small Yield Lake", 6.0, lake2Fishes, 1100.0, 1100.0);

        System.out.println("Воден басейн: " + smallYieldLake.name);
        System.out.println("Продуктивен ли е: " + smallYieldLake.isProductabe());
        System.out.println("Плаваем ли е: " + smallYieldLake.isFloaty());
        System.out.println("Изчислен добив: " + smallYieldLake.calculateProduction() + " тона");
    }
}
