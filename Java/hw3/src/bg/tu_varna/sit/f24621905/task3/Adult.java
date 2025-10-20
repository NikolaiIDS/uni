package bg.tu_varna.sit.f24621905.task3;

public class Adult extends Person{
    protected IdentificationCard id;

    public int getIdNumber() {
        return id.getNumber();
    }

    public String getEgn() {
        return id.getEgn();
    }

    public int getValidUntil() {
        return id.validUntil();
    }

    public String getPublishedBy() {
        return id.publishedBy();
    }

    public void setId(IdentificationCard id) {
        this.id = id;
    }

    public void getPersonalInformation() {
        System.out.println(thirdName + ", " + firstName + " " + secondName);
        System.out.println();
        System.out.println("Лична карта номер: " + id.getNumber() +
                " Издадена от: " + id.publishedBy());
    }


}
