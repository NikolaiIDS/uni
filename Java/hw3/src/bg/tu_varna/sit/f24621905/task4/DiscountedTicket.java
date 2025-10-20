package bg.tu_varna.sit.f24621905.task4;

public class DiscountedTicket extends StandardTicket {
    private String nameOfUser;

    public DiscountedTicket(String performanceName, double price, String nameOfUser) {
        super(performanceName, price * 0.5);
        this.nameOfUser = nameOfUser;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }
}

