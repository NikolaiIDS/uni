package bg.tu_varna.sit.f24621905.task4;

public class River extends WaterBody {
    double speed;

    public River(String name, double depth, Fish[] fishes, double speed) {
        super(name, depth, fishes);
        this.speed = speed;
    }

    @Override
    public boolean isFloaty() {
        return (this.depth >= 3 && this.speed <= 30);
    }
}