package bg.tu_varna.sit.f24621905.task3;

public class City {
    protected String name;
    private int postalCOde;

    public City(String name, int postalCOde) {
        this.name = name;
        this.postalCOde = postalCOde;
    }

    public String getName() {
        return name;
    }

    public int getPostalCOde() {
        return postalCOde;
    }
}
