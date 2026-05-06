package bg.tu_varna.sit.f24621905.task1;

import java.util.Objects;

public class Milk extends Item implements Delivery {

    private String name;
    private int daysToExpire;

    public Milk(String name, int daysToExpire, ItemType itemType,
                double itemPrice, int availableQuantity) {
        super(itemType, itemPrice, availableQuantity);
        this.name = name;
        this.daysToExpire = daysToExpire;
    }

    public String getName() {
        return name;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public boolean needsDelivery() {
        return getAvailableQuantity() < 15;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Milk milk = (Milk) o;
        return daysToExpire == milk.daysToExpire
                && Objects.equals(name, milk.name);
    }

    @Override
    public String toString() {
        return "Milk{" +
                "name='" + name + '\'' +
                ", daysToExpire=" + daysToExpire +
                '}';
    }
}

