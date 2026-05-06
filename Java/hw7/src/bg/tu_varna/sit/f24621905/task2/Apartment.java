package bg.tu_varna.sit.f24621905.task2;

class Apartment extends Property {
    private final int numberOfRooms;
    private final int floor;
    private final Parking parkingLot;


    public Apartment(double area, double price, PropertyType propertyType, int numberOfRooms,
                     int floor, Parking parkingLot) {
        super(area, price, propertyType);
        this.numberOfRooms = numberOfRooms;
        this.floor = floor;
        this.parkingLot = parkingLot;
    }


    @Override
    public double calculateCommission() {
        if (getPropertyType() == PropertyType.rent &&
                (parkingLot == Parking.onePlaceForRent || parkingLot == Parking.twoPlacesForRent)) {
            return 0.15 * getPrice();
        } else if (getArea() < 60) {
            return 0.10 * getPrice();
        } else {
            return 0.07 * getPrice();
        }
    }
}