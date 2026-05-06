package bg.tu_varna.sit.f24621905.task2;

public class Application {
    public static void main(String[] args) {
        System.out.println("----- Демонстрация на Агенция за Недвижими Имоти -----");

        Property ap1 = new Apartment(85.0, 1500.0, PropertyType.rent, 3, 5, Parking.onePlaceForRent);
        Property ap2 = new Apartment(55.0, 120000.0, PropertyType.sale, 2, 2, Parking.noParkingLot);
        Property h1 = new House(150.0, 3000.0, PropertyType.rent, 2, true);
        Property h2 = new House(90.0, 180000.0, PropertyType.sale, 1, false);
        Property o1 = new Office(100.0, 2000.0, PropertyType.rent, Parking.placesForRent, 5);
        Property o2 = new Office(70.0, 150000.0, PropertyType.sale, Parking.onePlaceForSale, 4);
        Property s1 = new Shop(45.0, 1000.0, PropertyType.rent);
        Property s2 = new Shop(130.0, 300000.0, PropertyType.sale);


        System.out.println("\n--- Детайли за имотите и изчислените комисионни ---");
        System.out.println(ap1.toString());
        System.out.println(ap2.toString());
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(o1.toString());
        System.out.println(o2.toString());
        System.out.println(s1.toString());
        System.out.println(s2.toString());

        Property[] inventory = {ap1, ap2, h1, h2, o1, o2, s1, s2};
        RealEstateAgency agency = new RealEstateAgency("ImotiExpress", inventory);

        double totalCommission = agency.calculateTotalExpectedCommission();
        int salesCount = agency.getPropertiesForSale();

        System.out.println("\n--- Резултати от Клас RealEstateAgency ---");
        System.out.printf("Обща очаквана комисионна от %d имота: %.2f лв.\n", inventory.length, totalCommission);
        System.out.printf("Брой имоти за продажба (sale): %d бр.\n", salesCount);
        System.out.println("--------------------------------------------------");
    }
}
