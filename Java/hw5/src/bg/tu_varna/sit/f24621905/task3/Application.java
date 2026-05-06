package bg.tu_varna.sit.f24621905.task3;

public class Application {
    public static void main(String[] args) {

        Company ltdWithLoss = new CompanyLtd("ТехноЛТД", 100000, 50000, 1000, -10000);
        Company ltdWithProfit = new CompanyLtd("АлфаЛТД", 100000, 50000, 1000, 5000);

        Company stPatent = new CompanyST("Майстор ЕТ", 30000, 10000, "Иван Иванов", true);
        Company stNoPatent = new CompanyST("Консулт ЕТ", 80000, 60000, "Петър Петров", false);

        System.out.println("ООД (със загуба): " + ltdWithLoss.dds());
        System.out.println("ООД (с печалба): " + ltdWithProfit.dds());
        System.out.println("ЕТ (Патент): " + stPatent.dds());
        System.out.println("ЕТ (Без патент): " + stNoPatent.dds());

        System.out.println("ЕИК на ЕТ: " + stPatent.getEik());
    }
}
