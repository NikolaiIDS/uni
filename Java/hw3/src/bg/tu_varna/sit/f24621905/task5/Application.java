package bg.tu_varna.sit.f24621905.task5;

public class Application {
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", "Corolla", 0xFFFFFF, 120, "Petrol", "Manual", 2018);
        car1.setMileage(50000);
        System.out.println(car1.getBrand() + " " + car1.getModel() +
                ", Color: #" + String.format("%06X", car1.getColor()) +
                ", Mileage: " + car1.getMileage());

        Truck truck1 = new Truck("Volvo", "FH", 0x0000FF, 400, "Diesel", "Automatic", 2020, 15000);
        truck1.setElapsedTime(5.5);
        System.out.println(truck1.getBrand() + " " + truck1.getModel() + ", Can start? " + truck1.checkIfCanBeStarted());

        Bus bus1 = new Bus("Mercedes", "Sprinter", 0xFF0000, 200, "Diesel", "Manual", 2019, 30);
        for(int i=0;i<57;i++) bus1.incrementCourses();
        System.out.println(bus1.getBrand() + " " + bus1.getModel() + ", Courses traveled: " + bus1.getCoursesTraveled());
        System.out.println("Limit exceeded? " + bus1.isLimitExceeded());
    }
}
