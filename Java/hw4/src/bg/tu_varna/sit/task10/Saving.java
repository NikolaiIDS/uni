package bg.tu_varna.sit.task10;

public class Saving {
    private String currency;
    private double quantity;
    private double interestRate;

    public Saving() {}

    public Saving(String currency, double quantity, double interestRate) {
        this.currency = currency;
        this.quantity = quantity;
        this.interestRate = interestRate;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Saving{" +
                "currency='" + currency + '\'' +
                ", quantity=" + quantity +
                ", interest=" + interestRate +
                '}';
    }

    public double calculateInterest() {
        return (interestRate/100) * quantity;
    }
}