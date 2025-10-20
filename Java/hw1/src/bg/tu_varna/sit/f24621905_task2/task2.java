package bg.tu_varna.sit.f24621905_task2;

public class task2 {
    public static void printCharArray(char[] array) {
        int i = 0;
        while (i < array.length) {
            System.out.println(array[i]);
            i++;
        }
    }

    public static void main(String[] args) {
        char[] text = {'S', 'o', 'm', 'e', ' ', 't', 'e', 'x', 't'};

        printCharArray(text);
    }
}
