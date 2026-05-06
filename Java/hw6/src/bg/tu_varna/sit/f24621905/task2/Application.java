package bg.tu_varna.sit.f24621905.task2;

public class Application {
    public static void main(String[] args) {
        Property[] properties = {
                new Apartment(55.0, 100000, false, 2, 3),
                new House(120.0, 250000, true, 2, true),
                new Office(80.0, 150000, false, true, 4),
                new Shop(40.0, 50000, true)
        };

        RealEstateAgency agency = new RealEstateAgency("Prime Properties", properties);

        System.out.println("Total expected commission: " + agency.calculateTotalExpectedCommission());
        System.out.println("Properties for sale: " + agency.getPropertiesForSale());
    }
}