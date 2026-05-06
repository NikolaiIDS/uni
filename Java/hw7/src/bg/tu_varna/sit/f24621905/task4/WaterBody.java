package bg.tu_varna.sit.f24621905.task4;

public abstract class WaterBody implements Usage {
    String name;
    double depth;
    Fish[] fishes;

    public WaterBody(String name, double depth, Fish[] fishes) {
        this.name = name;
        this.depth = depth;
        this.fishes = fishes;
    }

    @Override
    public boolean isProductabe() {
        for (Fish f : fishes) {
            if (f instanceof EdibleFish) {
                if (f.quantity > 10) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract boolean isFloaty();

    public double calculateProduction() {
        if (!isFloaty()) {
            return 0.0;
        }

        double totalYield = 0.0;
        for (Fish f : fishes) {
            if (f instanceof EdibleFish) {
                EdibleFish edible = (EdibleFish) f;
                totalYield += (edible.quantity * (edible.percentOfYield / 100.0));
            }
        }
        return totalYield;
    }
}
