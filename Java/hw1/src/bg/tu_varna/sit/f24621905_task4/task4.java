package bg.tu_varna.sit.f24621905_task4;
import java.util.ArrayList;

public class task4 {

    public static void main(String[] args) {
        int[] numbers = {
                2312345,
                2215678,
                2119012,
                2013456,
                2316789,
                2212349,
                2119876,
                2014321,
                2311111,
                1987654
        };
        CheckFN(numbers);
    }

    public static void CheckFN(int[] fns){
        ArrayList<String> firstC = new ArrayList<>();
        ArrayList<String> secondC = new ArrayList<>();
        ArrayList<String> thirdC = new ArrayList<>();
        ArrayList<String> fourthC = new ArrayList<>();
        ArrayList<String> unidentified = new ArrayList<>();

        for(int i = 0; i< fns.length; i++)
        {
            String temp = fns[i] + "";

            if (temp.charAt(0) == '2'){
                switch (temp.charAt(1)){
                    case '0': fourthC.add(temp); break;
                    case '1': thirdC.add(temp); break;
                    case '2': secondC.add(temp); break;
                    case '3': firstC.add(temp); break;
                    default: unidentified.add(temp); break;
                }
            }else unidentified.add(temp);

        }
        printArrayInfo("First course", firstC);
        printArrayInfo("Second course", secondC);
        printArrayInfo("Third course", thirdC);
        printArrayInfo("Fourth course", fourthC);
        printArrayInfo("Unidentified course", unidentified);
    }
    public static void printArrayInfo(String arrayName, ArrayList<String> array) {
        System.out.print("In " + arrayName + " there is " + array.size() + " students with faculty numbers: ");

        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
            if (i != array.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }
}
