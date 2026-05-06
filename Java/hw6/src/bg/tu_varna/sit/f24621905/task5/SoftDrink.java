package bg.tu_varna.sit.f24621905.task5;

public class SoftDrink extends Drink {
    private boolean isSugarFree;

    public SoftDrink(String name, double quantity, double serveQuantity, boolean isSugarFree) {
        super(name, quantity, serveQuantity);
        this.isSugarFree = isSugarFree;
    }

    @Override
    public boolean needOfDelivery() {
        return quantity < 10;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sugar Free: " + isSugarFree;
    }
}
