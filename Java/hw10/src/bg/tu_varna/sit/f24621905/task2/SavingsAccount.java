package bg.tu_varna.sit.f24621905.task2;

public class SavingsAccount extends Account {

    public SavingsAccount(String id, AccountType type, Currency currency, double balance) {
        super(id, type, currency, balance);
    }

    @Override
    public double calculateInterestValue() {
        if (getType() == AccountType.PERSONAL && getCurrency() == Currency.USD) {
            return getBalance() * 0.10;
        } else {
            return getBalance() * 0.01;
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "id='" + getId() + '\'' +
                ", type=" + getType() +
                ", currency=" + getCurrency() +
                ", balance=" + getBalance() +
                '}';
    }
}