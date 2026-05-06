package bg.tu_varna.sit.f24621905.task3;

public class Owner extends Person {
    private String drivingLicense;

    public Owner(String egn, String firstName, String lastName, int age, String drivingLicense) throws PersonalDataException {
        super(egn, firstName, lastName, age);
        this.drivingLicense = (drivingLicense == null || drivingLicense.trim().isEmpty()) ? "none" : drivingLicense;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    @Override
    public boolean hasCompetence() {
        return getAge() >= 18 && getAge() <= 75 && !drivingLicense.equals("none");
    }

    @Override
    public String toString() {
        return "Owner: " + getFirstName() + " " + getLastName() + ", EGN: " + getEgn() + ", License: " + drivingLicense;
    }
}