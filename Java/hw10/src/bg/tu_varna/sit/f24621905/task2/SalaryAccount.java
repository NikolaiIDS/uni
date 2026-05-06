package bg.tu_varna.sit.f24621905.task2;

public class SalaryAccount extends Account {

    public SalaryAccount(String id, AccountType type, Currency currency, double balance) {
        super(id, type, currency, balance);
    }

    @Override
    public double calculateInterestValue() {
        if (getType() == AccountType.CORPORATE) {
            return 0;
        } else if (getCurrency() == Currency.USD) {
            return getBalance() * 0.03;
        } else if (getCurrency() == Currency.EUR) {
            return getBalance() * 0.02;
        } else {
            return getBalance() * 0.01;
        }
    }

    @Override
    public String toString() {
        return "SalaryAccount{" +
                "id='" + getId() + '\'' +
                ", type=" + getType() +
                ", currency=" + getCurrency() +
                ", balance=" + getBalance() +
                '}';
    }
}