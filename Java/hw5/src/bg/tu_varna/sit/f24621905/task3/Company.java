package bg.tu_varna.sit.f24621905.task3;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Company {

    private String name;
    private String eik;
    protected double incomes;
    protected double costs;

    public Company(String name, double incomes, double costs) {
        this.name = name;
        this.incomes = incomes;
        this.costs = costs;
        this.eik = this.generateEIK();
    }

    private String generateEIK() {
        long eikValue = ThreadLocalRandom.current().nextLong(100_000_000L, 1_000_000_000L);
        return String.valueOf(eikValue);
    }

    public abstract double dds();

    public String getName() {
        return name;
    }

    public String getEik() {
        return eik;
    }
}