package bg.tu_varna.sit.task10;

public class AccountingFirm {
    public static double calculateInterest(Deposit[] deposits, String currency) {
        double interest = 0.0d;
        for(int i = 0; i < deposits.length; i++) {
            if(deposits[i].getCurrency() == currency) {
                interest+=deposits[i].calculateInterestPerDeposit();
            }
        }
        return interest;
    }
}
