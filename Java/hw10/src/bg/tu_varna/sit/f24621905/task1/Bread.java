package bg.tu_varna.sit.f24621905.task1;

import java.util.Objects;

public class Bread extends Item implements Delivery {

    private String name;

    public Bread(String name, ItemType itemType, double itemPrice, int availableQuantity) {
        super(itemType, itemPrice, availableQuantity);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean needsDelivery() {
        return getAvailableQuantity() < 15;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bread bread = (Bread) o;
        return Objects.equals(name, bread.name);
    }

    @Override
    public String toString() {
        return "Bread{" +
                "name='" + name + '\'' +
                '}';
    }
}
