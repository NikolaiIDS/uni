package bg.tu_varna.sit.f24621905.task3;

public class CompanyST extends Company {

    private String owner;
    private boolean isPatentActivity;

    public CompanyST(String name, double incomes, double costs, String owner, boolean isPatentActivity) {
        super(name, incomes, costs);
        this.owner = owner;
        this.isPatentActivity = isPatentActivity;
    }

    @Override
    public double dds() {
        if (this.isPatentActivity) {
            return 500.0;
        }

        double operativeProfit = incomes - costs;

        if (operativeProfit > 0) {
            return operativeProfit * 0.15;
        } else {
            return 0.0;
        }
    }

    public String getOwner() {
        return owner;
    }

    public boolean isPatentActivity() {
        return isPatentActivity;
    }
}
