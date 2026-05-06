package bg.tu_varna.sit.f24621905.task4;

public class River extends WaterBody {
    private double speed;

    public River(String name, double depth, Fish[] fishPopulation, double speed) {
        super(name, depth, fishPopulation);
        this.speed = speed;
    }

    @Override
    public boolean isFloaty() {
        return depth >= 3 && speed <= 30;
    }
}