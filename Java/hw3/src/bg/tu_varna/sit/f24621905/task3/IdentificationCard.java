package bg.tu_varna.sit.f24621905.task3;

public class IdentificationCard {
    private int number;
    private int year;
    private String egn;
    private City city;

    public IdentificationCard(int number, City city, String egn, int year) {
        this.number = number;
        this.city = city;
        this.egn = egn;
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public String getEgn() {
        return egn;
    }

    public int validUntil() {
        return year + 10;
    }

    public String publishedBy() {
        return "МВР " + this.city.name;
    }
}
