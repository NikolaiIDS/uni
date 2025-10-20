package bg.tu_varna.sit.f24621905.task1;

public class Application {
    public static void main(String[] args){
        Printer myPrinter = new Printer();

        myPrinter.setPrice(499.99);

        myPrinter.setNumberOfPages(30);

        System.out.println("Информация за принтера:");
        System.out.println("Цена: " + myPrinter.getPrice() + " лв.");
        System.out.println("Брой страници в минута: " + myPrinter.getNumberOfPages());
    }
}
