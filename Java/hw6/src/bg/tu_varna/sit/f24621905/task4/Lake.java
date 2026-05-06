package bg.tu_varna.sit.f24621905.task4;

public class Lake extends WaterBody {
    private double width;
    private double length;

    public Lake(String name, double depth, Fish[] fishPopulation, double width, double length) {
        super(name, depth, fishPopulation);
        this.width = width;
        this.length = length;
    }

    @Override
    public boolean isFloaty() {
        return depth >= 5 && width >= 1000 && length >= 1000;
    }
}