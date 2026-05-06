package bg.tu_varna.sit.f24621905.task5;

public class AlcoholicBeverage extends Drink {
    private double vol;

    public AlcoholicBeverage(String name, double quantity, double serveQuantity, double vol) {
        super(name, quantity, serveQuantity);
        this.vol = vol;
    }

    @Override
    public boolean needOfDelivery() {
        return quantity < 5;
    }

    @Override
    public String toString() {
        return super.toString() + ", Volume: " + vol + "%";
    }
}
