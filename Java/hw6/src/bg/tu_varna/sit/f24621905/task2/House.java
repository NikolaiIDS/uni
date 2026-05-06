package bg.tu_varna.sit.f24621905.task2;

public class House extends Property {
    private int numberOfFloors;
    private boolean hasGarden;

    public House(double area, double price, boolean isForRent, int numberOfFloors, boolean hasGarden) {
        super(area, price, isForRent);
        this.numberOfFloors = numberOfFloors;
        this.hasGarden = hasGarden;
    }

    @Override
    public double calculateCommission() {
        if (isForRent && hasGarden) {
            return price * 0.08;
        } else if (!isForRent && area < 100) {
            return price * 0.05;
        } else {
            return price * 0.03;
        }
    }
}
