package bg.tu_varna.sit.f24621905.task1;

public class City {
    private String name;
    private int postalCode;

    public City(String name, int postalCode) {
        this.name = name;

        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
