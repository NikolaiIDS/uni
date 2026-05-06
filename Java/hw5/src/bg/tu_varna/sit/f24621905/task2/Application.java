package bg.tu_varna.sit.f24621905.task2;

public class Application {
    public static void main(String[] args) {

        Cow betsy = new Cow(50);
        System.out.println( betsy);

        betsy.move();
        System.out.println(betsy);

        betsy.eat();
        System.out.println(betsy);

        betsy.sleep();
        System.out.println(betsy);

        Horse trigger = new Horse(80);
        System.out.println( trigger);

        trigger.eat();
        System.out.println(trigger);

        trigger.eat();
        System.out.println(trigger);

        Sheep dolly = new Sheep(20);
        System.out.println(dolly);

        dolly.move();
        System.out.println(dolly);
    }
}