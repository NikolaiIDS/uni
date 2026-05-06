package bg.tu_varna.sit.f24621905.task5;

public abstract class Drink implements Delivery, Serving {
    protected String name;
    protected double quantity;
    protected double serveQuantity;

    public Drink(String name, double quantity, double serveQuantity) {
        this.name = name;
        this.quantity = quantity;
        this.serveQuantity = serveQuantity;
    }

    @Override
    public void deliver(double deliveredQuantity) {
        this.quantity += deliveredQuantity;
    }

    @Override
    public void serve(int units) {
        double neededQuantity = units * serveQuantity;
        if (quantity >= neededQuantity) {
            quantity -= neededQuantity;
            System.out.println("Served " + units + " units of " + name + ".");
        } else {
            int possibleUnits = (int) (quantity / serveQuantity);
            quantity -= possibleUnits * serveQuantity;
            System.out.println("Not enough " + name + ". Served only " + possibleUnits + " units.");
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Quantity: " + quantity + "L, Needs Delivery: " + needOfDelivery();
    }
}
