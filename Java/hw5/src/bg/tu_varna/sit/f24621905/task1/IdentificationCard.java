package bg.tu_varna.sit.f24621905.task1;

public class IdentificationCard {
    private String number;
    private int year;
    private String egn;
    private City city;

    public IdentificationCard(String number, int year, String egn, City city) {
        this.number = number;
        this.year = year;
        this.egn = egn;
        this.city = city;
    }

    public String publishedBy() {
        return "МВР " + this.city.getName();
    }

    public int validUntil() {
        return this.year + 10;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
