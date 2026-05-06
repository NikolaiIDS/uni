package bg.tu_varna.sit.f24621905.task4;

public class StandardTicket extends Ticket {
    private boolean valid;

    public StandardTicket(String performanceName, double price) {
        super(performanceName, price);
        this.valid = true;
    }

    @Override
    public double getPrice() {
        return super.price;
    }

    public boolean isValid() {
        return valid;
    }

    public void invalidate() {
        this.valid = false;
    }
}
