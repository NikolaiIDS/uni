package bg.tu_varna.sit.f24621905.task4;

public class EdibleFish extends Fish {
    double percentOfYield;

    public EdibleFish(FishList name, double quantity, double percentOfYield) {
        super(name, quantity);
        this.percentOfYield = percentOfYield;
    }
}
