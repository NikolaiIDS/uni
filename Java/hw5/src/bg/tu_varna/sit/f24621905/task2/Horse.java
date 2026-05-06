package bg.tu_varna.sit.f24621905.task2;

public class Horse extends Animal {

    public Horse(int initialEnergy) {
        super(initialEnergy);
    }

    @Override
    public void sleep() {
        super.updateEnergy(7);
    }

    @Override
    public void eat() {
        super.updateEnergy(15);
    }

    @Override
    public void move() {
        super.updateEnergy(-15);
    }
}
