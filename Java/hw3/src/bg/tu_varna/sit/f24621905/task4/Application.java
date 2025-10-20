package bg.tu_varna.sit.f24621905.task4;

public class Application {
    public static void main(String[] args) {
        StandardTicket ticket1 = new StandardTicket("Concert A", 100);
        System.out.println(ticket1.getPerformanceName() + " - Цена: " + ticket1.getPrice());

        DiscountedTicket studentTicket = new DiscountedTicket("Concert A", 100, "Ivan Ivanov");
        System.out.println(studentTicket.getPerformanceName() + " - Цена: " + studentTicket.getPrice() +
                " - Потребител: " + studentTicket.getNameOfUser());

        GroupTicket groupTicket = new GroupTicket("Concert B", 50);
        for (int i = 0; i < 5; i++) {
            groupTicket.addUser();
        }
        System.out.println(groupTicket.getPerformanceName() + " - Цена: " + groupTicket.getPrice() +
                " - Брой участници: " + groupTicket.getNumberOfUsers());
    }
}
