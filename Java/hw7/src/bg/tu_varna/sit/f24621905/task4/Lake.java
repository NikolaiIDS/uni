package bg.tu_varna.sit.f24621905.task4;

public class Lake extends WaterBody {
    double width;
    double length;

    public Lake(String name, double depth, Fish[] fishes, double width, double length) {
        super(name, depth, fishes);
        this.width = width;
        this.length = length;
    }

    @Override
    public boolean isFloaty() {
        return (this.depth >= 5 && this.width >= 1000 && this.length >= 1000);
    }
}
