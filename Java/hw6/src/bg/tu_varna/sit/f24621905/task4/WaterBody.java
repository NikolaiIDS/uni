package bg.tu_varna.sit.f24621905.task4;

public abstract class WaterBody implements Usage {
    protected String name;
    protected double depth;
    protected Fish[] fishPopulation;

    public WaterBody(String name, double depth, Fish[] fishPopulation) {
        this.name = name;
        this.depth = depth;
        this.fishPopulation = fishPopulation;
    }

    public abstract boolean isFloaty();

    @Override
    public boolean isProductable() {
        for (Fish fish : fishPopulation) {
            if (fish instanceof EdibleFish && fish.getQuantity() > 10) {
                return true;
            }
        }
        return false;
    }

    public double calculateProduction() {
        double totalProduction = 0;
        for (Fish fish : fishPopulation) {
            if (fish instanceof EdibleFish) {
                totalProduction += ((EdibleFish) fish).getYieldQuantity();
            }
        }
        return totalProduction;
    }
}