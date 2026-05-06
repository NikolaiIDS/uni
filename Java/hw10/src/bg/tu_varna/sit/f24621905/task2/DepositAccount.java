package bg.tu_varna.sit.f24621905.task2;

public class DepositAccount extends Account {

    public DepositAccount(String id, AccountType type, Currency currency, double balance) {
        super(id, type, currency, balance);
    }

    @Override
    public double calculateInterestValue() {
        if (getType() == AccountType.PERSONAL) {
            return getBalance() * 0.09;
        } else if (getCurrency() == Currency.USD) {
            return getBalance() * 0.05;
        } else if (getCurrency() == Currency.EUR) {
            return getBalance() * 0.02;
        } else {
            return getBalance() * 0.01;
        }
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "id='" + getId() + '\'' +
                ", type=" + getType() +
                ", currency=" + getCurrency() +
                ", balance=" + getBalance() +
                '}';
    }
}
