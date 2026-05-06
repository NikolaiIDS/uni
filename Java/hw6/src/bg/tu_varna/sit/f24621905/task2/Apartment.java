package bg.tu_varna.sit.f24621905.task2;

public class Apartment extends Property {
    private int numberOfRooms;
    private int floor;

    public Apartment(double area, double price, boolean isForRent, int numberOfRooms, int floor) {
        super(area, price, isForRent);
        this.numberOfRooms = numberOfRooms;
        this.floor = floor;
    }

    @Override
    public double calculateCommission() {
        if (isForRent) {
            return price * 0.15;
        } else if (area < 60) {
            return price * 0.10;
        } else {
            return price * 0.07;
        }
    }
}