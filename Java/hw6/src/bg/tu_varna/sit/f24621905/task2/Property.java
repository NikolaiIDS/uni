package bg.tu_varna.sit.f24621905.task2;

public abstract class Property implements Commission {
    protected double area;
    protected double price;
    protected boolean isForRent;

    public Property(double area, double price, boolean isForRent) {
        this.area = area;
        this.price = price;
        this.isForRent = isForRent;
    }

    public boolean isForRent() {
        return isForRent;
    }
}