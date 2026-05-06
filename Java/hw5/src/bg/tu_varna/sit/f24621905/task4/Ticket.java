package bg.tu_varna.sit.f24621905.task4;

public abstract class Ticket {
    protected String performanceName;
    protected double price;

    public Ticket(String performanceName, double price) {
        this.performanceName = performanceName;
        this.price = price;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public abstract double getPrice();
}