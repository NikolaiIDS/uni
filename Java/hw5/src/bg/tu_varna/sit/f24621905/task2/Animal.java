package bg.tu_varna.sit.f24621905.task2;

public abstract class Animal implements Movement {

    protected int energy;

    public Animal(int initialEnergy) {
        this.setEnergy(initialEnergy);
    }

    public abstract void sleep();
    public abstract void eat();

    @Override
    public abstract void move();

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy > 100) {
            this.energy = 100;
        } else if (energy < 0) {
            this.energy = 0;
        } else {
            this.energy = energy;
        }
    }

    protected void updateEnergy(int change) {
        int newEnergy = this.energy + change;
        this.setEnergy(newEnergy);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [Енергия: " + this.energy + "%]";
    }
}