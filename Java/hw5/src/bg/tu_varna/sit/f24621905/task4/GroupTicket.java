package bg.tu_varna.sit.f24621905.task4;

public class GroupTicket extends Ticket {

    private static final int USER_COUNT_MAX = 20;
    private int currentUserCount;

    public GroupTicket(String performanceName, double singleTicketPrice) {
        super(performanceName, singleTicketPrice);
        this.currentUserCount = 0;
    }

    public void addUser() {
        if (this.currentUserCount < USER_COUNT_MAX) {
            this.currentUserCount++;
        }
    }

    public int getCurrentUserCount() {
        return currentUserCount;
    }

    @Override
    public double getPrice() {
        double priceForMaxUsers = super.price * USER_COUNT_MAX;
        double discountForCurrentUsers = (super.price * this.currentUserCount) * 0.10;

        return priceForMaxUsers - discountForCurrentUsers;
    }
}