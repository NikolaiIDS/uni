package bg.tu_varna.sit.f24621905.task3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Register {
    private String unit;
    private Map<Car, Owner> registeredCars;

    public Register(String unit) {
        this.unit = unit;
        this.registeredCars = new HashMap<>();
    }

    public void addRegistration(Car car, Owner owner) {
        if (car != null && owner != null) {
            registeredCars.put(car, owner);
        }
    }

    public void printRegisteredCars() {
        for (Car car : registeredCars.keySet()) {
            System.out.println(car);
        }
    }

    public String findOwnerByRegistrationNumber(String registrationNumber) {
        for (Map.Entry<Car, Owner> entry : registeredCars.entrySet()) {
            if (entry.getKey().getRegistrationNumber().equals(registrationNumber)) {
                return entry.getValue().getFirstName() + " " + entry.getValue().getLastName();
            }
        }
        return "Not found";
    }

    public void printLicensedDrivers() {
        Set<Owner> uniqueOwners = new HashSet<>(registeredCars.values());
        for (Owner owner : uniqueOwners) {
            if (owner.hasCompetence()) {
                System.out.println(owner);
            }
        }
    }
}