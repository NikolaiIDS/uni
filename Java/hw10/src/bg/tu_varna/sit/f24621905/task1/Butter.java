package bg.tu_varna.sit.f24621905.task1;

import java.util.Objects;

public class Butter extends Item implements Delivery {

    private int packing;
    private double butterContent;

    public Butter(int packing, double butterContent, ItemType itemType,
                  double itemPrice, int availableQuantity) {
        super(itemType, itemPrice, availableQuantity);
        this.packing = packing;
        this.butterContent = butterContent;
    }

    public int getPacking() {
        return packing;
    }

    public void setPacking(int packing) {
        this.packing = packing;
    }

    public double getButterContent() {
        return butterContent;
    }

    public void setButterContent(double butterContent) {
        this.butterContent = butterContent;
    }

    @Override
    public boolean needsDelivery() {
        return (packing < 250 && getAvailableQuantity() < 20)
                || getAvailableQuantity() < 30;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Butter butter = (Butter) o;
        return packing == butter.packing
                && Double.compare(butter.butterContent, butterContent) == 0;
    }

    @Override
    public String toString() {
        return "Butter{" +
                "packing=" + packing +
                ", butterContent=" + butterContent +
                '}';
    }
}

