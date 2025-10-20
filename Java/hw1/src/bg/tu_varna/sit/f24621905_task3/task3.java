package bg.tu_varna.sit.f24621905_task3;

public class task3 {

    public static void main(String[] args) {
        String day = "Monday";
        WorkDay(day);

        day = "Sunday";
        WorkDay(day);
    }

    public static void WorkDay(String day){
        String[] days = { "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"};
        String psAndP = "13:30 до 18:00 ";
        String vAndC = "8:00 до 12:30";

        for(int i = 0; i< days.length; i++)
        {
            if (day.equals(days[i])) {
                if(i>4){
                    System.out.println("Doesnt work saturday and sunday.");
                    return;
                }

                if(i == 0 || i == 2 || i == 4) {
                    System.out.println("On" + days[i] + "the lab works in these hours: " + psAndP);
                }
                else{
                    System.out.println("On" + days[i] + "the lab works in these hours: " + vAndC);
                }
            }
        }
    }
}
