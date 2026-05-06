package bg.tu_varna.sit.f24621905.task5;

public abstract class Drink implements Delivery, Serving {
    String name;
    double quantity;
    double serveQuantity;

    public Drink(String name, double quantity, double serveQuantity) {
        this.name = name;
        this.quantity = quantity;
        this.serveQuantity = serveQuantity;
    }

    @Override
    public abstract boolean needOfDelivery();

    @Override
    public void deliver(double quantity) {
        this.quantity += quantity;
    }

    @Override
    public void serve(int units) {
        double neededQuantity = units * this.serveQuantity;

        if (this.quantity >= neededQuantity) {
            this.quantity -= neededQuantity;
        } else {
            int availableUnits = (int) (this.quantity / this.serveQuantity);
            if (availableUnits > 0) {
                double servedQuantity = availableUnits * this.serveQuantity;
                this.quantity -= servedQuantity;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Наименование: ").append(this.name).append("\n");
        sb.append("Налично количество: ").append(this.quantity).append(" L\n");
        sb.append("Нужда от доставка: ").append(this.needOfDelivery());
        return sb.toString();
    }
}



