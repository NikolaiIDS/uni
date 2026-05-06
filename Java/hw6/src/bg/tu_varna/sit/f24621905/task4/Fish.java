package bg.tu_varna.sit.f24621905.task4;

public abstract class Fish {
    protected String name;
    protected double quantity;

    public Fish(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }
}
