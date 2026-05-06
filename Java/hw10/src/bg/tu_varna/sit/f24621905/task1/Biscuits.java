package bg.tu_varna.sit.f24621905.task1;

import java.util.Objects;

public class Biscuits extends Item implements Delivery{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Biscuits(String name, ItemType itemType, double itemPrice, int availableQuantity) {
        super(itemType, itemPrice, availableQuantity);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Biscuits biscuits = (Biscuits) o;
        return Objects.equals(name, biscuits.name);
    }

    @Override
    public String toString() {
        return "Biscuits{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean needsDelivery() {
        return this.getAvailableQuantity() >= 5;
    }
}
