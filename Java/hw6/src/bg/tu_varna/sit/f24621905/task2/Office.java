package bg.tu_varna.sit.f24621905.task2;

public class Office extends Property {
    private boolean hasParkingLot;
    private int numberOfRooms;

    public Office(double area, double price, boolean isForRent, boolean hasParkingLot, int numberOfRooms) {
        super(area, price, isForRent);
        this.hasParkingLot = hasParkingLot;
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public double calculateCommission() {
        if (isForRent) {
            return price * 0.18;
        } else if (hasParkingLot && numberOfRooms > 2) {
            return price * 0.15;
        } else {
            return price * 0.11;
        }
    }
}