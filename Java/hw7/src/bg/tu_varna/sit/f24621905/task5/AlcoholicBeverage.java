package bg.tu_varna.sit.f24621905.task5;

public class AlcoholicBeverage extends Drink {
    double vol;

    public AlcoholicBeverage(String name, double quantity, double serveQuantity, double vol) {
        super(name, quantity, serveQuantity);
        this.vol = vol;
    }

    @Override
    public boolean needOfDelivery() {
        return this.quantity < 5.0;
    }

    public boolean isProper(int age) {
        if (age < 18) {
            return false;
        } else if ((age < 21) || age > 70) {
            return this.vol < 10.0;
        } else{
            return true;
        }
    }
}

