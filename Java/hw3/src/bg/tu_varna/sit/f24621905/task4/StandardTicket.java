package bg.tu_varna.sit.f24621905.task4;


public class StandardTicket extends Ticket {
    private boolean used;

    public StandardTicket(String performanceName, double price) {
        super(performanceName, price);
        this.used = false;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
