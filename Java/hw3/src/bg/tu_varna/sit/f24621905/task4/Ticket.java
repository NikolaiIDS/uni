package bg.tu_varna.sit.f24621905.task4;

public class Ticket {
    private String performanceName;
    protected double price;

    public Ticket(String performanceName, double price) {
        this.performanceName = performanceName;
        this.price = price;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public double getPrice() {
        return price;
    }
}
