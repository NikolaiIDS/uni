package bg.tu_varna.sit.f24621905.task5;

public class Application {
    public static void main(String[] args) {

        Truck myTruck = new Truck("Scania", "R730", 730, "V8 Diesel", "Auto", 2021, 25000);

        myTruck.setElapsedTime(4);
        System.out.println("--- Камион 1 ---");
        System.out.println("Марка: " + myTruck.getBrand());
        System.out.println("Модел: " + myTruck.getModel());
        System.out.println("Цвят: " + myTruck.getColor());
        System.out.println("Мощност: " + myTruck.getPower() + "hp");
        System.out.println("Двигател: " + myTruck.getEngineType());
        System.out.println("Скорости: " + myTruck.getTransmission());
        System.out.println("Година: " + myTruck.getYearOfManufacture());
        System.out.println("Пробег: " + myTruck.getMileage() + "km");
        System.out.println("Капацитет: " + myTruck.getCapacity() + "kg");
        System.out.println("Изминало време: " + myTruck.getElapsedTime() + " часа");
        System.out.println("Резултат от старт: " + myTruck.startup());


        myTruck.setElapsedTime(8);
        System.out.println("\n--- Камион 2 (след промяна) ---");
        System.out.println("Марка: " + myTruck.getBrand());
        System.out.println("Модел: " + myTruck.getModel());
        System.out.println("Изминало време: " + myTruck.getElapsedTime() + " часа");
        System.out.println("Резултат от старт: " + myTruck.startup());

        System.out.println("\n------------------------------");

        Bus myBus = new Bus("Ikarus", "280", 210, "Diesel", "Manual", 1988, 40);

        myBus.setCourses(3);
        System.out.println("\n--- Автобус 1 ---");
        System.out.println("Марка: " + myBus.getBrand());
        System.out.println("Модел: " + myBus.getModel());
        System.out.println("Цвят: " + myBus.getColor());
        System.out.println("Мощност: " + myBus.getPower() + "hp");
        System.out.println("Двигател: " + myBus.getEngineType());
        System.out.println("Скорости: " + myBus.getTransmission());
        System.out.println("Година: " + myBus.getYearOfManufacture());
        System.out.println("Пробег: " + myBus.getMileage() + "km");
        System.out.println("Места: " + myBus.getSeats());
        System.out.println("Изминати курсове: " + myBus.getCourses());
        System.out.println("Резултат от старт: " + myBus.startup());

        myBus.setCourses(12);
        System.out.println("\n--- Автобус 2 (след промяна) ---");
        System.out.println("Марка: " + myBus.getBrand());
        System.out.println("Модел: " + myBus.getModel());
        System.out.println("Изминати курсове: " + myBus.getCourses());
        System.out.println("Резултат от старт: " + myBus.startup());
    }
}