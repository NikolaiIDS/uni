package bg.tu_varna.sit.task10;

public class Deposit extends Saving {
    private int monthsOfDeposit;

    public Deposit() {
    }

    public Deposit(String currency, double quantity, double interest, int monthsOfDeposit) {
        super(currency, quantity, interest);
        this.monthsOfDeposit = monthsOfDeposit;
    }

    public double calculateInterestPerDeposit() {
        return super.calculateInterest() * monthsOfDeposit / 12;
    }
}
