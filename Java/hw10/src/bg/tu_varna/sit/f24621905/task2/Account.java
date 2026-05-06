package bg.tu_varna.sit.f24621905.task2;

import java.util.Objects;

public abstract class Account implements InterestCalculator {
    private String id;
    private AccountType type;
    private Currency currency;
    private double balance;

    public Account(String id, AccountType type, Currency currency, double balance) {
        this.id = id;
        this.type = type;
        this.currency = currency;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public AccountType getType() {
        return type;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}