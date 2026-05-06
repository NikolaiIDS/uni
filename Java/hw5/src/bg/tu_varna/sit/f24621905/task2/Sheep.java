package bg.tu_varna.sit.f24621905.task2;

public class Sheep extends Animal {

    public Sheep(int initialEnergy) {
        super(initialEnergy);
    }

    @Override
    public void sleep() {
        super.updateEnergy(5);
    }

    @Override
    public void eat() {
        super.updateEnergy(10);
    }

    @Override
    public void move() {
        super.updateEnergy(-25);
    }
}