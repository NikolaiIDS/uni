package bg.tu_varna.sit.f24621905.task4;

public class GroupTicket extends Ticket {
    private int numberOfUsers;
    private static final int MAX_USERS = 20;

    public GroupTicket(String performanceName, double singlePrice) {
        super(performanceName, singlePrice * MAX_USERS);
        this.numberOfUsers = 0;
    }

    public void addUser() {
        if (numberOfUsers < MAX_USERS) {
            numberOfUsers++;
            this.price = this.price -2;
        }
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }
}
