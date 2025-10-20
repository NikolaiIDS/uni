package bg.tu_varna.sit.f24621905_task3;

class Application {
    public static void main(String[] args) {
        Account acc1 = new Account("BG01", "BGN", 1000.50);
        Account acc2 = new Account("BG02", "USD", 250.75);
        Account acc3 = new Account("BG03", "BGN", 3000.00);
        Account acc4 = new Account("BG04", "EUR", 500.00);
        Account acc5 = new Account("BG05", "BGN", 1500.25);

        Account[] accountsArray = {acc1, acc2, acc3, acc4, acc5};

        Bank bank = new Bank(accountsArray);

        System.out.println("Average balance in BGN: " + bank.calculateAverageBalanceByCurrency("BGN"));
        System.out.println("Average balance in USD: " + bank.calculateAverageBalanceByCurrency("USD"));
        System.out.println("Average balance in EUR: " + bank.calculateAverageBalanceByCurrency("EUR"));
    }
}

class Account {
    private String accountNumber;
    private String currency;
    private double balance;

    public Account(String accountNumber, String currency, double balance) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getCurrency() { return currency; }
    public double getBalance() { return balance; }

    public void printInfo() {
        System.out.println("Account: " + accountNumber + ", Currency: " + currency + ", Balance: " + balance);
    }
}

class Bank {
    private Account[] accounts;

    public Bank(Account[] accounts) {
        this.accounts = accounts;
    }

    public double calculateAverageBalanceByCurrency(String currency) {
        double sum = 0;
        int count = 0;

        for (Account account : accounts) {
            if (account.getCurrency().equalsIgnoreCase(currency)) {
                sum += account.getBalance();
                count++;
            }
        }

        if (count == 0) return 0;
        return sum / count;
    }
}
