package bg.tu_varna.sit.f24621905.task2;

public class Shop extends Property {
    public Shop(double area, double price, boolean isForRent) {
        super(area, price, isForRent);
    }

    @Override
    public double calculateCommission() {
        if (isForRent && area < 50) {
            return price * 0.02;
        } else if (area > 100) {
            return price * 0.01;
        } else {
            return price * 0.06;
        }
    }
}
