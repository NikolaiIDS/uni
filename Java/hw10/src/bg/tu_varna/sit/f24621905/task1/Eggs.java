package bg.tu_varna.sit.f24621905.task1;

import java.util.Objects;

public class Eggs extends Item implements Delivery {

    private int numberInPack;

    public Eggs(int numberInPack, ItemType itemType,
                double itemPrice, int availableQuantity) {
        super(itemType, itemPrice, availableQuantity);
        this.numberInPack = numberInPack;
    }

    public int getNumberInPack() {
        return numberInPack;
    }

    public void setNumberInPack(int numberInPack) {
        this.numberInPack = numberInPack;
    }

    @Override
    public boolean needsDelivery() {
        return getAvailableQuantity() < 15;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Eggs eggs = (Eggs) o;
        return numberInPack == eggs.numberInPack;
    }

    @Override
    public String toString() {
        return "Eggs{" +
                "numberInPack=" + numberInPack +
                '}';
    }
}
