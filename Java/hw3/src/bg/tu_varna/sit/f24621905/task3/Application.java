package bg.tu_varna.sit.f24621905.task3;

public class Application {
    public static void main(String[] args) {
        City sofia = new City("София", 1000);

        IdentificationCard idCard = new IdentificationCard(123456,sofia , "9901012345", 2018);

        Adult adult = new Adult();
        adult.setFirstName("Иван");
        adult.setSecondName("Петров");
        adult.setThirdName("Георгиев");
        adult.setId(idCard);

        System.out.println("=== Персонална информация ===");
        adult.getPersonalInformation();
    }
}
