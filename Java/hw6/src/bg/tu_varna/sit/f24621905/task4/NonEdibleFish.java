package bg.tu_varna.sit.f24621905.task4;

public class NonEdibleFish extends Fish {
    private String threat;

    public NonEdibleFish(String name, double quantity, String threat) {
        super(name, quantity);
        this.threat = threat;
    }
}