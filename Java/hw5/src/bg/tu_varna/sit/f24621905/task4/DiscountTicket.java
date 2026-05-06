package bg.tu_varna.sit.f24621905.task4;

public class DiscountTicket extends StandardTicket {
    private String userName;

    public DiscountTicket(String performanceName, double price, String userName) {
        super(performanceName, price);
        this.userName = userName;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 0.50;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
