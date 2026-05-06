package bg.tu_varna.sit.f24621905.task1;

import java.util.Objects;

public class Water extends Item implements Delivery {

    private String name;
    private String waterType;

    public Water(String name, String waterType, ItemType itemType,
                 double itemPrice, int availableQuantity) {
        super(itemType, itemPrice, availableQuantity);
        this.name = name;
        this.waterType = waterType;
    }

    public String getName() {
        return name;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    @Override
    public boolean needsDelivery() {
        return ("sparkling".equalsIgnoreCase(waterType) && getAvailableQuantity() < 30)
                || getAvailableQuantity() < 15;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Water water = (Water) o;
        return Objects.equals(name, water.name)
                && Objects.equals(waterType, water.waterType);
    }

    @Override
    public String toString() {
        return "Water{" +
                "name='" + name + '\'' +
                ", waterType='" + waterType + '\'' +
                '}';
    }
}
