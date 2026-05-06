package bg.tu_varna.sit.f24621905.task1;

public class Application {
    public static void main(String[] args) {

        City sofia = new City("София", 1000);

        IdentificationCard myCard = new IdentificationCard(
                "620101987",
                2022,
                "8001011234",
                sofia
        );

        Adult adult = new Adult("Мария", "Иванова", "Димитрова", myCard);

        System.out.println(adult.toString());
    }
}