package bg.tu_varna.sit.f24621905.task1;

import java.util.Objects;

public class Chocolate extends Item implements Delivery {

    private String name;
    private double cocoaContent;

    public Chocolate(String name, double cocoaContent, ItemType itemType,
                     double itemPrice, int availableQuantity) {
        super(itemType, itemPrice, availableQuantity);
        this.name = name;
        this.cocoaContent = cocoaContent;
    }

    public String getName() {
        return name;
    }

    public double getCocoaContent() {
        return cocoaContent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCocoaContent(double cocoaContent) {
        this.cocoaContent = cocoaContent;
    }

    @Override
    public boolean needsDelivery() {
        return getAvailableQuantity() < 10;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chocolate chocolate = (Chocolate) o;
        return Double.compare(chocolate.cocoaContent, cocoaContent) == 0
                && Objects.equals(name, chocolate.name);
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "name='" + name + '\'' +
                ", cocoaContent=" + cocoaContent +
                '}';
    }
}
