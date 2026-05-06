package bg.tu_varna.sit.f24621905.task4;

public class EdibleFish extends Fish {
    private double percentOfYield;

    public EdibleFish(String name, double quantity, double percentOfYield) {
        super(name, quantity);
        this.percentOfYield = percentOfYield;
    }

    public double getYieldQuantity() {
        return quantity * (percentOfYield / 100.0);
    }
}
