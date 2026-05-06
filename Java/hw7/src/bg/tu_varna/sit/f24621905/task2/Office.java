package bg.tu_varna.sit.f24621905.task2;

class Office extends Property {
    private final Parking parkingLot;
    private final int numberOfRooms;

    public Office(double area, double price, PropertyType propertyType, Parking parkingLot, int numberOfRooms) {
        super(area, price, propertyType);
        this.parkingLot = parkingLot;
        this.numberOfRooms = numberOfRooms;
    }


    @Override
    public double calculateCommission() {

        if (getPropertyType() == PropertyType.rent) {
            if (parkingLot == Parking.placesForRent && numberOfRooms > 2) {
                return 0.18 * getPrice();
            } else {
                return 0.15 * getPrice();
            }
        } else {
            return 0;
        }
    }
}