package bg.tu_varna.sit.f24621905.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Bank {
    private Map<Account, Double> bankAccounts;

    public Bank() {
        this.bankAccounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        if (!bankAccounts.containsKey(account)) {
            bankAccounts.put(account, account.calculateInterestValue());
        }
    }

    public List<Account> sortAccountsByBalance() {
        return bankAccounts.keySet().stream()
                .sorted(Comparator.comparingDouble(Account::getBalance))
                .collect(Collectors.toList());
    }

    public List<Account> sortAccountsByInterest() {
        return bankAccounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Currency findCurrencyWithMostAccounts() {
        Map<Currency, Integer> currencyCount = new HashMap<>();
        for (Account acc : bankAccounts.keySet()) {
            currencyCount.put(acc.getCurrency(), currencyCount.getOrDefault(acc.getCurrency(), 0) + 1);
        }
        return Collections.max(currencyCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bank Accounts:\n");
        for (Map.Entry<Account, Double> entry : bankAccounts.entrySet()) {
            sb.append(entry.getKey().toString())
                    .append(" | Interest: ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}
