package bg.tu_varna.sit.f24621905.task2;

public class Attacker extends Character {
    private int efficiency;

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public Attacker() {
        super.setLife(150);
    }
}
