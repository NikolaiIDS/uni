package bg.tu_varna.sit.f24621905.task3;

public class Person {
    protected String firstName;
    protected String secondName;
    protected String thirdName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public void iAm(){
        System.out.println(this.thirdName + " " + this.firstName + " " + this.secondName);
    }
}
