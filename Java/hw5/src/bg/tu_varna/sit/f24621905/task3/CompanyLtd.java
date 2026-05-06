package bg.tu_varna.sit.f24621905.task3;

public class CompanyLtd extends Company {

    private double capital;
    private double profit;

    public CompanyLtd(String name, double incomes, double costs, double capital, double profit) {
        super(name, incomes, costs);
        this.capital = capital;
        this.profit = profit;
    }

    @Override
    public double dds() {
        double operativeProfit = incomes - costs;

        if (operativeProfit <= 0) {
            return 0.0;
        }

        if (this.profit < 0) {
            operativeProfit += this.profit;
        }

        if (operativeProfit <= 0) {
            return 0.0;
        }

        return operativeProfit * 0.10;
    }

    public double getCapital() {
        return capital;
    }

    public double getProfit() {
        return profit;
    }
}