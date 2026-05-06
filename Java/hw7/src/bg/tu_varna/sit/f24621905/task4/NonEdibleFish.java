package bg.tu_varna.sit.f24621905.task4;

public class NonEdibleFish extends Fish {
    String threat;

    public NonEdibleFish(FishList name, double quantity, String threat) {
        super(name, quantity);
        this.threat = threat;
    }
}
