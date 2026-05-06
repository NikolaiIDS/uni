package bg.tu_varna.sit.f24621905.task1;

public class Adult extends Person {

    private IdentificationCard idCard;

    public Adult(String firstName, String secondName, String thirdName, IdentificationCard idCard) {
        super(firstName, secondName, thirdName);
        this.idCard = idCard;
    }

    public IdentificationCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdentificationCard idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        String personInfo = firstName + ", " + secondName + " " + thirdName;

        String idInfo = "Лична карта номер: " + this.idCard.getNumber() + "\n" +
                "Издадена от: " + this.idCard.publishedBy();

        return personInfo + "\n" + idInfo;
    }
}