package bg.tu_varna.sit.f24621905.task4;

public class Application {
    public static void main(String[] args) {

        StandardTicket standard = new StandardTicket("Хамлет", 50.00);
        DiscountTicket discount = new DiscountTicket("Хамлет", 50.00, "Иван Иванов");

        GroupTicket group = new GroupTicket("Комедия", 40.00);
        group.addUser();
        group.addUser();
        group.addUser();

        System.out.println("Цена на Стандартен: " + standard.getPrice());
        System.out.println("Цена на Намален: " + discount.getPrice());
        System.out.println("Цена на Групов (3-ма): " + group.getPrice());
    }
}
